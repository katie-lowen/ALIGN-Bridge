#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int globalSwap;
int globalCompare;
//Since we will be doing a lot of swapping, we will 
//pass of the swapping to a function to make our code 
//look cleaner. 
void swap(int* a, int* b){
    int temp = *a;
    *a = *b;
    *b = temp;
}
#define ARRAY_SIZE 10000
//Selection sort will sort an array by finding the smallest element in the unsorted part of the array and placing this 
//element at the front of the array
//This algorithim will continue to find the smallest element from the remaining unsorted part of the algorithm
//until the array is completely sorted which will occur in n-1 iterations of the array.  
void selectionSort(int* array, unsigned int size) {
    //This is an error check to make sure that the array is not empty
    //If the array was empty it would throw an error. 
    if(array == NULL) {

      printf("Array is null!\n");
    } 
    
    //This min variable will be used to track the position of the smallest number in the array
    //This will minimze the amount of swapping we have to do, which will increase the speed of this sorting algorithim 
    int min;   
    //The first loop which will set the size of the unsorted part of the array
    for (int i = 0; i < size-1; i++) {
	min = i;
	//Our second for loop will determine the smallest element in the array
	for(int j = i; j < size-1; j++) {
	    //Our global Variable is used to track the amount of comparisons the Selection Sort Algorithm
	    //will make
	    globalCompare++; 
	    
	   //This is to check if an element is greater than the element that comes after it. If it is the new
	   //smallest element will be the element in position [j+1]
	   if (array[min] > array[j+1]) {
		min = j+1;	  
              }  
	 }
        //This check is to minimze swapping. 
        //It will check if the smallest number is in the first position already
        //if it is it will not swap
	if (min != i) {
        swap(&array[i],&array[min]);		      
	globalSwap++;
	} 
   }
} 
//This will print the array if we choose to. We will not print our sorted array since its 10,000 elements/
//We will only print the first 10 and last ten elements as a rational check. 
void printArray(int* array, unsigned int size){
    if(array == NULL){
        printf("Array is null!\n");
        return;
    }
    for(int i = 0; i < size; i++){
        printf("%d ", array[i]);
    }
    printf("\n");
}

int main(){
    //First test and record time for implementing insortion sort
    //1. create an array with Array Size defined as macro
    int array[ARRAY_SIZE];
    
    // 2. read values from input text file and store it in the above array
    FILE* SelectionSortFile;
    SelectionSortFile= fopen("testUnsortedSelection.txt", "w");
    int buffer;  // to hold the value read from input file
    int counter = 0;  // record and control how many values to take
    //Initalize Random number generator
    
    srand(time(NULL));
    //This for loop will take random numbers and add them into a file. 
    for (int n = 1; n < ARRAY_SIZE; n++) {
       //We keep the numbers between 1 and a million so the output is easier to read.  	
	fprintf(SelectionSortFile,"%d\n",rand()%1000000);
	
    }

    fclose(SelectionSortFile);
    
    //We will open the same file we wrote to so we can sort it using Selection Sort. 
    FILE* SelectionSortFile2;
    SelectionSortFile2 = fopen("testUnsortedSelection.txt", "r");	
    if (SelectionSortFile != NULL) {
    while(counter < ARRAY_SIZE && 1 == fscanf(SelectionSortFile2,"%d", &buffer)){
          	array[counter] = buffer;
                counter ++;   	}
    }
    fclose(SelectionSortFile2);
   // 3. print the furst 10 elements in the array before sorting to make sure our numbers are random
   for ( int i =0; i < 10; i++) {
      printf(" %d",array[i]);
    } 
    printf("\n");
    // 4. use selection sort to sort and time sorting
   //START(Insertion_Sort_the_unsorted_input);
   clock_t t;
   t = clock();
   selectionSort(array, ARRAY_SIZE);
   t = clock() - t;
   double time_taken = ((double)t)/CLOCKS_PER_SEC;
   printf("\n The SelectionSort Algorithm took %f seconds to sort an unsorted array of %d elements \n:", time_taken, ARRAY_SIZE);
   printf("The Selection Sort Algorithm produce %d swaps and %d comparisons\n", globalSwap, globalCompare);   
  

   //We will print the first ten and last ten elements in the list as a sainty check to make sure our list
   //is sorted properly. We will nor print all 10,000 items since that will take up to much space. 
   for ( int i = 0; i < 10; i++) {
      printf(" %d",array[i]);			
   } printf("\n");

  for ( int i=9990 ; i < 10000; i++) {
      printf(" %d", array[i]);
	} printf("\n");
   return 0;
} 

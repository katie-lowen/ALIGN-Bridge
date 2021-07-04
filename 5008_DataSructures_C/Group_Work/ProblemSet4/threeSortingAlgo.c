#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define ARRAY_SIZE 10000
#define START(X) clock_t X = clock()
#define END(X) printf("Time for %s: %lf sec.\n", (#X), (double)(clock() - (X))/ CLOCKS_PER_SEC)

/*
 * Thi is the insertion sort algorithm. It will read from an
 * array A with n positive integers, and output the elements
 *  of A in sorted order.
 */
// swap values of two elements
void swap(int* a, int* b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void insertionSort(int* array, unsigned int size){
    // check if input is null
    if(array == NULL){
        printf("Array is null!\n");
        return;
    }
    int swapCounter;
    int compareCounter;
    // traverse the array, for every value at index i,
    // compare it with all values before index i (from right to left),
    // and swap if it is smaller, until find the proper
    // position to keep the first i values in ascending order
    for(int i = 1; i < size; i++){
        while(i > 0){
            compareCounter++; // comparison happens here
            if(array[i-1] > array[i]){
                swap(&array[i], &array[i-1]);
                swapCounter++; // if it enters this condition, swap counter increase by 1
                i--;
            }else{
                break; // since the first i elements are sorted, if there is no more swap,
                      // then no need to compare more for this ith round.
            }
        }
    }
    printf("Total Comparisons for Insertion Sort is: %d\n", compareCounter);
    printf("Total Swaps for Insertion Sort is: %d\n", swapCounter);
}

//this function will use the swap function to accomplish bubbleSort
void bubbleSort(int* array, unsigned int size) {
    int i;
    int p;
    //swaps will track the number of swaps
    int swaps = 0;
    //comps will count the number of comparisons
    int comps = 0;
    

    //use a for loop to traverse through the entire array
    for (i = 0; i< size; i++) {
        //use a second for-loop to compare elements 
        int flag = 0;
        for(p = 0; p < size - i - 1; p++) {
            //compare elements
            comps ++;
            if(array[p] > array[p + 1]) {
                //move the larger element back towards end of array
                swap(&array[p], &array[p + 1]);
                swaps ++;
                flag = 1;    
            }
        }
        if (flag == 0){
            break;
        }  
    }
    
    printf("Total Comparisons for Optimized Bubble Sort is: %d\n", comps);
    printf("Total Swaps for Optimized Bubble Sort is: %d\n", swaps);
}

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
    int globalCompare;  
    int globalSwap;
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
    printf("Total Comparisons for Selection Sort is: %d\n", globalCompare);
    printf("Total Swaps for Selection Sort is: %d\n", globalSwap);
} 


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

/* Writing to file 10000(defined as macro) random integers into test text file*/
FILE* generate_test_file(){
    FILE* testUnsorted;
    testUnsorted= fopen("test.txt", "w");
    for(int i = 0; i < ARRAY_SIZE; i++){
        fprintf(testUnsorted, "%d\n", rand());
    }
    fclose(testUnsorted);
    return testUnsorted;
}

void read_from_file(FILE* test, int* array){
    // int* array = malloc(sizeof(int) * ARRAY_SIZE);
    int buffer;  // to hold the value read from input file
    int counter = 0;  // record and control how many values to take
    test= fopen("test.txt", "r");
	while(counter < ARRAY_SIZE && 1 == fscanf(test,"%d", &buffer)){
		array[counter] = buffer;
        counter ++;
	}
	fclose(test);
    return;
}
	
int main(){
    // 1. generate test file by writing random numbers into the file
    FILE* testUnsorted = generate_test_file();
    // 2. create an array with Array Size defined as macro
    int array[ARRAY_SIZE];
    // 3. read values from input text file and store it in the above array
    read_from_file(testUnsorted, array);
    // 4. use insertion sort to sort and time sorting,
    // the time macro will print out time used.
    START(Insertion_Sort);
    insertionSort(array, ARRAY_SIZE);
    END(Insertion_Sort);
    printf("\n");

    // 5. Refresh the sorted array to generate an unsorted version,
    // and use bubble sort to sort it and time the sorting.
    read_from_file(testUnsorted, array);
    START(Bubble_Sort);
    bubbleSort(array, ARRAY_SIZE);
    END(Bubble_Sort);
    printf("\n");

    //6.  Refresh the sorted array to generate an unsorted version,
    // and use selection sort to sort it and time the sorting.
    read_from_file(testUnsorted, array);
    START(Selection_Sort);
    selectionSort(array, ARRAY_SIZE);
    END(Selection_Sort);

    return 0;
}
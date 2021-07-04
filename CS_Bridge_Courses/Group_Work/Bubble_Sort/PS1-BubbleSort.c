#include <stdio.h>
#include <stdlib.h>
#include <time.h>



//this function allows us to swap values in our array using pointers!
 
void swapValues(int *value1, int *value2) {

//we will use a temporary pointer to accomplish swapping items

int tempValue = *value1;

//now tempValue holds the same data as value1

//next we will reassign value1 to be the same as value2

*value1 = *value2;

//now to finish the swap, we must set value2 to be the 
//old value1. This is done by using the tempValue

*value2 = tempValue;
}

int write_to_file(){

    //static int i = 0;
    FILE *filepointer;
    filepointer = fopen("bubblesort2.txt", "w");
    //fprintf(filepointer, "%d.", i);
    int i;
    for(i = 0; i < 10000; i++) {
        fprintf(filepointer, "%d\n", i);

    }
    


    //fclose(filepointer);

    //i++;

    return 0;

}

int write_to_fileUnsorted(){

    //static int i = 0;
    FILE *filepointer;
    filepointer = fopen("bubblesort.txt", "w");
    //fprintf(filepointer, "%d.", i);
    int i;
    for(i = 0; i < 10000; i++) {
        fprintf(filepointer, "%d\n", rand());

    }
    


    //fclose(filepointer);

    //i++;

    return 0;
}
//this function will use the swap function to accomplish bubbleSort

void bubbleSortArray(int unsortedArray[], int arrayLength) {
    int i;
    int p;
    //swaps will track the number of swaps
    int swaps = 0;
    //comps will count the number of comparisons
    int comps = 0;
    

    //use a for loop to traverse through the entire array
    for (i = 0; i< arrayLength - 1; i++) {
        //use a second for-loop to compare elements 
        int flag = 0;
        for(p = 0; p < arrayLength - i - 1; p++) {
            //compare elements
            comps ++;
            if(unsortedArray[p] > unsortedArray[p + 1]) {
                //move the larger element back towards end of array
                swapValues(&unsortedArray[p], &unsortedArray[p + 1]);
                swaps ++;
                flag = 1;
                
            }
        }
        if (flag == 0){
            break;
        }
        
    }
    
    printf("\n\nTotal Comparisons: %d\n\n", comps);
    printf("\n\nTotal Swaps: %d\n\n", swaps);
    return;
}

void printBubbleArray(int array[], int arrayLength) {
    int i;
    for(i = 0; i < arrayLength; i++) {
            printf("%d  ", array[i]);

    }
    
}

int main() {

    // Calculate the time taken by the test harness to complete

    clock_t t; 
    t = clock(); 

    int bubbleArray [10000];
    int i = 0;

    //create a filepointer

    FILE *bubbleFile;

    //the function below was used to write 10,000 random ints to the file
    write_to_fileUnsorted();
    
    bubbleFile = fopen("bubblesort.txt", "r");

    //use a for loop to get every digit in the file

    if (bubbleFile == NULL) {
        printf("Invalid file!");
        return 0;
    }


    //now use feof which tells us where the end of file is
    //this will be used to know if we should continue getting the
    //data from the file
    //we use 20 to compare to index i because that is the array size
    //created above

    if(bubbleFile != NULL) {
        while(!feof(bubbleFile)  && i < 10000) {
            fscanf(bubbleFile, "%d", &bubbleArray[i]);
            i++;
        }

    }

//prints the unsorted array 

    printf("\nUnsorted Array (10000): \n\n");

    

    fclose(bubbleFile);

//now we have our inputs stored in an array
//we close the file and now must use BubbleSort to sort the array



    bubbleSortArray(bubbleArray, 10000);


    t = clock() - t; 
    double time_taken = ((double)t)/CLOCKS_PER_SEC; // in seconds 
    printf("\n\nThe BubbleSort took %f seconds to execute for an unsorted array \n", time_taken); 
    

    //-------------------

    clock_t t2; 
    t2 = clock(); 
    int bubbleArray2 [10000];
    int j = 0;

    FILE *bubbleFile2;

    write_to_file();
    bubbleFile2 = fopen("bubblesort2.txt", "r");

    //use a for loop to get every digit in the file

    if (bubbleFile2 == NULL) {
        printf("Invalid file!");
        return 0;
    }

    //now use feof which tells us where the end of file is
    //this will be used to know if we should continue getting the
    //data from the file
    //we use 20 to compare to index i because that is the array size
    //created above

    if(bubbleFile2 != NULL) {
        while(!feof(bubbleFile2)  && j < 10000) {
            fscanf(bubbleFile2, "%d", &bubbleArray2[j]);
            j++;
        }

    }
    fclose(bubbleFile2);
   

    printf("\n \nSorted Array (10000 elements) : \n");

    bubbleSortArray(bubbleArray2, 10000);




    t2 = clock() - t2; 
    double time_taken2 = ((double)t2)/CLOCKS_PER_SEC; // in seconds 
  
    printf("\n\nThe BubbleSort took %f seconds to execute for a sorted array \n", time_taken2); 
    return 0; 






    



 
}

    

    

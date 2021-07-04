#include <stdio.h>
#include <stdlib.h>
#include <time.h>
# define ARRAY_SIZE 50
#define START(X) clock_t X = clock()
#define END(X) printf("time for %s: %lf sec.\n", (#X), (double)(clock() - (X)) * 1000/ CLOCKS_PER_SEC)
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
    // traverse the array, for every value at index i,
    // compare it with all values before index i (from right to left),
    // and swap if it is smaller, until find the proper
    // position to keep the first i values in ascending order
    for(int i = 1; i < size; i++){
        while(i > 0 && array[i-1] > array[i]){
            swap(&array[i], &array[i-1]);
            i --;
        }
    }
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

int main(){
    // - First test and record time for implementing insortion sort
    // 1. create an array with Array Size defined as macro
    int array[ARRAY_SIZE];
    // 2. read values from input text file and store it in the above array
    FILE* testUnsorted;
	testUnsorted= fopen("testUnsorted.txt", "r");
	int buffer;  // to hold the value read from input file
    int counter = 0;  // record and control how many values to take
	while(counter < ARRAY_SIZE && 1 == fscanf(testUnsorted,"%d", &buffer)){
		array[counter] = buffer;
        counter ++;
	}
	fclose(testUnsorted);
    // 3. print the array before sorting
    printf("Array before sorting: ");
    printArray(array, ARRAY_SIZE);
    // 4. use insertion sort to sort and time sorting
    START(Insertion_Sort_the_unsorted_input);
    insertionSort(array, ARRAY_SIZE);
    END(Insertion_Sort_the_unsorted_input);
    // 5. print out result
    printf("Array after insertion sorting: ");
    printArray(array, ARRAY_SIZE);
    return 0;
}
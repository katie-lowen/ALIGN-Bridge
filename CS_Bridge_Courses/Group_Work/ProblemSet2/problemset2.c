#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define ARRAY_SIZE 10000
#define START(X) clock_t X = clock()
#define END(X) printf("Time for %s: %lf sec.\n", (#X), (double)(clock() - (X))/ CLOCKS_PER_SEC)

int quickSortSwapCounter = 0;
int quickDortComparisonCounter = 0;
int mergeSortSwapCounter = 0;

/*
 * Thi is the Merge sort algorithm. It will read from an
 * array A with n positive integers, and output the elements
 *  of A in sorted order.
 */
void merge(int* array, int left, int mid, int right, int* helper){
    // swap equas comparisons in the merge sort, so only initialize one counter
    int swap = 0;

    // copy the array to be merged to helper array
    for(int i = left; i <= right; i++){
        helper[i] = array[i];
    }
    // pointer on original array to record sorted result
    int i = left;
    // two pointers to work on helper array for sorting
    int j = left;
    int k = mid+1;
    // move whichever is smaller
    while(j <= mid && k <= right){
        if(helper[j] <= helper[k]){
            array[i] = helper[j];
            j++;
        }else{
            array[i] = helper[k];
            k++;
        }
        i++;
        mergeSortSwapCounter++;
    }
    // if the latter half is first moved and the first half left
    // copy the rest of the first half to array; if it's the later half
    // left, there is no need to copy because it is already in the array.
    while(j <= mid){
        array[i] = helper[j];
        i++;
        j++;
    }
}

void mergeSortHelper(int* array, int left, int right, int* helper){
    // base case
    if(left >= right){
        return;
    }

    int mid = left + (right - left) / 2 ;
    mergeSortHelper(array, left, mid, helper); // sort the left half
    mergeSortHelper(array, mid+1, right, helper); // sort the right half
    merge(array,left, mid, right, helper); // merge the two
}

void mergeSort(int* array, unsigned int size){
    if(array == NULL){
        return;
    }
    int* helper = malloc(size* sizeof(int)); // all the recursion uses the same helper array
	    
	mergeSortHelper(array, 0, size - 1, helper);
	free(helper);
	//return array;
}

// swap values of two elements
void swap(int* a, int* b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void quickSortHelper(int* array, int left, int right){
    //base case
    if(left >= right){
        return;
    }
    //Lomuto partition
    int pivot = array[right];
    
    int low = 0; // elements to the left of the pointer are smaller than pivot
    for(int high = 0; high < right; high++){ // elements between i and j are larger than pivot
        quickDortComparisonCounter++;
        if(array[high] <= pivot){
            swap(&array[low], &array[high]);
            low++;
            quickSortSwapCounter++;
        }
    }
    swap(&array[low], &array[right]); // swap the pivot from the end to its prpper position
    quickSortHelper(array, left, low-1);
    quickSortHelper(array, low+1, right);
}

void quickSort(int* array, unsigned int size){
    if(array == NULL){
        return;
    }
    return quickSortHelper(array, 0, size-1);
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

//the following function will write 10,000 unsorted numbers to a file 
//these numbers will be used in the sorting functions
int write_to_fileUnsorted(){

	FILE *filepointer;
	filepointer = fopen("randomNumbers.txt", "w");

	int i;

	for(i = 0; i< 10000; i++) {
	fprintf(filepointer, "%d\n", rand());

	}

	return 0;
}


int main(){
	int i = 0;
    	clock_t t;
	t = clock();
	
	int testArray [10000];

	//create a filepointer
	FILE *numberFile;

	//call function that writes random numberrs to the file
	
	write_to_fileUnsorted();

	numberFile = fopen("randomNumbers.txt", "r");
	
	if (numberFile == NULL) {
		printf("Invalid File!");
	return 0;	
	}

	//adding the numbers from the unsorted file to the array
	if(numberFile != NULL) {
	while(!feof(numberFile) && i < 10000) {
	fscanf(numberFile, "%d", &testArray[i]);
	i++;
		}
	}

	mergeSort(testArray, 10000);		
		
    //int test[] = {4, 6, 3, 8, 5, 0, 1, 2};
    // mergeSort(test, 8);
    	printf("Total comparisons and swaps for merge sort is: %d\n",mergeSortSwapCounter);
 
   	//quickSort(testArray, 10000);
    	//printf("Total Comparisons for Quick Sort is: %d\n", quickDortComparisonCounter);
	// printf("Total Swaps for Quick Sort is: %d\n", quickSortSwapCounter);

	t = clock() - t;
	double time_taken = ((double)t)/CLOCKS_PER_SEC; // in seconds
	printf("\n The mergeSort took %f seconds to execute \n", time_taken);

	//free(mergeSort);
     
       

}


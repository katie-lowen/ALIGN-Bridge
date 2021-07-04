/**
 * Katie Lowen
 * Lab03
 * VECTOR
 */



#include <stdio.h>
#include <stdlib.h>


typedef struct vector{
	int* data; //creating a pointer for data
	int size; // number of elements CURRENTLY stored in array
	int capacity; //number of elements that COULD be stored int he array
} vector_t;

/**
 * This fuction creates a makeVector
 * it uses malloc to allocate memory
 *
 */

vector_t* makeVector(int initCapacity){
	vector_t* vector = (vector_t*)malloc(sizeof(vector_t));
	if (vector == NULL){
		return NULL;
	}

	//next we allocate memory for our array
	//using arrows to dereference with it is pointing to
	
	vector->data = (int*)malloc(sizeof(int) * initCapacity);
	vector->size = 0;
	vector->capacity = initCapacity;
	return vector;

}

/*
 * DESTRUCTOR
 * Next we create a function to delete the memory from the heap
 * we must free the data when we use malloc, first we delete the data
 * array, then we delete the vector.
 * The first if statement protects our code from crashing if the vector is 
 * NULL.
 */

void freeVector (vector_t* vector){
	if (vector == NULL){
		return;
	}

	//this will delete the data that is stored
	//we use vector->data because we used it in the constructor with malloc
	
	if (vector->data != NULL){
		free(vector->data);
	}
	free(vector);
}

/*
 * Now we are creating a function to resize our array. 
 * If we want to add to an array, we must make sure 
 * there is enough "space" to do so. In this function we are
 * doubling the capacity of the array. 
 *
 */


int resize(vector_t* vector){
	if (vector == NULL){
		return 0;
	}

//now that we have covered if our vector is NULL,
//we need to double the capacity of our vector

	vector->capacity = vector->capacity * 2;
	int* newData = (int*)malloc(sizeof(int)*vector->capacity);

//next we check if our malloc resizing succeeded

	if ( newData == NULL || vector->data == NULL){
		return 0;
	}

//now we must copy the data from the old array to the new aray
//using a for loop, we loop up to the "size" because size is
//the number of elements in our original array

	for (int i = 0; i < vector->size; i ++){
		newData[i] = vector->data[i];
	}

//now that the original data is now stored in newData,
//we must delete the old array called data and free the memory
//note: our newData is twice the size of "old" data
//but has all the same data

	free(vector->data);
	vector->data = newData;
	return 1;
}

/**
 *This method pushes back the data so we are able to insert 
 * an element to the back  of the array
 * @param is an int element, the element we want to push to the back 
 */


int append(vector_t* vector, int element){
//first write our if statements that prevent our code 
//from crashing if we have a null vector

	if (vector == NULL){
		return 0;
	}

	if (vector->data == NULL){
		return 0;
	}

//next we need to make sure we have enough space in our array
//to add to the back. If we do not, we will have to resize 
//our array.

	if (vector->size == vector->capacity){
		int resizeSuccess = resize(vector);
		if (resizeSuccess == 0){
			return 0;
		}
	}

//now that we know we have enough space in our vector
//to add to the back, we can append to the back of the array

	vector->data[vector->size] = element;
	vector->size +=1;
	return 1;
}

/**
 *This method allows us to insert an element into a certain position
 *in our list. We must know the position and element we want to add to the array.
 */
int add(vector_t* vector, int pos, int element){
	if (vector == NULL || pos < 0){
		return 0;
	}

// now we must account for wanting to add an element to a position that is 
// greater than the current size of our list. 

	if (pos == vector->size){
		return append(vector, element);
	}

//TO SHIFT to the right, we must start at the element on the right
//and shift it over (we need enough room to insert the vector)

	if (vector->size == vector->capacity){
		int successOnResize = resize(vector);
		if (successOnResize == 0){
			return 0;
		}
	}

	if (vector->data == NULL){
		return 0;
	}
}
//code to copy the elements over to the right to make space for the 
//inserted element. 

int insert(vector_t* vector, int pos, int element){
	if (vector == NULL || pos < 0){
		return 0;
	}

	if (pos == vector->size){
		return append(vector, element);
	}

//Now to insert an element into the vector, we must start on 
//the far right and shift(copy) the data over to the right
//this will give us enough room to insert into the vector

	if (vector->size == vector->capacity){
		int successOnResize = resize(vector);
		if (successOnResize == 0){
			return 0;
		}
	}

	if (vector->data == NULL){
		return 0;
	}

//next we begin the process of copying the elements over

	for (int i = vector->size - 1; i >= pos; i --){
		vector->data[i + 1] = vector->data[i];
	}

	vector->data[pos] = element;
	vector->size += 1;
	return 1;

}

int remove_data(vector_t* vector, int pos){
	if (vector == NULL || pos < 0){
		return 0;
	}

	if (pos > vector->size){
		return 0;
	}

	if (vector->data == NULL){
		return 0;
	}
	
	vector->data[pos] = 0;

	for (int i = pos+1; i < vector->size; i++){
		vector->data[i-1] = vector->data[i];

	}
	vector->size -= 1;

	//for (int i = vector->size; i >= pos; i --){
	//	vector->data[i -1] = vector->data[i];
	//}

	return 1;
}




int add_front(vector_t* vector, int element){
	return insert(vector, 0, element);
}

int isEmpty(vector_t* vector){
	if (vector->data == NULL){
		return 1;
	}

}

int size(vector_t* vector){
	if (vector == NULL){
		return 0;
	}

	if (vector->data == NULL){
		return 0;
	}

	printf("Vector size: %d\n", vector->size);
}

int get(vector_t* vector, int element){
	if (vector == NULL){
		return 0;
	}
	
	if (vector->data == NULL){
		return 0;
	}

	for (int i = 0; vector->size; i ++){
		if (vector->data[i] == element){
			return printf("%d\n",i);
		}
	}
}
	 

int print(vector_t* vector){
	if (vector == NULL){
		return 0;
	}

	if (vector->data == NULL){
		return isEmpty(vector);
	}	

	for (int i = 0; i < vector->size; i ++){
		printf("%d ", vector->data[i]);
	}
	printf("\n");
}

int main(){


//construct vector on the heap, with the makeVector function
	
	vector_t* vector = makeVector(2);
	append(vector, 3);
	append(vector, 4);
	append(vector, 5);
	append(vector, 6);
	append(vector, 7);
	print(vector);

	add_front(vector, 1);
	print(vector);
	add_front(vector, 0);
	print(vector);
	
	
	get(vector, 0);
	get(vector, 3);
	size(vector);
	
	print(vector);

	
	remove_data(vector, 2);
	print(vector);
	
//	free(vector);
//	free(vector);
//	free(vector);
//	free(vector);

	/*

	FILE* filepointer;
	int buffer;
	filePointer = fopen("lab3_test.txt", "r");
	while(1 == fscanf(filePointer, "%d", &buffer)){
		append(vector, &buffer);
	*/


	return 0;
}




















// This is a Queue implementation with Vector.
// The Queue consists of makeQueue, freeQueue, resizeQ, printQ, enqueue, dequeue
# include<stdio.h>
# include<stdlib.h>
# include<limits.h>
typedef struct vector{
	int* data;
	int size;
	int capacity;
}vector_t;


typedef struct Queue{
        vector_t* vector; // vector that stores array, int size and int capacity
        int head; // location to dequeue
        int tail; // location to enqueue
}queue_t;

vector_t* makeVector(int initCapacity){
	vector_t* vector = (vector_t*)malloc(sizeof(vector_t));
	if(vector == NULL){
		return NULL;
	}
	//Allocate memory for int array[]
	vector->data = (int*)malloc(sizeof(int)*initCapacity);
	vector->size = 0;
	vector->capacity = initCapacity;
	return vector;
}

//Queue Constructor
queue_t* makeQueue(int initCap){
	queue_t* q =(queue_t*)malloc(sizeof(queue_t));
        if(q == NULL){
                return NULL;
        }
	vector_t* v = makeVector(initCap);
	q->vector = v;
	q->head = q->tail = 0;
	return q;
}

void freeVector(vector_t* vector){
	//Deconstructor: delete the struct vector_t on the heap.
	//Different from free(), which is for a variable. 
	if(vector == NULL){
		return;
	}
//First free the data array, then delete vector;
	if(vector->data != NULL){
		free(vector->data);
	}
	free(vector);
}

//Queue Deconstructor
void freeQueue(queue_t* q){
	if(q == NULL){
                return;
        }
        if(q->vector != NULL){
                freeVector(q->vector);
        }
        free(q);
}


int resizeV(vector_t* vector){
	if(vector == NULL){
		return 0;
	}

	vector->capacity  = vector->capacity * 2;
	int* newData =(int*)malloc(sizeof(int) * 
						vector->capacity);
	
	if(newData == NULL || vector->data == NULL){

		return 0;
	}

	for (int i =0; i < vector->size; i++){
		newData[i] = vector->data[i];
	}
	free(vector->data);
	vector->data = newData;
	return 1;
} 

// resizeQ
int resizeQ(queue_t* q){
	 if(q == NULL){
         	return 0;
        }
	return resizeV(q->vector);
}

//isFull
// 0 means it's full and failed to resize
// 1 means either it's not full or it's successfully resized.
int isFull(queue_t* q){
	if (q == NULL || q->vector == NULL){
        	return 0;
        }
	if(q->vector->size == q->vector->capacity){
			return resizeV(q->vector);
	}
	return 0;
}

int isEmpty(queue_t* q){
        if(q->vector->size == 0){
		return 1;
	}
	return 0;
}
	
void printV(vector_t* vector){
	if (vector == NULL){
		return;
	}
	if(vector ->data == NULL){
		return;
	}

	for(int i = 0; i < vector->size; i++){
		printf("%d ", vector->data[i]);
	}	printf("\n");
}

// printQ
void printQ(queue_t* q){
        if(q == NULL){
                return;
        }
        printV(q->vector);
}

int pushBack(vector_t* vector, int element){
	if (vector == NULL){
		return 0;
	}
	//Check the size, whether need resize
	if(vector->size == vector->capacity){
		int resize = resizeV(vector);
		if(resize == 0){
			return 0;
		}
	}
	vector->data[vector->size] = element;
	vector->size += 1;
	return 1;
}	

int insert(vector_t* vector, int position, int element){
	if(vector ==NULL){
		return 0;
	}	
	if(position < 0){
		return 0;
	}
	if(position == vector->size){
		return pushBack(vector,element);
	}
	
	if(vector->size == vector->capacity){
		int successResize = resizeV(vector);
		if(successResize == 0){
			return 0;
		}
	}
	if(vector->data == NULL){
		return 0;
	}

	for (int i = vector ->size -1; i >= position; i--){
		vector->data[i+1] = vector->data[i];	
	}
	vector->data[position] = element;
	vector ->size += 1;
	return 1;
} 

int pushFront(vector_t* vector, int element){
	return insert(vector,0,element);
}

// return the first element in the array and move the rest of 1 index forward
int deleteFront(vector_t* vector){
	if(vector == NULL|| vector->size == 0){
		return INT_MIN;
	}
	
	int res = vector->data[0];
	if(vector->size == 1){
		vector->size = 0;
		return res;
	}
	//move the rest forward
	for(int i = 1; i<vector->size; i++){
		vector->data[i-1] = vector->data[i];	
	} 	
	vector->size -= 1;
	return res;
}		

int enqueue(queue_t* q, int item){
	if(q == NULL ||q->vector == NULL ){
		return 0;
	}
	int res = pushBack(q->vector, item);
	//Once pushBack is done, the size should be updated and update tail.
	q->tail = q->vector->size - 1;
	return res;	
}

int dequeue(queue_t *q){
	 if(isEmpty(q)){
		q->tail = q->head = 0;
         	return INT_MIN;
        }
	int res = deleteFront(q->vector);
	// head remains the same as the vector moves the array forward, but tail
	// decreases 1.
        q->tail = q->vector->size - 1; 
        return res;
}

int main(){
	queue_t* q2 = makeQueue(2);
        FILE* filePointer;
        int buffer;
        filePointer = fopen("lab3_test_file.txt","r");
        while(1 == fscanf(filePointer, "%d", &buffer)){
                enqueue(q2,buffer);
        }
        printQ(q2);

	while(!isEmpty(q2)){
		int del = dequeue(q2);
		printf("dequeued: %d\n", del);
	}
	printQ(q2);
	freeQueue(q2);	
}


#include<limits.h>
#include<stdio.h>
#include<stdlib.h>

typedef struct Queue{
	int* data; //array that stores int
	int size; // array size
	int capacity; //capacity of array 
	int head; // location to dequeue
	int tail; // location to enqueue
}queue_t;

// Constructor of Queue
queue_t* makeQueue(int initCap){
	queue_t* q =(queue_t*)malloc(sizeof(queue_t));
	if(q == NULL){
		return NULL;
	}
	// allocate memeory for vector
	q->capacity = initCap;
	q->size = q->head = q->tail = 0;
	q->data = (int*)malloc(sizeof(int)*initCap);
	return q;
}

// Deconstuctor of Queue
void freeQueue(queue_t* q){
	if(q == NULL){
		return;
	}
	if(q->data != NULL){
		free(q->data);
	}
	free(q);
}

int resizeQ(queue_t* q){
	if(q == NULL){
		return 0;
	}

	q->capacity = q->capacity * 2;
	int* newData = (int*)malloc(sizeof(int)*q->capacity);
	if(newData == NULL || q->data ==NULL){
		return 0;
	}
	// Copy the original data to newData.
	for(int i = 0; i < q->size; i++){
		newData[i] = q->data[i];
	}
	free(q->data);
	q->data = newData;
	return 1;	
}

int isFull(queue_t* q){
	if (q == NULL || q->data == NULL){
		return 0;
	}
	if(q->size == q->capacity){
		int res = resizeQ(q);
		if(res == 0){
			return 0;// Queue is full, but fail to resize
			}
		return 1;// successfully resize Queue
	}
	return 1;// size!= capacity, not full
}

int isEmpty(queue_t* q){
	return(q->size == 0);	
	}

int enqueue(queue_t* q, int item){
	if(!isFull(q)){
		printf("%d can't be enqueued",item);
		return 0; // can't enqueue more item.
	}
	q->data[q->head] = item;
	q-> size += 1;
	q->head = q->head+1;
	
	return 1;
}

int dequeue(queue_t* q){
	if(isEmpty(q)){
		return INT_MIN;		
	}
	int item = q->data[q->head];
	q->head = (q->head+1) % q->capacity;
	q->size -= 1;
	return item;	
}

void printQ(queue_t* q){
	if(q == NULL){
		return;
	}
	if(q->data == NULL){
		return;
	}
	for(int i = 0; i < q->size; i++){
		printf("%d", q->data[i]);
	}
	printf("\n");
}

int main(){
	queue_t* q = makeQueue(2);
	FILE* filePointer;
        int buffer;
        filePointer = fopen("lab3_test_file.txt","r");
        while(1 == fscanf(filePointer, "%d", &buffer)){
		enqueue(q,buffer);
        }
	printQ(q);	
	return 0;
}

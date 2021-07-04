// Implementation of queue with single linked list
# include<stdio.h>
# include<stdlib.h>

typedef struct QNode{
	int key;
	struct QNode* next;
}QN_t;

typedef struct Queue{
	QN_t* head;
	QN_t* tail;
}queue_t;

// Constructor of QNode
QN_t* makeQNode(int k){
	QN_t* node = (QN_t*)malloc(sizeof(QN_t));
	//node -> key = k;
	node -> next = NULL;
	return node;
}

// Constructor of Queue
queue_t* makeQueue(){
	queue_t* q = (queue_t*)malloc(sizeof(queue_t));
	if(q == NULL){
		return NULL;
	}	
	q->head = q->tail != NULL;
	return q;
}

void enqueue(queue_t* q, int k){
	// Create a new sll node
	QN_t* node = makeQNode(k);
	if(node == NULL){
		printf("Fail to enqueue!");
	// If queue is empty, head = tail = node
	if(q->tail == NULL){
		q->head = q->tail = node;
	}
	return;
	}
}
void dequeue(queue_t* q){
	if(q->head ==NULL){
		return;
	}
	int  temp = q->head->tail;
	q->head = q->head->next;
	if(q->head == NULL){
		q->tail = NULL;
	}
	free(temp);
}

int main(){
	queue_t* q = makeQueue();
	FILE* filePointer;
        int buffer;
        filePointer = fopen("lab3_test_file.txt","r");
        while(1 == fscanf(filePointer, "%d", &buffer)){
		enqueue(q,buffer);
        }
	return 0;	
}

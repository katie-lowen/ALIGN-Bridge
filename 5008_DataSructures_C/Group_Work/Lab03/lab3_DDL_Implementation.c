// Implementation of queue with double linked list
# include<stdio.h>
# include<stdlib.h>

typedef struct QNode{
	int key;
	struct QNode* next;
	struct QNode* prev;
}QN_t;

typedef struct Queue{
	QN_t* head;
	QN_t* tail;
}queue_t;

// Constructor of QNode
QN_t* makeQNode(int k){
	QN_t* node = (QN_t*)malloc(sizeof(QN_t));
	node -> key = k;
	node -> next = NULL;
	node -> prev = NULL;
	return node;
}

// Constructor of Queue
queue_t* makeQueue(){
	queue_t* q = (queue_t*)malloc(sizeof(queue_t));
	if(q == NULL){
		return NULL;
	}	
	q->head = q->tail = NULL;
	return q;
}

void enqueue(queue_t* q, int k){
	// Create a new dll node
	QN_t* newNode = makeQNode(k);
	if(newNode == NULL){
		printf("Fail to enqueue!");
	}
	// If queue is empty, head = tail = node
	if(q->tail == NULL){
		q->head = q->tail = newNode;
	}else{
		q->tail->prev = newNode;
		newNode->prev = q->tail;
		newNode->next =NULL;
		q->tail = newNode;		
	}	
	return 1;
}

void dequeue(queue_t* q){
	if(q->head ==NULL){
		return;
	}
	QN_t* temp = q->head->key;
	q->head = q->head->next->tail;
	if(q->head != NULL){
		q->tail = NULL;
	}else{
		q->head->prev = NULL;
	}
	free(temp);
}

int main(){
	queue_t* q = makeQueue();
	FILE* filePointer;
        int buffer;
        filePointer = fopen("lab3_test_file.txt","r");
        while(1 == scanf(filePointer, "%d", &buffer)){
		enqueue(q,buffer);
        }
	return 0;	
}

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

// Contructors of node, sll, and Queue
typedef struct node{
	int data;
	struct node* next;
}node_t;

node_t* makeNode(int data){
	node_t* newNode = (node_t*)malloc(sizeof(node_t));
	if(newNode ==NULL){
		return NULL;
	}
	newNode->data = data;
	newNode->next = NULL;
	return newNode;
}

typedef struct slist{
	node_t* head;
	node_t* tail;
	int size;
}sl_t;

sl_t* makeList(){
	sl_t* newList = (sl_t*)malloc(sizeof(sl_t));
	if(newList != NULL){
		newList ->head =NULL;
		newList ->tail =NULL;
		newList ->size = 0;
		return newList;
	}
	return NULL;
}

 typedef struct Queue{
 	sl_t* list; // sll implements queue
 }queue_t; 

queue_t* makeQueue(){
	queue_t* newQ = (queue_t*)malloc(sizeof(queue_t*));
	if(newQ == NULL){
		return NULL;
	}
	newQ->list = makeList();
	return newQ;	
}


// Deconstructors of node, sll, and Queue
void freeNode(node_t* n){
	if(n ==NULL){
		return;
	}
	if(n->next == NULL){
		return;
	}
	free(n->next);
	free(n);
}

void freeSll(sl_t* sl){
	if(sl == NULL){
		return;
	}
	if(sl->head != NULL){
		free(sl->head);
	}
	if(sl->tail != NULL){
		free(sl->tail);
	}
	free(sl);
}

void freeQueue(queue_t* q){
	if(q->list != NULL){
		freeSll(q->list);
		free(q);
	}
}

//Print function of node, ssl, and queue
void printNode(node_t* node){
	while(node != NULL){
		printf("%d ", node->data);
		node = node->next;
	}
	printf("\n");	
}

void printSll(sl_t* list){
	if(list == NULL){
		return;
	}
	node_t* cur = list->head;
	while(list->head!= NULL ){
		printf("%d ", list->head->data);
		list->head = list->head->next;	
	}
	list->head = cur;
}

void printQueue(queue_t* q){
	if(q != NULL){	
		printSll(q->list);
	}
}		
//List operations	
void append(sl_t* list,int item){
	if(list == NULL){
		return;
	}
	node_t* newNode = makeNode(item);
	if(newNode ==NULL){
		return;
	}
	if(list->size == 0){
		list->head =list->tail = newNode;
	}else{
		list->tail->next = newNode;
	}
	newNode->next = NULL;
	list->tail = newNode;
	list->size += 1;	
}

void addFront(sl_t* list,int item){
	if(list ==NULL){
         	return;
            }
	if(list->size == 0){
		append(list,item);
		return;
	}
	node_t* newNode = makeNode(item);
        if(newNode ==NULL){
                 return;
	}
	newNode->next = list->head;
	list->head = newNode;
	list->size += 1;
}

void add(sl_t* list,int pos, int item){
	if(list ==NULL){
		return;
	}
	if(pos < 0 || pos > list->size){
		printf("Position out of bound!");
	}
	// add to the end = append
	if(pos== list->size){
		append(list,item);
	}
	// add to the front
	if(pos == 0){
		addFront(list, item);
	}
	// add in the middle 
	node_t* newNode = makeNode(item);
	if(newNode ==NULL){
		return;
	}
	node_t* headCur = list->head;
	while(pos >= 1){
		list->head = list->head->next;
		pos--;
	}
	//locating the position-1,append the newNode after it, and connect the next to newNode, size ++; 		
	node_t* curNext = list->head->next;
	list->head->next = newNode;
	newNode ->next = curNext;
	list->head = headCur;
	free(headCur);
	list->size+=1;
}

bool contains(sl_t* list,int item){
	if(list ==NULL|| list->size == 0){
		return false;
		}
	node_t* headCur = list->head;
 	while(list->head != NULL){
		if(list->head->data == item){
			return true;
		}
		list->head = list->head->next;
	}
	list->head = headCur;
	free(headCur);
	return false;
}

int size(sl_t* list){
	if(list ==NULL){
		return INT_MIN;
	}
	return list->size;
}

bool isEmpty(sl_t* list){
	if(list == NULL){
		return true;
	}
	return size(list);
}


int  get(sl_t* list,int pos){
	if(list ==NULL){
                 return INT_MIN;
         }
         if(pos < 0 || pos > list->size){
                 printf("Position out of bound!");
          }
         // get tail
         if(pos== list->size-1){
               return list->tail->data;
         }
         // get head
         if(pos == 0){
                return list->head->data;
         }
	// pos in the middle
	node_t* headCur = list->head;
        while(pos >= 0){
        	list->head = list->head->next;
                pos--;
         }
	int res = list->head->data;
	list->head = headCur;
	free(headCur);
	return res;	
}

int removeNode(sl_t* list, int pos){
	if(list ==NULL){
                return INT_MIN;
        }
        if(pos < 0 || pos > list->size){
                printf("Position out of bound!");
  		return INT_MIN;
        }  
	// remove head
	if(pos == 0){
		int res = list->head->data;
		list->head = list->head->next;
	}
	node_t* headCur = list->head;
	while(pos > 0){// 1 position before  the node to be deleted
		list->head = list->head->next; 	
	}
	node_t* delNext = list->head->next->next;
        node_t* del = list->head->next;
        int res = list->head->next->data;
        list->head->next =delNext;

	list->head = headCur;
	list->size -= 1;
	free(headCur);
	free(del);
	return res;			
}

//Queue operations
void enqueue(queue_t* q, int item){
	if(q == NULL || q->list == NULL){
		return;
	}
	addFront(q->list, item);	
}


int dequeue(queue_t* q){
	if(q ==NULL){
		return INT_MIN;
	}
	if(size(q->list) == 0 || size(q->list) == INT_MIN){
		printf("q is empty!");
		return INT_MIN;
	}
	return removeNode(q->list,0);		
}

int main(){
	queue_t* q = makeQueue();
        FILE* filePointer;
        int buffer;
        filePointer = fopen("lab3_test_file.txt","r");
        while(1 == fscanf(filePointer, "%d", &buffer)){
                enqueue(q,buffer);
        }
        printQueue(q);
	printf("\n");
	return 0;
}

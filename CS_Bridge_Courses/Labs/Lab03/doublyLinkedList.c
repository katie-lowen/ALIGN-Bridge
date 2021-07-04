#include <stdio.h>
#include <stdlib.h>

/**
 * CS5008 Lab03
 * Katie Lowen
 * Doubly Linked Lists
 */

//First we create a node function, this is different from SLL 
//because we have a second pointer to the previous node.

typedef struct node{
	int data;
	struct node* next;
	struct node* prev;
}node_t;

typedef struct dlist{
	node_t* head;
	node_t* tail;
	int size;
}dlist_t;

//Now we make the dlist

dlist_t* makeDlist(){
	dlist_t* newList = (dlist_t*)malloc(sizeof(dlist_t));
	if (newList != NULL){
		return 0;
	}

	newList->head = NULL;
	newList->tail = NULL;
	newList->size = 0;
}

//The following is a function that makes a new node
//we can add these new nodes to our doubly linked list

node_t* makeNode(int data){
	node_t* newNode = (node_t*)malloc(sizeof(node_t));
	if (newNode == NULL){
		return NULL;
	}

	newNode->data = data;
	newNode->next = NULL;
	newNode->prev = NULL;
	return newNode;
}

	
int push_front(dlist_t* dlist, int value){
	if (dlist == NULL){
		return 0;
	}

//next we account for a node being make that has a NULL value
	
	node_t* newNode = makeNode(value);
	if (newNode == NULL){
		return 0;
	}

//now we account for an empty dlist. In this case, the new node 
//will be the head and the tail.

	if (dlist->head == NULL && dlist->tail == NULL){
		dlist->head = makeNode(value);
		dlist->tail = makeNode(value);
	}

//now we account for a non-empty dlist. In this case, we are pushing to 
//the front of the list. This means that the new node will become 
//the new HEAD, where the next pointer will point to the old head and the 
//prev pointer will be NULL

	if (dlist->head != NULL){
		makeNode(value)->data = newNode;
		newNode->next = dlist->head;
		dlist->head->prev = newNode;
		newNode->prev = NULL;
		dlist->head = newNode;


	}
}

int push_back(dlist_t* dlist, int value){
	if (dlist == NULL){
		return 0;
	}
	
	node_t* newNode = makeNode(value);
	if (newNode == NULL){
		return 0;
	}

	if (dlist->head == NULL && dlist->tail == NULL){
		dlist->head = makeNode(value);
		dlist->tail = makeNode(value);
	}

	if (dlist->tail != NULL){
		makeNode(value)->data = newNode;
		newNode->next = NULL;
		newNode->prev = dlist->tail;
		dlist->tail->next = newNode;
		dlist->tail = newNode;
	}
}	

int remove_tail(dlist_t* dlist){
	 if (dlist == NULL){
                return 0;
	}

        if (dlist->head == NULL && dlist->tail == NULL){
                return 0;
        }

        if (dlist->tail != NULL){		
                dlist->tail = dlist->tail->prev;
		dlist->tail->next = NULL;
		
	}

        
}

int remove_head(dlist_t* dlist){
	if (dlist == NULL){
		return 0;
	}

	if (dlist->head == NULL && dlist->tail == NULL){
		return 0;
	}

	if (dlist->head != NULL){
		dlist->head = dlist->head->next;
		dlist->head->prev = NULL;
	}
}


void printNodes(node_t* node){
	node_t* itr = node;
	while (itr != NULL){
		printf("%d ", itr->data);
		itr = itr->next;
	}

	printf("\n");
}







int main(){
	
	makeDlist();

	node_t* node1 = makeNode(1);
	node_t* node2 = makeNode(2);
	node_t* node3 = makeNode(3);

	node1->next = node2; //have assigned next pointer to node2
	node1->prev = NULL; // have assigned prev pointer to null, therefore the head of dlist
	node2->next = node3;
	node2->prev = node1;
	node3->next = NULL; // this is the tail node of dlist
	node3->prev = node2;

	
	
	printf("Print node 1: \n");
        printNodes(node1);
        printf("Print node 2: \n");
        printNodes(node2);
        printf("Print node 3: \n");
        printNodes(node3);

	printf("Push front: 5 \n");
	push_front(&node1, 5);
	printNodes(node1);

	push_front(&node1, 7);
	printf("Push front 7: \n");
	printNodes(node1);

	printf("Push back: 8\n");
	push_back(&node3, 8);
	printNodes(node1);

	printf("Remove tail\n");
	remove_tail(&node3);
	printNodes(node1);

	printf("Remove head:\n");
	remove_head(&node1);
	printNodes(node1);
	/*
	FILE* filePointer;
	int buffer;
	filePointer = fopen("lab3_test.txt", "r");
	while(1 == fscanf(filePointer, "%d", &buffer)){
		push_front(&node1, buffer);
	*/

	return 0;
}











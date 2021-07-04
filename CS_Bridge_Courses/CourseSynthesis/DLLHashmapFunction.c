 /**
 * CS5008 Course Synthesis
 * Katie Lowen
 * LRU Cache
 */


#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#include "DLLHashmap.h"
pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;

typedef struct node_t* node;

typedef struct dlist_t* dlist;

dlist_t* makeDlist(){
	dlist_t* newList = (dlist_t*)malloc(sizeof(dlist_t));

	if(newList == NULL){
		return 0;
	}

	newList->head = NULL;
	newList->tail = NULL;
	newList->size = 0;
    return newList;
}

//The following is a function that makes a new node
//we can add these new nodes to our doubly linked list
//ADD KEY AND VALUE not just data

node_t *makeNode(char* data) {
    
	node_t* newNode = (node_t*)malloc(sizeof(node_t));
	if (newNode == NULL){
		return NULL;
	}

	newNode->data = data;
	newNode->next = NULL;
	newNode->prev = NULL;
    newNode->key = gIndex;
    gCIncrement();
	return newNode;
    
}


int gCIncrement(){
	pthread_mutex_lock(&mutex1);
    gIndex++;
	pthread_mutex_unlock(&mutex1);

    return 0;
}
	
void push_front(dlist_t* dlist, char* value){

    node_t *newNode = makeNode(value);

	if (newNode == NULL){
		return;
	}



//now we account for an empty dlist. In this case, the new node 
//will be the head and the tail.

	if (dlist->head == NULL && dlist->tail == NULL){
		dlist->head = newNode;
		dlist->tail = newNode;
        newNode->next = NULL;
        newNode->prev = NULL;
        dlist->size++;
        return;
	}

//now we account for a non-empty dlist. In this case, we are pushing to 
//the front of the list. This means that the new node will become 
//the new HEAD, where the next pointer will point to the old head and the 
//prev pointer will be NULL

	if (dlist->head != NULL){
		newNode->next = dlist->head;
		newNode->prev = NULL;
		dlist->head = newNode;
        dlist->size++;
        return;


	}
    
}

//forward declare
void least_recent(dlist_t* dlist);

//this will be used for queue, adds a tail
void most_recent(dlist_t* dlist, char value[]){
	
	//if list is NULL...
	if (dlist == NULL) {
		return;
	}



//make a temporary end value

	node_t *travel = dlist->head;
	node_t*newNode = makeNode(value);
	
//if newNode is null...	
	if (newNode == NULL) {
		return;
	 }



//if list is empty new node becomes the head and the tail	
	if (dlist->head == NULL && dlist->tail == NULL) {
		dlist->tail = newNode;
		dlist->head = newNode;
		newNode->next = NULL;
		newNode->prev = NULL;
		dlist->size++;
		
		 return;
	}

		//SET CACHE SIZE HERE!!
	if(dlist->size > 2) {
		
		printf("\n Cache full! Removing least recent!\n\n");
		least_recent(dlist);
		printf("\n");
		
	}

	
	
//use a while loop to pass through linked list to end 
	while(travel->next != NULL)
		travel = travel->next;


//when we reach the end of the current list, the travel->next will
//be NULL. Now we make a new node here
	travel->next = newNode;
	dlist->tail = newNode;
	newNode->next= NULL;
	newNode->prev = travel;
	dlist->size++; 
	return;
}

void least_recent(dlist_t* dlist){
	if (dlist == NULL){
		return;
	}



	if (dlist->head == NULL && dlist->tail == NULL){
		return;
	}

	
	if (dlist->head != NULL){

		
		node_t* node = dlist->head;
		node_t* standin = node->next;

		//copy the data from in list
		node->data = standin->data;
		node->next = standin->next;
        node->key = standin->key;
		node->prev = NULL;
		//now our stand in value has take the place of the previous head

		//to get rid of temporary head, 
		free(standin);
		printNodes(dlist->head);
		dlist->size--;
	}
	return;
}

void sameValue(dlist_t* dlist, char* value){

    if (dlist == NULL) {
        return;
    }

    node_t* newNode = makeNode(value);

    if (newNode == NULL) {
        return;
    }
    newNode->prev = dlist->tail;
    dlist->tail->next = newNode;
    return;
}

void remove_Node(dlist_t* dlist, int key){
    int counter = 0;
 	
    
	node_t* node = dlist->tail;
    for( int i = 0; i<=dlist->size; i++)
	if (i != key+1) {
		node = node->prev;
		i++;
    }
	node_t* temp = node;
	node=  node->next;
	free(node);
	temp->next =node->next; 
	temp->prev = node;
	dlist->size--;
    }




void printNodes(node_t* node){
	
	while (node != NULL){
        
		printf(" %s", node->data);
        printf("(%d) ", node->key);
		node = node->next;
	}

	printf("\n");
	return;
}

void* runHM(){
    
	
	dlist_t* dlist = makeDlist();
	node_t* start = makeNode("First");
	dlist->head = start;
    printNodes(start);
	most_recent(dlist, "Second");
	printNodes(start);
	most_recent(dlist, "Third");
	printNodes(start);
    sameValue(dlist, "Second");
    printNodes(start);
    remove_Node(dlist, 2);
    printNodes(start);

    most_recent(dlist, "Hello");
	printNodes(start);
    least_recent(dlist);

	most_recent(dlist, "Fifth");
	printNodes(start);
    sameValue(dlist, "Hello");
    printNodes(start);
    most_recent(dlist, "Sixth");
    printNodes(start);
    remove_Node(dlist, 5);
    printNodes(start);
	least_recent(dlist);
	printNodes(start);
	most_recent(dlist, "Seventh");
    printNodes(start);
	most_recent(dlist, "Eighth");
	printNodes(start);
	most_recent(dlist, "Nineth");
    printNodes(start);

	return 0;
}

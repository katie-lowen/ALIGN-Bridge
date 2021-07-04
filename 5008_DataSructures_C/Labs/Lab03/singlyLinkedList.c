#include <stdio.h>
#include <stdlib.h>

/**
 * Singly linked list
 * Katie Lowen
 * Lab03
 */

typedef struct node{
	int data;
	struct node* next;
}node_t;

typedef struct slist{
	node_t* head;
	node_t* tail;
	int size;
}slist_t;

//The following is our constructor for slist

slist_t* makeSlist(){
	slist_t* newList = (slist_t*)malloc(sizeof(slist_t));
	if (newList != NULL){
		return 0;
	}

	newList->head = NULL;
	newList->tail = NULL;
	newList->size = 0;
}

node_t* makeNode(int data){
        node_t* newNode = (node_t*)malloc(sizeof(node_t));
        if (newNode == NULL){
                return NULL;
        }

        newNode->data = data;
	newNode->next = NULL;
        return newNode;
}


int push_front(slist_t* slist, int value){
	if (slist == NULL){
		return 0;
	}

	node_t* newNode = makeNode(value);
	if (newNode == NULL){
		return 0;
	}
	
	if (slist->head == NULL && slist->tail == NULL){
		slist->head = makeNode(value);
		slist->tail = makeNode(value);
	}
	if (slist->head != NULL){
		makeNode(value)->data = newNode;
		newNode->next = slist->head;
		slist->head = newNode;

		//makeNode(value)->next = slist->head;
		//slist->head = makeNode(value);
		
		//slist->tail = NULL
		//reasign the pointer to new node?
		//like the swap function	

	}


//if head and tail are both null, then both head and tail will become
//new node. If they are not null, then the next pointer
//of newNode will point to the old head, and the newNode will become
//the new head. 

	return 0;
}


/**
 *This function adds a node to the end of the list. It does this by 
 * attaching itself to the old tail node as "next"
 */
int push_back(slist_t* slist, int value){
	if (slist == NULL){
		return 0;
	}

	node_t* newNode = makeNode(value);
	if (newNode == NULL){
		return 0;
	}

	if (slist->head == NULL && slist->tail == NULL){
		slist->head = makeNode(value);
		slist->tail = makeNode(value);
	}

	if (slist->head != NULL);{
		slist->tail->next = makeNode(value);
		newNode->next = NULL;
	}

	return 0;
}



int remove_head(slist_t* slist){
	if (slist == NULL){
		return 0;
	}

	if (slist->head == NULL && slist->tail == NULL){
		return 0;
	}

	if (slist->head != NULL){
		slist->head = slist->head->next;
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


void freeNode(node_t* node){
	if (node == NULL){
		return;
	}

	free(node);
}



int main(){

	

	node_t* node1 = makeNode(1);
	node_t* node2 = makeNode(2);
	node_t* node3 = makeNode(3);

	node1->next = node2; //now have assigned the pointer to address of node2
	node2->next = node3; // now have assigned the pointer to the address of node3
	node3->next = NULL; //this is the tail node 
	
	printf("Print node 1: \n");
	printNodes(node1);
	printf("Print node 2: \n");
	printNodes(node2);
	printf("Print node 3: \n");
	printNodes(node3);
	
	printf("Print push front 4: \n");
	push_front(&node1, 4);

	printf("Print node 1: \n");
	printNodes(node1);
	printf("Print node 2: \n");
	printNodes(node2);
	printf("Print node 3: \n");
	printNodes(node3);
	
	push_front(&node1, 5);
	printf("Print push front 5: \n");
	printNodes(node1);

	printf("Print push back 6: \n");
	push_back(&node3, 6);

	printNodes(node1);
	
	printf("Remove head: \n");
	remove_head(&node1);

	printNodes(node1);
		
	freeNode(node1);
	freeNode(node2);
	freeNode(node3);
	
	//The file reading and "pushfront" 
	//gives a segfault! 
	//Careful!
	
	/**
	FILE* filePointer;
	int buffer;
	filePointer = fopen("lab3_test.txt", "r");
	while(1 == fscanf(filePointer, "%d", &buffer)){
		push_front(&node1, buffer);
	}

	printNodes(node1);
	*/


	//freeNode(node4);
	//freeNode(node5);
	//freeNode(node6);	





	return 0;


}

























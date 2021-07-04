#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//This creates the node structure
typedef struct node {
	int data;
	struct node* next;

}node_t;

//this is a function declartion to prevent an issue 
node_t makenode(int data);

//will take a pointer to our node strcutre and will dereference and print the values with each node
void printNodes (node_t* node) {
		
	while( node != NULL) {
		printf("%d ", node->data);
		node = node->next;
		}
	printf("\n");
}



typedef struct slist {
	node_t* head;
	node_t* tail;
	int size;
}slist_t;


 
slist_t* makeslist() {
	
//Allocate memory to the heap
	slist_t* newList = (slist_t*) malloc(sizeof(slist_t));
	
	//if null is passed to the new lsit retrun zero.
	if ( newList == NULL) {
		return 0;}
	newList->head = NULL;
	newList-> tail = NULL;
	newList->size = 0;
	return newList;
}


//Push a item tot he front of the linked list 
void  push_front(slist_t* slist, int value) {
	//return nothing is null list
	if ( slist == NULL) {
	return;}

	//allocate mmeory to heap for new node 
	node_t *newnode = makenode(value);
	//if someone passes a null value;
	if (newnode == NULL) {
	return;}

	//if there is not new list head and tail equal to new ndoe
	if (slist->head== NULL &&  slist->tail == NULL) {
		slist-> head = newnode;
		slist->tail = newnode;
		newnode->next = NULL;
		slist->size++;
		return;}	
	
	//if not new, new node becomes new head 
	if (slist->head != NULL) { 
		newnode->next = slist->head;
		slist-> head = newnode;
		slist->size++;
		return;}	
}


//this will be used for queue, adds a tail
void add_end(slist_t* slist, int value){
	
	//return null if null lsit
	if (slist ==NULL) {
		return;}
 	//temp variable and new node, temp variable to iterate over list 
	node_t *last = slist->head;
	node_t*newnode = makenode(value);
	
	
	if (newnode == NULL) {
	 return;}
	//if new lsit
	if (slist->head == NULL && slist->tail == NULL) {
		slist->head = newnode;
		slist->tail = newnode;
		newnode->next = NULL;
		slist->size++;
		 return;}
	
	//this iterates to node with null value 
	while(last->next != NULL)
		last = last->next;


	//we change our last->next from null to newnode
	//then have the newnode point to null 
	last->next = newnode;
	slist->tail = newnode;
	newnode->next= NULL;
	slist->size++; 
	return;
}

//test to see if  avlaue is in the linked list or not 
bool boolean_in (node_t* node, int x) {
	if (node == NULL) {
	return false;}
	
	//goes through the list unless value is found in which is breaks
	//tkaes the current node as a param
	while( node != NULL) {
		if (x == node->data) { 
		return true;}
		node = node->next;}
	return false;
}

//Test to see if boolean is empty
//only empty when head and tial are null
bool booleanISEmpty (slist_t* list) {
	if (list->head == NULL && list->tail ==NULL) {
		return true; }
	return false;	
}


//inserta  valeu anywehre in the linked list !!
void insert(slist_t* slist, int pos, int value) {
	if ( slist == NULL) {
	return;}
	//used to determine correct values, cant be less than one, since we have an insert function for zero 
	if (pos > slist->size || pos <1) {
	printf("position %d cant be bigger than size or has to be bigger than 1 %d \n",pos,slist->size);
	return;}
	
	//get the location of the ehad fcuntion and rthen make a new node 
	node_t* node = slist->head;
	node_t *newnode = makenode(value);
	if (newnode == NULL) {
	return;}

	//if new fucntion
	if (slist->head== NULL &&  slist->tail == NULL) {
		slist-> head = newnode;
		slist->tail = newnode;
		newnode->next = NULL;
		slist->size++;
		slist->size++;
			return;}	
	
	//function used to take the position and go up tot that position in linked list less one value  
	int counter = 0; 
	while (counter < pos-1) {	
		node = node->next;
		counter++;}
	
	//our newnode will take point to the next node and take value pass as parm
	newnode-> data = value;
	//will point to value after it by taking the pointer before it next value 
	newnode->next = node->next;
	//prior pointe points ot new code 
	node->next = newnode;
	slist->size++;
	
}

/*
 * remove is broken up into two parts 
 * 1.one for the head 
 * one for the tail and th rest of the LL 
 */
void remv(slist_t* slist, int pos) {

	//Error hadning by checking to see is posiiton is in LL 
	if (pos < 0 || pos > slist->size || slist==NULL) {
 printf("Error: enter a positive value or number smaller than: %d \n",slist->size);
return;	}
	
	//used to iterate over list;
	int counter = 0;
	
	//takes out head
	if (pos==0) {
		    
	    //takes node and find the head fo the linked list
	    node_t* node = slist->head;
	    //temp store the head value so we can pass it to the second node in our LL
	    node_t*temp= node->next;
	    //will store second value point and address of the second vlaue point
	    node->data = temp->data;
	    node->next = temp->next;  
	    
	    //getting rid of temp value 
	    free(temp); 
	    //size is reduced twcie since we called slist-> head twice 
	    slist->size--;
	    slist->size--;
	    
	     return;	}
	

//this is head is not zero
//will move in front of node which is to be deleetd 
//take temporary node 
//free node
//then has temproary node link to the node after the deleetd node 
	if (pos >0) {
	node_t* node = slist->head;
	while (counter < pos-1) {
		node = node->next;
		counter++;};
	node_t* temp = node;
	node=  node->next;
	free(node);
	temp->next =node->next; 
	slist->size--;}
}
 

//used to get the value of a positon in a linked list 
void get(node_t* node, slist_t*list, int pos) {
	
	//erro handling 
	int size = list->size;
	if (pos < 0 || pos > size) {
 printf("Error: enter a positive value or number smaller than: %d \n",size);
return;	}
	
	//will rpint out value of posiiton by iterating to that position 

	int counter = 0;
	while (counter < pos) {
		node = node->next;
		counter++;}
	int a = node->data;
	printf("value of pos %d is %d: \n", pos, a);
}


//shows the state of the linked lsit via various print funcitons 
void print_queue (slist_t* list) {

	printf("Address of head: %p \n",list->head);
	printf("Address of tail: %p \n",list->tail);
	printf("Size of array: %d \n",list-> size);
	printf("value of head: %d \n", *list->head);
	printf("value of tail %d \n", *list->tail);
	bool x =booleanISEmpty(list);
	printf("%s", x ? "true" : "false");	
	printf("\n");
	}

//used to free datat 
void dequeue(node_t* node) {
	if (node == NULL) {
	  return; }

	free(node);
}


//makes a node 
node_t *makenode(int data) {

	node_t* newnode = (node_t*) malloc(sizeof(node_t));
	if (newnode == NULL) {
	  return NULL;	}

	newnode->data = data;
	return newnode;
}



int main() {
	//intialize our lsit and our queue 
	slist_t* list = makeslist();
	//add three items to form queue 
	add_end(list,10);
	add_end(list,5);
	node_t* node4 = list->head;
	printNodes(node4);
	add_end(list,8);
	node_t *node_5 = list->head;
	printNodes(node_5);
	//print queue for testing purpsoes
	remv(list,0);
	printNodes(node_5);	
	remv(list,0);
	printNodes(node_5);
	
	remv(list,0);
	remv(list,0);
	add_end(list,43);
	add_end(list,23);
	add_end(list,199);
	printNodes(node_5);
	add_end(list,345);
	add_end(list,-23);
	node_t*node_6 = list->head;
	printNodes(node_6);
	remv(list,0);
	printNodes(node_6);
	remv(list,0);
	printNodes(node_6);
	print_queue(list); 
	printf("second test \n \n");
		
	
      

/*	//Testing of random stuff
	slist_t* slist = makeslist();
        node_t* node_2 = NULL; 
	bool y  =boolean_in(node_2,3);
	printf("%s", y ? "true" : "false");	
	printf("\n");
	push_front(slist,1);
	push_front(slist,-20);
	add_end(slist,2);
	add_end(slist,3);	
	add_end(slist,-1);
	node_t* node = slist->head; 
	insert(slist,2,-10);
	bool z = boolean_in(node,3);
	printf("%s", z ? "true" : "false");
	printf("\n");
	printNodes(node);
	print_queue(slist);
	printf("\n");
	get(node,slist,2);
	get(node,slist,10);
	get(node,slist,-1);
	printf("\n");
	printNodes(node);
	remv(slist,5);
	printNodes(node);	
	add_end(slist,407);
	printf("\n");
	printNodes(node);
	remv(slist,1);
	printNodes(node);
	
	print_queue(slist);
	remv(slist,0);
	printNodes(node);
	add_end(slist,327);
	push_front(slist,4);
	insert(slist,4,16);
	remv(slist,3);
	printNodes(node);
	print_queue(slist);*/
return 0;}

@Katie Lowen  
@Course Synthesis CS 5008  
@LRU Cache Implementation

---

# Course Synthesis - LRU Cache Implementation

This document will outline the process of building an LRU Cache implementation in C.  

###  Building the Doubly Linked List

For this project, I began by building a doubly linked list. This involved creating structs for the "dlist" and the "node," which are then connected to other nodes using "neext" and "previous" pointers. 

```
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
node_t *makeNode(char* data) {
    // static int gIndex;
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
```

Looking at thesee two pices of code, the biggest change added from a typical doubly linked list is the addition of a key value in the node struct. This key value will be later used to assign a "key value" to each node. A key value is unique to each node created in the list and can be used to call a value in our functions. 

The key values were created by using a global static variable that increments everytime a node is created. This ensures that while the program is running, even if there are duplicate entries (which will be discussed later on), there will be a unique identifier for each node value. In this project, the global variable is called gIndex, and starts at the value of 1. This variable has a dedicated function in the code, which increments the gIndex by one. This function is called everytimee a node is created, and results in an incrementing assigned index. 
```
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

// creating a global variable that will bee used as a key. 
int static gIndex = 1;

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;


//this function increments the key to ensure each node has a unique identifier. 

int gCIncrement(){
    pthread_mutex_lock(&mutex1);
    gIndex++;
    pthread_mutex_unlock(&mutex1);
    return 0;
}
```

As seen above, the code will also be executed using threads. Since the gIndex is a global variable and is shared among all nodes and threads, it is surrounded by a lock. This prevents a data race and ensures that the global variable creating the keys increments uninterrupted. 

---
### The Functions

The primary function of an LRU is to keep track of the most recently used data and release data that is unused and taking up space. This is simulated by creating a maximum size of a list and keeping track of the current size by incrementing the value every time a new node is made. If the size of the list reaches its maximum threshold, the list then "bumps" the oldest piece of data in the list to make room for the new entry. 

My implementation of the LRU Cache builds from the back towards the front. The oldest piecee of data is the head and the newest piece of data is the tail. Every time a new node is constructed, it is added to the back. 

To accomplish this, there are several functions and helper functions utilized. 

```
void most_recent(dlist_t*, char[]);

void least_recent(dlist_t*) ;

void sameValue(dlist_t*, char*);

void remove_Node(dlist_t*, int);

void printNodes(node_t* node);

void* runHM();
```
---

###  *void most_recent(dlist_t*, char[]);

The most_recent() function is used to create a new node with a new value. It is named most_recent because it would be the "newest" piece of data being added to the cache. For this reason, most_recent() adds a new node to the tail of the Doubly Linked List.

<br/> 


```
void most_recent(dlist_t* dlist, char value[]){

	if (dlist == NULL) {
		return;
	}
```
To begin, we check and see if the DLL is NULL, and if so return the function. 

```
	node_t *travel = dlist->head;
	node_t*newNode = makeNode(value);

	if (newNode == NULL) {
		return;
	 }
```
Next we create two new nodes. The first node "travel" is a temporary node and is assigned to equal the dlist head. This node will be used to travel through the linked list and determine where the tail is. The second node created is the node containing the "newest" data that will be added to the LRU cache, this node is called "newNode." 

Before moving to the next part of the function, we must check to see if newNode is NULL, and if so return the function. 

The last step in our conditionals is to check for a NULL dlist. If the dlist head and tail nodes are both NULL, we know this is an empty list, and the newNode will become the head and tail. 

```
	if (dlist->head == NULL && dlist->tail == NULL) {
		dlist->tail = newNode;
		dlist->head = newNode;
		newNode->next = NULL;
		newNode->prev = NULL;
		dlist->size++;
		
		 return;
	}
```

Now that we have created our two nodes, one temporary and one to be added to the list, we set the desired cache size. For the purpose of this exercise, we have set the cache size to 3. This means any node that is added when the size of the cache reaches beyond 3, it will remove the node at the head and place the new nodes at the tail. We see this in the code below where least_recent() is called. We will look at the least_recent function next. 

```
//SET CACHE SIZE HERE!!
	if (dlist->size > 3) {
		
		printf("\n Cache full! Removing least recent! \n\n");
		least_recent(dlist);
		printf("\n");
	}
```

Now that we can confirm there is room to be adding to the list, we use a while loop that traverses the "travel" node through the linked list. The travel node knows when it has reached the end of the linked list because it will hit the tail node, where the next pointer is null, denoted as "next->NULL". When this node is reached, the function breaks out of the while loop and continues on. 

```
//use a while loop to pass through linked list to end 
	while(travel->next != NULL)
		travel = travel->next;
```
Once at the dlist->tail, where the current node->next = NULL, we utilize the temporary travel node to reassign the old tail node's next pointer to point to the newNode (rather than NULL). Now that the new node is assigned to the old tail's next pointer, the new node has been added to the back of the list and has a NULL next pointer! 

```

//when we reach the end of the current list, the travel->next will
//be NULL. Now we make a new node here
	travel->next = newNode;
	dlist->tail = newNode;
	newNode->next= NULL;
	newNode->prev = travel;
	dlist->size++; 
	return;
}
```

### Big O Analysis

In the most_recent() function, we can see that if we are successfully able to create a node where the dlist and the node data are not NULL, the next step is to traverse through the entire linked list from head to tail and add the new node to the tail. This would give us a O("m"), where "m" is the size of the cache. In this example, the cache is set to three and would have a O(3), but if we changed our cache size to m = 12, then our Big O would also change to O(12). 


---
###  *void most_recent(dlist_t*, char[]);

In the previous function, if the cache was full, the function void most_recent(dlist_t*, char[]) is called. We will now dive into how this function call contributes to the LRU cache structure. 

```
void least_recent(dlist_t* dlist){
	if (dlist == NULL){
		return;
	}

	if (dlist->head == NULL && dlist->tail == NULL){
		return;
	}

```
The function begins by doing the usual checks, once we confirm that the dlist is not NULL, and the tail and head are not NULL, we move to the action portion of the function.

```
	if (dlist->head != NULL){

		node_t* node = dlist->head;
		node_t* standin = node->next;

		//copy the data from in list
		node->data = standin->data;
		node->next = standin->next;
        node->key = standin->key;
		node->prev = NULL;

		free(standin);
		
		dlist->size--;
		printNodes(dlist->head);
	}
	return;
}
```

The goal of this code is to remove the head of the dlist. This removal frees the "oldest" piece of data from the linked list and makes room for the list to be added on to. In this function, the data from the dlist->head node is copied to a standin node, and then the standin node is freed from the list. 

To better illustrate the functions, view the diagram below:

<br/>


![cache diagram](../cache%20diagram.png)

<br/>

### Big O Analysis

In the least_recent() function, we are entering into the linked list at the head and redirecting the current head pointers such that we can release this data. This operation is not happening anywhere throughout the linked list, only where the "oldest" data exists, which is the head. Therefore this function has a O(1) because it traverses to the first node in the list and completes the operations from that location. 


---
### Running the Code

If we were to run the only the most_recent function, it would be as follows:

<br/>

INPUT:
```
int main(){ 
    
	
	dlist_t* dlist = makeDlist();
	node_t* start = makeNode("First");
	dlist->head = start;
    printNodes(start);
	most_recent(dlist, "Second");
	printNodes(start);
	most_recent(dlist, "Third");
	printNodes(start);
    most_recent(dlist, "Hello");
	printNodes(start);
	most_recent(dlist, "Fifth");
	printNodes(start);
    most_recent(dlist, "Sixth");
    printNodes(start);
	return 0;

}
```

<br/> 

OUTPUT:

```
 First(1) 
 First(1)  Second(2) 
 First(1)  Second(2)  Third(3) 
 First(1)  Second(2)  Third(3)  Hello(4) 

 Cache full! Removing least recent!

 Second(2)  Third(3)  Hello(4) 

 Second(2)  Third(3)  Hello(4)  Fifth(5) 

 Cache full! Removing least recent!

 Third(3)  Hello(4)  Fifth(5) 

 Third(3)  Hello(4)  Fifth(5)  Sixth(6) 

 Cache full! Removing least recent!

 Hello(4)  Fifth(5)  Sixth(6) 
 ```

 ---

 ### *void sameValue(dlist_t* dlist, char* value)   
 ### *void remove_Node(dlist_t* dlist, int key)

 Lastly, two very important functions in this implementation of the LRU cache are the same_value() and remove_Node() functions. These functions create a new node of the same value in our linked list (with a new unique key), and then utilize the unique key value associated to the older piece of data to remove the old node from the linked list. 
 
 This new node if then places at the end of the list, because it is the most recently used piece of data. This removal of duplicated data allows us to delete unnecessary duplicate data from the linked list. Since a cache has limited space, it is important to not have the same values taking up additional space. 

<br/> 

```
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

void remove_Node(dlist_t* dlist, int key) {
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

```

### Big O Analysis
Looking at the sameValue() function, we can see the creation of a new node and it being added directly to the tail. There is no traversing through the linked list because the newest piece of data always is added to the tail. This means the sameValue() function is O(1). 

This is different to the remove_Node() function. In this function we see that the key value is being used in a for-loop to find its unique match. In the best case, it could be the first node in our linked list, but in the worst case it may be the last node. For this reason, this function is O(n).

INPUT:
```


int main(){ 
    
	
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

    most_recent(dlist, "Hello");
	return 0;

}
```

With the print statement separating the sameValue() and remove_Node() functions, we can see what these two functions are doing: 

OUTPUT:
```
 First(1) 
 First(1)  Second(2) 
 First(1)  Second(2)  Third(3) 
 First(1)  Second(2)  Third(3)  Second(4) 
 First(1)  Third(3)  Second(4)  Hello(5) 

 ```

 As shown above, the value "Second" has been places in the most recent position, and is then removed from the old position by deleting the older duplicate! 

<br/>

 ![same_value](sameValue%20cache.png)

 <br/>

 ---

 <br/>

### Bringing in Concurrency

After completing the building of the structure of a LRU cache, the final step was to bring in concurrency using pthreads. In this implementation, the test harness, previously int main() was converted into a void* runHM() function. Since there is a global variable that is incremented in the function gCIncrement(), which is used to assign unique key values, it is the function that contains the lock. This lock prevents the data being used as the unique identifier to encounter data races and maintain accuracy. 

For this stage of the implementation, I created a header file that is used for a new test harness. This was to maintain readable code and focus on the execution of pthreads. The new file is as follows: 

<br/> 

```
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include "DLLHashmap.h"

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER; 

// int static gIndex = 1;

#define NUM_THREADS 100

int main(){
    //IDs for the threads that we will create. 
    pthread_t threadID[NUM_THREADS];

    for (int i = 0; i < NUM_THREADS; i ++) { 
        pthread_create(&threadID[i], NULL, runHM, NULL);
    }

    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_join(threadID[i], NULL);
    }

    printf("\n Threads Complete\n");
    return 0;
```

In the code above, 100 threads will run the function runHM(), which contains the old main() function. 

OUTPUT SAMPLES:

```
 Third(21)  Second(35)  Hello(50)  Fifth(61)  Hello(62) 
 Third(21)  Second(35)  Hello(50)  Fifth(61)  Hello(62) 
 Third(21)  Second(35)  Fifth(61)  Hello(62) 
 Third(21)  Second(35)  Fifth(61)  Hello(62) 
 Third(21)  Second(35)  Fifth(61)  Hello(62) 
 Third(21)  Second(35)  Fifth(61)  Hello(62)  Fourth(63) 
 Third(21)  Second(35)  Fifth(61)  Hello(62)  Fourth(63)  Fifth(64) 

 Cache full! Removing least recent!
 ```
 <br/> 

 ```
 Second(30) (74)  Fifth(75) (90)  Sixth(59) (84)  Hello Fifth
 Second(26)  Second Fifth(55) (36)  Second Fifth(53)  Hello(56)  Fourth(81)  Fifth(89) 
 Hello Fourth(68) (80)  Fourth Fifth(82)  Fifth(92) (86) 


 Third
 Cache full! Removing least recent!

 Second(29)  Fifth(55)  Hello
 Cache full! Removing least recent!

(41) 
 Cache full! Removing least recent!

 Second(40)  Fifth
 Cache full! Removing least recent!
 ```
 <br/>

```
 Second(464)  Fifth Fifth(605)  Hello(679)  Fourth(952)  Fifth(989)  Sixth(999) 
(713)  Second(396)  Fifth(605)  Hello(679)  Fourth(952) (967)  Sixth(994) 
 Second(406)  Fifth Sixth(996) 
(676)  Hello(712)  Fourth(898)  Hello(776)  Fourth(993)  Fifth(967)  Sixth(994) 
 Fifth(997)  Sixth(1000) 
 Second(464)  Fifth(713)  Hello(776)  Fourth(993)  Fifth(997)  Sixth(1000) 
 Fifth(989)  Sixth(999) 
 Second(396)  Fifth(605)  Hello(679)  Fourth(952)  Fifth(989)  Sixth(999) 

 Threads Complete

 ```
 
 <br/>

This completes the analysis of our construction of an LRU Cache. In this particular implementation, we have integrated the use of pthreads to run our LRU Cache in 100 different threads concurrently. 

---
# The Final Code 

The final draft of the code utilized a header file, test harness file, functions file, and a Makefile. 

1. Header File "DLLHashmap.h"
   
```
#ifndef DLLHASHMAP_H_ 

#define DLLHASHMAP_H_

int static gIndex = 1;

typedef struct node {
    int key;
	char *data;
	struct node* next;
	struct node* prev;
}node_t;

typedef struct dlist{
	node_t* head;
	node_t* tail;
	int size;
}dlist_t;

dlist_t *makeDlist();

node_t *makeNode(char *);

int gCIncrement();

void push_front(dlist_t*, char*);

void least_recent(dlist_t*);

void most_recent(dlist_t*, char[]);

void sameValue(dlist_t*, char*);

void remove_Node(dlist_t*, int);

void printNodes(node_t* node);

void* runHM();
	
#endif

```
2. Functions File "DLLHashmapFunctions.c"

```

#include <stdio.h>
#include <stdlib.h>
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
	most_recent(dlist, "Fourth");
    printNodes(start);
	most_recent(dlist, "Fifth");
	printNodes(start);
	most_recent(dlist, "Sixth");
    printNodes(start);

	return 0;
}
```

3. Test Harness File "runDLLHashmap.c"
```
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <time.h>

#include "DLLHashmap.h"

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER; 

#define NUM_THREADS 100

int main(){

    // Calculate the time taken by for the threads to complete

    clock_t t; 
    t = clock(); 

    //IDs for the threads that we will create. 
    pthread_t threadID[NUM_THREADS];

    for (int i = 0; i < NUM_THREADS; i ++) { 
        pthread_create(&threadID[i], NULL, runHM, NULL);
    }

    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_join(threadID[i], NULL);
    }

    printf("\n Threads Complete\n");
    

     t = clock() - t; 
    double time_taken = ((double)t)/CLOCKS_PER_SEC; // in seconds 
  
    printf("The LRU Cache test took %f seconds to execute \n", time_taken); 
    return 0; 

}
```

4. The Makefile "Makefile"
   
```
all: 
	gcc runDLLHashmap.c DLLHashmapFunctions.c -o hm

exec:
	./hm

clean:
	rm -rf hm
	
```

5. Sample Output 
```
 Hello(446)  Fifth(581)   Hello(911)

 Cache full! Removing least recent!

 Hello(457)  Fifth Seventh(541)  Seventh(938) 

 Cache full! Removing least recent!

 Eighth(805)  Nineth(724) Second(845)  

 Hello(444)  Fifth(605) 

 ```


<br/>

## THE TRADEOFFS 

---
<br/>

### WORDS -vs- NUMBERS

In my implementation, the data type stored in the doubly linked list was a character array. Initially, I was going to work with numbers, as I had previously been working with doubly linked list with integer data types. However, because I would be implementing a key to each of the values, where the key value needed to be unique, I thought the most efficient way to create a key would be to increment a global variable. 

The tradeoff to using words over numbers as the stored data type, is that a character array data type requires more storage space. Alternatively, I could have used a integers as both the data stored and the key value. 

---
<br/>

### RUN-TIME

The biggest tradeoff in my implementation is the use of 100 threads over a for-loop. 

In C, we are able to use a timer to record how long the functions take to execute. With this in mind, we can see if it is more timely to run 100 threads which each execute the same test harness, or run our test harness once and multiply this by 100 to compare the sequential runtime to the threaded run time. 

To include a timer in the sequential code:

```
#include <time.h>
```

```
int main(){ 
	
    // Calculate the time taken by the Test Harness for the LRU Cache 
    clock_t t; 
    t = clock(); 
	
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
    most_recent(dlist, "Sixth");
    printNodes(start);
    remove_Node(dlist, 5);
    printNodes(start);
	least_recent(dlist);
	printNodes(start);
	most_recent(dlist, "Fourth");
    printNodes(start);
	most_recent(dlist, "Fifth");
	printNodes(start);
	most_recent(dlist, "Sixth");
    printNodes(start);
    sameValue(dlist, "Fourth");
    printNodes(start);

     t = clock() - t; 
    double time_taken = ((double)t)/CLOCKS_PER_SEC; // in seconds 
  
    printf("The LRU Cache test took %f seconds to execute \n", time_taken); 
    return 0; 
}
```

OUTPUT:
```
The LRU Cache test took 0.000070 seconds to execute 
```

When we multiply this time by 100, the expected time to run this program sequentially 100 times is 0.0070 seconds.

<br/> 

Lets compare this to running 100 threads with the same test harness. 

INPUT:

```
int main(){
    // Calculate the time taken by for the threads to complete

    clock_t t; 
    t = clock(); 

    //IDs for the threads that we will create. 
    pthread_t threadID[NUM_THREADS];

    for (int i = 0; i < NUM_THREADS; i ++) { 
        pthread_create(&threadID[i], NULL, runHM, NULL);
    }

    for (int i = 0; i < NUM_THREADS; i++) {
        pthread_join(threadID[i], NULL);
    }

    printf("\n Threads Complete\n");
    

     t = clock() - t; 
    double time_taken = ((double)t)/CLOCKS_PER_SEC; // in seconds 
  
    printf("The LRU Cache test took %f seconds to execute \n", time_taken); 
    return 0; 
}
```

<br/>

OUTPUT:
```
The LRU Cache test took 0.223951 seconds to execute 
```
As we can see, the time to complete 100 threads running concurrently takes a significantly more time then our preditede time of 0.007 seconds for a sequentially run set up. To confirm these findings, we can create a for-loop that is timed where the for-loop runs the test harness 100 times. 

The code is as follows:
```
int main(){ 
    

	
    // Calculate the time taken by the test harness to complete

    clock_t t; 
    t = clock(); 
    
   

for (int i = 0; i <= 100; i++) {	
	dlist_t* dlist = makeDlist();
	node_t* start = makeNode("First");
	dlist->head = start;
	// printf("\n%d\n", dlist->size);
    printNodes(start);
	most_recent(dlist, "Second");
	printNodes(start);
	// printf("\n%d\n", dlist->size);
	most_recent(dlist, "Third");
	printNodes(start);
	// printf("\n%d\n", dlist->size);
    sameValue(dlist, "Second");

    printNodes(start);
    remove_Node(dlist, 2);
    printNodes(start);

    most_recent(dlist, "Hello");
	printNodes(start);
    least_recent(dlist);

	most_recent(dlist, "Fifth");
	// printf("\n%d\n", dlist->size);
	printNodes(start);
    // sameValue(dlist, "Hello");

    // printNodes(start);
    most_recent(dlist, "Sixth");
	// printf("\n%d\n", dlist->size);
    printNodes(start);
    remove_Node(dlist, 5);
    printNodes(start);

	least_recent(dlist);
	printNodes(start);
	most_recent(dlist, "Fourth");
    printNodes(start);
	most_recent(dlist, "Fifth");
	printNodes(start);
	most_recent(dlist, "Sixth");
    printNodes(start);
   

    sameValue(dlist, "Fourth");
    printNodes(start);

}

     t = clock() - t; 
    double time_taken = ((double)t)/CLOCKS_PER_SEC; // in seconds 
  
    printf("The LRU Cache test took %f seconds to execute \n", time_taken); 
    return 0; 
}

```

OUTPUT:
```
The LRU Cache test took 0.004260 seconds to execute 
```

<br/>

As we can see, the sequential runtime took even less time than our prediction! Therefore, the timliness of running our threads takes a considerable longer amount of time compared to running the program sequentially. On the scale of the current program, the scale of the time difference is so small that seems insignificant. However, if we considered this on a larger scale:
 
 <br/> 

Sequential Running Time = 0.00426 seconds 
Threading Running Time = 0.223951 seconds

 <br/> 

difference = 0.223951 - 0.00426 = 0.21969

 <br/> 

Percentage Difference = ( 0.21969 / 0.00426 ) * 100 = 5,157.04

With a 5,157% time increase to run 100 threads verses running the program as a for-loop 100 times, this becomes a huge element to consider! 

In the real-world, with a change of 5,000% increase between threads and sequential execution, I would reassess the structure of the functions and the choices of how the threading is being executed. 

---

### Time Complexity 

As mentioned above in the report, the following function are:

most_recent() : O("m") where "m" is the cache size  
least_recent() : O(1)  
sameValue() : O(1)  
remove_Node() : O(n)  

The time complexity of the most_recent() function could be refactored to a O(1). Currently in the function, there is a "travel" node that is created and begins to travel through the linked list at the head. Once the node reaches the tail, it breaks out of the while loop (as it reaches a next->NULL pointer) and adds the new node here. Rather than traversing through the list to find the tail, I could have added the new node directly to the back. 

Initially I thought the traversal was integral to keeping track of how many nodes were in my function, however now understanding that the dlist->size increments independently of the list traversal (rather it increments every time a new node is made, and decrements if a node is removed), I could have avoided traversing "m" number of nodes and directly attached the newest node to the tail. 

The combination of sameValue() and remove_Node() could have been combined into a single function with an O(n) time complexity. Currently, these two functions are separate and the remove_Node() function traverses the list, however a better choice would have been to redirect the node pointers to become the tail rather than creatings a new node with the same value and deleting the old node. 

---





















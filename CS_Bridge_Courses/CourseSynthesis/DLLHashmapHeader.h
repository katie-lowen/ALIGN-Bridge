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

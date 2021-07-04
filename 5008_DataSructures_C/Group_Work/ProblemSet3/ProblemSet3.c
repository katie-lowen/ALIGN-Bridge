//Specifically, you will create this data structure from scratch, including the following functions in
//your implementation: Search, Insert, Delete, and Print Inorder.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//create a node struct which has a left and right pointer 
//these pointers will act as the branches in our tree
typedef struct node {
    int data;
    struct node* left;
    struct node* right;
}node_t;

//create a tree structure with a root and number nodes
typedef struct tree {
    node_t* root;
    int numNodes;
}tree_t;

//this creates a new tree with a NULL root and numNodes of 0.
tree_t* makeTree() {
    tree_t* newTree = (tree_t*)malloc(sizeof(tree_t));

    if(newTree == NULL) {
        return 0;
    }

    newTree->root = NULL;
    newTree->numNodes = 0;

    return newTree;
}


//make node function which creates a new node with a given value
node_t *makeNode(int data) {
    node_t* newNode = (node_t*)malloc(sizeof(node_t));

    if (newNode == NULL) {
        return NULL;
    }

    newNode->data = data;
    newNode->right = NULL;
    newNode->left = NULL;

    return newNode;
}

//this is the addHelper function in our tree. 
//this function takes in a new node value and compares to a node
//value existing in the tree to determine proper placement. 

int insertHelper(node_t* node, node_t* newNode) {
    //this function we take the node we want to compare the new node to

    if(newNode->data < node->data) {
        

        if(node->left == NULL) {
            node->left = newNode;
        }


        else {
        insertHelper(node->left, newNode);
        }
    }

    else if(newNode->data > node->data) {
        if(node->right == NULL) {
            node->right = newNode;
        }
        else {
            insertHelper(node->right, newNode);
        }      
    } 
    return 1;      
}

//this function adds a new element to the tree.
int insert(tree_t* t, int data) {

    if (t == NULL) {
        return 0;
    }

    node_t* newNode = makeNode(data);

    if(t->root == NULL) {
        t->root = newNode;
        return 1;
    }

    insertHelper(t->root, newNode);

    return 1;
}

//this function helps search the tree based on nodes in the tree
//if the value being searched is bigger or smaller than the current node,
//the function will recursively call itself with the next child in the correct
//direction. If the value is not equal to the node data, this will continue 
//until node->left or node->right is NULL, which indicates this is the end of
//our tree and the value is therefore not present. 
int searchHelper(node_t* n, int value) {
    if(n == NULL) {
        return 0;
    }

    if(n->data == value) {
        printf("\n %d -- Value Found!\n", value);
        return 1;
    }

    if(n->data < value) {
        if(n->right != NULL) {
            searchHelper(n->right, value);
        }

        else {
            printf("\n %d -- Value not found\n", value);
            return 1;
        }
        
    }

    if(n->data > value) {
        if(n->left != NULL) {
            searchHelper(n->left, value);
            
        }
        else {
            printf("\n %d -- Value not found\n", value);
            return 1;
        }
        
    }
    return 1;
    
}


//searches the tree with the given value.
int search(tree_t* t, int value) {
    if(t == NULL) {
        return 0;
    }

    if(t->root->data == value) {
        printf("Value is in tree");     
    }

    searchHelper(t->root, value);

    return 1;
}

struct node* deleteHelper(node_t* n, int value);

int delete(tree_t* t, int value) {
    if(t == NULL) {
        return 0;
    }

    
    deleteHelper(t->root, value);
    return 1;

    
}

struct node* findMax(node_t* n) {
    node_t* temp = n;

    //traverse through the tree until find null value with node
    //this will give us the predecessor 

    while(temp && n->left != NULL) {
        temp = temp ->left;
    }

    return temp;



}

struct node* deleteHelper(node_t* n, int value) {
    if (n == NULL) {
        return n;
    }

    
    if(n->data == value) {
        //if node only has zero children 
        if(n->left == NULL) {
            node_t* tempNode = makeNode(value);
            tempNode = n->right;
            free(n);
            return tempNode;
        }
        else if(n->right == NULL) {
            node_t* tempNode = makeNode(value);
            tempNode = n->left;
            free(n);
            return tempNode;

        }
    

        //if node has two children 
        //must find pred in the list to replace node 
        //call helper function to find largest value in left subtree
        else {

        
        node_t* findP = findMax(n->left);

        n->data = findP->data;

        n->left = deleteHelper(n->left, findP->data);

        }

        return n;
        
    }


    if(n->data < value) {
        if(n->right != NULL) {
            return deleteHelper(n->right, value);
              
        }
        else {
            printf("Value cannot be removed because it does not exist");
        }
    if(n->data > value) {
        if(n->left != NULL) {
            return deleteHelper(n->left, value);
               
        }
         else {
            printf("Value cannot be removed because it does not exist");
        }
    }
    }
    return n;
}









//prints the tree in sorted order from smallest to largest. 
void printHelper(node_t* n) {
    if(n == NULL) {
        return;
    }

    printHelper(n->left);
    printf("%d ", n->data);
    printHelper(n->right);

    return;
}

//printing our tree in order smallest to largest

//prints the tree. 
void printTree(tree_t* t) {
    if(t == NULL) {
        return;
    }
    printHelper(t->root);
    printf("\n");
    
    
}







//the following function will write 10,000 unsorted numbers to a file 
//these numbers will be used in the sorting functions
int write_to_fileUnsorted(){

	FILE *filepointer;
	filepointer = fopen("randomNum.txt", "w");

	int i;

	for(i = 0; i< 10000; i++) {
	fprintf(filepointer, "%d\n", rand());

	}

	return 0;
}


int main() {
    int i = 0;
    clock_t t;
	t = clock();

    int testArray [10000];

	//create a filepointer
	FILE *numberFile;

	//call function that writes random numberrs to the file
	
	write_to_fileUnsorted();

	numberFile = fopen("randomNum.txt", "r");
	
	if (numberFile == NULL) {
		printf("Invalid File!");
	return 0;	
	}

	//adding the numbers from the unsorted file to the array


    tree_t* myTree = makeTree();
    node_t* start = makeNode(10);

    myTree->root = start;

    if(numberFile != NULL) {
	    while(!feof(numberFile) && i < 1000) {
	    fscanf(numberFile, "%d", &testArray[i]);
	    i++;
		}
	}

    for(int j = 0; j < 1000; j++){
        insert(myTree, testArray[j]);
    }

    t = clock() - t;
	double time_taken = ((double)t)/CLOCKS_PER_SEC; // in seconds
	printf("\n The TreeSort took %f seconds to execute \n", time_taken);

    printTree(myTree);

    // insert(myTree, 30);
    

    // printTree(myTree);

    // search(myTree, 30);

    // insert(myTree, 40);
    // insert(myTree, 32);
    // insert(myTree, 2);
    // insert(myTree, 18);

    // printTree(myTree);

    // search(myTree, 19);

    // delete(myTree,30);
    // search(myTree, 3);
    // printTree(myTree);

    // insert(myTree, 17);
    // // insert(myTree, 20);
    // search(myTree, 30);
    // printTree(myTree);

    // delete(myTree, 18);
    // printTree(myTree);

















    return 1;
}


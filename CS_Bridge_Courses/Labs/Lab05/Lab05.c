
#include <stdio.h>
#include <stdlib.h>

#define maximumQ 8

void insert_element(int);
void delete_element(int);
void make_array();
void place_element(int);
void print_pQueue();
 
int priority_Q[maximumQ];
int front;
int back;


void make_array(){
    int front = -1;
    int back = -1;
}

//function to add a value to the priority queue array

void insert_element(int data) {

    //check to make sure there is space in the array
    //there must be one extra space to add an element, 
    //so would be PQMAX - 1

    if (back >= (maximumQ -1)) {
        printf("There is no more room in the array!");
        return;
    }
    
    //if array is empty, index 0 becomes the data
    //we increase front and back by 1 so that the index is 0
    if ((front == -1) && (back == -1))
    {
        front ++;
        back ++;
        priority_Q[back] = data;
        return;
    }

    //if array is not empty, we call the helper function to place the data where it should go in the list. 
    else {
        place_element(data);
    }
    //back is always increasing by one when a element is added to the list.
    back ++;
}

//this function is called if the array IS NOT empty. 
void place_element(int data) {
    int i;
    int j;
    //use a for loop to iterate through the elements in the list 
    for (i = 0; i < back; i++) {

        //if the new element is greater that the elements in the list...
        if (data >= priority_Q[i]) {

            for (j = back + 1; j > i; j--) {
                // bump the lower values back by one placement
                priority_Q[j] = priority_Q[j - 1];
            }
            //else if data is less than next element in the list, place here
            priority_Q[i] = data;
            return;
        }
    }
    //else place data in the front because i = 0
    priority_Q[i] = data;
}

//function is used to delete an element
void delete_element(int data) {
    int i;

    //account for the array being empty, cannot delete what is not there!
    if ((front == -1) && (back == -1)) {
        printf("Array is empty!");
        return;
    }
    //for loop moving through the array
    for (i = 0; i < back; i ++) {

        //find the element that equals the data wanted to be deleted
        if (data == priority_Q[i]) {

            //move everything behind the element being deleted up by one index
            for (; i < back; i++) {

                priority_Q[i] = priority_Q[ i + 1];
            }

            priority_Q[i] = 0;
            back--;

            if (back == -1) {
                front = -1;
                return;
            }
        }
    }
}

void print_pQueue() {
    if ((front== -1) && (back == -1)) {
        printf("This queue is empty\n");
        return;
    }

    for (int front = 0; front <= back; front ++) {
        printf(" %d ", priority_Q[front]);
    }

   
}

void print_menu() {
    printf("\n");
    printf("   - Insert an element into queue -- type 1 -- \n");
    printf("   - Delete an element from queue -- type 2 -- \n");
    printf("   - Display queue elements       -- type 3 -- \n");
    printf("   - Exit                         -- type 4 -- \n\n");

    return;

}

int main() {

    int number;
    int choice;
 
    print_menu();
    make_array();
 
    while (1) {
        
        printf("\nEnter your choice : ");    
        scanf("%d", &choice);
 
        switch (choice)
        {
        case 1: 
            printf("\nEnter value to be inserted : ");
            scanf("%d",&number);
            insert_element(number);
            print_menu();
            break;
        case 2:
            printf("\nEnter value to delete : ");
            scanf("%d",&number);
            delete_element(number);
            print_menu();
            break;
        case 3: 
            print_pQueue();
            print_menu();
            break;
        case 4: 
            exit(0);
        default: 
            printf("Oops! That wasn't an option!");
            print_menu();
        }
    }
}
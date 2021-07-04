
#include <stdio.h>
#include <stdlib.h>
#include "priorityqueue.h"
#define maximumQ 8
int priority_Q[maximumQ];
// int front;
// int back;


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
    
    if ((front == -1) && (back == -1))
    {
        front ++;
        back ++;
        priority_Q[back] = data;
        return;
    }

    else {
        place_element(data);
    }

    back ++;
}

void place_element(int data) {
    int i;
    int j;

    for (i = 0; i < back; i++) {

        if (data >= priority_Q[i]) {

            for (j = back + 1; j > i; j--) {

                priority_Q[j] = priority_Q[j - 1];
            }
            priority_Q[i] = data;
            return;
        }
    }
    priority_Q[i] = data;
}

void delete_element(int data) {
    int i;

    if ((front == -1) && (back == -1)) {
        printf("Array is empty!");
        return;
    }

    for (i = 0; i < back; i ++) {

        if (data == priority_Q[i]) {

            for (; i < back; i++) {

                priority_Q[i] = priority_Q[ i + 1];
            }

            priority_Q[i] = -99;
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

    for (; front <= back; front ++) {
        printf(" %d ", priority_Q[front]);
    }

    front = 0;
}

void print_menu() {
    printf(" - Insert an element into queue -- type 1 -- \n");
    printf(" - Delete an element from queue -- type 2 -- \n");
    printf(" - Display queue elements       -- type 3 -- \n");
    printf(" - Exit                         -- type 4 -- \n");
    return;

}

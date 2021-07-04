
#include <stdio.h>
#include <stdlib.h>
#include "priorityqueue.h"
int priority_Q[maximumQ];

#define maximumQ 8

int main(){

    make_array();
    print_pQueue();
    printf("\n");
    insert_element(6);
    print_pQueue();
    insert_element(30);
    printf("\n");
    print_pQueue();
    printf("\n");
    insert_element(40);
    print_pQueue();
    printf("\n");
    insert_element(3);
    delete_element(6);
    printf("\n");
    print_pQueue();
    printf("\n");
    insert_element(4);
    insert_element(35);
    printf("\n");
    print_pQueue();
    printf("\n");
    insert_element(80);
    print_pQueue();
    printf("\n");
    delete_element(10);
    insert_element(1);
    printf("\n");
    print_pQueue();
    insert_element(3);
    printf("\n");
}

    


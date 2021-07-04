 /**
 * CS5008 Course Synthesis
 * Katie Lowen
 * LRU Cache
 */


#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <time.h>

#include "DLLHashmap.h"



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

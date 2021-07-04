***
Lab06 -- BLAG for a simple THREAD. CS5007/5008

@author Katie Lowen

NOTE: the following code has been provided by MOD 6 videos. 

***
 

# INTRODUCTION:

 
For this lab, we will be walking through the process of creating a thread in C. We will be discussing the purpose, construction, and potential risks of threads. 
 ***
 <br /> 

### What is Threading?
> A thread is a single sequence stream within a process. Threads are not independent, unlike a process, threads share their code, data, and memory. 
***
<br /> 

### Benefits of Threading
> Threading allows us to execute "simultaneously" and maximize the utilization of the CPU by multitasking. Since threads share resources, it is a more economical choice to use threads rather than creating multiple, separate processes. 
***

<br /> 

### Code Sample

To begin, we will take a brief look at the code we will be using in its full form. The code provided creates two threats of the same process. These two processes will be using concurrency, which is when two processes are overlapped. 

``` 
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>


void* task1(void* arg) {
    if (arg == NULL) {
        return NULL;
    }

    int* array =(int*)arg;
    
    int numToRun = array[0];
    int sleepTime = array[1];

    for( int i = 0; i < numToRun; i++){
        sleep(sleepTime);
        printf("%d. Running task 1\n", i);
    }
    return "task 1 is done!";
}

void* task2(void* arg) {
    if (arg == NULL) {
        return NULL;
    }

    int* array = (int*)arg;
    int numToRun = array[0];
    int sleepTime = array[1];

    for (int i = 0; i < numToRun; i++) {
        sleep(sleepTime);
        printf("%d. Running task 2\n", i);
    }
    return "task 2 is done!";
}


int main() {

    pthread_t threadID[2];

    int t1[2] = {50, 1};
    int t2[2] = {50, 1};


    pthread_create(&threadID[0], NULL, task1, t1);
    pthread_create(&threadID[1], NULL, task2, t2);

    void* task1Result;
    void* task2Result;
    pthread_join(threadID[0], &task1Result);
    pthread_join(threadID[1], &task2Result);

    printf("Task1: %s\n", (char*)task1Result);
    printf("Task2: %s\n", (char*)task2Result);


    return 0;
}

```
***
<br /> 

### Examining the Code
<br /> 

#### Header File Imports 

```
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
```
**Looking at the sample code, we can see there are two new header files we haven't seen until now.**
- #include <pthreads.h>
- #include <unistd.h>


What do these header files add to our toolbox? These two libraries allow us to create threads within our code. All programs in C must include the <pthreads.h> header file and follow these four basic steps:   
   1. Define a thread reference variable.
   2. Create an entry point for the thread.
   3. Create the thread.
   4. Join everything together. 

Next we will dive into these four steps in our continued analysis of the sample code. 

---
<br /> 

### Defining Threads
<br /> 


At the beginning of our main(), we can see the defing of our threads. 

```
int main() {

    pthread_t threadID[2];

```

The moment of interest in this case is the pthread_t. In general, to account for multiple threads, we create an array where each element is an ID for a separate thread. Each thread has an ID associated to it, in this case, we have declared the array to be a size of 2, which means 2 thread IDs will be created. Now that we have made our 2 thread IDs, and now must create the threads!

#### Creating Threads

To create a thread, we use a provided function called pthread_create(). This function takes in 4 parameters.

**pthread_create parameters:**  
1. ID
2. Attributes
3. Starting Routine
4. Arguments

In our code, the pthread_create function is structured as follows:
```
    pthread_create(&threadID[0], NULL, task1, t1);
    pthread_create(&threadID[1], NULL, task2, t2);
```

We will not get into the details of these parameters, but it is important to note that we are using the thread ID we created in our earlier step! Notice that our array declared earlier was a size of 2, therefore because indexing begins at 0, the two threads created associate themselves with the thread IDs of "&threadID[0]" and "&threadID[1]."

---
<br /> 

### Functions and Threads
<br /> 

By now you have likely noticed that the functions we are passing are structured differently than previously seen. For example: 
```
void* task1(void* arg) {
    if (arg == NULL) {
        return NULL;
    }

    int* array =(int*)arg;
    
    int numToRun = array[0];
    int sleepTime = array[1];

    for( int i = 0; i < numToRun; i++){
        sleep(sleepTime);
        printf("%d. Running task 1\n", i);
    }
    return "task 1 is done!";
}
```
What is particularly interesting about threads is their return type is a void pointer, denoted by void*. This is because threads require this function type to be passed as one of the four parmeters in the pthread_create() function. 

If we continue to step through this function, we see that our void* arg parameter is type casted as an int pointer. This means that now our return value will be an integer. If we look at our second function in the code, we will see the same layout. 

```
void* task2(void* arg) {
    if (arg == NULL) {
        return NULL;
    }

    int* array = (int*)arg;
    int numToRun = array[0];
    int sleepTime = array[1];

    for (int i = 0; i < numToRun; i++) {
        sleep(sleepTime);
        printf("%d. Running task 2\n", i);
    }
    return "task 2 is done!";
}
```

---

So what does this all mean? Looking at both functions, two things stand out. 

```
    int numToRun = array[0];
    int sleepTime = array[1];
```
What are these variables responsible for in our two functions? As we can see numToRun is beinig used to bound our for-loop. That is familiar, however what roll does sleepTime play?

In concurrency, because we cannot control how the threads are going to distribute the running of the threads, we can insert a sleepTime variable to offer some control of timing. In our case sleepTime is assigned to index position one of an array. This array is created in the int main() function. Setting the sleepTime to 1, would mean that we would wait one execution of the other thread, before re-executing the current thread! 

The values for these two variables is declared in the followoing lines of code in the main function:
```
    int t1[2] = {50, 1};
    int t2[2] = {50, 1};
```

As we can see, both threads are assigning 50 to index zero and 1 to index one, meaning the threads will run 50 times and wait 1 execution by the other thread before re-executing! 

---
<br /> 

### Joining Threads
<br /> 

Before reaching our final step, we can see an assigning of the return values for our two functions. This allows us to see when the threads have completed their executions. 
```
    void* task1Result;
    void* task2Result;
```

More importantly, the last and final step before running our thread code is to join the threads together using "pthread_join()." This method ensures that the two threads finish running before exiting the program. If we forget this step, we will notice that nothing happens! Therefore, it is vital to join our threads before running the program. In this function, we can see that the second parameter is dereferencing the pointer we declared above as our "result" to indicate we have completed running ourr function. It is also an option to have the second parameter as NULL. 

```
    pthread_join(threadID[0], &task1Result);
    pthread_join(threadID[1], &task2Result);

    printf("Task1: %s\n", (char*)task1Result);
    printf("Task2: %s\n", (char*)task2Result);
```
---
<br /> 

### Run the Code! 
<br /> 

Now that we have discussed the process of creating our threads, it is time to run the code! With the current settings of our numToRun and sleepTime, you should see an execution similar to this:

<br /> 


![threads](threads1.png)
![threads](threads2.png)


---
<br /> 

### Congratulations! 
<br /> 

You have now successfully run two threads! If you play with the sleepTime and numToRun values, you will find your outputs will do different things with timing! 

---
<br /> 

### Other Cool Features
<br /> 

Since threads share data, there is a risk of a data race. A data race is when two conflicting actions are happening in different threads, but operating with the same data. For example, if we were to withdraw and deposit from the same bank account, with our actions occuring and freezing at different times, we wouldn't know what the proper value of our account is at a given moment! To avoid such instances, threading uses a function that allows us to lock and unlock data. This prevents a thread from executing an action on a piece of shared data before the other execution has finished with it. 

This function is:
```
        pthread_mutex_lock(&mutex1);
        globalCounter++;
        pthread_mutex_unlock(&mutex1);
```

As you can see, our variable "globalCounter" is being locked before incremented, and then unlocked after the incrementation has finished! This means another thread cannot access the globalCounter variable until after this thread has unlocked the globalCounter varriable. 

It is important to note that although this feature prevents a data race, if it is not properly coded, it can result in a deadlock! A deadlock is when a piece of shared data is locked, but is never unlocked. This means other threads are unable to execute because they are waiting for that shared data to be unlocked! This results in the entire process being halted, and essentially nothing happening. If you are using mutex and no execution is happening, check to see there is not a deadlock! 

A second warning to watch out for when using mutex is the labelling of your lock. It is vital to use the same lock between two functions that are operating on the same piece of data. For example:

```
void* task1(void* arg) {
    if (arg == NULL) {
        return NULL;
    }

    int* array =(int*)arg;
    
    int numToRun = array[0];
    int sleepTime = array[1];

    for( int i = 0; i < numToRun; i++){
        pthread_mutex_lock(&mutex1);
        globalCounter++;
        pthread_mutex_unlock(&mutex1);
        
    }
    return "task 1 is done!";
}

void* task2(void* arg) {
    if (arg == NULL) {
        return NULL;
    }
    
    int* array = (int*)arg;
    int numToRun = array[0];
    int sleepTime = array[1];

    for (int i = 0; i < numToRun; i++) {
        pthread_mutex_lock(&mutex1);
        globalCounter++;
        pthread_mutex_unlock(&mutex1);
    }
    return "task 2 is done!";
}
```

In this code, although we are using two different functions, you will notice that the lock notation is exactly the same. This is because we want to use the same lock! If we were to use two different locks, we would not be stopping the other threads from executing on the same data because they will be looking for their corresponding lock to know if they are able to proceed. 

---
References used for information:

[geeksforgeeks](https://www.geeksforgeeks.org/multithreading-c-2/)  


[edpresso](https://www.educative.io/edpresso/how-to-create-a-simple-thread-in-c)


[POSIX Threads Programming](https://computing.llnl.gov/tutorials/pthreads/)

Module 6 - CS 5007/5008



























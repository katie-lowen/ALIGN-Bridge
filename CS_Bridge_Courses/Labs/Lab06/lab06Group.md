
<br/> 

#### @Meilin 
#### @John
#### @Katie 
#### @Group 010 - Lab 06
#### @CS 5007/5008
---
<br/> 

# Python concurrency

[https://liyanxu.blog/2019/04/19/summary-of-multithreading-and-multiprocessing-in-java-python/] 

Python is a script language and has different implementation. 
CPython is the C-implementation of Python, that is more commonly used than Jython (java-implementation of Python).

It's generally not recognized as thread-safe because the interpreter it uses doesn't support fine-grained locking mechanism like JVM.

Instead, it only has one global interpreter lock (GIL). Any thread must hold the GIL to access the memory space, and the parallel execution in CPython is just context switch. Therefore in CPython, multithreading 
 is only suggested for IO-related jobs.

 ---

<br/>

# Java vs C concurrency
[http://tutorials.jenkov.com/java-concurrency/java-memory-model.html]

## Differences:
<br/>


Java uses classes like Thread, Runnable and Callable to achieve concurrency by enabling
subclasses to rewrite run() method. But since Java doesn't support multiple inheritance,
a child class could only inherits 1 thread-related class. Also, when it comes
to multiple threads doing the same tasks, java needs multiple blocks
of code to execute that.

C has structs, which contain only data, thus it could put multiple threads in one code block 
to execute the same task. Also, it has full access to the different memeory orderings
provided by hardware.

## Similarities:

<br/> 
Both languages have visibility issue, meaning when shared data is updated by different threads,
thread don't see the changes other thread make. This could be called data race.
Both languages solve the problem by similar approach. C uses mutex and p_thread_join to lock
and release the shared data, whereas Java uses holdsLock() and synchronized to realize it. 


The following is an example of multithreading first without synchronization
and then with synchronization. 

Example reference: 
[https://www.tutorialspoint.com/java/java_thread_synchronization.htm]

```
class PrintDemo {
   public void printCount() {
      try {
         for(int i = 5; i > 0; i--) {
            System.out.println("Counter   ---   "  + i );
         }
      } catch (Exception e) {
         System.out.println("Thread  interrupted.");
      }
   }
}

class ThreadDemo extends Thread {
   private Thread t;
   private String threadName;
   PrintDemo  PD;

   ThreadDemo( String name,  PrintDemo pd) {
      threadName = name;
      PD = pd;
   }
   
   public void run() {
      PD.printCount();
      System.out.println("Thread " +  threadName + " exiting.");
   }

   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}

public class TestThread {
   public static void main(String args[]) {

      PrintDemo PD = new PrintDemo();

      ThreadDemo T1 = new ThreadDemo( "Thread - 1 ", PD );
      ThreadDemo T2 = new ThreadDemo( "Thread - 2 ", PD );

      T1.start();
      T2.start();

      // wait for threads to end
         try {
         T1.join();
         T2.join();
      } catch ( Exception e) {
         System.out.println("Interrupted");
      }
   }
}
```

This produces a different result every time you run this program −

```
Output
Starting Thread - 1
Starting Thread - 2
Counter   ---   5
Counter   ---   4
Counter   ---   3
Counter   ---   5
Counter   ---   2
Counter   ---   1
Counter   ---   4
Thread Thread - 1  exiting.
Counter   ---   3
Counter   ---   2
Counter   ---   1
Thread Thread - 2  exiting.
```
Here is the same example which prints counter value in sequence and every time we run it, it produces the same result.

Example
```
class PrintDemo {
   public void printCount() {
      try {
         for(int i = 5; i > 0; i--) {
            System.out.println("Counter   ---   "  + i );
         }
      } catch (Exception e) {
         System.out.println("Thread  interrupted.");
      }
   }
}

class ThreadDemo extends Thread {
   private Thread t;
   private String threadName;
   PrintDemo  PD;

   ThreadDemo( String name,  PrintDemo pd) {
      threadName = name;
      PD = pd;
   }
   
   public void run() {
      synchronized(PD) {// Add sync here
         PD.printCount();
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }

   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}

public class TestThread {

   public static void main(String args[]) {
      PrintDemo PD = new PrintDemo();

      ThreadDemo T1 = new ThreadDemo( "Thread - 1 ", PD );
      ThreadDemo T2 = new ThreadDemo( "Thread - 2 ", PD );

      T1.start();
      T2.start();

      // wait for threads to end
      try {
         T1.join();
         T2.join();
      } catch ( Exception e) {
         System.out.println("Interrupted");
      }
   }
}

```

<br/> 


This produces the same result every time you run this program −

```
Output
Starting Thread - 1
Starting Thread - 2
Counter   ---   5
Counter   ---   4
Counter   ---   3
Counter   ---   2
Counter   ---   1
Thread Thread - 1  exiting.
Counter   ---   5
Counter   ---   4
Counter   ---   3
Counter   ---   2
Counter   ---   1
Thread Thread - 2  exiting.

```

Here is a github link to Java Thread examples that use wait(), notify(),
interrupt(), join() ect..  

https://github.com/jorgeacetozi/java-threads-examples

This is a link to a free beginner-friendly Java Concurrency course

http://tutorials.jenkov.com/java-concurrency/index.html

---
--- 

<br/> 

# Introduction to Golang  

Golang (or Go for short) is a scripting language invented by Robert Griesemer, Rob Pike, and Ken Thompson in 2007 that became an open-sourced language in 2009. Go is a scripting language with automatic memory management and is a type safety language. Go also has some object orientated programming roots since it implements methods and interfaces (like in Java) but does not support a hierarchical interface. Therefore, it relies on functions to complete tasks.  

<br/> 

## Goroutines: 

Go unlike C does not use threads. Go instead implements a function called “Goroutines”.  Goroutines are different than threads due to the fact that they do not need to be type casted to and from a void parameter. Goroutines are initialized by typing in “go” in front of a function. 

E.X. 
```
go list.Sort() 
```
<br/>

Go manages to use concurrency effectively by having multiple “go” functions be semi controlled by a primitive type called a “Channel”. 

Channels are different compared to threads since they avoid the use of manual tracking of shared data. They accomplish this task by having multiple goroutines (threads in C) share a specific data value or values. This means that another goroutine cannot access a given data value unless it is passed from a prior goroutine. This is similar to using deadlocks, semaphores and conditionals variables in C, but by using “chan” in Go, the chan primitive type will control the sharing of mutual data for the programmer. This background work being done by the Go language minimizes the risk of bugs resulting from data races since one data point can’t be accessed by two goroutines at once.  The below example is an example of Go code.  

```
func WorkerGoroutine(data []int, c chan int) { 

    for d := range data { 

        result := SomeOperation(d) 

        c <- result 

    } 

    close(c) 

} 

 

func main() { 

    var data []int = // some data 

    var c chan int = make(chan int, BUF_SIZE) 

 

    go WorkerGoroutine(data, c) 

 

    // blocks until there is data to receive from c and stops when c 

    // has been closed 

    for result := range c { 

        // do something with result 

    } 

} 
```
<br/> 


As can be seen above, the “go workerGoroutine(data, c)” function is the function where concurrency is being initialized in the code. The “data” parameter will be the variable that is telling the above function to use channels to pass the “c” (array) value between multiple goroutines.  

---
<br/> 

## Race Conditions: 

Like C, Go does have the option of restricting who has access to shared data. C completes this using a deadlock (pthread_mutex_lock) while go accomplishes this by setting a buffered channel set to size one. 

### C: 
```
void* sum(void* ret) { 

    for(int i = 0; i < 1000000; i++) { 

        pthread_mutex_lock(&mutex); 

        (*((int*)ret))++; 

        pthread_mutex_unlock(&mutex); 

    } 

} 

 ```

 

### Go: 
```
func sum(sumChan chan int, done chan int) { 

    for i := 0; i < 1000000; i++ { 

        // sumChan has a buffer of size 1, so receiving blocks if there 

        // is another goroutine currently incrementing the sum 

        cur := <-sumChan 

        cur++ 

        sumChan <- cur 

    } 

    done <- 1 

} 

``` 

When programming in Go, a programmer does not need to explicitly unlock this previously locked data as the channels will tell one goroutine when another goroutine is finished editing a variable.   

<br/>

### Deleting a race condition:  

Go is identical to C in being able to detect race conditions. In C we can use the flag “-fsanitize=thread”, while in Go we can use “-race” to detect any race conditions that arise in our compiled code.  

<br/> 

### Segmentation/Slicing:  

In Go we can efficiently add concurrency and parallelism while working on a data structure like an array by breaking up the operations on an array using segmentation/slicing. Segmentation and slicing operations on a list are well known in python. In Go we can use segmentation with “chan” and the go functions to split up the summing of an array into two goroutines/parts. By splitting up an array, this will allow two or more CPU(s) to work on this data structure simultaneously. By completing the following steps, we can achieve concurrency on an array in go: 

 1. Picking some data value(s) (in this case an array) and setting it to a “chan” primitive type 

 2. Slice the array at some arbitrary data point (in this case the middle of the array),  

 3. Then pass off the two parts of the array to the two goroutine functions.  

<br/> 


```

arr := []int{7, 2, 8, -9, 4, 0} 

partSums := make(chan int) 

go sum(a[:len(a)/2], partSums) 

go sum(a[len(a)/2:], partSums) 

x, y := <-partSums, <-partSums 

fmt.Println(x+y) 
```

<br/> 

 The above task in C would require more manual work as the data accessing of the array would have to be manually handled by the C program through the use of deadlocks and context switching.   
 
---
<br/> 

## Cases: 

Cases in the go programming language allow the user to simplistically control which data values they receive information from. In the below example, a programmer could make a for loop that tries to receive a data value from a given channel (in this case channel 1). If the channel hasn’t finished it operations on the targeted data yet, it will move on to the next channel. This process will continue until at least one channel provides information to pass to a new variable. This will occur in the default portion of the select statement. This process is similar to a switch statement in Java.   

OuterLoop: 
```
for { 

    a := <-ch1 

    select { 

    case b := <-ch2: 

        break OuterLoop 

    default: 

        ch1 <- a 

        // wait 

    } 

} 

// use a and b 

 ```

We can take this select statement one step further by setting up a go routine function which can use a sleep operation. This function will force the user to receive a value from the timeout channel, unless the “ch” channel can return a value within one second. This functionally minimizes the risk of deadlocks since this sleep function will automatically assign a value even if another channel is stuck in a priority inversion situation.    

```
timeout := make(chan bool, 1) 

go func() { 

    time.Sleep(1 * time.Second) 

    timeout <- true 

}() 

 

select { 

case <-ch: 

    // a read from ch has occurred 

case <-timeout: 

    // the read from ch has timed out 

} 

 ```

 ---
<br/> 

## Runtime Scheduling: 

Deeper and more control over the synchronization process of goroutines can be accomplished by importing certain packages. The sync and atomic packages allow a go programmer to assist in the process of the scheduler algorithm by providing various operations that are guaranteed to be atomic. For example, runtime.LockOSThread() locks a goroutine to whichever OS thread it happens to be running on. In addition, a programmer can look at runtime information such as the stack trace information by using runtime.Stack(). 

Ultimately, the efficiency of goroutines is determined by the scheduler native to the goroutines and the scheduler native to the operating system of the hardware of the user.  

 ---
 <br/> 
 
## Parallelism:  

 Parallelism can be accomplished by running the runtime.GOMAXPROCS(int) function. The “GOMAXPROCS(int)” function allows you to break up and run multiple parts of your program in parallel by utilizing multiple CPU cores at once. The int variable is defaulted to one, but it can be increased to the amount of CPU cores a given hardware has at its disposal. In the below example, the number of cores allocated by the software’s OS schedule was four. Thus, if we used a non-linear program, we could potentially speed up the runtime of our program by four times (though this is unlikely). 

```
package main 
import ( 
    "fmt" 
    "runtime" 
)// showNo - Shows no from 0 to 99 
func showNo() { 
   for i := 0; i < 100; i++ { 
       fmt.Println("value of i=", i) 
   } 
}// showAlphabets - shows alphabets from a-z 
func showAlphabets() { 
   for j := 'a'; j <= 'z'; j++ { 
       fmt.Println("value of j=", string(j)) 
   } 
}// main function 
func main() { 
/* 
   In newer versions of go by default value GOMAXPROCS is set to no of logical processor you have 
*/runtime.GOMAXPROCS(4)for i := 0; i < 100; i++ { 
      go showNo() 
      go showAlphabets() 
   } 
   a := 0 
   fmt.Scanf("%d", &a) 
} 
```
<br/> 

The effectiveness of Parallelism in GO can fluctuate massively depending on the hardware architecture and the efficiency of the Go software written. If a process is linear in nature, the use of GOMAXPROCS(int)” will not speed up the runtime of the program, but will in fact slow it down. The reason for this is, the complier will have to spend more time allocating resources and memory between the various goroutines, increasing the amount of information that is being processed by the CPU. 

---

<br/> 

### Links used: 

[https://medium.com/a-journey-with-go/go-gomaxprocs-live-updates-407ad08624e1] 

[https://mayurwadekar2.medium.com/concurrency-and-parallelism-in-golang-c8327701fd94]

[https://golang.org/doc/faq#What_operations_are_atomic_What_about_mutexes] 

[http://www.diva-portal.org/smash/get/diva2:1220262/FULLTEXT01.pdf]

[http://dead10ck.github.io/2014/12/15/go-vs-c.html]

---
---
# Threading in C++


## C++ Brief History

<br/> 

The C++ programming language has a history going back to 1979, when Bjarne Stroustrup was doing work for his Ph.D. thesis. He began work on "C with Classes", which as the name implies was meant to be a superset of the C language. His goal was to add object-oriented programming into the C language, which was and still is a language well-respected for its portability without sacrificing speed or low-level functionality. In 1983, the name of the language was changed from C with Classes to C++.

---

## Concurrency -vs- Parallelism
<br/> 

In C and C++, the ideas of concurrency and parallelism are consistent. Parallelism is when we are running multiple **copies** of the same program, but are executed on **different** data. In concurrency, we are accessing a shared memory location and running threads with this shared data. The threads are reading output from other threads, and executing their own operations on this same data. For the purpose of this write up, we will be focusing on the difference of threading set-ups for C and C++. 

---

<br/> 

NOTE: The following code has been provided by C Plus Plus  

### Sample Code:
[https://www.cplusplus.com/reference/thread/thread/]

```
// thread example
#include <iostream>       // std::cout
#include <thread>         // std::thread
 
void foo() 
{
  // do stuff...
}

void bar(int x)
{
  // do stuff...
}

int main() 
{
  std::thread first (foo);     // spawn new thread that calls foo()
  std::thread second (bar,0);  // spawn new thread that calls bar(0)

  std::cout << "main, foo and bar now execute concurrently...\n";

  // synchronize threads:
  first.join();                // pauses until first finishes
  second.join();               // pauses until second finishes

  std::cout << "foo and bar completed.\n";

  return 0;
}
```

Output: 
```
main, foo and bar now execute concurrently...
(...)
foo and bar completed.
```

<br/>


---

<br/>

### Steps To Create Threads
<br/>

> 1. Create threads using std::thread
> 2. Pass function call and parameters with our thread creation i.e. std::thread first (foo);
> 3. Be sure to pass all the parameters needed for the function to run. For example, if foo needed an integer passed as a parameter, we would create our thread i.e. std::thread first (foo(3));
> 4. Thread std::thread do not have return values. If you are wanting to create a return value you must store it as one of the parameters passed by reference. 
> 5. Use .join() to ensure that the threads will finish before the program is exited i.e.first.join(); 



| Task               | Code in C              | Code in C++ |  |
|--------------------|------------------------|-------------|--|
| Creating a thread: | pthread_create() | std::thread |  |
|Parameters for Creating Threads| (thread,attr,start_routine,arg)| Thread Name (Function Call (function parameters))
|Join Threads| pthread_join(threadID[0], &task1Result); | first.join();  |

---

## C and C++ Similarities
As we can see, there are huge similarities between creaing threads in C++ and in C. Both languages require a form of thread creating and thread joining and have libraries that specifically facillitate multithreading. Below is a list of commonalities between the two programming languages:

    > Both the languages have a similar syntax.
    > Code structure of both the languages are same.
    > The compilation of both the languages is similar.
    > They share the same basic syntax. Nearly all of C’s operators and keywords are also present in C++ and do the same thing.
    > C++ has a slightly extended grammar than C, but the basic grammar is the same.
    > Basic memory model of both is very close to the hardware.
    > Same notions of stack, heap, file-scope and static variables are present in both the languages.

[https://www.geeksforgeeks.org/difference-between-c-and-c/]

Therefore, it is not surprising that the approaches to creating and running threads have a similar approach. The biggest difference between these two languages is that C++ supports Object Oriented Programming and Exception Handling. 

---

<br/>

## C and C++ Difference
In C++, the programmer is able to limit the visibility of the members (public, private or protected) because it is able to facillitate using classes compared to C, where we are only able to use structs (where everything is public). A struct is like a bundle, holding data that has been grouped together in a specific context. A class does "things" and considers itself as an object. A class can also utilize interfaces, and therefore create more separation betweent the code and what the user would be seeing. 

---
### Summary

In conclusion, there are many similarities between C and C++ syntactically, and is further noticeable in the creation and running of threads. The biggest difference between these languages is seen in the offering of Object Oriented Programming and Exception Handling in C++, which we do not have in C. 

---
#### SOURCES
[https://www.tutorialspoint.com/History-of-Cplusplus-language]
[https://www.fluentcpp.com/2017/06/13/the-real-difference-between-struct-class/]
[https://www.youtube.com/watch?v=3aqxaZsvn80]
[https://www.cplusplus.com/reference/thread/thread/]
[https://hackernoon.com/learn-c-multi-threading-in-5-minutes-8b881c92941f]
[https://www.geeksforgeeks.org/multithreading-in-cpp/]











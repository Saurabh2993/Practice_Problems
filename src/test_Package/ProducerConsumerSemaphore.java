package Test_Package;

// ProducerConsumerSemaphore.java EECE6029 Cheng 2017
// threads implementing the producer and consumer problem
// simulating a solution with three semaphores to the problem and prints digits consumed
// Figure 2-28 of Tanenbaum
// Usage: java ProducerConsumerSemaphore

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ProducerConsumerSemaphore{
  static final int N = 10;
  static producer p = new producer();
  static consumer c = new consumer();
  static Semaphore mutex = new Semaphore(1);
  static Semaphore empty = new Semaphore(N);
  static Semaphore full = new Semaphore(N);
  static our_monitor mon = new our_monitor();
  static Random random = new Random();
  static int symbol = 0;
 
  public static void main(String[] args){
    full.drainPermits();
    System.out.println(full.availablePermits());
    System.out.println(empty.availablePermits());
    System.out.println(mutex.availablePermits());
    
    p.start();  c.start();
  }

  static class producer extends Thread{
    public void run(){
     while (true){
       try { sleep(random.nextInt(200)); 
         // your code for down(&empty)
   		 empty.acquire();
   		 // your code for down(&mutex)
   		 mutex.acquire();
         mon.insert(symbol);
         // your code for up(&mutex)
         mutex.release();
         // your code for up(&full)
         full.release();
       } catch(InterruptedException e){};
       symbol = (symbol + 1) % 10;
     }
    }
  }

  static class consumer extends Thread{
    public void run(){
     int item = -1;
     while (true){
       try { sleep(random.nextInt(500)); 
         // your code for down(&full)
   		 full.acquire();
         // your code for down(&mutex)
   		 mutex.acquire();
         item = mon.remove();
         // your code for up(&mutex)
         mutex.release();
         // your code for up(&empty)
         empty.release();
       } catch(InterruptedException e){};
       System.out.print(item);
     }
    }
  }

  static class our_monitor{  // not a monitor
     int[] buffer = new int[N];
     int count = 0, lo = 0, hi = 0;

     public void insert(int val){
       if (count == N) return;
       buffer[hi] = val;
       hi = (hi + 1) % N;
       count++;
     }

     public int remove(){
        if (count == 0) return -1;
        int val = buffer[lo];
        lo = (lo + 1) % N;
        count--;
        return val;
     }
   }
}
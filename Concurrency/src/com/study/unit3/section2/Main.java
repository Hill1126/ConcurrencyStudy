package com.study.unit3.section2;

/**
 * @author HILL
 * 用于展示利用信号量semaphore实现模拟打印机的同步操作
 *
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        Thread[] threads = new Thread[5];
//        ThreadPoolExecutor executor =
        for (int i=0;i<threads.length;i++){
            threads[i] = new Thread(new PrintJob(queue));
        }
        assert 1==1;
        for (Thread thread :threads){
            thread.start();
        }
    }
}

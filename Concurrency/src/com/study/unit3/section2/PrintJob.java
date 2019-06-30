package com.study.unit3.section2;

public class PrintJob implements Runnable {
    private   PrintQueue queue ;
    PrintJob(PrintQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始打印");
        queue.printJob(new Object());
        System.out.println(Thread.currentThread().getName()+"已经打印结束");
    }
}

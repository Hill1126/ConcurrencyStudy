package com.study.unit3.section2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *  semaphore内部是一个计数器在初始化时确定资源数量
 *  当内部计数器为0时，线程调用 semaphore.acquire();将会被休眠
 *  直到计数器不为0。
 */
public class PrintQueue {
    private final Semaphore semaphore;

    PrintQueue(){
        semaphore = new Semaphore(1);
    }

    public void  printJob(Object job){
        try {
            semaphore.acquire();
            double printJobTime = Math.random() * 10;
            TimeUnit.SECONDS.sleep((int)printJobTime);
            System.out.println(Thread.currentThread().getName()+"线程打印时间为"+printJobTime+"秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

}

package com.study.threadpool;

import java.util.concurrent.ThreadFactory;

/**
 * @author HILL
 * @version V1.0
 * @date 2019/7/3
 * @deprecated 实现线程方法，完成对线程的自定义命名操作，使线程的动态更加清楚
 **/
public class BasicThreadFactory implements ThreadFactory {


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("位于线程工厂的线程");
        return thread;
    }



}

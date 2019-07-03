package com.study.threadpool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author HILL
 * @date  2019/7/3
 * @version V1.0
 * @deprecated TODO
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(10);
        BasicThreadFactory factory = new BasicThreadFactory();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 10, 60,
                TimeUnit.SECONDS, queue, factory,
                (Runnable r, ThreadPoolExecutor executor)->{
                        System.out.println(executor.getQueue().size()+"消息队列已满");
                        System.out.println("拒绝服务");

                });

        Runnable task = ()->{
            System.out.println("任务启动");
            System.out.println(Thread.currentThread().getName()+"执行了任务");
            try {
                Random random = new Random();
                int i = random.nextInt(10);
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
            }
            System.out.println("任务完成");

        };
        int i = 0;
        int startThreadNum = 25;
        while (i<startThreadNum){
            poolExecutor.execute(task);
            i++;
        }

        poolExecutor.shutdown();


    }
}

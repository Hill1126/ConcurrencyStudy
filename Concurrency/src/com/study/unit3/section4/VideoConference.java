package com.study.unit3.section4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author HILL
 * @date 2019-6-30
 *视频会议类，利用CountDownLatch对象实现线程等待操作完成前，一直阻塞。
 */
public class VideoConference implements Runnable{
    private CountDownLatch controller;

    VideoConference(int arriveNum){
        //初始化CountDownLatch对象，指定对象需要等待多少个操作
       this.controller = new CountDownLatch(arriveNum);
    }

    public void arrive(){
        controller.countDown();//到达一个来宾，计数器-1
    }

    @Override
    public void run() {
        try {
            //计数器没有到0前一直阻塞
            controller.await();
            System.out.println("嘉宾已经全部到达，开始会议");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("会议结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

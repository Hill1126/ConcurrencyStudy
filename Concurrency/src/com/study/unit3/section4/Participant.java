package com.study.unit3.section4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            System.out.println("会议参加人员,"+this.name+"已出发");
            int arrive= new Random().nextInt(10);
            TimeUnit.SECONDS.sleep(arrive);
            conference.arrive();
            System.out.println("会议人员"+this.name+"用时"+arrive+"到达视频会议产所");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

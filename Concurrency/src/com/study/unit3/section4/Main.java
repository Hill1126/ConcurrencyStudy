package com.study.unit3.section4;

public class Main {
    public static void main(String[] args) {
        VideoConference conference = new VideoConference(5);
        new Thread(conference).start();
        for (int i = 0; i < 5; i++) {
            new Thread(new Participant(conference,"参与者"+i)).start();
        }
    }
}

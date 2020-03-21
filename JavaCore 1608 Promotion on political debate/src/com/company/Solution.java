package com.company;

/*

1608 Promotion of the political debate
1. Understand what the program does.
2. It is necessary to make Ivanov say most things in the political debate.
3. Think about what method you can call the ivanov object so that Ivanov talks until all the free time is over.

Requirements:
1. Call the join method on the desired object.
2. The Politician class toString method should output how many things a politician has said, for example: "Ivanov has said the speech 35 times".
3. The program must create 3 objects of type Politician.
4. Do not change the methods that are responsible for output to the console.
5. The conclusion of the program should indicate that Ivanov said most of the things in the political debate.


 */

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static int totalCountSpeeches = 200;
    public static int soundsInOneSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        Politician ivanov = new Politician("Иванов");
        ivanov.join();
        Politician petrov = new Politician("Петров");
        Politician sidorov = new Politician("Сидоров");

        while (ivanov.getCountSpeeches() + petrov.getCountSpeeches() + sidorov.getCountSpeeches() < totalCountSpeeches) {
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politician extends Thread {
        private volatile int countSounds;

        public Politician(String name) {
            super(name);
            start();
        }

        public void run() {
            while (countSounds < totalCountSpeeches * soundsInOneSpeech) {
                countSounds++;
            }
        }

        public int getCountSpeeches() {
            return countSounds / soundsInOneSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getCountSpeeches());
        }
    }
}


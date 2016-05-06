package com.example;

import java.util.Random;

public class Joker {

    Random random;

    String[] jokes = {
            "Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all.",
            "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                    "\n" +
                    "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                    "\n" +
                    "Doctor: \"Nine.\" " ,
            "A man asks a farmer near a field, “Sorry sir, would you mind if I crossed your field instead of going around it? You see, I have to catch the 4:23 train.”\n" +
                    "\n" +
                    "The farmer says, “Sure, go right ahead. And if my bull sees you, you’ll even catch the 4:11 one.” ",
            "It is so cold outside I saw a politician with his hands in his own pockets.\n",
            "What is the difference between a snowman and a snowwoman?\n" +
                    "-\n" +
                    "Snowballs.\n"
    };

    public Joker(){
        random = new Random();
    }

    public String getJoke() {
        int jokeNumber = random.nextInt(jokes.length);
        System.out.println(jokes[jokeNumber]);
        return jokes[jokeNumber];
    }
}

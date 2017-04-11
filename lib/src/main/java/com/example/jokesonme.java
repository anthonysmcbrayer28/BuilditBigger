package com.example;


import java.util.Random;






public class jokesonme {
    public String setjoke()
    {
        return "this is a good joke ";
    }


    public static String getJoke() {
        String jokes[]={
                "Q: What is red and smells like blue paint? \n A: red paint! ","Q: Why do java programmers where glasses \n A: they dont c#",
                "If i had a dollar for every girl that found me unattractive, they would eventually find me attractive.","you should hire me."


        };

        int idx = new Random().nextInt(jokes.length);
        return jokes[idx];
    }
}















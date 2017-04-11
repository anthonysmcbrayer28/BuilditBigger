package com.example.android.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.jokesonme.getJoke;

public class jokeFactory extends AppCompatActivity {




    public static String JOKE_KEY = "JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_factory);

        TextView textview = (TextView) findViewById(R.id.joke_text);

        String JokeResult = null ;

        Intent intent = getIntent();
        JokeResult = intent.getStringExtra(getString(R.string.jokeEnvelope));


        if (JokeResult != null) {
            textview.setText(getJoke());
        } else {
            textview.setText("why does it do this");
        }


    }
}
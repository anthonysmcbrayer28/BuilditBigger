package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.support.v4.app.Fragment;

import com.example.android.mylibrary.jokeFactory;
import com.udacity.gradle.builditbigger.EndpointAsynaTask;
import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment {
    public boolean testFlag = false;


    public MainActivityFragment() {

    }

    ProgressBar progressBar = null;
    public String loadedJoke = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        // Set onClickListener for the button
        Button button = (Button) root.findViewById(R.id.button_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.GONE);
                getJoke();
            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.joke_progressbar);
        progressBar.setVisibility(View.GONE);
        return root;
    }

    public void getJoke() {
        new EndpointAsynaTask().execute(this);
    }

    public void launchDisplayJokeActivity() {
        if (!testFlag) {
            Context context = getActivity();
            Intent intent = new Intent(context, jokeFactory.class);
            intent.putExtra(context.getString(R.string.jokeEnvelope), loadedJoke);

            context.startActivity(intent);
            progressBar.setVisibility(View.GONE);
        }

    }
}


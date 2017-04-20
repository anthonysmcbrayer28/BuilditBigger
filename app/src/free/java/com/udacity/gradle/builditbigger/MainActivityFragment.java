package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.example.antho_000.myapplication.backend.myApi.MyApiRequest;

import com.example.android.mylibrary.jokeFactory;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.EndpointAsynaTask;
import com.udacity.gradle.builditbigger.R;

import static android.os.AsyncTask.execute;

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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);

        // Set onClickListener for the button
        Button button = (Button) root.findViewById(R.id.button_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.GONE);
                getJoke();
            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.joke_progressBar);
        progressBar.setVisibility(View.GONE);



        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
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

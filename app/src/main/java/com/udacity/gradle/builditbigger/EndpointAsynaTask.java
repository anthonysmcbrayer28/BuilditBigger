package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import com.example.antho_000.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

;
;


/**
 * Created by antho_000 on 3/28/2017.
 */
public class EndpointAsynaTask extends AsyncTask<MainActivityFragment, Void, String> {
    private static MyApi myApiService = null;
    private MainActivityFragment mainActivityFragment;

    public EndpointAsynaTask() {

    }



    @Override
    protected String doInBackground(MainActivityFragment... params) {
        mainActivityFragment = params[0];
        Context context = mainActivityFragment.getActivity();

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("https://android-app-backend.appspot.com/_ah/api/");

            myApiService = builder.build();
        }




        try {
            return myApiService.telljoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mainActivityFragment.loadedJoke = result;
        mainActivityFragment.launchDisplayJokeActivity();
    }
}



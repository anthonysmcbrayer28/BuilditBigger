/**
 * Created by antho_000 on 4/10/2017.
 */

package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.R.attr.fragment;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskTest extends AndroidTestCase {
    private static final String LOG_TAG ="EndPointAsyncTaskTest";
    @SuppressWarnings("unChecked")
    public void Test(){
        Log.v("EndPointAsyncTaskTest","Running EndPointAsyncTaskTest test");
        String result = null;
        EndpointAsynaTask endpointAsynaTask = new EndpointAsynaTask(getContext(), null);
        endpointAsynaTask.execute();
        try {
            result = endpointAsynaTask.get();
            Log.d(LOG_TAG, "Retrieved a non -empty String:"+ result);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull(result);


    }
}

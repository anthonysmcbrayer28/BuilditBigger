/**
 * Created by antho_000 on 4/10/2017.
 */

package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;



public class EndPointAsyncTaskTest extends AndroidTestCase {
    private static final String LOG_TAG ="EndPointAsyncTaskTest";
    @SuppressWarnings("unChecked")
    public void Test(){
        Log.v("EndPointAsyncTaskTest","Running EndPointAsyncTaskTest test");
        String result = null;
        EndpointAsynaTask endpointAsynaTask = new EndpointAsynaTask();
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

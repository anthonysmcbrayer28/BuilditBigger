/**
 * Created by antho_000 on 4/10/2017.
 */

package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.R.attr.fragment;
import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTaskTest {

    @Test
    public void testDoInBackground() throws Exception {
        com.udacity.gradle.builditbigger.MainActivityFragment fragment = new com.udacity.gradle.builditbigger.MainActivityFragment();
        fragment.testFlag = true;
        new EndpointAsynaTask().execute(fragment);
        Thread.sleep(4000);
        assertTrue("Error: get Joke = " + fragment.loadedJoke, fragment.loadedJoke != null);
    }
}

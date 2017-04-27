/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.antho_000.myapplication.backend;

import com.example.jokesonme;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;



/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.antho_000.example.com",
                ownerName = "backend.myapplication.antho_000.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "telljoke")
    public MyBean tellJoke(){
        MyBean response = new MyBean();
        jokesonme jokesonme = new jokesonme();
        response.setData(jokesonme.getJoke());

        return response;
    }


}

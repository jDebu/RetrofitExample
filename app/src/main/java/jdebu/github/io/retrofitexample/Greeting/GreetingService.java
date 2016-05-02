package jdebu.github.io.retrofitexample.Greeting;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Glup on 2/05/16.
 */
interface GreetingService {
    @GET("/greeting")
    Call<List<Greeting>> callback();
    public static final Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("http://rest-service.guides.spring.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

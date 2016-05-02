package jdebu.github.io.retrofitexample.Greeting;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import jdebu.github.io.retrofitexample.R;
import retrofit2.Call;

//import retrofit.Callback;
//import retrofit.RestAdapter;
//import retrofit.RetrofitError;
//import retrofit.client.Response;

/**
 * Created by Glup on 2/05/16.
 */
public class HelloWorld extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();

        /*final String BASE_URL = "http://rest-service.guides.spring.io/greeting";
        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

        GreetingService service = retrofit.create(GreetingService.class);

        service.getGreeting(new Callback<Greeting>() {
            @Override
            public void success(Greeting greeting, Response response) {
                Greeting greeting1= (Greeting) response.getBody();
                TextView greetingIdText = (TextView) findViewById(R.id.R_id_lblId);
                TextView greetingContentText = (TextView) findViewById(R.id.R_id_lblContent);
                greetingIdText.setText(greeting.getId());
                greetingContentText.setText(greeting.getContent());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("HelloWorld", error.getMessage());
            }
        });*/

    }
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.hello);
        //GreetingService greetingService=GreetingService.retrofit.create(GreetingService.class);
        //final Call<List<Greeting>> call = greetingService.callback();
        //new NetworkCall().execute(call);

    }
    private class  NetworkCall extends AsyncTask<Call,Void,String>{
        @Override
        protected String doInBackground(Call... params) {

        try {
            return params[0].execute().body().toString();
        } catch (IOException e) {
            Log.e("Error",e.getMessage());
        }

            return null;
        }
        @Override
        protected void onPostExecute(String result){
            Log.e("Result",result);
        }
    }
}

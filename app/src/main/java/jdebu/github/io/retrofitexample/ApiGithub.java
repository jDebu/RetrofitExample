package jdebu.github.io.retrofitexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Glup on 2/05/16.
 */
public class ApiGithub extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.github);
        final Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
        Call<List<Repo>> repos=service.listRepos("jdebu");
        new NetworkCall().execute(repos);

    }
    private class  NetworkCall extends AsyncTask<Call,Void,ArrayList<Repo>> {
        @Override
        protected ArrayList<Repo> doInBackground(Call... params) {

            try {
                return (ArrayList<Repo>)params[0].execute().body();
            } catch (IOException e) {
                Log.e("Error", e.getMessage());
            }

            return null;
        }
        @Override
        protected void onPostExecute(ArrayList<Repo> result){
            Log.e("Result","Rep:"+result.get(0).getName());
        }
    }
}

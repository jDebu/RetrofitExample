package jdebu.github.io.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Glup on 2/05/16.
 */
interface GithubService {
    @GET("users/{owner}/repos")
    Call<List<Repo>> listRepos(@Path("owner") String owner);
}

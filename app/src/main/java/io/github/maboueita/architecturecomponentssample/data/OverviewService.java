package io.github.maboueita.architecturecomponentssample.data;

import android.arch.lifecycle.LiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Overview refers to the endpoint responsible for returning the latest best seller lists.
 */

public interface OverviewService {

    String BASE_API_URL = "http://api.nytimes.com/svc/books/v3/lists/";
    
    @Headers("api-key:1834f843952d460da0fe61bec1e06e85")
    @GET("overview.json")
    public Call<OverviewApiResponse.Results> getBestSellers();

}

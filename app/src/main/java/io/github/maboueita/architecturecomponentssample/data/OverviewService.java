package io.github.maboueita.architecturecomponentssample.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Overview refers to the endpoint responsible for returning the latest best seller lists.
 */

public interface OverviewService {

    String BASE_API_URL = "http://api.nytimes.com/svc/books/v3/lists/";
    
    @Headers("api-key:fb999a49-abba-4853-9c73-595b582ef4d5")
    @GET("overview.json")
    Call<OverviewViewModel.Results> getBestSellers();

}

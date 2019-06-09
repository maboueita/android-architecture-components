package io.github.maboueita.architecturecomponentssample.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Overview refers to the endpoint responsible for returning the latest best seller lists.
 */

public interface OverviewService {
    String BASE_API_URL = "https://api.nytimes.com/svc/books/v3/lists/";
    @Headers({
            "Accept: application/json",
    })
    @GET("overview.json?api-key=GfKA3zS2UhPeiPjlfIeAN3jKYVRWK3sF")
    Call<OverviewViewModel.Results> getBestSellers();
}

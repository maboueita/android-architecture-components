package io.github.maboueita.architecturecomponentssample.data


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import android.util.Log

import com.google.gson.annotations.SerializedName

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OverviewViewModel : ViewModel() {

    var results: LiveData<Results>? = null

    fun init() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
                .baseUrl(OverviewService.BASE_API_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(OverviewService::class.java)
        service.bestSellers.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<OverviewViewModel.Results>, response: Response<OverviewViewModel.Results>) {
                if (response.body() != null) {
                    val data = MutableLiveData<Results>()
                    data.value = response.body()
                    Log.d("YOLO ", "data is here. success.")
                }
            }
            override fun onFailure(call: Call<OverviewViewModel.Results>, t: Throwable) {
                //TODO: Add logging.
                Log.e("YOLO error ", t.message)
            }
        })
    }

    inner class Results {

        @SerializedName("bestsellers_date")
        var bestSellersDate: String? = null
        @SerializedName("published_date_description")
        var publishedDateDescription: String? = null
        private var lists: List<Lists>? = null

        internal inner class Lists {
            @SerializedName("list_id")
            var listId: Int = 0
            @SerializedName("list_name")
            var listName: String? = null
            @SerializedName("books")
            var books: List<Book>? = null

            internal inner class Book {
                var author: String? = null
                var title: String? = null
                var description: String? = null
            }
        }
    }
}


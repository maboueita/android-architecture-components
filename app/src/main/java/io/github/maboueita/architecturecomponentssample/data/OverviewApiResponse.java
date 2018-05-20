package io.github.maboueita.architecturecomponentssample.data;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OverviewApiResponse extends ViewModel {

    private static final String TAG = OverviewApiResponse.class.getSimpleName();

    private LiveData<Results> results;

    public LiveData<Results> getResults() {
        return results;
    }

    public void setResults(LiveData<Results> results) {
        this.results = results;
    }

    public OverviewApiResponse() {

    }

    public void init() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(OverviewService.BASE_API_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        OverviewService service = retrofit.create(OverviewService.class);
        service.getBestSellers().enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<OverviewApiResponse.Results> call, Response<OverviewApiResponse.Results> response) {
                if (response.body() != null) {
                    final MutableLiveData<Results> data = new MutableLiveData<>();
                    data.setValue(response.body());
                    Log.d(TAG, "onResponse: data? " + String.valueOf(data == null));
                    Log.d(TAG, "data? " + String.valueOf(data.getValue() == null));
                    Log.d(TAG, "data? " + String.valueOf(data.getValue()));
                }
            }

            @Override
            public void onFailure(Call<OverviewApiResponse.Results> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }


        });
    }

    public class Results {

        @SerializedName("bestsellers_date")
        private String bestSellersDate;
        @SerializedName("published_date_description")
        private String publishedDateDescription;
        private List<Lists> lists;

        public String getBestSellersDate() {
            return bestSellersDate;
        }

        public void setBestSellersDate(String bestSellersDate) {
            this.bestSellersDate = bestSellersDate;
        }

        public Results() {
        }

        public String getPublishedDateDescription() {
            return publishedDateDescription;
        }

        public void setPublishedDateDescription(String publishedDateDescription) {
            this.publishedDateDescription = publishedDateDescription;
        }

        public List<Lists> getLists() {
            return lists;
        }

        public void setLists(List<Lists> lists) {
            this.lists = lists;
        }

        class Lists {

            @SerializedName("list_id")
            private int listId;
            @SerializedName("list_name")
            private String listName;
            @SerializedName("books")
            private List<Book> books;

            public Lists() {

            }

            public int getListId() {
                return listId;
            }

            public void setListId(int listId) {
                this.listId = listId;
            }

            public String getListName() {
                return listName;
            }

            public void setListName(String listName) {
                this.listName = listName;
            }

            public List<Book> getBooks() {
                return books;
            }

            public void setBooks(List<Book> books) {
                this.books = books;
            }

            class Book {

                private String author;
                private String title;
                private String description;

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }
            }


        }


    }


}

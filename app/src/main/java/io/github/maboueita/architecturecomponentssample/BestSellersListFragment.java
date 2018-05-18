package io.github.maboueita.architecturecomponentssample;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.maboueita.architecturecomponentssample.data.OverviewApiResponse;
import io.github.maboueita.architecturecomponentssample.data.OverviewService;
import retrofit2.Retrofit;

public class BestSellersListFragment extends LifecycleFragment {

    private static final String TAG = BestSellersListFragment.class.getSimpleName();

    OverviewApiResponse overviewApiResponse;

    public BestSellersListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        overviewApiResponse = ViewModelProviders.of(this).get(OverviewApiResponse.class);
        overviewApiResponse.init();

        if (overviewApiResponse.getResults() != null) {
            overviewApiResponse.getResults().observe(this, results -> {
                Log.d(TAG, "onActivityCreated: did data change? ");
            });
        }
        
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_best_sellers_list, container, false);
    }

}

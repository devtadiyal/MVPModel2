package com.firstapp.mvpmodel.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.firstapp.mvpmodel.apicontent.ApiClient;
import com.firstapp.mvpmodel.apicontent.ApiInterface;
import com.firstapp.mvpmodel.mvp.BasePresenter;
import com.firstapp.mvpmodel.responsemodel.TyreListResponse;
import com.firstapp.mvpmodel.utility.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TyrePresenterImp extends BasePresenter<TyrePresenter.View> implements TyrePresenter {

    public TyrePresenterImp(View mview) {
        view = mview;
    }

    @Override
    public void onViewActive(View view) {
        super.onViewActive(view);
    }


    @Override
    public void onViewInActive() {
        super.onViewInActive();
    }


    @Override
    public void login(String auth, String contentype) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TyreListResponse> userCall = apiInterface.tyre_list(
                auth,contentype);
        userCall.enqueue(new Callback<TyreListResponse>() {
            @Override
            public void onResponse(Call<TyreListResponse> call, Response<TyreListResponse> response) {
                if (response.isSuccessful()) {
                    view.hideLoadingLayout();
                    TyreListResponse tyreListResponse = response.body();
                    Log.d("login successful ", response.message());
                    view.TyreResponse(tyreListResponse);
                }
            }


            @Override
            public void onFailure(Call<TyreListResponse> call, Throwable t) {
                if (view != null) {
                    view.hideLoadingLayout();
                    view.showError(Constant.INTERNET_CONNECTION_ERROR);
                }
            }
        });

    }
}
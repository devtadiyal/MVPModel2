package com.firstapp.mvpmodel.presenter;

import com.firstapp.mvpmodel.mvp.MainView;
import com.firstapp.mvpmodel.responsemodel.TyreListResponse;

import okhttp3.ResponseBody;

public interface TyrePresenter {

    interface View<ViewT> extends MainView<ViewT> {

        void TyreResponse(TyreListResponse response);
    }

    void login(String hashnumber, String password);


}

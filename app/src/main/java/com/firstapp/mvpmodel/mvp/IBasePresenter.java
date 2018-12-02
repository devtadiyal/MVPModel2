package com.firstapp.mvpmodel.mvp;

public interface IBasePresenter<ViewT> {

    void onViewActive(ViewT view);

    void onViewInActive();
}

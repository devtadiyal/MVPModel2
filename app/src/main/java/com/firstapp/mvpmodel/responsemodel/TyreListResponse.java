package com.firstapp.mvpmodel.responsemodel;

import java.util.ArrayList;

public class TyreListResponse {

    private int errorcode;
    private boolean status;
    private ArrayList<TyreListResponse2> data;

    public ArrayList<TyreListResponse2> getData() {
        return data;
    }

    public void setData(ArrayList<TyreListResponse2> data) {
        this.data = data;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }




}

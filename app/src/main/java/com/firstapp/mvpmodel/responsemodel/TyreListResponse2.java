package com.firstapp.mvpmodel.responsemodel;

import android.os.Parcel;
import android.os.Parcelable;

public class TyreListResponse2 implements Parcelable{

private int productId;
    private String productName;
    private String imagePath;

    protected TyreListResponse2(Parcel in) {
        productName = in.readString();
        imagePath = in.readString();
        productId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productName);
        dest.writeString(imagePath);
        dest.writeInt(productId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TyreListResponse2> CREATOR = new Creator<TyreListResponse2>() {
        @Override
        public TyreListResponse2 createFromParcel(Parcel in) {
            return new TyreListResponse2(in);
        }

        @Override
        public TyreListResponse2[] newArray(int size) {
            return new TyreListResponse2[size];
        }
    };

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}

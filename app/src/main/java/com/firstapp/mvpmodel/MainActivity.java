package com.firstapp.mvpmodel;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.firstapp.mvpmodel.adapter.AdapterClass;
import com.firstapp.mvpmodel.presenter.TyrePresenter;
import com.firstapp.mvpmodel.presenter.TyrePresenterImp;
import com.firstapp.mvpmodel.responsemodel.TyreListResponse;
import com.firstapp.mvpmodel.responsemodel.TyreListResponse2;
import com.firstapp.mvpmodel.utility.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

public class MainActivity extends BaseActivity implements TyrePresenter.View ,View.OnClickListener {
    TyrePresenterImp tyrePresenterImp;
    RecyclerView recyclerView;
    TextView header;
    ArrayList<Integer> productId = new ArrayList<>();
    private List<TyreListResponse2> list = new ArrayList<>();
    AdapterClass adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tyrePresenterImp = new TyrePresenterImp(this);
        tyrePresenterImp.login("Bearer vagVtNV31Co9-FyoXfvuGZXLHF6DpDdjOeYKJx7C0Q8Hyy_BU3aulC2Im4tOWl2GqjAT50SnWnUSOJ9425hctFxsIBJaXNt6xkssMeI76N08II6xSARWwrCkqr1wAy0vlMyOAMvRiVh3r3P4uHrrqPGQxXO_apiiSth_e_7h9GF_fLwe4SjkWhl8OjTYuSTQ-06T1mfLyvb7bDXp-spPFMoMZSSW0E-fXT8TY52DiPvksDkP4qpfN2l4_daWj_BkaYP5Xs4AZchVMWb_eN_PBnmzLYknyvd7C68_w2J6E57J6gE-d_sKe8UwbQPC5Mgcs3sxaK35IBYd1KDZayVwG3ILlUSKpBVp0mIQXeQ40lreZbcuIEwO6xsOe-QiB4h9SzkBE64QFgosN0juzLeYM15Kz00I2shsEXb-GNb-mdU07dzCArCE8hMgEAUXP_dIlJZBv3J2YnuEyJhSq4jPidiEDiN75zUATaaFRHUTR1LY99eLj_CCvBsuILy5AzbEUn1V0ruFs_gTAxr6k_WnWw",
                "application/json");

    }

    @Override
    public void TyreResponse(TyreListResponse response) {

        for (TyreListResponse2 respons : response.getData()) {
            list.add(respons);
            productId.add(respons.getProductId());
        }
        // System.out.println("PRODUCT ID " + productId);
        adapter = new AdapterClass(response.getData(), MainActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showError(String response) {

    }

    @Override
    public void showLoadingLayout() {

    }

    @Override
    public void hideLoadingLayout() {

    }

    @Override
    public void onClick(View view) {

    }
}

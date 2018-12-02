package com.firstapp.mvpmodel.utility;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Objects;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    int previously_selected_layout = 0;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);*/
        progressDialog = new ProgressDialog(BaseActivity.this);
        String DEFAULT_MESSAGE = "Please wait...";
        progressDialog.setMessage(DEFAULT_MESSAGE);
        //hideSoftKeyboard();
    }

    public void showProgress(String message, boolean isCancelable) {
        if (!isFinishing()) {
            progressDialog.setMessage(message);
            progressDialog.setCancelable(isCancelable);
            progressDialog.show();
        }
    }

    public void showProgress(String message) {
        showProgress(message, false);
    }

    public void showProgressDialog(String message) {
        showProgress(message);
    }

    public void dismissProgress() {
        try {
            if (progressDialog != null) {
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setView(View view) {
        ((View) view.getParent()).setSelected(true);
        View v1 = findViewById(previously_selected_layout);
        if (v1 != null) {
            v1.setSelected(false);
        }
        previously_selected_layout = ((View) view.getParent()).getId();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }

    public void hideKeyboard(Context context, View view) {
        try {
            if (context != null) {
                InputMethodManager methodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                Objects.requireNonNull(methodManager).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        Objects.requireNonNull(inputManager).hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void showKeyboard(Context context) {
        InputMethodManager methodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        Objects.requireNonNull(methodManager).toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}
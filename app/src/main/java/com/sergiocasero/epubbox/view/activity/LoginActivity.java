package com.sergiocasero.epubbox.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sergiocasero.epubbox.R;
import com.sergiocasero.epubbox.presenter.module.LoginPresenter;
import com.sergiocasero.epubbox.view.module.Login;

public class LoginActivity extends AppCompatActivity implements Login{

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializePresenter();
    }

    private void initializePresenter() {
        loginPresenter = new LoginPresenter();
        loginPresenter.setView(this);
        loginPresenter.initialize();
    }
}

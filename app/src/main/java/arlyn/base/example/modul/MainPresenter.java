package arlyn.base.example.modul;

import android.util.Log;

import java.util.ArrayList;

import arlyn.playground.base.ConstantStatus;

public class MainPresenter implements MainContract.Presenter{
    private final MainContract.View view;


    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }


    @Override
    public void performLogin(String email, String password) {

    }
}

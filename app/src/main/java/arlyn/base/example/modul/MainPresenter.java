package arlyn.base.example.modul;

import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

import arlyn.base.example.data.pojo.User;
import arlyn.base.example.data.source.MainDataSource;
import arlyn.playground.base.ConstantStatus;
import arlyn.playground.base.DataResult;
import arlyn.playground.base.RequestResponseListener;

public class MainPresenter implements MainContract.Presenter{
    private final MainContract.View view;
    private final MainDataSource mainDataSource;
    private User user;



    public MainPresenter(MainContract.View view, MainDataSource mainDataSource) {
        this.view = view;
        this.mainDataSource = mainDataSource;

    }

    @Override
    public void start() {

    }


    @Override
    public void performLogin(final String email, final String password){

        view.setLoadingDialog(true, "Login...");
        mainDataSource.login(email, password,new RequestResponseListener() {
            @Override
            public void onSuccess(String dataResult) {
                user = new DataResult<User>().getResult(user, User.class, dataResult);
                if(user.getStatusCode().equals("000")) {//success
                    view.setLoadingDialog(false, null);
                    view.showStatus(ConstantStatus.STATUS_SUCCESS, "Login Success");
                    Log.i("Test", dataResult);
                }else{
                    view.setLoadingDialog(false, null);
                    view.showStatus(ConstantStatus.STATUS_ERROR, "Login failed");
                }
            }


            @Override
            public void onFailure(Throwable throwable) {
                view.setLoadingDialog(false, null);
                view.showStatus(ConstantStatus.STATUS_ERROR, "Gagal terhubung ke server");
            }
        });
    }
}

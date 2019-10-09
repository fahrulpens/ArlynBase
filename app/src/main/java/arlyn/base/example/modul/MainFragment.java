package arlyn.base.example.modul;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import arlyn.base.example.R;
import arlyn.playground.base.BaseFragment;

public class MainFragment extends BaseFragment<MainActivity, MainContract.Presenter> implements MainContract.View {

    public MainFragment() {
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_main, container, false);

        mPresenter = new MainPresenter(this);
        mPresenter.start();

        return fragmentView;
    }



    @Override
    protected void setTitle() {
        title = "Title From Fragment";
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadingDialog(boolean isLoading, @Nullable String message) {
        super.setLoadingDialog(isLoading, message);
    }

    @Override
    public void showStatus(int type, String message) {
        super.showStatus(type, message);
    }

    @Override
    public void redirectToProfile() {


    }


}

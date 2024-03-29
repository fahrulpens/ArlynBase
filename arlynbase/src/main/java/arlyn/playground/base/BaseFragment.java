package arlyn.playground.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public abstract class BaseFragment<T extends FragmentActivity, U extends BasePresenter> extends Fragment {

    protected String title;
    protected T activity;
    protected ProgressDialog loadingDialog;
    protected View fragmentView;
    protected U mPresenter;
    protected FragmentListener fragmentListener;
    private boolean loading;

    protected abstract void setTitle();

    protected String getTitle() {
        return title;
    }

    protected boolean isLoading() {
        return loading;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        title = getResources().getString(R.string.app_name);
        setTitle();
        fragmentListener.setTitle(title);

        return view;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (T) context;
        this.fragmentListener = (FragmentListener) context;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected void setLoadingDialog(boolean isLoading, @Nullable String message) {
        loading = isLoading;
        if (isLoading) {
            loadingDialog = new ProgressDialog(getContext());
//            loadingDialog.setCancelable(true);
            loadingDialog.setMessage(message);
            loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            loadingDialog.setProgress(0);
            loadingDialog.setMax(100);
            loadingDialog.show();
        } else {
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }
    }

    protected void showStatus(int type, String message) {
        new Toaster().builder(activity)
                .setType(type)
                .setMessage(message)
                .show();
    }

    protected void showToast(int type, String message) {
        new Toaster().builder(activity)
                .setType(type)
                .setMessage(message)
                .show();
    }
}

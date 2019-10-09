package arlyn.base.example.modul;

import arlyn.playground.base.BasePresenter;
import arlyn.playground.base.BaseView;

public interface MainContract{
    interface View extends BaseView<Presenter> {
        void redirectToProfile();
    }
    interface Presenter extends BasePresenter {
        void performLogin(String email, String password);
    }
}

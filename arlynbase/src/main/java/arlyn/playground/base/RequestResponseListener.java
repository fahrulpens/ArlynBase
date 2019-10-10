package arlyn.playground.base;


public interface RequestResponseListener<T> {
    void onSuccess(String result);

    void onFailure(Throwable throwable);
}

package arlyn.playground.base;

import android.util.Log;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public abstract class BaseRemoteRepository<V> {

    protected Retrofit retrofit;
    protected V endPoint;

    protected BaseRemoteRepository() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(setBaseUrl())
                .addConverterFactory(ScalarsConverterFactory.create());

        if (enableLogging()) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS);

            retrofitBuilder.client(httpClient.build());
        }

        retrofit = retrofitBuilder.build();

        setEndPoint();
    }
    protected BaseRemoteRepository(boolean isUnsafeRepository) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(setBaseUrl())
                .addConverterFactory(ScalarsConverterFactory.create());

        if (enableLogging()) {
            OkHttpClient httpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
            retrofitBuilder.client(httpClient);
        }

        retrofit = retrofitBuilder.build();

        setEndPoint();
    }

    protected abstract String setBaseUrl();

    protected abstract void setEndPoint();

    protected abstract boolean enableLogging();

    @SuppressWarnings("unchecked")
    protected <T> void execute(Call call, final RequestResponseListener listener) {


        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body() == null) {
                    listener.onFailure(new Throwable());
                    Log.e("Fatal Error", "JSON Mal-formatted");
                } else {
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                listener.onFailure(t);
            }
        });
    }



}

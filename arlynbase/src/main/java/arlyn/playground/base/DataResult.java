package arlyn.playground.base;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

public class DataResult<T> {

    public T getResult(T data, String response) {
        Class<T> tClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return new Gson().fromJson(response, tClass);
    }
}

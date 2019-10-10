package arlyn.playground.base;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DataResult<T> {

    public T getResult(T data, Class<T> tClass, String response) {
        String cleanResponse = response;
        if(!response.startsWith("{"))
            cleanResponse = new JsonResponseCleaner().JsonCleaning(response);
        return new Gson().fromJson(cleanResponse, tClass);
    }
}

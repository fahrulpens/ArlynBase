package arlyn.base.example.data.source;

import java.util.HashMap;
import java.util.Map;

import arlyn.playground.base.BaseRemoteRepository;
import arlyn.playground.base.RequestResponseListener;
import retrofit2.Call;

public class MainDataSource extends BaseRemoteRepository<MainEndPoint> {
    private static final String BASE_URL = "http://arlyn-project.online";

    public MainDataSource() {
        super();
    }

    public MainDataSource(boolean isUnsafeRepository) {
        super(isUnsafeRepository);
    }

    @Override
    protected String setBaseUrl() {
        return BASE_URL;
    }

    @Override
    protected void setEndPoint() {
        endPoint = retrofit.create(MainEndPoint.class);
    }

    @Override
    protected boolean enableLogging() {
        return true;
    }

    public void login(String email, String password, RequestResponseListener listener) {
        Map<String, String> params = new HashMap<>();
        params.put("Usr", email);
        params.put("Pwds", password);
        params.put("jnsUsr", "1");
        params.put("op","17");
        Call<String> call = endPoint.login(params);
        execute(call, listener);
    }
}

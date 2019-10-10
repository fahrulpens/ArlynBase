package arlyn.base.example.data.source;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface MainEndPoint {
    String END_POINT_ONE = "/WS_QR/Data.php";
    String END_POINT_TWO = "/WS_QR/Data.php";


    @GET(END_POINT_ONE)
    Call<String> login(@QueryMap Map<String, String> param);


    @FormUrlEncoded
    @POST(END_POINT_TWO)
    Call<String> logout(@FieldMap Map<String, String> param);

}

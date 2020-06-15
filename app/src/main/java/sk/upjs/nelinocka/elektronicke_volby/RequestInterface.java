package sk.upjs.nelinocka.elektronicke_volby;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("http://192.168.0.101:3000/Kandidati")
    Call<JSONResponse> getJSON();
}
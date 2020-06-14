package sk.upjs.nelinocka.elektronicke_volby;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("http://localhost:3000/Kandidati")
    Call<JSONResponse> getJSON();
}
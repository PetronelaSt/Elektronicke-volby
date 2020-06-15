package sk.upjs.nelinocka.elektronicke_volby;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CandidateApi {
    String BASE_URL =
            "http://192.168.0.101:3000/";

    @SuppressWarnings("ALL")

    @GET("Kandidati")
    Call<List<Candidate>> getCandidates();

    @GET("Kandidati/{meno}")
    Call<List<Candidate>> getCandidateName(@Path(value = "meno", encoded = true) String meno);

    @GET("Kandidati/{strana}")
    Call<List<Candidate>> getCandidatePP(@Path(value = "strana", encoded = true) String strana);

    @GET("Kandidati/{vek}")
    Call<List<Candidate>> getCandidateAge(@Path(value = "vek", encoded = true) int vek);

    @GET("Kandidati/{info}")
    Call<List<Candidate>> getCandidateInfo(@Path(value = "info", encoded = true) String info);

    Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    CandidateApi API = RETROFIT.create(CandidateApi.class);
}

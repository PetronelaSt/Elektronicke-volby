package sk.upjs.nelinocka.elektronicke_volby;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CandidateViewModel extends ViewModel {

    private CandidateApi candidateApi = CandidateApi.API;
    private MutableLiveData<List<Candidate>> candidates;

    public LiveData<List<Candidate>> getCandidates() {
        if (candidates == null) {
            candidates = new MutableLiveData<>();
            refresh();
        }

        return candidates;
    }

    public void refresh() {
        Call<List<Candidate>> call = candidateApi.getCandidates();

        call = candidateApi.getCandidates();

        call.enqueue(new Callback<List<Candidate>>() {
            @Override
            public void onResponse(Call<List<Candidate>> call,
                                   Response<List<Candidate>> response) {
                if (response.isSuccessful()) {
                    CandidateViewModel.this.candidates.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Candidate>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

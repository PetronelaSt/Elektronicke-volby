package sk.upjs.nelinocka.elektronicke_volby;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CandidateListViewFragment extends Fragment implements CandidateOnClickListener {
    ListView candidatesNamesListView;

    /////

    private RecyclerView recyclerView;
    private ArrayList<Candidate> data;
    private DataAdapter adapter;

    /////

    private Candidate selectedCandidate;
    private CandidateViewModel candidateViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;

    public CandidateListViewFragment() {
    }

    private RecyclerView listRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master,
                container, false);


        CandidateListAdapter clAdapter = new CandidateListAdapter(this);
        clAdapter.setContext(getContext());

        listRecyclerView = view.findViewById(R.id.listRecyclerView);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listRecyclerView.setAdapter(clAdapter);

        candidateViewModel = new ViewModelProvider(this).get(CandidateViewModel.class);
        candidateViewModel.getCandidates().observe(this, new Observer<List<Candidate>>() {
            @Override
            public void onChanged(List<Candidate> candidates) {
                clAdapter.submitList(candidates);
            }
        });

        return view;
    }

    @Override
    public void onCandidateClick(@NotNull Candidate candidate) {
        selectedCandidate = candidate;
        ((MainActivity) getActivity()).showDetailFragment(candidate);
    }
/*
    private Integer[] candidateImages = new Integer[]{
            R.drawable.albus_dumbledor, R.drawable.filius_flitwick,
            R.drawable.gilderoy_lockhart, R.drawable.horace_slughorn,
            R.drawable.minerva_mcgonagall, R.drawable.pomona_sprout, R.drawable.remus_lupin,
            R.drawable.rubeus_hagrid, R.drawable.severus_snape, R.drawable.sybill_trelawney};
    private String[] candidateNames = new String[]{
            "Albus Dumbledor", "Filius Flitwick", "Gilderoy Lockhart",
            "Horace Slughorn", "Minerva McGonagall", "Pomona Sprout", "Remus Lupin",
            "Rubeus Hagrid", "Severus Snape", "Sybill Trelawney"};
    private String[] candidatePoliticalParties = new String[]{"Gryffindor",
            "Ravenclaw", "Ravenclaw", "Slytherin", "Gryffindor", "Hufflepuff", "Gryffindor",
            "Gryffindor", "Slytherin", "Ravenclaw"};
    private ListView listView;
*/

    /**
     *
     * private void loadJSON() {
     *         Retrofit retrofit = new Retrofit.Builder()
     *                 .baseUrl("https://gist.githubusercontent.com")
     *                 .addConverterFactory(GsonConverterFactory.create())
     *                 .build();
     *         RequestInterface request = retrofit.create(RequestInterface.class);
     *         Call<JSONResponse> call = request.getJSON();
     *         call.enqueue(new Callback<JSONResponse>() {
     *             @Override
     *             public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
     *
     *                 JSONResponse jsonResponse = response.body();
     *                 data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
     *                 adapter = new DataAdapter(data);
     *                 recyclerView.setAdapter(adapter);
     *             }
     *
     *             @Override
     *             public void onFailure(Call<JSONResponse> call, Throwable t) {
     *                 Log.d("Error",t.getMessage());
     *             }
     *         });
     *     }*/
    /*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.listView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
       // recyclerView.setLayoutManager(layoutManager);
        loadJSON();
*/
    ///////
/*
        final CandidateViewModel viewModel = new ViewModelProvider(requireActivity()).get(CandidateViewModel.class);

        candidatesNamesListView = view.findViewById(R.id.listView);
        //candidatesNamesListView = view.findViewById(R.id.candidateName);
        candidatesNamesListView.setOnItemClickListener((parent, v, position, id) -> {
            String name = (String) candidatesNamesListView.getItemAtPosition(position);
            viewModel.setSelectedCandidate(name);
            viewModel.setSelectedCandidateID(position);
        });

        listView = view.findViewById(R.id.listView);
        CandidateListAdapter candidateListAdapter = new CandidateListAdapter(
                candidateImages, candidateNames, candidatePoliticalParties, this.getContext());
        listView.setAdapter(candidateListAdapter);
    }
*/
/*
    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://s.ics.upjs.sk/~pstanova/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getCandidate()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
*/
}

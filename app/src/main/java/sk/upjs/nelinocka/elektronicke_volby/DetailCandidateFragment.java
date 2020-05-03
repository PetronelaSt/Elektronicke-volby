package sk.upjs.nelinocka.elektronicke_volby;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DetailCandidateFragment extends Fragment {

    private TextView detailAboutCandidate;

    public DetailCandidateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,
                container,
                false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        detailAboutCandidate =
                view.findViewById(R.id.detailsAboutCandidate);
        ViewModelProvider viewModelProvider = new ViewModelProvider(requireActivity());
        CandidateViewModel candidateViewModel = viewModelProvider.get(CandidateViewModel.class);

        //candidateViewModel.getSelectedCandidate().observe(this, this::setDetailsAboutCandidate);
        candidateViewModel.getSelectedCandidateID().observe(this, this::setDetailsAboutCandidate);

        Button button = view.findViewById(R.id.pickedCandidate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), VoteActivity.class);
                startActivity(i);
            }
        });
    }

    private String[] detailsAboutCandidates = new String[]{"Albus Dumbledor", "Filius Flitwick", "Gilderoy Lockhart",
            "Horace Slughorn", "Minerva McGonagall", "Pomona Sprout", "Remus Lupin",
            "Rubeus Hagrid", "Severus Snape", "Sybill Trelawney"};

    private void setDetailsAboutCandidate(@org.jetbrains.annotations.NotNull Integer candidateID) {
        detailAboutCandidate.setText("Detail..." + detailsAboutCandidates[candidateID]);
    }
}

package sk.upjs.nelinocka.elektronicke_volby;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
//        candidateViewModel.getSelectedCandidateID().observe(this, this::setDetailsAboutCandidate);

        detailAboutCandidate.setMovementMethod(new ScrollingMovementMethod());

        Button button = view.findViewById(R.id.pickedCandidate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), VoteActivity.class);
                startActivity(i);
            }
        });
    }

    private String[] detailsAboutCandidates = new String[]{"Albus Dumbledor What is Lorem Ipsum?\n" +
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\n" +
            "Why do we use it?\n" +
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", "Filius Flitwick", "Gilderoy Lockhart",
            "Horace Slughorn", "Minerva McGonagall", "Pomona Sprout", "Remus Lupin",
            "Rubeus Hagrid", "Severus Snape", "Sybill Trelawney"};

    private void setDetailsAboutCandidate(@org.jetbrains.annotations.NotNull Integer candidateID) {
        detailAboutCandidate.setText("Detail..." + detailsAboutCandidates[candidateID]);
    }
}

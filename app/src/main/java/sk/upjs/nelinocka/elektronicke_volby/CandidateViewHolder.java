package sk.upjs.nelinocka.elektronicke_volby;

import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import androidx.recyclerview.widget.RecyclerView;

public class CandidateViewHolder extends RecyclerView.ViewHolder {
    private View candidateView;
    private TextView candidateNameTextView;
    private TextView candidateAgeTextView;
    private TextView candidatePoliticalPartyTextView;
    private TextView candidateInfoTextView;


    public CandidateViewHolder(@NotNull View candidateView) {
        super(candidateView);

        this.candidateView = candidateView;
        candidateNameTextView = (TextView) candidateView.findViewById(R.id.candidateName);
        // this.candidateAge=(TextView) candidateView.findViewById(R.id.candidateDetails);
        candidatePoliticalPartyTextView = (TextView) candidateView.findViewById(R.id.candidatePoliticalParty);
        // this.candidateInfo = (TextView) candidateView.findViewById(R.id.detailsAboutCandidate);
    }

    private void setCandidateDetails(Candidate candidate, final CandidateOnClickListener candidateOnClickListener) {
        candidateNameTextView.setText(candidate.getCandidateName());
        candidatePoliticalPartyTextView.setText(candidate.getCandidatePoliticalParty());
        candidateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                candidateOnClickListener.onCandidateClick(candidate);
            }
        });
    }

    public void bind(final Candidate candidateDetails, final CandidateOnClickListener candidateOnClickListener) {
        setCandidateDetails(candidateDetails, candidateOnClickListener);
    }
}

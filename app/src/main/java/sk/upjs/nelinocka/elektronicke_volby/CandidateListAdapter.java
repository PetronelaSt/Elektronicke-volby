package sk.upjs.nelinocka.elektronicke_volby;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

//extends BaseAdapter
public class CandidateListAdapter extends BaseAdapter {
    private Integer[] candidateImages;
    private String[] candidateNames, candidatePoliticalParties;
    private LayoutInflater inflater;
    private Context context;
    private ImageView candidateImg;
    private TextView candidateName, candidatePoliticalParty;
    private ArrayList<Candidate> candidate;

    public CandidateListAdapter(ArrayList<Candidate> candidate) {
        this.candidate = candidate;
    }

    public CandidateListAdapter(Integer[] candidateImages, String[] candidateNames,
                                String[] candidatePoliticalParties, Context context) {
        this.candidateImages = candidateImages;
        this.candidateNames = candidateNames;
        this.candidatePoliticalParties = candidatePoliticalParties;
        this.context = context;
        inflater = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return candidate.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*  @Override
      public CandidateListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
    return view;
    }*/
/*
    @Override
    public void onBindViewHolder(View view, int position) {
        view = inflater.inflate(R.layout.listview_row, null);
        candidateImg = view.findViewById(R.id.candidateImg);
        candidateName = view.findViewById(R.id.candidateName);
        candidatePoliticalParty = view.findViewById(R.id.candidatePoliticalParty);
        candidateImg.setImageResource(candidateImages[position]);
        candidateName.setText(candidateNames[position]);
        candidatePoliticalParty.setText(candidatePoliticalParties[position]);
  }
*/
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.listview_row, null);
        candidateImg = view.findViewById(R.id.candidateImg);
        candidateName = view.findViewById(R.id.candidateName);
        candidatePoliticalParty = view.findViewById(R.id.candidatePoliticalParty);
        candidateImg.setImageResource(candidateImages[position]);
        candidateName.setText(candidateNames[position]);
        candidatePoliticalParty.setText(candidatePoliticalParties[position]);
        return view;
    }
}
/**
 * <p>
 * public class ViewHolder extends RecyclerView.ViewHolder {
 * private TextView tv_name;
 * private TextView tv_version;
 * private TextView tv_api_level;
 * <p>
 * public ViewHolder(View itemView) {
 * super(itemView);
 * <p>
 * tv_name = (TextView)itemView.findViewById(R.id.tv_name);
 * tv_version = (TextView)itemView.findViewById(R.id.tv_version);
 * tv_api_level = (TextView)itemView.findViewById(R.id.tv_api_level);
 * <p>
 * }
 * }
 * }
 */
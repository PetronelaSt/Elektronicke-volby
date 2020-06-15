package sk.upjs.nelinocka.elektronicke_volby;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

//extends BaseAdapter
public class CandidateListAdapter extends ListAdapter<Candidate, CandidateViewHolder> {
    private Integer[] candidateImages;
    private String[] candidateNames, candidatePoliticalParties;
    private LayoutInflater inflater;
    private Context context;
    private ImageView candidateImg;
    private TextView candidateName, candidatePoliticalParty;
    private ArrayList<Candidate> candidate;
    private final CandidateOnClickListener candidateOnClickListener;

    public CandidateListAdapter(CandidateOnClickListener candidateOnClickListener) {
        super(new DiffUtil.ItemCallback<Candidate>() {
            @Override
            public boolean areItemsTheSame(@NonNull Candidate oldItem, @NonNull Candidate newItem) {
                return (oldItem == newItem);
            }

            @Override
            public boolean areContentsTheSame(@NonNull Candidate oldItem, @NonNull Candidate newItem) {
                boolean equals = false;
                if ((oldItem.meno.equals(newItem.meno)) &&
                        (oldItem.strana.equals(newItem.strana)) &&
                        (oldItem.vek == (newItem.vek)) &&
                        (oldItem.info.equals(newItem.info)))
                    equals = true;
                return equals;
            }
        });
        this.candidate = candidate;
        this.candidateOnClickListener = candidateOnClickListener;
    }

    /*    public CandidateListAdapter(ArrayList<Candidate> candidate) {
            this.candidate = candidate;
        }
    */
    /*
    public CandidateListAdapter(Integer[] candidateImages, String[] candidateNames,
                                String[] candidatePoliticalParties, Context context) {
        this.candidateImages = candidateImages;
        this.candidateNames = candidateNames;
        this.candidatePoliticalParties = candidatePoliticalParties;
        this.context = context;
        inflater = (LayoutInflater.from(context));
    }*/

    public void setContext(Context context) {
        this.context = context;
    }
/*
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

 */

    @Override
    public CandidateViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_row, parent, false);
        return new CandidateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateViewHolder holder, int position) {
        Candidate c = this.candidate.get(position);
        holder.bind(c, candidateOnClickListener);
    }

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
    }*/
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
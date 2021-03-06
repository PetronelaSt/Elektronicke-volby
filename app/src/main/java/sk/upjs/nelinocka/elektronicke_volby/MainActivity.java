package sk.upjs.nelinocka.elektronicke_volby;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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
    private Candidate candidate = new Candidate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new CandidateListViewFragment()).commit();

        //  showCandidateFragment();
        //   ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        //  CandidateViewModel candidateViewModel =
        //        viewModelProvider.get(CandidateViewModel.class);
       /* candidateViewModel.getSelectedCandidate().observe(this,
                this::showDetailFragment);*/
        //  CandidateListViewFragment candidateListViewFragment = new CandidateListViewFragment();
    }

    private void showCandidateFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new CandidateListViewFragment())
                .addToBackStack(null).commit();

    }

    public void showDetailFragment(Candidate candidate) {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new DetailCandidateFragment())
                .addToBackStack(null).commit();
        getSupportActionBar().setTitle("Info o " + candidate.meno);
    }
}

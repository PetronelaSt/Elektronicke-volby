package sk.upjs.nelinocka.elektronicke_volby;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import sk.upjs.nelinocka.elektronicke_volby.databinding.ActivityVoteBinding;

public class VoteActivity extends AppCompatActivity {
/*
    private NU_UserListViewModel nu_userListViewModel;
    private NU_VoteApi voteApi = NU_VoteApi.API;
*/
    ActivityVoteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onClick(View view) {
        CharSequence personOP = binding.personOP.getEditText().getText();
        CharSequence personPIN = binding.personPIN.getEditText().getText();

        if (personOP.toString().isEmpty()) {
            binding.personOP.setError("Vyplňte OP!");
            return;
        }
        if (personPIN.toString().isEmpty()) {
            binding.personPIN.setError("Vyplňte PIN!");
            return;
        }
        binding.personOP.setError("");
        binding.personPIN.setError("");
    }
}

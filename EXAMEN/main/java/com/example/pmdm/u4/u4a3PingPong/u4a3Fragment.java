package com.example.pmdm.u4.u4a3PingPong;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link u4a3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class u4a3Fragment extends Fragment {

    private static final int MAX_SCORE = 21;
    private static final String WINNER_P_ONE = "PLAYER ONE WINS";
    private static final String WINNER_P_TWO = "PLAYER TWO WINS";
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;
    private Button btnPlayerOne;
    private Button btnPlayerTwo;

    private String fragmentName; // New variable to store the fragment name

    public u4a3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment u4a3Fragment.
     */
    public static u4a3Fragment newInstance(String fragmentName) {
        u4a3Fragment fragment = new u4a3Fragment();
        Bundle args = new Bundle();
        args.putString("fragmentName", fragmentName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fragmentName = getArguments().getString("fragmentName", "");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.u4a3_fragment_activity, container, false);

        btnPlayerOne = layout.findViewById(R.id.u4a3idbtPlayer1);
        btnPlayerTwo = layout.findViewById(R.id.u4a3btidPlayer2);

        btnPlayerOne.setOnClickListener(v -> {
            scorePlayerOne++;
            updateScores();
        });

        btnPlayerTwo.setOnClickListener(v -> {
            scorePlayerTwo++;
            updateScores();
        });

        return layout;
    }

    private void updateScores() {
        if (scorePlayerOne >= MAX_SCORE || scorePlayerTwo >= MAX_SCORE) {
            if (scorePlayerOne >= MAX_SCORE) {
                showToast(WINNER_P_ONE);
            } else {
                showToast(WINNER_P_TWO);
            }

            btnPlayerOne.setText("");
            btnPlayerTwo.setText("");

            btnPlayerOne.setEnabled(false);
            btnPlayerTwo.setEnabled(false);

        } else {
            btnPlayerOne.setText(String.valueOf(scorePlayerOne));
            btnPlayerTwo.setText(String.valueOf(scorePlayerTwo));
        }
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}

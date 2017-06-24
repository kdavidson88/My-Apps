package com.example.kyle.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(score);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreViewA);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreViewB);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeA(View view){
        score = score + 3;
        displayForTeamA(score);
    }

    public void addTwoA(View view){
        score = score + 2;
        displayForTeamA(score);
    }

    public void addOneA(View view){
        score = score + 1;
        displayForTeamA(score);
    }

    public void addThreeB(View view){
        score = score + 3;
        displayForTeamB(score);
    }

    public void addTwoB(View view){
        score = score + 2;
        displayForTeamB(score);
    }

    public void addOneB(View view){
        score = score + 1;
        displayForTeamB(score);
    }

    public void resetScore(View view){
        score = 0;
        TextView scoreViewA = (TextView) findViewById(R.id.scoreViewA);
        TextView scoreViewB = (TextView) findViewById(R.id.scoreViewB);
        scoreViewA.setText("0");
        scoreViewB.setText("0");
    }
}

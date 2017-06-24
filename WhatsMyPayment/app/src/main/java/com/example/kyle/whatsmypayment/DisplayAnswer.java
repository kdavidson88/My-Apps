package com.example.kyle.whatsmypayment;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kyle on 3/16/2017.
 */

public class DisplayAnswer extends AppCompatActivity{

    TextView amount;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_display);

        amount = (TextView) findViewById(R.id.finalAmount);
        Intent answer = getIntent();
        Double displayAmount = answer.getDoubleExtra("results", 0.0);
        String dblAmt = String.format("%.2f", displayAmount);
        amount.setText("$" + dblAmt.toString());

        goBack = (Button) findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    public void goBack(){
        goBack = (Button) findViewById(R.id.goBack);
        Intent intent = new Intent(this, OptionActivity.class);
        startActivity(intent);
        this.finish();
    }
}

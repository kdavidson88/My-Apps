package com.example.kyle.whatsmypayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Kyle on 4/9/2017.
 */

public class OptionActivity extends AppCompatActivity {

    Spinner optionSpinner;
    ArrayAdapter adapter;
    char selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);

        adapter = ArrayAdapter.createFromResource(this, R.array.loans, android.R.layout.simple_spinner_item);

        optionSpinner = (Spinner) findViewById(R.id.loanSpinner);
        optionSpinner.setAdapter(adapter);
        optionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id){
                Object item = adapterView.getItemAtPosition(position);

                if(item.toString().equals("Home Loan")){
                    selection = 'a';
                }
                else if(item.toString().equals("Car Loan")){
                    selection = 'a';
                }
                else if(item.toString().equals("Student Loan")){
                    selection = 'a';
                }
                else if(item.toString().equals("Simple Loan")){
                    selection = 'b';
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }

    public void Next(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("selection", selection);
        startActivity(intent);
        this.finish();
    }
}

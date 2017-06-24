package com.example.kyle.spinnerpractice;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayAdapter adapter;
    TextView dialog;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = ArrayAdapter.createFromResource(this, R.array.dropdown, android.R.layout.simple_spinner_item);

        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(MainActivity.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String item = parent.getItemAtPosition(position).toString();
        dialog = (TextView) findViewById(R.id.textView);
        if(spinner.getSelectedItem().toString().equals("Theme1")){
            dialog.setText("Theme 1");
            dialog.setTextAppearance(R.style.Theme1);
            dialog.setBackgroundColor(getColor(R.color.theme1));
        }
        else if(spinner.getSelectedItem().toString().equals("Theme2")){
            dialog.setText("Theme 2");
            dialog.setTextAppearance(R.style.Theme2);
            dialog.setBackgroundColor(getColor(R.color.theme2));
        }
        else if(spinner.getSelectedItem().toString().equals("Theme3")){
            dialog.setText("Theme 3");
            dialog.setTextAppearance(R.style.Theme3);
            dialog.setBackgroundColor(getColor(R.color.theme3));
        }
        else if(spinner.getSelectedItem().toString().equals("Theme4")){
            dialog.setText("Theme 4");
            dialog.setTextAppearance(R.style.Theme4);
            dialog.setBackgroundColor(getColor(R.color.theme4));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

package com.example.kyle.whatsmypayment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText payment;
    EditText prin;
    EditText inter;
    EditText month;
    Button submit;
    Intent selection = getIntent();
    double newPrin;
    double interestValue;
    double interestAmount;
    double fullValue;
    double finalValue = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Payment Amount and convert to int
        payment = (EditText) findViewById(R.id.paymentInput);

        //Get Principal Amount and convert to int
        prin = (EditText) findViewById(R.id.principalInput);

        //Get Interest and convert to double
        inter = (EditText) findViewById(R.id.interestInput);

        //Get Interest and convert to double
        month = (EditText) findViewById(R.id.durationInput);

        submit = (Button) findViewById(R.id.submitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmit();
            }
        });
    }

    public void incorrect(){
        Toast.makeText(this, "Unable to calculate. Try Again.", Toast.LENGTH_SHORT).show();
    }

    public double calculateSimple() {

        try {
            String getPayment = payment.getText().toString();
            double downPayment = Double.parseDouble(getPayment);

            String getPrin = prin.getText().toString();
            double principal = Double.parseDouble(getPrin);

            String getInter = inter.getText().toString();
            double interest = Double.parseDouble(getInter);

            String getMonth = month.getText().toString();
            double duration = Double.parseDouble(getMonth);

            newPrin = principal - downPayment;
            interestValue = interest / 100;
            interestAmount = newPrin * interestValue;
            fullValue = newPrin + interestAmount;
            finalValue = fullValue / duration;

            return finalValue;
        }
        catch(ArithmeticException e){
            incorrect();
        }
        finally {
            return finalValue;
        }
    }

    public double calculateCompound(){
        try{
            String getPayment = payment.getText().toString();
            double downPayment = Double.parseDouble(getPayment);

            String getPrin = prin.getText().toString();
            double principal = Double.parseDouble(getPrin);

            String getInter = inter.getText().toString();
            double interest = Double.parseDouble(getInter);

            String getMonth = month.getText().toString();
            double duration = Double.parseDouble(getMonth);

            interestValue = interest / 100;

            newPrin = principal - downPayment;

            finalValue = newPrin * Math.pow(1 + interestValue, (duration / 12));
        }
        catch(ArithmeticException e){
            incorrect();
        }
        finally {
            return finalValue;
        }
    }

    public void onSubmit(){
        Intent intent = new Intent(this, DisplayAnswer.class);
        if(selection.equals('b')) {
            intent.putExtra("results", calculateSimple());
        }
        else if(selection.equals('a')){
            intent.putExtra("results",calculateCompound());
        }
        startActivity(intent);
        this.finish();
    }

}

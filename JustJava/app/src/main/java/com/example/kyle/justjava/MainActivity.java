package com.example.kyle.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    String totalItems = "Total Number of Items: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decrement(View view){
        if (quantity >= 1) {
            quantity --;
            displayQuantity(quantity);
        }
        else{
            quantity = 0;
        }
    }

    public void increment(View view){
        displayQuantity(quantity ++);
    }

    public void submitOrder(View view){
        String message = totalItems + quantity;
        displayMessage(message);
        displayPrice(quantity * 5);
    }

    public void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText( "" + number);
    }

    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("Amount Due: " + NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.amount_text_view);
        priceTextView.setText(message);
    }
}

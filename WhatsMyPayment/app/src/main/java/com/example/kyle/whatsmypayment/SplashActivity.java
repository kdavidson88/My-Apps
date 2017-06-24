package com.example.kyle.whatsmypayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kyle.whatsmypayment.MainActivity;

/**
 * Created by Kyle on 3/12/2017.
 */

public class SplashActivity extends Activity{

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread background = new Thread(){
            public void run(){
                try
                {
                    Thread.sleep(3000);
                    Intent i = new Intent(getBaseContext(), OptionActivity.class);
                    startActivity(i);
                    finish();
                }
                catch(Exception e)
                {
                }
            }
        };
        background.start();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}

package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;

    TextView mcurrentheight;
    TextView mcurrentweight;
    SeekBar mseekbarforheight, mseekbarforweight;
    TextView result;

    int currentprogress1;
    int currentprogress2;
    String mprogressh="170";
    String mprogressw="55";
    String typeofuser="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        mcalculatebmi=findViewById(R.id.calculatebmi);
        mcurrentheight=findViewById(R.id.currentheight);
        mcurrentweight=findViewById(R.id.currentweight);
        mseekbarforheight=findViewById(R.id.seekbarforheight);
        mseekbarforweight=findViewById(R.id.seekbarforweight);

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentprogress1=progress;
                mprogressh=String.valueOf(currentprogress1);
                mcurrentheight.setText(mprogressh);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mseekbarforweight.setMax(200);
        mseekbarforweight.setProgress(55);
        mseekbarforweight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentprogress2=progress;
                mprogressw=String.valueOf(currentprogress2);
                mcurrentweight.setText(mprogressw);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, bmiactivity.class);
                    intent.putExtra("height", mprogressh);
                    intent.putExtra("weight", mprogressw);
                    startActivity(intent);
                }
            }
            );



    }
}



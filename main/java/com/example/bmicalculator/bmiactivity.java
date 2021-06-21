package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay, mbmicategory, mbmihealthrisk;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;
    Button mbutton1;

    String height;
    String weight;
    float intheight, intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        mbutton1= (Button) findViewById(R.id.button1);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent=getIntent();

        mbmidisplay=findViewById(R.id.bmidislay);
        mbmicategory=findViewById(R.id.bmicategory);
        mbmihealthrisk=findViewById(R.id.bmihealthrisk);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi= intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);

        if(intbmi < 18.4)
        {
            mbmicategory.setText("Underweight");
            mbmihealthrisk.setText("Malnutrition Risk");
            mimageview.setImageResource(R.drawable.cross);
        }
        else if(intbmi <24.9 && intbmi > 18.4)
        {
            mbmicategory.setText("Normal weight");
            mbmihealthrisk.setText("Low Risk");
            mimageview.setImageResource(R.drawable.okay);
        }
        else if(intbmi <29.9 && intbmi > 25)
        {
            mbmicategory.setText("Overweight");
            mbmihealthrisk.setText("Enchanced Risk");
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi <34.9 && intbmi > 30)
        {
            mbmicategory.setText("Moderately obese");
            mbmihealthrisk.setText("Medium Risk");
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi <39.9 && intbmi > 35)
        {
            mbmicategory.setText("Severely obese");
            mbmihealthrisk.setText("High Risk");
            mimageview.setImageResource(R.drawable.cross);
        }
        else if(intbmi > 40)
        {
            mbmicategory.setText("Very severely obese");
            mbmihealthrisk.setText("Very high Risk");
            mimageview.setImageResource(R.drawable.cross);
        }

        mbmidisplay.setText(mbmi);

        getSupportActionBar().hide();
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(bmiactivity.this, aboutme.class);
                startActivity(intent);
            }
        });

    }
}
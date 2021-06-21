package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class aboutme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        setupHyperLink();
    }

    private void setupHyperLink() {
        TextView LinkTextView = findViewById(R.id.link);
        LinkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
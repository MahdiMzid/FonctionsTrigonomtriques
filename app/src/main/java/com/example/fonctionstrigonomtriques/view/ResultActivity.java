package com.example.fonctionstrigonomtriques.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fonctionstrigonomtriques.R;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    // attribus de l'activité
    private Button btnReturn;
    private TextView tvReponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();

        String result = String.valueOf(getIntent().getDoubleExtra("result",0));
        tvReponse.setText(result);

        btnReturn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init()
    {
       btnReturn = findViewById(R.id.btnReturn);
       tvReponse = findViewById(R.id.tvReponse);
    }
}
package com.example.fonctionstrigonomtriques.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.fonctionstrigonomtriques.R;
import com.example.fonctionstrigonomtriques.controller.Controller;


public class MainActivity extends AppCompatActivity {
    private static final int CODE = 1;
    private Controller controller = Controller.getInstance();
    private EditText etValeur;
    private RadioButton Sinus, Cosinus, Tangent;
    private Button btnCalculer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double angle;
                String method;
                if(etValeur.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Veuillez saisir Une valeur !", Toast.LENGTH_SHORT).show();
                else {
                   if (Sinus.isChecked()){
                       method = "Sinus";
                   } else if (Cosinus.isChecked()) {
                       method = "Cosinus";
                   }else {method = "Tangent";}
                   angle = Double.valueOf(etValeur.getText().toString());
                   controller.createTrigonometrie(angle, method);
                   double result = controller.getValeur();
                   Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                   intent.putExtra("result", result);
                   startActivityForResult(intent, CODE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE)
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "ERROR : RESULT_CANCELED", Toast.LENGTH_SHORT).show();
            }
    }

    private void init()
    {
        etValeur = findViewById(R.id.etValeur);
        btnCalculer = findViewById(R.id.btnCalculer);
        Sinus = findViewById(R.id.rbtSin);
        Cosinus = findViewById(R.id.rbtCos);
        Tangent = findViewById(R.id.rbtTan);
    }
}
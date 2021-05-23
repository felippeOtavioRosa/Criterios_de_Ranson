package com.example.criterios_de_ranson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int pontuacao = intent.getIntExtra(MainActivity.EXTRA_POINT,0);
        int idade = intent.getIntExtra(MainActivity.EXTRA_AGE, 0);
        int mortalidade = intent.getIntExtra(MainActivity.EXTRA_MORTAL,0);
        boolean situ = intent.getBooleanExtra(MainActivity.EXTRA_SITUATION, false);

        TextView textViewAge = findViewById(R.id.textView_age_value);
        textViewAge.setText(Integer.toString(idade));
        TextView textViewPoint = findViewById(R.id.score_value);
        textViewPoint.setText(Integer.toString(pontuacao));
        TextView textViewMortality = findViewById(R.id.mortality_value);
        textViewMortality.setText(Integer.toString(mortalidade));
        TextView textViewSituation = findViewById(R.id.situation_value);
        if (situ == true){
            textViewSituation.setText("Grave");
        }else {
            textViewSituation.setText("Não é Grave");
        }
    }
}
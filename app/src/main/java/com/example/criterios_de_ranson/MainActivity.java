package com.example.criterios_de_ranson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_AGE = "com.example.criterios_de_ranson.extra.idade";
    public static final String EXTRA_POINT = "com.example.criterios_de_ranson.extra.pontuacao";
    public static final String EXTRA_MORTAL = "com.example.criterios_de_ranson.extra.grave";
    public static final String EXTRA_SITUATION = "com.example.criterios_de_ranson.extra.mortalidade";
    private EditText iIdadeEditText;
    private CheckBox cCheckBox;
    private EditText lLeucocitosEditText;
    private EditText gGlicemiaEditText;
    private EditText aAstEditText;
    private EditText lLdhEditText;
    private int pontuacao = 0;
    private boolean grave = false;
    private int mortalidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iIdadeEditText = findViewById(R.id.age_editText);
        cCheckBox = findViewById(R.id.checkBox);
        lLeucocitosEditText = findViewById(R.id.leucocites_editText);
        gGlicemiaEditText = findViewById(R.id.glico_editText);
        aAstEditText = findViewById(R.id.ast_editText);
        lLdhEditText = findViewById(R.id.ldh_editTextText);
    }

    public void launchSecondActivity(View view) {
        int age = Integer.parseInt(iIdadeEditText.getText().toString()); // pega a idade
        int leucocitos = Integer.parseInt(lLeucocitosEditText.getText().toString());
        int glicemia = Integer.parseInt(gGlicemiaEditText.getText().toString());
        int ast = Integer.parseInt(aAstEditText.getText().toString());
        int ldh = Integer.parseInt(lLdhEditText.getText().toString());

        if (cCheckBox.isChecked()){
            if (age > 70){
                pontuacao ++;
            } else {
                pontuacao = pontuacao;
            }
            if (leucocitos > 1800){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
            if (glicemia > 12.2){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
            if (ast > 250){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
            if (ldh > 400){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
        } else {
            if (age > 55){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
            if (leucocitos > 1600){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
            if (glicemia > 11){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
            if (ast > 250){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
            if (ldh > 350){
                pontuacao ++;
            }else {
                pontuacao = pontuacao;
            }
        }

        if (pontuacao >= 3){
            grave = true;
        }else {
            grave = false;
        }

        if (pontuacao < 3){
            mortalidade = 2;
        } else if (pontuacao < 5){
            mortalidade = 15;
        }else if (pontuacao < 7){
            mortalidade = 40;
        } else {
            mortalidade = 100;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_POINT,pontuacao);
        intent.putExtra(EXTRA_AGE,age);
        intent.putExtra(EXTRA_SITUATION, grave);
        intent.putExtra(EXTRA_MORTAL, mortalidade);
        startActivity(intent);

    }
}
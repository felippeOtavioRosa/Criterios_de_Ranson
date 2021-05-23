package com.example.criterios_de_ranson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int EXTRA_POINT = 1;
    private EditText iIdadeEditText;
    private CheckBox cCheckBox;
    private EditText lLeucocitosEditText;
    private EditText gGlicemiaEditText;
    private EditText aAstEditText;
    private EditText lLdhEditText;


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
        int pontuacao = 0;
        boolean grave;



        if (cCheckBox.isChecked()){
            if (age > 70){
                pontuacao ++;
            } else if (leucocitos > 1800){
                pontuacao ++;
            }else if (glicemia > 12.2){
                pontuacao ++;
            } else if (ast > 250){
                pontuacao ++;
            } else if (ldh > 400){
                pontuacao ++;
            }
        } else {
            if (age > 55){
                pontuacao ++;
            } else if (leucocitos > 1600){
                pontuacao ++;
            }else if (glicemia > 11){
                pontuacao ++;
            } else if (ast > 250){
                pontuacao ++;
            } else if (ldh > 350){
                pontuacao ++;
            }
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_POINT, pontuacao);
        startActivityForResult(intent, EXTRA_POINT);


    }
}
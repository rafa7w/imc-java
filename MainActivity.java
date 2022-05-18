package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText pesoEditText;
    EditText altEditText;
    EditText resultEditText;
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoEditText = findViewById(R.id.pesoEditText);
        altEditText = findViewById(R.id.alturaEditText);
        resultEditText = findViewById(R.id.resultEditText);
    }

    protected Float calcImc() {
        Float peso = Float.parseFloat(pesoEditText.getText().toString());
        Float alt = Float.parseFloat(altEditText.getText().toString());
        alt = alt / 100;
        Float imc = peso / (alt * alt);

        return imc;
    }

    protected void cleanFields() {
        pesoEditText.setText(String.valueOf(""));
        altEditText.setText(String.valueOf(""));
    }

    public void statusImc(View v) {
        Float imc = calcImc();

        if (imc < 18.5) {
            cleanFields();
            resultEditText.setText(String.valueOf(df.format(imc) + " Magreza"));
        } else if (imc <= 24.9) {
            cleanFields();
            resultEditText.setText(String.valueOf(df.format(imc) + " Normal"));
        } else if (imc <= 29.9) {
            cleanFields();
            resultEditText.setText(String.valueOf(df.format(imc) + " Sobrepeso"));
        } else if (imc <= 34.9) {
            cleanFields();
            resultEditText.setText(String.valueOf(df.format(imc) + " Obesidade grau I"));
        } else if (imc <= 39.9) {
            cleanFields();
            resultEditText.setText(String.valueOf(df.format(imc) + " Obesidade grau II"));
        } else {
            cleanFields();
            resultEditText.setText(String.valueOf(df.format(imc) + " Obesidade grau III"));
        }
    }

}

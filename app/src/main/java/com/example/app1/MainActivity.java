package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnEnviar(View view){
        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        EditText txtFechaNac = (EditText)findViewById(R.id.txtFechaNac);
        EditText txtTlf = (EditText)findViewById(R.id.txtTlf);
        RadioButton rdbM = (RadioButton)findViewById(R.id.rdbMasc);
        RadioButton rdbF = (RadioButton)findViewById(R.id.rdbFem);

        //Creamos la información a pasar entre actividades - Pares Key-Value
        Bundle b = new Bundle();
        b.putString("NOMBRE", txtNombre.getText().toString());
        if (rdbM.isChecked() == true){
            b.putString("GENERO", rdbM.getText().toString());
        } else{
            b.putString("GENERO", rdbF.getText().toString());
        }
        b.putString("FECHANAC", txtFechaNac.getText().toString());
        b.putString("TLF", txtTlf.getText().toString());

        //Añadimos la información al intent
        intent.putExtras(b);

        // Iniciamos la nueva actividad
        startActivity(intent);
    }

}
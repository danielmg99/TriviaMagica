package com.example.megacinetriviaamst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JuegoPerdido extends AppCompatActivity {
    private Button btnVolver,btnSalir;
    private TextView txtcontador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_perdido);

        //Referencias a los controles
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        txtcontador = (TextView) findViewById(R.id.txtcontador);

        Bundle datos = this.getIntent().getExtras();
        String contador = datos.getString("contador");
        txtcontador.setText("Ha respondido " + contador + " preguntas.");

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(JuegoPerdido.this, trivia.class);
                startActivity(volver);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salir = new Intent(JuegoPerdido.this, MainActivity.class);
                startActivity(salir);
            }
        });

    }

}
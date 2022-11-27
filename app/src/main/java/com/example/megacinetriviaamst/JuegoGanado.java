package com.example.megacinetriviaamst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class JuegoGanado extends AppCompatActivity {
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_ganado);

        //Referencias a los controles
        btnSalir = (Button) findViewById(R.id.btnSalir);
    }

    public void Salir(View view) {
        Intent intent = new Intent(this, MainActivity.class); startActivity(intent);
    }
    public void onClick(View v) {
        if(v.getId() == R.id.btnSalir){
            Log.d("mensaje","ïngreso");
        }
    }
}
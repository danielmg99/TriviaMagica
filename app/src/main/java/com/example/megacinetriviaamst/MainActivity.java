package com.example.megacinetriviaamst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnEmpezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias a los controles
        btnEmpezar = (Button) findViewById(R.id.btnEmpezar);

    }

    public void Trivia(View view) {
        Intent intent = new Intent(this, trivia.class); startActivity(intent);
    }

    public void onClick(View v) {
        if(v.getId() == R.id.btnEmpezar){
            Log.d("mensaje","ïngreso");
        }
    }

}
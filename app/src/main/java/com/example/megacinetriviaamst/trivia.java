package com.example.megacinetriviaamst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class trivia extends AppCompatActivity {
    private int ContadorRespuestas = 0;
    private Button btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4;
    private TextView pregunta;
    private ImageView foto;

    List<Integer> list = new ArrayList<>();
    List<String> Preguntas = new ArrayList<>();
    List<String> Respuestas =   new ArrayList<>();
    List<Integer> Imagenes =   new ArrayList<>();
    List<List<String>> Opciones = new ArrayList<List<String>>();
    Random rand = new Random();
    private int RandomIndex;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        btnRespuesta1 = (Button) findViewById(R.id.respuesta1);
        btnRespuesta2 = (Button) findViewById(R.id.respuesta2);
        btnRespuesta3 = (Button) findViewById(R.id.respuesta3);
        btnRespuesta4 = (Button) findViewById(R.id.respuesta4);
        pregunta = (TextView) findViewById(R.id.pregunta);
        foto = (ImageView) findViewById(R.id.fotopregunta);


        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Preguntas.add("¿Como se llama este superheroe?");
        Preguntas.add("¿A que casa pertenece Harry Potter?");
        Preguntas.add("¿De color es el sable de luz de Obi Wan?");
        Preguntas.add("¿En que pais se desarrolla Encanto?");
        Preguntas.add("¿Como se llama este traje de IronMan?");

        Respuestas.add("Thor");
        Respuestas.add("Gryffindor");
        Respuestas.add("Azul");
        Respuestas.add("Colombia");
        Respuestas.add("Mark 85");

        Imagenes.add(R.drawable.thor);
        Imagenes.add(R.drawable.harry);
        Imagenes.add(R.drawable.obi);
        Imagenes.add(R.drawable.encanto);
        Imagenes.add(R.drawable.ironman);

        List<String> Opciones1 = new ArrayList<>();
        Opciones1.add("Thor");
        Opciones1.add("Hulk");
        Opciones1.add("Ironman");
        Opciones1.add("Hawkeye");

        List<String> Opciones2 = new ArrayList<>();
        Opciones2.add("Hufflepuff");
        Opciones2.add("Ravenclaw");
        Opciones2.add("Gryffindor");
        Opciones2.add("Slytherin");

        List<String> Opciones3 = new ArrayList<>();
        Opciones3.add("Purpura");
        Opciones3.add("Verde");
        Opciones3.add("Rojo");
        Opciones3.add("Azul");

        List<String> Opciones4 = new ArrayList<>();
        Opciones4.add("Mexico");
        Opciones4.add("Colombia");
        Opciones4.add("Argentina");
        Opciones4.add("España");

        List<String> Opciones5 = new ArrayList<>();
        Opciones5.add("TonyMaximo");
        Opciones5.add("Jarvis");
        Opciones5.add("Mark 85");
        Opciones5.add("Stormbreaker");



        Opciones.add(Opciones1);
        Opciones.add(Opciones2);
        Opciones.add(Opciones3);
        Opciones.add(Opciones4);
        Opciones.add(Opciones5);

        CambiarPregunta();

    }

    public void CambiarPregunta() {
        RandomIndex = list.get(rand.nextInt(list.size()));
        pregunta.setText(Preguntas.get(RandomIndex));
        foto.setImageResource(Imagenes.get(RandomIndex));
        btnRespuesta1.setText(Opciones.get(RandomIndex).get(0));
        btnRespuesta2.setText(Opciones.get(RandomIndex).get(1));
        btnRespuesta3.setText(Opciones.get(RandomIndex).get(2));
        btnRespuesta4.setText(Opciones.get(RandomIndex).get(3));
        list.remove(list.indexOf(RandomIndex));
    }

    public void responder(View v){

        Button b = (Button)v;
        String buttonText = b.getText().toString();

        if(buttonText == Respuestas.get(RandomIndex)){

            ContadorRespuestas +=1;
            if(ContadorRespuestas ==5 ){
                Intent intent = new Intent(this, JuegoGanado.class);
                startActivity(intent);
            }
            Toast toast=Toast.makeText(getApplicationContext(),"Respuesta correcta",Toast.LENGTH_SHORT);
            toast.show();
            CambiarPregunta();
        }else {
            Bundle extras = new Bundle();
            extras.putString("contador",String.valueOf(ContadorRespuestas)); // se obtiene el valor mediante getString(...)
            Intent intent = new Intent(this, JuegoPerdido.class);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
}


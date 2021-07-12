package com.leleo.myjogovelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    //Declaração dos atributos que serão manipulados
    Button btnJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Mapeamento dos objetos que serão manipulados
        btnJogar = findViewById(R.id.btnJogar);

        //Configuração do ouvidor (listener) para o evento OnClick
        btnJogar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                abrirJogo();
            }
        });
    }

    //Criando metodo para abrir os activities usando intent e startActivity
    private void abrirJogo()
    {
        Intent janelag = new Intent (this, Jogo.class);
        startActivity(janelag);
    }
}
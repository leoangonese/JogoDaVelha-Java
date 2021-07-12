package com.leleo.myjogovelha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Jogo extends AppCompatActivity
{

    private Button[] arrayButton = new Button[10];
    private String vez = "X", jogador = "jogador 1";
    private int jogadas = 0;
    private  String[] matriz = new String[10];
    private TextView txtj;
    Button btnFora;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtj = findViewById(R.id.txtJogador);
        btnFora = findViewById(R.id.btnFora);

        inicializaBotoes();
        onClickButton();

        txtj.setText(jogador);

        btnFora.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sair();

            }
        });

    }

    private void sair()
    {
        finish();

    }



    private void inicializaBotoes()
    {
        arrayButton[1] = findViewById(R.id.btn1);
        arrayButton[2] = findViewById(R.id.btn2);
        arrayButton[3] = findViewById(R.id.btn3);
        arrayButton[4] = findViewById(R.id.btn4);
        arrayButton[5] = findViewById(R.id.btn5);
        arrayButton[6] = findViewById(R.id.btn6);
        arrayButton[7] = findViewById(R.id.btn7);
        arrayButton[8] = findViewById(R.id.btn8);
        arrayButton[9] = findViewById(R.id.btn9);
    }

    private void onClickButton()
    {
        for (int x=1; x<10;x++){
            final int finalX = x;
            arrayButton[finalX].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    setJogadas(finalX);
                }
            });
            matriz[x]="";
        }
    }

    private void setJogadas(int x)
    {
        if(matriz[x].equals(""))
        {
            matriz[x] = vez;
            jogadas++;
            if (vez.equals("X") )
            {
                vez = "O";
                jogador = "jogador 2";
            }
            else
                {
                vez = "X";
                jogador = "jogador 1";
            }

            txtj.setText(jogador);
        }
        getButton();
        verifica();
    }

    private void getButton()
    {
        for (int x=1;x<10;x++)
        {
            arrayButton[x].setText(matriz[x]);
        }
    }

    private void verifica()
    {
        if(matriz[1].equals(matriz[2]) && !matriz[1].equals(""))
        {
            if(matriz[2].equals(matriz[3]))
            {
                ganhador(matriz[1]);
                return;
            }
        }

        if(matriz[1].equals(matriz[4]) && !matriz[1].equals(""))
        {
            if(matriz[4].equals(matriz[7]))
            {
                ganhador(matriz[1]);
                return;
            }
        }

        if(matriz[1].equals(matriz[5]) && !matriz[1].equals(""))
        {
            if(matriz[5].equals(matriz[9]))
            {
                ganhador(matriz[1]);
                return;
            }
        }

        if(matriz[2].equals(matriz[5]) && !matriz[2].equals(""))
        {
            if(matriz[5].equals(matriz[8]))
            {
                ganhador(matriz[2]);
                return;
            }
        }

        if(matriz[3].equals(matriz[6]) && !matriz[3].equals(""))
        {
            if(matriz[6].equals(matriz[9]))
            {
                ganhador(matriz[3]);
                return;
            }
        }else if(matriz[3].equals(matriz[5]) && !matriz[3].equals(""))
        {
            if (matriz[5].equals(matriz[7]))
            {
                ganhador(matriz[3]);
                return;
            }
        }

        if(matriz[4].equals(matriz[5]) && !matriz[4].equals(""))
        {
            if(matriz[5].equals(matriz[6]))
            {
                ganhador(matriz[4]);
                return;
            }
        }

        if(matriz[7].equals(matriz[8]) && !matriz[7].equals(""))
        {
            if(matriz[8].equals(matriz[9]))
            {
                ganhador(matriz[7]);
                return;
            }
        }

        if(jogadas == 9){
            ganhador("");
            return;
        }

    }

    private void ganhador(String win)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Jogo.this);
        builder.setTitle("Resultado");
        if(win.equals(""))
        {
            builder.setMessage("Empate");
        }
        else
            {
            if(win.equals("X"))
            {
                builder.setMessage("\"X\" é o Vencedor");
            }else{
                builder.setMessage("\"O\" é o Vencedor");
            }
        }

        builder.setPositiveButton("Novo jogo", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                jogadas = 0;
                for (int x=1;x<10;x++)
                {
                    matriz[x] = "";
                }
                getButton();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

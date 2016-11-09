package com.nstick.raihanyuwono.n_stick;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import static com.nstick.raihanyuwono.n_stick.MainProgram.newPlayer;

public class Multiplayer extends AppCompatActivity {

    protected int sticks;
    protected TextView stick1, stick2;
    protected Button[] player1, player2;
    protected boolean turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);
        turn = false;
        stick1 = (TextView) findViewById(R.id.multi_stick_1);
        stick2 = (TextView) findViewById(R.id.multi_stick_2);
        player1 = new Button[4];
        player2 = new Button[4];
        player1[0] = (Button) findViewById(R.id.p1_0);
        player1[1] = (Button) findViewById(R.id.p1_1);
        player1[2] = (Button) findViewById(R.id.p1_2);
        player1[3] = (Button) findViewById(R.id.p1_3);
        player2[0] = (Button) findViewById(R.id.p2_0);
        player2[1] = (Button) findViewById(R.id.p2_1);
        player2[2] = (Button) findViewById(R.id.p2_2);
        player2[3] = (Button) findViewById(R.id.p2_3);

        init();

        player1[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(player1[0].getText().toString());
                play(x);
            }
        });
        player1[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(player1[1].getText().toString());
                play(x);
            }
        });
        player1[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(player1[2].getText().toString());
                play(x);
            }
        });
        player1[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(player1[3].getText().toString());
                play(x);
            }
        });
        player2[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(player2[0].getText().toString());
                play(x);
            }
        });
        player2[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(player2[1].getText().toString());
                play(x);
            }
        });
        player2[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(player2[2].getText().toString());
                play(x);
            }
        });
        player2[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(player2[3].getText().toString());
                play(x);
            }
        });
    }

    protected void init(){
        Random rand = new Random();
        sticks = rand.nextInt(100)+1;
        stick1.setText(String.valueOf(sticks));
        stick2.setText(String.valueOf(sticks));
        randButton();
        disableBtn();
    }

    protected void randButton(){
        Random rand = new Random();
        int x;
        if(sticks<8) x = 1;
        else x = rand.nextInt(7)+1;
        for(int i=0; i<4; i++){
            player1[i].setText(String.valueOf(x));
            player2[i].setText(String.valueOf(x));
            if(sticks-x>0) x++;
        }
    }

    protected void disableBtn(){
        for(int i=0; i<4; i++) {
            if(!turn){
                player1[i].setEnabled(true);
                player2[i].setEnabled(false);
            }
            else {
                player1[i].setEnabled(false);
                player2[i].setEnabled(true);
            }
        }
    }

    protected void play(int x){
        sticks-=x;
        stick1.setText(String.valueOf(sticks));
        stick2.setText(String.valueOf(sticks));
        turn = !turn;
        disableBtn();
        if(sticks==0){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(Multiplayer.this);
            alertDialog.setTitle(turn ? "PLAYER 1\nWIN" : "PLAYER 2\nWIN");

            alertDialog.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            onBackPressed();
                        }
                    });
            alertDialog.show();
        }
        if(!turn) randButton();
    }

}

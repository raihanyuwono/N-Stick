package com.nstick.raihanyuwono.n_stick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final Button easy = (Button) findViewById(R.id.dif_easy);
        final Button medium = (Button) findViewById(R.id.dif_med);
        final Button hard = (Button) findViewById(R.id.dif_hard);
        Button backToMenu = (Button) findViewById(R.id.backToMenu);

        switch (MainProgram.com.getLv()){
            case 1: easy.setEnabled(false);
                break;
            case 2: medium.setEnabled(false);
                break;
            case 3: hard.setEnabled(false);
                break;
        }
    
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainProgram.com.setLv(1);
                activateButton(easy, medium, hard);
                easy.setEnabled(false);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainProgram.com.setLv(2);
                activateButton(easy, medium, hard);
                medium.setEnabled(false);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainProgram.com.setLv(3);
                activateButton(easy, medium, hard);
                hard.setEnabled(false);
            }
        });
        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    protected void activateButton(Button x, Button y, Button z){
        x.setEnabled(true);
        y.setEnabled(true);
        z.setEnabled(true);
    }

}

package com.nstick.raihanyuwono.n_stick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SinglePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        TextView player_name = (TextView) findViewById(R.id.player_name);
        TextView stick = (TextView) findViewById(R.id.single_stick);

        player_name.setText(MainProgram.getNamePlayer());
        stick.setText("");
    }
}

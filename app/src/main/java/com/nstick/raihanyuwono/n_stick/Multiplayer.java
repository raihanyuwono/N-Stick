package com.nstick.raihanyuwono.n_stick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Multiplayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        TextView stick1 = (TextView) findViewById(R.id.multi_stick_1);
        TextView stick2 = (TextView) findViewById(R.id.multi_stick_2);

        stick1.setText("");
        stick2.setText("");
    }
}

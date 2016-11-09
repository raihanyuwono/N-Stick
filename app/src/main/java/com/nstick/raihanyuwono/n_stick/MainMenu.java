package com.nstick.raihanyuwono.n_stick;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static com.nstick.raihanyuwono.n_stick.MainProgram.newPlayer;

public class MainMenu extends AppCompatActivity {

    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button singlePleyer = (Button) findViewById(R.id.single_player);
        Button multiPlayer = (Button) findViewById(R.id.multiplayer);
        Button setting = (Button) findViewById(R.id.setting);
        Button exit = (Button) findViewById(R.id.exit);

        singlePleyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, SinglePlayer.class));
            }
        });

        multiPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Multiplayer.class));
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Setting.class));
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        prefs = getSharedPreferences("com.nstick.raihanyuwono.n_stick", MODE_PRIVATE);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        if(prefs.getBoolean("firstrun", true)){
            MainProgram.setComLv(1);
//            inputName();
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }

    protected void inputName(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainMenu.this);
        alertDialog.setTitle("User Name");
        alertDialog.setMessage("Your Name :");

        final EditText input = new EditText(MainMenu.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("ENTER",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        newPlayer(input.getText().toString());
                    }
                });
        alertDialog.show();
    }

}

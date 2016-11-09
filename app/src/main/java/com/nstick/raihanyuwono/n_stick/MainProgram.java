package com.nstick.raihanyuwono.n_stick;

/**
 * Created by raihanyuwono on 08/11/2016.
 */

public class MainProgram {
    public static Computer com = new Computer();
    public static Player user;

    public static void play(int lv, int type){

    }

    public static void newPlayer(String name){
        user = new Player(name);
    }
}

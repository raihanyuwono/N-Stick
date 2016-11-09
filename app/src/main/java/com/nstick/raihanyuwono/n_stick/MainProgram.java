package com.nstick.raihanyuwono.n_stick;

/**
 * Created by raihanyuwono on 08/11/2016.
 */

public class MainProgram {
    private static Computer com = new Computer();
    private static Player user;

    public static void play(int lv, int type){

    }

    public static int getComLv(){
        return com.getLv();
    }

    public static void setComLv(int lv){
        com.setLv(lv);
    }

    public static void newPlayer(String name){
        user = new Player(name);
    }

    public static String getNamePlayer(){
        return user.getName();
    }
}

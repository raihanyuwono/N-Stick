package com.nstick.raihanyuwono.n_stick;

/**
 * Created by raihanyuwono on 08/11/2016.
 */

public class Player {
    private int win, lose;
    private String name;
    public Player(String name){
        this.name = name;
        this.win = 0;
        this.lose = 0;
    }
    public void setWin(){
        this.win++;
    }
    public void setLose(){
        this.lose++;
    }
    public int getWin(){
        return this.win;
    }
    public int getLose(){
        return this.lose;
    }
    public void restart() {
        this.win = 0;
        this.lose = 0;
    }
}

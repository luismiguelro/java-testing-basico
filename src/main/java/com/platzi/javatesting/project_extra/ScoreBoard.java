package com.platzi.javatesting.project_extra;

public class ScoreBoard {

    private Integer tienum;
    private Integer winnum;
    private Integer  lossnum;

    public ScoreBoard() {
        tienum=0;
        winnum=0;
        lossnum=0;
    }

    public Integer getTienum() {
        return tienum;
    }

    public Integer getWinnum() {
        return winnum;
    }

    public Integer getLossnum() {
        return lossnum;
    }

    public void incrementWins(){
        winnum++;
    }

    public void incrementLosses(){
        lossnum++;
    }

    public void incrementTies(){
        tienum++;
    }
}

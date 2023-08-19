package com.platzi.javatesting.project_extra;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {

        //start game
        printGameRules();

        String choice = input.nextLine().toUpperCase(); //prompt response

        //initialize variables
        ScoreBoard scoreBoard = new ScoreBoard();



        while (!choice.equals("quit")) //do the following if the user does not put in "quit"
        {
            GameOption choicenum = getChoiceNum(choice);

            if (choicenum == null){

                while(choicenum == null) //continue while user input is still not valid
                {
                    System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                    choice = input.nextLine().toUpperCase();

                    choicenum = getChoiceNum(choice);
                }
            }


            GameOption compnum = getChoiceComputer();


            completeGamePlay(scoreBoard, choicenum, compnum);
            printResults(scoreBoard);
            choice = input.nextLine().toUpperCase();; //prompt for new user input
        }
        if(choice.equals("quit")) //if user prints "quit", then quit program
            return;
    }

    private static void printResults(@NotNull ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWinnum() + "\nloses:" + scoreBoard.getLossnum() + "\nties:" + scoreBoard.getTienum()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private static void  completeGamePlay (ScoreBoard scoreBoard, GameOption choicenum, GameOption compnum) {

        if(choicenum == compnum) //tie cases
        {
            System.out.println("It's a tie");
            scoreBoard.incrementTies();
        }
        else if (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS) //user wins rock vs scissors
        {
            System.out.println("you win!");
           scoreBoard.incrementWins();
        }
        else if (choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER) //user wins scissors vs paper
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        }
        else if (choicenum == GameOption.PAPER && compnum == GameOption.ROCK) //user wins paper vs rock
        {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        }
        else //otherwise computer wins
        {
            System.out.println("you lose.");
           scoreBoard.incrementLosses();
        }
    }

    public GameOption getChoiceNum(@NotNull String choice){
        GameOption selectedOption = null;

        if (choice.equals("quit"))
            System.exit(0); //quit program


        try{
            selectedOption = GameOption.valueOf(choice);
        } catch (Exception e){
            return null;
        }

        return selectedOption;
    }
    private GameOption getChoiceComputer() {
        GameOption option = GameOption.values()[random.nextInt(3)];
        System.out.println("Computer chose " + option.toString().toLowerCase());
        return option;
    }

    private static void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }
}
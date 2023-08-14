package com.platzi.javatesting.project_extra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;
    //indicar clase principal
    @InjectMocks
    private Game game;

    //objeto a mockear
    @Mock
    Scanner scanner;

    @Mock
    Random random;

    private ByteArrayOutputStream out;

    @Before
    public void setUp(){
        //obtener lo que se esta imprimiendo en consola
        out = new ByteArrayOutputStream();

        // indicar objeto a utilizar como consola
        System.setOut(new PrintStream(out));
    }
    @Test
    public void when_write_quit_then_exit_game(){

        //simular con mockito
        when(scanner.nextLine()).thenReturn("Quit");


        // crear un juego
        game.play();

        // comparar parte del  texto
        Assert.assertTrue(out.toString().contains("Let's play Rock"));
    }

    @Test
    public void when_chose_rock_then_beats_scissors(){

        //simular con mockito, la seleccion del usuario
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        // simular la respuesta random del pc
        when(random.nextInt(3)).thenReturn(OPTION_SCISSORS);


        // crear un juego
        game.play();

        //pruebas
       Assert.assertTrue(out.toString().contains("Computer chose scissors"));
       Assert.assertTrue(out.toString().contains("wins:1"));

    }

    @Test
    public void when_chose_scissors_then_beats_paper(){

        //simular con mockito, la seleccion del usuario
        when(scanner.nextLine()).thenReturn("scissors").thenReturn("Quit");
        // simular la respuesta random del pc
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);


        // crear un juego
        game.play();

        //pruebas
        Assert.assertTrue(out.toString().contains("Computer chose paper"));
        Assert.assertTrue(out.toString().contains("wins:1"));

    }

    @Test
    public void when_chose_paper_then_beats_rock(){

        //simular con mockito, la seleccion del usuario
        when(scanner.nextLine()).thenReturn("paper").thenReturn("Quit");
        // simular la respuesta random del pc
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);


        // crear un juego
        game.play();

        //pruebas
        Assert.assertTrue(out.toString().contains("Computer chose rock"));
        Assert.assertTrue(out.toString().contains("wins:1"));

    }

    @Test
    public void when_both_choose_rock_then_tie(){

        //simular con mockito, la seleccion del usuario
        when(scanner.nextLine()).thenReturn("rock").thenReturn("Quit");
        // simular la respuesta random del pc
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);


        // crear un juego
        game.play();

        //pruebas
        Assert.assertTrue(out.toString().contains("Computer chose rock"));
        Assert.assertTrue(out.toString().contains("ties:1"));

    }

    @Test
    public void when_choose_rock_and_computer_choose_paper_then_lose(){

        //simular con mockito, la seleccion del usuario
        when(scanner.nextLine()).thenReturn("rock").thenReturn("Quit");
        // simular la respuesta random del pc
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);



        // crear un juego
        game.play();

        //pruebas
        Assert.assertTrue(out.toString().contains("Computer chose paper"));
        Assert.assertTrue(out.toString().contains("loses:1"));

    }
}


package com.platzi.javatesting.project_extra;

import org.junit.Assert;
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

    //indicar clase principal
    @InjectMocks
    private Game game;

    //objeto a mockear
    @Mock
    Scanner scanner;

    @Mock
    Random random;
    @Test
    public void when_write_quit_then_exit_game(){

        //simular con mockito
        when(scanner.nextLine()).thenReturn("Quit");

        //obtener lo que se esta imprimiendo en consola
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // indicar objeto a utilizar como consola
        System.setOut(new PrintStream(out));

        // crear un juego
        game.play();

        // comparar parte del  texto
        Assert.assertTrue(out.toString().contains("Let's play Rock"));
    }

    @Test
    public void when_chose_rock_then_beats_scissors(){

        //simular con mockito: rock
        when(scanner.nextLine()).thenReturn("Rock ").thenReturn("Quit");
        // simular la respuesta random
        when(random.nextInt(3)).thenReturn(2);

        //obtener lo que se esta imprimiendo en consola
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // indicar objeto a utilizar como consola
        System.setOut(new PrintStream(out));

        // crear un juego
        game.play();

        // comparar parte del  texto
       Assert.assertTrue(out.toString().contains("Let's play Rock"));
    }

}


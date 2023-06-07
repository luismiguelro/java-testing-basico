package com.platzi.javatesting.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void loses_when_dice_number_is_too_low() {
        // dado: simular dado
        Dice dice = Mockito.mock(Dice.class);

        // simular resultado, cuando se llame al roll, retorne un 2
        Mockito.when(dice.roll()).thenReturn(2);

        // jugador
        Player player = new Player(dice,3);

        assertFalse(player.play());
    }

    @Test
    public void wins_when_dice_number_is_too_big() {
        // dado: simular dado
        Dice dice = Mockito.mock(Dice.class);

        // simular resultado, cuando se llame al roll, retorne un 4
        Mockito.when(dice.roll()).thenReturn(4);

        // jugador
        Player player = new Player(dice,3);

        assertTrue(player.play());
    }

    @Test
    public void tie_when_dice_number_is_the_same(){
        // dado: simular dado
        Dice dice = Mockito.mock(Dice.class);

        // simular resultado, cuando se llame al roll, retorne un 4
        Mockito.when(dice.roll()).thenReturn(3);

        // jugador
        Player player = new Player(dice,3);

        assertFalse(player.play());

    }
}
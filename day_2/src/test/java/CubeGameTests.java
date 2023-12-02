import org.example.CubeGame;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CubeGameTests {
    String testString = "Game 1: 7 blue, 5 red; 10 red, 7 blue; 5 blue, 4 green, 15 red; 4 green, 6 red, 7 blue; 5 green, 8 blue, 4 red; 5 red, 4 blue, 3 green";
    CubeGame cubeGame = new CubeGame(testString);

    @Test
    public void canGetArrayOfNumbers (){

        assertEquals(5, cubeGame.getRedNumbers());
    }
    @Test
    public void canGiveMaxOfEachColour(){
        assertEquals(8, cubeGame.getMaxBlue());
        assertEquals(15, cubeGame.getMaxRed());
        assertEquals(5, cubeGame.getMaxGreen());
    }

    @Test
    public void canFailIfNumberExceedsLimit(){
        assertEquals(0, cubeGame.checkGame());
    }
}

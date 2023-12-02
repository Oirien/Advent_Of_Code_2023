import org.example.ListMaker;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListMakerTests {
    ListMaker listMaker = new ListMaker();

    @Test
    public void canFigureOutNumbers(){
        String test = "1hello2";
        List<String> stringList = listMaker.makeListOfStrings(test);
        assertEquals(12, listMaker.findCalibration(stringList));
    }
    @Test
    public void canFigureOutText(){
        String test = "1fishthree";
        List<String> stringList = listMaker.makeListOfStrings(test);
        assertEquals(13, listMaker.findCalibration(stringList));
    }

    @Test
    public void canFindCorrectFirstAndLast(){
        String test = "twoonefiveight";
        List<String> stringList = listMaker.makeListOfStrings(test);
        assertEquals(28, listMaker.findCalibration(stringList));
    }
}

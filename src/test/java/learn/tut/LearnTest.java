package learn.tut;

import org.junit.jupiter.api.Test;

import static  org.junit.jupiter.api.Assertions.*;

public class LearnTest {
    @Test
    void checkMaths(){
        assertEquals(5, 5);
    }

    @Test()
    void checkLearn(){

        Learn learn = new Learn("Ikemefuna", "Lagos");
        assertEquals("Ikemefuna", learn.getName());

    }


}

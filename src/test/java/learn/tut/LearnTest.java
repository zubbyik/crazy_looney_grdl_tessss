package learn.tut;

import org.junit.jupiter.api.Test;

import static  org.junit.jupiter.api.Assertions.*;

/**
 * The type Learn test.
 */
public class LearnTest {
    /**
     * Check maths.
     */
    @Test
    void checkMaths(){
        assertEquals(5, 5);
    }

    /**
     * Check learn.
     */
    @Test()
    void checkLearn(){

        Learn learn = new Learn("Ikemefuna", "Lagos");
        assertEquals("Ikemefuna", learn.getName());

    }


}

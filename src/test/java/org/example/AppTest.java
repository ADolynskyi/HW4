package org.example;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testStringConverter() {
        //Given
        String s = "Some Text";

        //When
        String result;
        result = App.stringConverter(s);

        //Then
        String expected = "sOmE TeXt";
        assertEquals(expected, result);
    }

}

package com.twu.biblioteca;

import com.twu.biblioteca.operation.InvalidOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class InvalidOptionTest {

    @Test
    public void ShouldCallViewToDisplayInvalidMessageAndReturnTrue() {
        InvalidOption invalidOption = new InvalidOption();

        assertEquals("Select a valid option!", invalidOption.execute());
    }

}
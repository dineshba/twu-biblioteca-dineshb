package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;


public class InvalidOptionTest {

    @Test
    public void ShouldCallViewToDisplayInvalidMessageAndReturnTrue() {
        View view = Mockito.mock(View.class);
        InvalidOption invalidOption = new InvalidOption(view);

        invalidOption.execute();
        Mockito.verify(view).show("Select a valid option!");
    }

}
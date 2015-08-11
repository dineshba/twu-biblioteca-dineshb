package com.twu.biblioteca.view;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class WelcomeViewTest {

    @Test
    public void shouldReturnTheLoginView() {
        MainMenuView mainMenuView = Mockito.mock(MainMenuView.class);
        WelcomeView welcomeView = new WelcomeView(mainMenuView);

        assertEquals(mainMenuView.getClass(), welcomeView.execute().getClass());
    }

}
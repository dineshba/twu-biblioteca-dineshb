package com.twu.biblioteca.operation;

import com.twu.biblioteca.helper.Login;
import com.twu.biblioteca.model.Users;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;


public class UserInformationTest {

    @Test
    public void shouldPrintTheUserInformation() {
        View view = Mockito.mock(View.class);
        Login login = Mockito.mock(Login.class);
        UserInformation userInformation = new UserInformation(view, login);

        Mockito.when(login.getCurrentUser()).thenReturn(new Users("", "", "","","",""));

        userInformation.execute();
        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }
}
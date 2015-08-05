package com.twu.biblioteca.operation;


import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;

public class UserInformationTest {

    @Test
    public void shouldPrintTheUserInformation() {
        View view = Mockito.mock(View.class);
        Users user = new Users("111-1111", "dinydiny", "User", "Dinesh", "dineshudt17@gmail.com", "8973882730");
        UserInformation userInformation = new UserInformation(view, user);

        userInformation.execute();

        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }
}
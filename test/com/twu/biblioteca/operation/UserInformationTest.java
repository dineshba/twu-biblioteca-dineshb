package com.twu.biblioteca.operation;


import com.twu.biblioteca.Login;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;

public class UserInformationTest {

    @Test
    public void shouldPrintTheUserInformation() {
        View view = Mockito.mock(View.class);
        Users userOne = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        Users userTwo = new Users("111-1112", "admin", "Admin", "Babu", "babu@yahoo.com", "9791621203");
        ArrayList<Users> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users);

        UserInformation userInformation = new UserInformation(view, login);

        userInformation.execute();

        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }
}
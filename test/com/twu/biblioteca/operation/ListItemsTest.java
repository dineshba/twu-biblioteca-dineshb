package com.twu.biblioteca.operation;

import com.twu.biblioteca.Login;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.View;
import com.twu.biblioteca.reponse.Success;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;


public class ListItemsTest {

    @Test
    public void libraryShouldGiveBookToView() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Users userOne = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        Users userTwo = new Users("111-1112", "admin", "Admin", "Babu", "babu@yahoo.com", "9791621203");
        ArrayList<Users> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users);
        Success success = new Success();
        Library library = new Library(books, login, success);
        View view = Mockito.mock(View.class);
        ListItems listItems = new ListItems(library, view, " ");

        listItems.execute();
        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }
}
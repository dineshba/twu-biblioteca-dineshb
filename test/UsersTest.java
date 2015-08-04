import com.twu.biblioteca.Users;
import org.junit.Test;

import static org.junit.Assert.assertFalse;


public class UsersTest {

    @Test
    public void shouldBeTrueWhenNamePasswordAndRollAreNotMatched() {
        Users user = new Users("Dinesh", "dinydiny", "Customer");

        assertFalse(user.authenticate("Dinesh", "dinydiny", "Customer"));
    }
}

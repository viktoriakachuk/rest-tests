package edu.bsuir.test.user;

import edu.bsuir.test.BasicTest;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserDeleteNegative extends BasicTest {
    final String ID_USER_TO_DELETE = "100";

    @Test
    public void unableToDeleteUser() {
        String path = "user/" + ID_USER_TO_DELETE;
        String message = deleteResourceError(path);
        assertThat(message).isEqualToIgnoringCase("{" +
                "\"errorMessage\":\"Unable to delete. User with id "+ID_USER_TO_DELETE+" not found.\"" +
                "}");
    }
}

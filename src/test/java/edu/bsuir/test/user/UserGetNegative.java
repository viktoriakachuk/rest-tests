package edu.bsuir.test.user;

import edu.bsuir.pojo.User;
import edu.bsuir.test.BasicTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class UserGetNegative extends BasicTest {
    final String ID_USER = "200";
    @Test
    public void unableToShowUser(){
        String path = "user/" + ID_USER;
        String message = getResourceError(path);
        assertThat(message).isEqualToIgnoringCase("{" +
                "\"errorMessage\":\"User with id "+ID_USER+" not found\"" +
                "}");
    }
}

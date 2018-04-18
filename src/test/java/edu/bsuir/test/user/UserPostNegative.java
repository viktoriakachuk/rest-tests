package edu.bsuir.test.user;

import edu.bsuir.pojo.User;
import edu.bsuir.test.BasicTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class UserPostNegative extends BasicTest {
    final String BAD_NAME_USER = "Sam";
    final String GOOD_NAME_USER = "Lilo";
    final String GOOD_AGE_USER = "40";
    final String BAD_AGE_USER ="kkk";
    private User postUser;
    @Test
    public void unableToCreateUserNameAlreadyExists(){
        postUser = createDummyUser(BAD_NAME_USER);
        String message = createResourceErrorName("user/", postUser);
        assertThat(message).isEqualToIgnoringCase("{" +
                "\"errorMessage\":\"Unable to create. A User with name "+BAD_NAME_USER+" already exist.\"" +
                "}");
    }

   /* @Test
    public void unableToCreateUserInvalidAgeInput(){}*/

    private User createDummyUser(String name) {
        return new User().setName(name)
                .setAge(40)
                .setSalary(90000);
    }
}

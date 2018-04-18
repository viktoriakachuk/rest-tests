package edu.bsuir.test.user;

import edu.bsuir.pojo.User;
import edu.bsuir.test.BasicTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserPutNegative extends BasicTest {
    final String ID_USER = "300";
    private User editUser;
    @Test
    public void unableToEditUser(){
        String path = "user/" + ID_USER;
        editUser = createDummyUser();
        String message = editResourceError(path, editUser);
        assertThat(message).isEqualToIgnoringCase("{" +
                "\"errorMessage\":\"Unable to upate. User with id "+ID_USER+" not found.\"" +
                "}");
    }
    private User createDummyUser() {
        return new User().setName("Tom")
                .setAge(40)
                .setSalary(10000);
    }
}

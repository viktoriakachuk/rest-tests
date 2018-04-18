package edu.bsuir.test.user;

import edu.bsuir.pojo.User;
import edu.bsuir.test.BasicTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
public class UserPut extends BasicTest {
    final double NEW_SALARY_USER = 55000;
    final double OLD_SALARY_USER = 50000;
    final String PATH = "user/2";
    private User editUser;
    private User getUser;


    @Test
    public void shouldEditUser() {
        editUser = createDummyUser(NEW_SALARY_USER);
        editResource(PATH, editUser);
        getUser = getResource(PATH, User.class);
        assertThat(getUser.getSalary()).isNotEqualTo(50000);

    }

    @After
    public void shutDown() {
        editUser = createDummyUser(OLD_SALARY_USER);
        editResource(PATH, editUser);
    }

    private User createDummyUser(double salary) {
        return new User().setName("Tom")
                .setAge(40)
                .setSalary(salary);
    }
}

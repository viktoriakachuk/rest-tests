package edu.bsuir.test.user;

import edu.bsuir.pojo.User;
import edu.bsuir.test.BasicTest;
import org.junit.After;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class UserDelete extends BasicTest {

    final String ID_USER_TO_DELETE = "4";
    final String NAME = "Silvia";
    final int AGE = 50;
    final double SALARY = 40000;
    @Test
    public void shouldDeleteUser(){
        String path = "user/" + ID_USER_TO_DELETE;
        deleteResource(path);
        List<User> list = getAll("user/");
        assertThat(list).extracting("name").doesNotContain("Silvia");
    }

    @After
    public void shutDown(){
        User deletedUser = new User().setId(4).setName(NAME).setAge(AGE).setSalary(SALARY);
        createResource("user/", deletedUser);
    }
}

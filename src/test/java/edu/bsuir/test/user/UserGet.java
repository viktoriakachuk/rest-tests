package edu.bsuir.test.user;

import edu.bsuir.pojo.User;
import edu.bsuir.test.BasicTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserGet extends BasicTest{
    @Test
    public void shouldShowUser(){
        User getUser = getResource("user/3", User.class);
        assertThat(getUser.getName()).isEqualTo("Jerome");
    }
}

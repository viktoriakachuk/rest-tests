package edu.bsuir.test.user;

import edu.bsuir.pojo.User;
import edu.bsuir.test.BasicTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

public class UserPost extends BasicTest {

    private User postUser;
    private User getUser;

    @Before
    public void setUp() {
        postUser = createDummyUser();
    }

    @Test
    public void shouldCreateUser() {
        String userLocation = createResource("user/", postUser);
        getUser = getResource(userLocation, User.class);
        assertThat(getUser).isEqualToIgnoringGivenFields(postUser, "id");
    }

    @After
    public void shutDown() {
        String id = valueOf(getUser.getId());
        String path = "user/" + id;
        deleteResource(path);
    }

    private User createDummyUser() {
        return new User().setName("John")
                .setAge(10)
                .setSalary(3000);
    }

}

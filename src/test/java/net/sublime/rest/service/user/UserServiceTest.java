package net.sublime.rest.service.user;

import net.sublime.rest.model.user.Role;
import net.sublime.rest.model.user.Status;
import net.sublime.rest.model.user.User;
import net.sublime.rest.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("User added successfully")
    public void addUser() {
        User user = new User();
        user.setUsername("Sublime_bot47");
        boolean isUserCreated = userService.addUser(user);
        Mockito.verify(userRepository , Mockito.times(1)).save(user);
        Assert.assertTrue(isUserCreated);
    }

    @Test
    public void checkUser() {
        User user = new User();
        user.setUsername("Sublime_bot47");
        userService.addUser(user);

        Assert.assertEquals(user.getStatus(), Status.ACTIVE);
        Assert.assertEquals(user.getRole(), Role.USER);

    }


}

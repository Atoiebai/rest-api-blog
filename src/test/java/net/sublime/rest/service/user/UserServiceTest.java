package net.sublime.rest.service.user;

import net.sublime.rest.dto.user.UserDTO;
import net.sublime.rest.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
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

        UserDTO user = new UserDTO();
        user.setUsername("Sublime_47");
        boolean isUserCreated = userService.addUser(user);
//        Mockito.verify(userRepository , Mockito.times(1)).save(user);
        Assert.assertTrue(isUserCreated);
    }

    @Test
    public void checkUser() {
        UserDTO user = new UserDTO();
        user.setUsername("Sublime_47");
        userService.addUser(user);
    }


}

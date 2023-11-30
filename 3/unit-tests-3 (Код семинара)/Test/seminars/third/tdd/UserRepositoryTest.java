package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private UserRepository userRepository;
    User user;
    private List<User> data;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        user=new User("First", "12345");
        data = new ArrayList<>();
    }

    @Test
    public void testAddUser() {
        data.add(user);
        assertEquals(1, data.size());
        assertTrue(data.contains(user));
    }

    @Test
    public void testFindTrueUser() {
        userRepository.addUser(user);

        boolean result = userRepository.findByName("First");
        assertTrue(result);
    }

    @Test
    public void testFindFalseUser() {
        userRepository.addUser(user);

        boolean result = userRepository.findByName("Second");
        assertFalse(result);
    }


}
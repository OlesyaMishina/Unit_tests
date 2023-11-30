package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    User user;

    @BeforeEach
    void setUp(){
        user=new User("First", "12345");
    }

    @Test
    void correctUser(){
//        user=new User("First", "12345");
        assertTrue(user.authenticate("First", "12345"));
    }

    @ParameterizedTest
    @CsvSource({"Second, 12345", "First, 1345"})
    void incorrectUser(String name, String password){
        assertFalse(user.authenticate(name, password));
    }
}
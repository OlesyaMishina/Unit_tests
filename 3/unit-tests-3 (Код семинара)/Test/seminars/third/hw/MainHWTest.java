package seminars.third.hw;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {

    MainHW hw;
    @BeforeEach
    void setUp(){
        hw = new MainHW();
    }

    @Test
    void checkEvenNumber() {
        assertTrue(hw.evenNumber(4));
    }

    @Test
    void checkOddNumber() {
        assertFalse(hw.evenNumber(3));
    }

    @ParameterizedTest
    @ValueSource(ints={25, 100})
    void numberInInterval(int num) {
        assertTrue(MainHW.numberInInterval(num));
    }

    @ParameterizedTest
    @ValueSource(ints={24, 101})
    void numberNotInInterval(int num) {
        assertFalse(MainHW.numberInInterval(num));
    }
}
package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
   // 3.1.
   SomeService someService;
    int[] numList;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    @Test
    void multipleThreeNotFiveReturnsFizz() {

        String check = someService.fizzBuzz(3);

        assertThat(check).isEqualTo("fizz");


    }

        @Test
        void multipleThreeNotThreeReturnsBuzz() {
            String check = someService.fizzBuzz(5);

            assertThat(check).isEqualTo("buzz");

        }

        @Test
        void multipleThreeOrFiveReturnsFizzBuzz() {
            String check = someService.fizzBuzz(15);

            assertThat(check).isEqualTo("fizzbuzz");

        }

        @Test
        void multipleNotThreeOrFiveReturnsNumber() {
            String check = someService.fizzBuzz(8);

            assertThat(check).isEqualTo("8");

        }
    @Test
    void testArrayCellValue6(){

        boolean result = someService.firstLast6( new int[]{1, 2, 3, 4, 5, 6});

        assertEquals(true, result);
    }

    @Test
    void testArrayCellValueFirst6(){

        boolean result = someService.firstLast6( new int[]{6, 2, 3, 4, 5, 0});

        assertEquals(true, result);
    }

    @Test
    void testArrayCellValueNot6(){

        boolean result = someService.firstLast6( new int[]{1, 2, 3, 4, 5, 6, 7});

        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"2000, 50, 1000", "2000, 100, 0", "2000, 0, 2000"})
    void insufficientCoverageTest(double amount, int discount, double result){

        assertThat(someService.calculatingDiscount(amount, discount))
                .isEqualTo(result); // обычная скидка
        }

    @Test
    void overDiscount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }
    void zeroDiscount() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

    @ParameterizedTest
    @CsvSource({"13, 10, 20, 30", "10, 13, 20, 30", "10, 20, 13, 30", "10, 20, 30, 60"})
    void checkSum(int a, int b, int c, int result){

        assertThat(someService.luckySum(a, b, c))
                .isEqualTo(result);
    }

}








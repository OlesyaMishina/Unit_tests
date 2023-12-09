import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MyArrayTest {
    int[] array1 = new int[]{1,1,1,1,1};
    MyArray myMock;
    MyArray myArray;
    double mean1 = 1;

    @BeforeEach
    void setUp() {
        myArray = new MyArray();
        myMock = mock(MyArray.class);
    }

    @Test // Проверяем длину массива
    void checkArraySizeTest() {
        assertThat(myArray.createArray().length).isEqualTo(15);
    }

    @Test // проверяем что createArray возвращает правильный массив
    void createArrayTest() {
        when(myMock.createArray()).thenReturn(array1);

        assertThat(myMock.createArray()).isEqualTo(array1);
    }


    @Test // проверяем что averageMean возвращает правильное среднее значение
    void averageMeanTest() {
        assertThat(myArray.averageMean(array1)).isEqualTo(mean1);
    }


    @ParameterizedTest
    @CsvSource({"1, 2, Среднее значение второго массива больше.",
            "2, 1, Среднее значение первого массива больше.",
            "1, 1, Средние значения массивов равны."})
    void compareMeansTest(double mean1, double mean2, String res) {
       assertThat(myArray.compareMeans(mean1, mean2).toString()).isEqualTo(res);
    }
}
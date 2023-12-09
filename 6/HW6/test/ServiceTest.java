import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class ServiceTest {
    MyArray myArray;
    Service service;
    int [] array1 = new int[]{1, 1, 1, 1, 1};

    double mean1 = 1;

    @BeforeEach
    void setUp() {
        myArray = mock(MyArray.class);
        service = new Service(myArray);
    }

    @Test
    void createArrayTest() {
        when(myArray.createArray()).thenReturn(array1);

        assertThat(service.createArray()).isEqualTo(array1);
    }

    @Test
    void meanCalculationTest() {
        when(myArray.averageMean(array1)).thenReturn(mean1);

        assertThat(service.meanCalculation(array1)).isEqualTo(mean1);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, Среднее значение второго массива больше.",
            "2, 1, Среднее значение первого массива больше.",
            "1, 1, Средние значения массивов равны."})
    void compareMeansTest(double mean1, double mean2, String res) {
        when(myArray.compareMeans(mean1, mean2)).thenReturn(res);
        service.compareMeans(mean1, mean2);

        verify(myArray).compareMeans(mean1, mean2);
    }
}
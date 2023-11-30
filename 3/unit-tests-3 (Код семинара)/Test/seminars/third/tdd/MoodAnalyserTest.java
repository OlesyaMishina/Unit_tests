package seminars.third.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoodAnalyserTest {


    @ParameterizedTest
    @CsvSource({"хорошая погода, happy", "все плохо, sad", "привет, So so"})
    void numberNotInInterval(String str, String res) {
        MoodAnalyser md = new MoodAnalyser();
        assertThat(md.analyze(str)).isEqualTo(res);
    }

}
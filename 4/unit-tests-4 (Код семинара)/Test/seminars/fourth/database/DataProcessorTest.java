package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataProcessorTest {
        @Test
        void testDatabase(){
            Database database = mock(Database.class);
            DataProcessor dataProcessor = new DataProcessor(database);
            when(database.query(anyString())).thenReturn(Arrays.asList("Data1","Data2","Data3"));

            List<String> result = dataProcessor.processData("qwe");

            assertThat(result).isEqualTo(Arrays.asList("Data1","Data2","Data3"));
        }
    }

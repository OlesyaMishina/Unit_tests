package seminars.fourth.webservice;

import org.junit.jupiter.api.Test;

import static javafx.beans.binding.Bindings.when;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WebserviceTest {
    @Test
    void testRequestCheck(){
        MyHttpClient myHttpClient = mock(MyHttpClient.class);
        Webservice webservice = new Webservice(myHttpClient);
        when(myHttpClient.get(anyString())).thenReturn("OK");

        String result = webservice.sendRequest("url");

        assertThat(result).isEqualTo("OK");
    }
}

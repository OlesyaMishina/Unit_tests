package seminars.fourth.webservice;

public class Webservice {

    public Webservice(MyHttpClient myHttpClient) {
        this.myHttpClient = myHttpClient;
    }

    MyHttpClient myHttpClient;

    public String sendRequest(String url) {
        return myHttpClient.get(url);
    }
}

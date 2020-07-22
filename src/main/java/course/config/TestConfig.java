package course.config;

import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestConfig {

    public static CloseableHttpClient closeableHttpClient;
    public static BasicCookieStore basicCookieStore;
    public static Logger log = LoggerFactory.getLogger(TestConfig.class); ;

    static {
        basicCookieStore=new BasicCookieStore();
    }

}

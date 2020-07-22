package course.config;

import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BeforeTestPrepare {
    @BeforeSuite(description = "套件测试开始，测试准备工作，Httpclient，拼接URL")
    public void beforeSuit(){
        //创建HTTP连接
        TestConfig.closeableHttpClient= HttpClients.custom().setDefaultCookieStore(TestConfig.basicCookieStore).build();
    }
    @AfterSuite(description = "套件测试结束")
    public void afterSuit(){
        System.out.println("afterSuit.........run");
    }
}

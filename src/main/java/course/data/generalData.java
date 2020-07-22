package course.data;

import com.alibaba.fastjson.JSONObject;
import course.config.TestConfig;
import course.utils.ConfigFile;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.List;

public class generalData {
    //获取URL地址
    public static String getloginUrl(int urlRow, int urlCell){
        return ConfigFile.getUrl(urlRow, urlCell);
    }

    //获取参数
    public static JSONObject getJsonParm(int row,int cell){
        return ConfigFile.getJsonParm(row, cell);
    }

    //获取预期结果
    public static String getEXpectResult(int expectRow,int expectCell){
        return ConfigFile.getParm(expectRow,expectCell);
    }

    //获取实际结果,post请求
    public static String getResult(String url, JSONObject jsonParm) throws IOException {
        //创建HTTPPOST连接
        HttpPost post = new HttpPost(url);
        //将参数添加到entity实体中
        StringEntity entity = new StringEntity(jsonParm.toString(),"utf-8");
        //设置请求头信息
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        //设置参数
        post.setEntity(entity);
        //执行post请求
        CloseableHttpResponse httpResponse = TestConfig.closeableHttpClient.execute(post);
        TestConfig.log.info("执行post请求");
        String result = EntityUtils.toString(httpResponse.getEntity());
        TestConfig.log.info("接口返回结果"+result);
        //遍历cookies，方便判断cookie是否获取到
        List<Cookie> cookies = TestConfig.basicCookieStore.getCookies();
        for (Cookie cookie:cookies) {
            //日志记录cookie信息
            TestConfig.log.info("cookies信息");
            TestConfig.log.info("cookies:"+cookie.getName()+":"+cookie.getValue());
        }
        return result;
    }


}

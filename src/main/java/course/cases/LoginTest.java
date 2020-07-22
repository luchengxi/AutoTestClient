package course.cases;

import course.config.TestConfig;
import course.data.generalData;
import course.utils.ConfigFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest {

    @Test(description = "登录接口测试")
    public void loginTest() throws IOException {
        //接口调用，获取结果
        String result = generalData.getResult(generalData.getloginUrl(1,4),generalData.getJsonParm(1,7));
        TestConfig.log.info("期望结果"+generalData.getEXpectResult(1,8));
        //验证结果
        Assert.assertEquals(result,generalData.getEXpectResult(1,8));
        TestConfig.log.info("登录接口结果验证成功，测试通过");
        ConfigFile.writeExcel(1,9,result);
        ConfigFile.writeExcel(1,10,"pass");
    }

}

package course.cases;


import course.config.TestConfig;
import course.data.addUserData;
import course.data.generalData;
import course.model.addUserCase;
import course.utils.ConfigFile;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class addUserTest {
    //类一加载就执行静态代码块，优先于构造代码块及构造函数
    public static addUserData addUserData;

    static {
        addUserData = new addUserData();
    }

    @Test(description = "添加用户接口测试")
    public void AddUserTest() throws IOException {
        //获得实际结果
        String result = generalData.getResult(generalData.getloginUrl(2, 4), generalData.getJsonParm(2, 7));
        JSONObject resultJson = new JSONObject(result);
        System.out.println("实际结果" + result);
        //从数据库查询得到实际结果
        addUserCase addusercase = addUserData.getCheckData("迪拜");
        //数据校验
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(resultJson.getString("userName"), addusercase.getUserName());
        TestConfig.log.info("测试通过，数据校验通过");
        ConfigFile.writeExcel(2, 9, result);
        ConfigFile.writeExcel(2, 10, "pass");
    }
}

package course.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    public static File files;
    public static  Row r;
    public static Workbook wkb;
    //读取配置文件的url地址信息
    public static ResourceBundle bundle = ResourceBundle.getBundle("UrlProperties", Locale.CHINA);
    //获取测试地址url
    public static String getUrl(int rowUrl,int cellUrl){
        //获取url地址
        String addrs = bundle.getString("test.url");
        //获取接口地址
        String url=getParm(rowUrl,cellUrl);
        //最终测试地址
        String testUrl =addrs+url;
        return testUrl;
    }

    //返回json格式参数
    public static JSONObject getJsonParm(int row, int cell) {
        //通过行获取第N列的值
        String strjson = creatExcel(row).getCell(cell).getStringCellValue();
        //封装成json对象
        JSONObject jsonParm = JSONObject.parseObject(strjson);
        System.out.println(jsonParm);
        return jsonParm;
    }

    //获取URL地址及其他参数
    public static String getParm(int row, int cell) {
        //通过行获取第N列的值
        String str = creatExcel(row).getCell(cell).getStringCellValue();
        System.out.println(str);
        return str;
    }


    //创建excel对象从而获取行对象，查询excel的信息
    public static Row creatExcel(int row) {
        files = new File(bundle.getString("excel.url"));
        //获取工作表
        try {
            wkb = WorkbookFactory.create(files);

        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }
        //获取第一个工作表，此处暂时写死，一个excel为一个工作表
        Sheet sheet = wkb.getSheetAt(0);
        //获取行
        r = sheet.getRow(row);
        //设置单元格类型为Strin
        r.getCell(row).setCellType(CellType.STRING);
        return r;
    }

    //写入excel
    public static void writeExcel(int writeRows,int writeCells,String writeString) throws FileNotFoundException, IOException {
        //获取excel
        FileInputStream fs = new FileInputStream(bundle.getString("excel.url"));
        //创建工作簿
        XSSFWorkbook wb = new XSSFWorkbook(fs);
        //获取工作表
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow rows = sheet.getRow(writeRows);
        //创建输出流
        FileOutputStream out = new FileOutputStream(bundle.getString("excel.url"));
        //写入数据
        rows.createCell(writeCells).setCellValue(writeString);
        out.flush();
        wb.write(out);
        wb.close();

    }

}

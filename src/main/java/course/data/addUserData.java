package course.data;

import course.model.addUserCase;
import course.utils.MybatisSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class addUserData {
    //获取加用户接口，添加到数据库的数据，用于数据库校验
    public addUserCase getCheckData(String userName) throws IOException {
        SqlSession sqlSession = MybatisSqlSession.getSqlsession();
        addUserCase adduercase = sqlSession.selectOne("addUserCase",userName);
        sqlSession.close();
        return adduercase;
    }
}

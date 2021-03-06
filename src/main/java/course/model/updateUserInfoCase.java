package course.model;

import lombok.Data;

@Data
public class updateUserInfoCase {
    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
    private String expected;

    public String toString(){
        return (
                "{id:"+id+","+
                        "userName:"+userName+","+
                        "password:"+password+","+
                        "age:"+age+","+
                        "sex:"+sex+","+
                        "permission:"+permission+","+
                        "isDelete:"+isDelete+","+
                        "expected:"+expected+"}"
        );
    }
}

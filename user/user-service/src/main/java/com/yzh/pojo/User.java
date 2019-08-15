package com.yzh.pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author yzh
 * @date 2019/8/8
 */
@Data
@Table(name = "tb_user")
public class User extends CommonFiled implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String userName;
    private String phone;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private String birthday;

}

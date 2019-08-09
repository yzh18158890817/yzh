package com.yzh.pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yzh
 * @date 2019/8/8
 */
@Data
@Table(name = "tb_user")
public class User extends CommonFiled {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private String birthday;

}

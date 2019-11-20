package com.css.dataexchangesystem.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
* @Description:
* @Param:
* @return:
* @Author: mxc
* @Date: 2019/11/13
* @Version：1.0
*/
@Data
public class User {
    @NotNull
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
}

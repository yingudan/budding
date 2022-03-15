package com.ripper.budding.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2022-01-12
 * @Description:com.ripper.budding
 * @Version:1.0
 **/

@Data
public class DemoDto implements Serializable {


    private static final long serialVersionUID = -4637862549612006446L;

    private String name;

    private Integer age;

    private String d;


}

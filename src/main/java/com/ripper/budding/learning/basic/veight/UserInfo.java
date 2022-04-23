package com.ripper.budding.learning.basic.veight;

import lombok.Builder;
import lombok.Data;

/**
 * @author yingd@jccfc.com
 * @since 2022/3/17 15:44
 **/
@Data
@Builder
public class UserInfo {

    private String name;

    private int age;

    private String status;

}

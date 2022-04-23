package com.ripper.budding;

import com.ripper.budding.utils.BusinessUtils;
import com.ripper.budding.utils.DemoDto;
import com.ripper.budding.utils.ReflexUtils;

import java.math.BigDecimal;
import java.util.List;

public class BuddingTest {

    public static void main(String[] args) {
        getObjectFields();
    }


    public static void getObjectFields() {
        DemoDto dto = new DemoDto();
        dto.setAge(2);
        dto.setName("demo");
        dto.setName("demo");
        List<String> objectFields = ReflexUtils.getObjectFields(dto);
        System.out.println(objectFields);
    }

}

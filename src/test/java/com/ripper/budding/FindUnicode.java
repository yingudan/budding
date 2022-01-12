package com.ripper.budding;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yingd [RipperF@hotmail.com]
 * @Date:2021-12-22
 * @Description:com.ripper.budding
 * @Version:1.0
 **/


public class FindUnicode {

    public static final String UNCHECKED="\u2610";

    public static final String CHECKED="\uD83D\uDDF9";

    public static final  String re="\\"+"u2610";

    public static final String uncheck="u2610";

    public static final String demo2=File.separator;

    public static void main(String[] args)  {
        Map<String,Object> map = new HashMap<>();
        map.put("demo2",demo2+uncheck);
        map.put("UNCHECKED",UNCHECKED);
        System.out.println("map>>>"+map);
    }



}

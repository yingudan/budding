package com.ripper.budding.design.factory.simple;


import com.ripper.budding.design.factory.Huawei;
import com.ripper.budding.design.factory.Iphone;
import com.ripper.budding.design.factory.Nuojiya;
import com.ripper.budding.design.factory.Phone;

/**
 * Created by Ripper on 2018/3/12.
 */
public class SimpleFactory {

    public Phone getPhone(String name){
        if("诺基亚".equals(name)){
            return new Nuojiya();
        }else  if ("苹果".equals(name)){
            return  new Iphone();
        }else  if("华为".equals(name)){
            return  new Huawei();
        }
        return  null;
    };

}

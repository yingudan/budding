package com.ripper.budding.learning.basic.exception;

/**
 * @Auther: Yingd [RipperF@hotmail.com]
 * @Date:2021-11-29
 * @Description:com.ripper.budding.learning.basic
 * @Version:1.0
 **/

/**
 * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.toLowerCase()" because "<local1>.address.city" is null
 * at Main.main(Main.java:5)
 * 可以在NullPointerException的详细信息中看到类似... because "<local1>.address.city" is null，意思是city字段为null，这样我们就能快速定位问题所在。
 *
 * 这种增强的NullPointerException详细信息是Java 14新增的功能，但默认是关闭的，我们可以给JVM添加一个-XX:+ShowCodeDetailsInExceptionMessages参数启用它：
 *
 * java -XX:+ShowCodeDetailsInExceptionMessages Main.java
 */
public class BaseException  extends  RuntimeException{

    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}

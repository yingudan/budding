/**
 * 
 */
package util.createClass.gencode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代码注解table
 * 
 * @author shadow
 * @version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface GenTable {

	public String name() default ""; // 对应数据库中列名

	public String alias() default ""; // 对应数据库中列名

	public String desc() default ""; // 对应数据库中列名
}

/**
 * 
 */
package util.createClass.gencode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 根据pojo生成对象属性
 * 
 * @author shadow
 * @version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface GenField {

	public String column() default ""; // 对应数据库中列名

	public String labelname() default ""; // 对应前台展现是的form标签名称

	public String alias() default ""; // 对应数据库中列名

	public boolean condition() default false; // 是否作为查询条件

	public boolean id() default false; // 是否是主键

	public boolean isnull() default true; // 是否允许为空

	public int length() default 0; // 获取文本的长度
}

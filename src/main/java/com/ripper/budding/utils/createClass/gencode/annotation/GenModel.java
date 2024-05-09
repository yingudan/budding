/**
 * 
 */
package util.createClass.gencode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 生成的模块名称
 * 
 * @author shadow
 * @version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface GenModel {

	public String packageName() default ""; // 包名

	public String modelName() default ""; // 模块名称
}

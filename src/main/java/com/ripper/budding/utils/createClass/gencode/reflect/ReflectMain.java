/**
 * 
 */
package util.createClass.gencode.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import util.createClass.gencode.annotation.GenField;
import util.createClass.gencode.annotation.GenModel;
import util.createClass.gencode.annotation.GenTable;


/**
 * 通过反射获取注解的设置的内容
 * 
 * @author desert
 * @version 1.0 2014/2/10
 */
public class ReflectMain {

	/**
	 * 获取类中的注解生成页面
	 * 
	 * @param objclass
	 */
	public ReflectVo getReflectFieldAnnotation(Class objclass) {
		ReflectVo vo = new ReflectVo();
		if (objclass != null) {
			String pojoname = objclass.getName();
			vo.setPojoClassName(pojoname);
			// 1、反射获取类中要创建的类名称GenModel名称
			Annotation[] class_annotation = objclass.getAnnotations();
			if (class_annotation != null && class_annotation.length > 0) {
				for (Annotation annotationType : class_annotation) {
					// 获取pojo中使用GenFile注解的属性
					if (annotationType != null && (annotationType.toString().indexOf("GenModel") != -1)) {
						GenModel genModel = (GenModel) annotationType;
						String modelname = genModel.modelName();
						String packagename = genModel.packageName();
						vo.setModelName(modelname);
						vo.setPackageName(packagename);
						// System.out.println(genModel.modelName()+"
						// "+genModel.packageName());
					}
					if (annotationType != null && (annotationType.toString().indexOf("GenTable") != -1)) {
						GenTable genTable = (GenTable) annotationType;
						vo.setTableName(genTable.name());
						vo.setTableDesc(genTable.desc());
					}
				} // end for
			} // end if
				// 2、获取类中的属性
			Field[] field_array = objclass.getDeclaredFields();
			// 记录列跟属性的映射的关系
			List<FieldColumnPojo> fcp_list = new ArrayList<FieldColumnPojo>();
			// 记录pojo中的表示属性的主键
			FieldColumnPojo keyField = null;
			for (Field field : field_array) {
				Annotation[] annotation = field.getAnnotations();
				Class typeclass = field.getType();
				String type_str = typeclass.toString().toLowerCase();
				if (annotation != null && annotation.length > 0) {
					Class annotationType = annotation[0].annotationType();
					// 获取pojo中使用GenFile注解的属性
					if (annotationType != null && (annotationType.toString().indexOf("GenField") != -1)) {
						GenField genField = (GenField) annotation[0];
						String fieldName = field.getName();
						String columnName = genField.column();
						String labelName = genField.labelname();
						boolean isId = genField.id();
						boolean isCondition = genField.condition(); // 是否为查询条件
						boolean isnull = genField.isnull(); // 判断输入的字段是否为空
						Integer length = genField.length(); // 验证框架中需要使用到的长度
						FieldColumnPojo obj = new FieldColumnPojo();
						obj.setColumn(columnName);
						obj.setFieldName(fieldName);
						obj.setLabelName(labelName);
						obj.setId(isId);
						obj.setIsCondition(isCondition);
						obj.setPermitNull(isnull);
						if (length != null && length > 0) {
							obj.setLength(length);
						}
						String type = "";
						if (type_str.indexOf("date") != -1) {
							type = "date";
						} else if (type_str.indexOf("double") != -1) {
							type = "double";
						} else if (type_str.indexOf("float") != -1) {
							type = "float";
						} else if (type_str.indexOf("string") != -1) {
							type = "string";
						} else if (type_str.indexOf("integer") != -1) {
							type = "integer";
						} else if (type_str.indexOf("long") != -1) {
							type = "long";
						} else if (type_str.indexOf("bigdecimal") != -1) {
							type = "bigdecimal";
						} else {
							System.out.println("格式错误：" + type_str);
						}
						// 验证框架需要验证用户提交到数据库中字段的长度
						obj.setValidteType(type);
						if (isId) {
							keyField = obj;
						}
						fcp_list.add(obj);
					}
				} // end if
			} // end for
			vo.setFcp_list(fcp_list);
			vo.setKeyvalue_obj(keyField);
			// 生成maper.xml文件
		} // end if
		return vo;
	}

	/**
	 * 测试
	 * 
	 * @param arg
	 */
	public static void main(String[] arg) {
		// ReflectMain reflectMain = new ReflectMain();
		// reflectMain.getReflectFieldAnnotation(ProductPojo.class);

	}
}

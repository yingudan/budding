package util.createClass.gencode.utils;

public class ClassUtil {

	public final static String NEXT_ROW = "\r\n";
	public final static String GET = "get";
	public final static String SET = "set";

	/**
	 * @param type
	 * @return 生成对象类型
	 */
	public static String fieldType(String type) {
		String colType = "";
		if (type.equalsIgnoreCase("date")) {
			colType = "Date";
		} else if (type.equalsIgnoreCase("double")) {
			colType = "Double";
		} else if (type.equalsIgnoreCase("float")) {
			colType = "Float";
		} else if (type.equalsIgnoreCase("string")) {
			colType = "String";
		} else if (type.equalsIgnoreCase("integer")) {
			colType = "Integer";
		} else if (type.equalsIgnoreCase("long")) {
			colType = "Long";
		} else if (type.equalsIgnoreCase("bigdecimal")) {
			colType = "BigDecimal";
		} else if (type.equalsIgnoreCase("boolean")) {
			colType = "boolean";
		} else {
			System.out.println("错误的类型");
		}
		return colType;
	}

	/**
	 * @param type
	 * @return 生成对象类型
	 */
	public static String fieldTypeMapper(String type) {
		String colType = "";
		if (type.equalsIgnoreCase("date")) {
			colType = "TIMESTAMP";
		} else if (type.equalsIgnoreCase("double")) {
			colType = "DECIMAL";
		} else if (type.equalsIgnoreCase("float")) {
			colType = "DECIMAL";
		} else if (type.equalsIgnoreCase("string")) {
			colType = "VARCHAR";
		} else if (type.equalsIgnoreCase("integer")) {
			colType = "INTEGER";
		} else if (type.equalsIgnoreCase("long")) {
			colType = "BIGINT";
		} else if (type.equalsIgnoreCase("bigdecimal")) {
			colType = "DECIMAL";
		} else {
			System.out.println("错误的类型");
		}
		return colType;
	}

	public static String fieldTypeRtnGet(String type) {
		if (type.equalsIgnoreCase("string")) {
			type = "String";
		} else if (type.equalsIgnoreCase("int")) {
			type = "Integer";
		} else if (type.equalsIgnoreCase("int16") || type.equalsIgnoreCase("int8")) {
			type = "Integer";
		} else if (type.equalsIgnoreCase("int32")) {
			type = "Integer";
		} else if (type.equalsIgnoreCase("date")) {
			type = "Date";
		} else if (type.equalsIgnoreCase("int64") || type.equalsIgnoreCase("int(64)")) {
			type = "Long";
		} else if (type.equalsIgnoreCase("double")) {
			type = "BigDecimal";
		} else if (type.equalsIgnoreCase("text")) {
			type = "String";
		} else {
			System.err.println("字段类型错误：" + type);
		}
		return type;
	}

}

/**
 * 
 */
package util.createClass.gencode.modelcontent;

import java.util.List;

import util.createClass.gencode.reflect.FieldColumnPojo;
import util.createClass.gencode.utils.ClassUtil;


/**
 * 构建Mapper中的代码
 * 
 * @author desert
 * @version 1.0 2014/2/12
 */
public class ModelMapperXMLUtils {

	/**
	 * 构建mapper中的namespace
	 * 
	 * @return
	 */
	public String getMapperNameSpace() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> " + ClassUtil.NEXT_ROW);
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" "
				+ "\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >" + ClassUtil.NEXT_ROW);
		return sb.toString();
	}

	public String construtMapperContent(String modelpackage, String pojoClassName, String modelName, String tableName,
			List<FieldColumnPojo> list, String keyColumn, String idvalue) {
		// 构建 Mapper
		String mapper_content = getMapperNameSpace();
		// 把类名的首字母大写
		StringBuffer classname = new StringBuffer(modelName);
		classname.setCharAt(0, Character.toUpperCase(classname.charAt(0)));

		mapper_content += "<mapper namespace=\"" + pojoClassName + "\"> " + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW;
		mapper_content += consttrutResultMap(pojoClassName, list);
		// mapper_content += this.consttrutSelectSql(pojoClassName, modelName,
		// tableName); // 构建select语句
		mapper_content += construtInsertSql(pojoClassName, tableName, modelName, list); // 构建insert语句
		mapper_content += insertBatchSql(pojoClassName, tableName, modelName, list); // 构建insert语句
		mapper_content += construtUpdateSQL(pojoClassName, list, modelName, tableName, keyColumn, idvalue); // 构建更新语句
		mapper_content += construtdeleteSql(modelName, tableName, idvalue,
		 keyColumn); // 构建删除语句
		mapper_content += construtsFindById(pojoClassName, list, modelName, tableName, keyColumn, idvalue); // 构建查询根据Id进行查询的查询语句
		mapper_content += "</mapper>" + ClassUtil.NEXT_ROW;
		return mapper_content;
	}

	/**
	 * @param pojoClassName
	 * @param list
	 * @return 构建代码块
	 */
	public String consttrutResultMap(String pojoClassName, List<FieldColumnPojo> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("	<resultMap id=\"BaseResultMap\" type=\"" + pojoClassName + "\" >" + ClassUtil.NEXT_ROW);
		// 需要先找出id来
		for (int i = 0; i < list.size(); i++) {
			FieldColumnPojo fcp = list.get(i);
			if (fcp.getId()) {
				sb.append("		<id column=\"" + fcp.getColumn() + "\"");
				sb.append(" property=\"" + fcp.getFieldName() + "\"");
				sb.append("	jdbcType=\"" + ClassUtil.fieldTypeMapper(fcp.getValidteType()) + "\"  />"
						+ ClassUtil.NEXT_ROW);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			FieldColumnPojo fcp = list.get(i);
			if (!fcp.getId()) {
				sb.append("		<result column=\"" + fcp.getColumn() + "\"");
				sb.append(" property=\"" + fcp.getFieldName() + "\"");
				sb.append("	jdbcType=\"" + ClassUtil.fieldTypeMapper(fcp.getValidteType()) + "\"  />"
						+ ClassUtil.NEXT_ROW);
			}
		}
		sb.append("	</resultMap>" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		sb.append("	<sql id=\"Base_Column_List\" >" + ClassUtil.NEXT_ROW);
		sb.append("		");
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				sb.append(list.get(i).getColumn());
			} else {
				sb.append("," + list.get(i).getColumn());
			}
			if (i % 20 == 19) {
				sb.append(ClassUtil.NEXT_ROW + "		");
			}
		}
		sb.append(ClassUtil.NEXT_ROW + "	</sql>" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		return sb.toString();
	}

	/**
	 * 查询sql
	 * 
	 * @param pojoClassName
	 * @return
	 */
	public String consttrutSelectSql(String pojoClassName, String modelName, String tableName) {
		// <select id="getNavigationByPage" parameterType="map"
		// resultType="net.lwyj.navigation.pojo.NavigationPojo">
		StringBuffer sb = new StringBuffer();
		sb.append("<select id=\"get" + modelName + "ByPage\" parameterType=\"map\" resultType=\"" + pojoClassName
				+ "\">   \r\n ");
		sb.append(" SELECT t.* FROM " + tableName + " t ");
		// 这个后面还需要添加sql的条件
		sb.append("  \r\n </select>  \r\n ");
		return sb.toString();
	}

	/**
	 * 构建Update语句
	 * 
	 * @param updateSql
	 *            更新sql
	 * @return
	 */
	public String construtUpdateSQL(String pojoClassName, List<FieldColumnPojo> list, String modelName,
			String tableName, String keyColumn, String idvalue) {
		StringBuffer sb = new StringBuffer();
		sb.append("	<update id=\"update\" parameterType=\"" + pojoClassName + "\">" + ClassUtil.NEXT_ROW);
		sb.append("		UPDATE " + tableName + ClassUtil.NEXT_ROW);
		sb.append("		<set>" + ClassUtil.NEXT_ROW);
		for (int i = 0; i < list.size(); i++) {
			FieldColumnPojo pojo = list.get(i);
			sb.append("			<if test=\"" + pojo.getFieldName() + " != null\" >" + ClassUtil.NEXT_ROW);
			sb.append("				" + pojo.getColumn() + " = " + "#{" + pojo.getFieldName() + ",jdbcType="
					+ ClassUtil.fieldTypeMapper(pojo.getValidteType()) + "}," + ClassUtil.NEXT_ROW);
			sb.append("			</if>" + ClassUtil.NEXT_ROW);
		}
		sb.append("		</set>" + ClassUtil.NEXT_ROW);
		sb.append("		where " + keyColumn + "= #{" + idvalue + "}" + ClassUtil.NEXT_ROW);
		sb.append("	</update> " + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		return sb.toString();
	}

	/**
	 * 构建插入语句
	 * 
	 * @param insertSql
	 *            插入sql
	 * @return
	 */
	public String construtInsertSql(String pojoClassName, String tableName, String modelName,
			List<FieldColumnPojo> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("	<insert id=\"insert\" parameterType=\"" + pojoClassName + "\" flushCache=\"true\" keyProperty=\"id\" useGeneratedKeys=\"true\" >" + ClassUtil.NEXT_ROW);
//		sb.append("		<selectKey resultType=\"Long\" order=\"BEFORE\" keyProperty=\"id\">" + ClassUtil.NEXT_ROW);
//		sb.append("			select SQ_" + tableName.replace("T_", "") + ".nextval as id from dual"
//				+ ClassUtil.NEXT_ROW);
//		sb.append("		</selectKey>" + ClassUtil.NEXT_ROW);
		// 针对mysql 插入时不添加组件
		sb.append("		INSERT INTO " + tableName + "(" + ClassUtil.NEXT_ROW);
		sb.append("		");
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				sb.append(list.get(i).getColumn());
			} else {
				sb.append("," + list.get(i).getColumn());
			}
			if (i % 6 == 5) {
				sb.append(ClassUtil.NEXT_ROW + "		");
			}
		}
		sb.append(") " + ClassUtil.NEXT_ROW);
		sb.append("		values (" + ClassUtil.NEXT_ROW);
		sb.append("			");
		for (int i = 0; i < list.size(); i++) {
			FieldColumnPojo fcp = list.get(i);
			if (i == 0) {
				sb.append("#{" + fcp.getFieldName() + ",jdbcType=" + ClassUtil.fieldTypeMapper(fcp.getValidteType())
						+ "}");
			} else {
				sb.append(",#{" + fcp.getFieldName() + ",jdbcType=" + ClassUtil.fieldTypeMapper(fcp.getValidteType())
						+ "}");
			}
			if (i % 5 == 4) {
				sb.append(ClassUtil.NEXT_ROW + "		");
			}
		}
		sb.append(ClassUtil.NEXT_ROW + "		)" + ClassUtil.NEXT_ROW);
		sb.append("	</insert>" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		return sb.toString();
	}

	/**
	 * 构建插入语句
	 * 
	 * @param insertSql
	 *            插入sql
	 * @return
	 */
	public String insertBatchSql(String pojoClassName, String tableName, String modelName, List<FieldColumnPojo> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("	<insert id=\"insertBatch\" parameterType=\"java.util.List\">" + ClassUtil.NEXT_ROW);
//		sb.append("		BEGIN" + ClassUtil.NEXT_ROW);
		sb.append("		INSERT INTO  " + tableName + " (");
		for (int i = 1; i < list.size(); i++) {
			if (i == 1) {
				sb.append(list.get(i).getColumn());
			} else {
				sb.append("," + list.get(i).getColumn());
			}
			if (i % 6 == 5) {
				sb.append(ClassUtil.NEXT_ROW + "		");
			}
		}
		sb.append(") values" + ClassUtil.NEXT_ROW);
//		sb.append("		SELECT " + tableName.replace("T_", "SQ_") + ".nextval,m.* FROM (" + ClassUtil.NEXT_ROW);
		sb.append("		<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">"
				+ ClassUtil.NEXT_ROW);
//		sb.append("			select" + ClassUtil.NEXT_ROW);
		StringBuilder sb2 = new StringBuilder();
		sb2.append("			(");
		for (int i = 0; i < list.size(); i++) {
			FieldColumnPojo fcp = list.get(i);
			if (fcp.getId()) {
				continue;
			}
			
			sb2.append("			#{item." + fcp.getFieldName() + "},"
//					+ "jdbcType="
//					+ ClassUtil.fieldTypeMapper(fcp.getValidteType()) + "},"
					+ClassUtil.NEXT_ROW);
		}
//		sb2.append("			)");
		sb.append(sb2.substring(0, sb2.length() - 3));
		sb.append(")");
//		sb.append(sb2.substring(0, sb2.length() ));
		sb.append(ClassUtil.NEXT_ROW);
		// sb.append(sb2.replace(sb2.lastIndexOf(","), sb2.lastIndexOf(","),
		// "").toString());
//		sb.append("			from dual" + ClassUtil.NEXT_ROW);
		sb.append("		</foreach>" + ClassUtil.NEXT_ROW);
//		sb.append("		) m" + ClassUtil.NEXT_ROW);
//		sb.append("		;END;" + ClassUtil.NEXT_ROW);
		sb.append("	</insert>" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		return sb.toString();
	}

	/**
	 * 根据Id主键查询对象
	 * 
	 * @param pojoClassName
	 * @param list
	 * @param modelName
	 * @param tableName
	 * @param keyColumn
	 *            主键名
	 * @param idvalue
	 * @return
	 */
	public String construtsFindById(String pojoClassName, List<FieldColumnPojo> list, String modelName,
			String tableName, String keyColumn, String idvalue) {

		StringBuffer sb = new StringBuffer();

		String keyName = "id";
		String keyDbName = "id";
		String keyType = "String";
		boolean ifId = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId()) {
				ifId = true;
				keyDbName = list.get(i).getColumn();
				keyName = list.get(i).getFieldName();
				keyType = ClassUtil.fieldType(list.get(i).getValidteType());
			}
		}
		if (!ifId) {
			System.out.println("没有主键id:" + pojoClassName);
		}
		sb.append("	<select id=\"findById\" parameterType=\"" + keyType + "\" " + " resultMap=\"BaseResultMap\" >"
				+ ClassUtil.NEXT_ROW);
		sb.append("		select " + ClassUtil.NEXT_ROW);
		sb.append("		<include refid=\"Base_Column_List\" />" + ClassUtil.NEXT_ROW);
		sb.append("		from " + tableName + ClassUtil.NEXT_ROW);
		sb.append("		where " + keyDbName + " = #{" + keyName + "}" + ClassUtil.NEXT_ROW);
		sb.append("	</select>" + ClassUtil.NEXT_ROW);
		return sb.toString();
	}

	/**
	 * 删除sql
	 * 
	 * @param deleteSql
	 * @return
	 */
	public String construtdeleteSql(String modelname, String tableName, String idvalue, String keyColumn) {
		StringBuffer sb = new StringBuffer();

		sb.append("<delete id=\"delete\" parameterType=\"java.lang.Integer\"> \r\n ");

		sb.append(" DELETE FROM " + tableName + " WHERE " + keyColumn + " = #{" + idvalue + "}");

		sb.append(" \r\n </delete>  \r\n ");

		return sb.toString();
	}

}

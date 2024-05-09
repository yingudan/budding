/**
 * 
 */
package util.createClass.gencode.modelcontent;

import java.util.ArrayList;
import java.util.List;

import util.createClass.gencode.reflect.FieldColumnPojo;


/**
 * 生成页面的主方法
 * 
 * @author
 * @version 1.0 2014/02/13
 */
public class ModelPageUtils {

	/**
	 * 获取jsp中的头文件
	 * 
	 * @return
	 */
	public String getJspHeader() {
		StringBuffer sb = new StringBuffer();
		// <%@ taglib prefix="limit" uri="http://www.biz-united.com.cn/limit" %>

		sb.append("<%@ page language=\"java\" import=\"java.util.*\" pageEncoding=\"UTF-8\"%> \r\n");
		sb.append("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\" %> \r\n");
		sb.append("<%@ taglib uri=\"http://www.lwyj.net/limit\" prefix=\"limit\"%> \r\n");
		sb.append("<%@ taglib prefix=\"spring\" uri=\"http://www.springframework.org/tags\" %> \r\n");
		sb.append("<% String path = request.getContextPath();%>  \r\n");

		return sb.toString();
	}

	/**
	 * 生成模块的主页面
	 * 
	 * @param list
	 *            条件列表
	 * @return index Content
	 */
	public String getIndexJsp(List<FieldColumnPojo> list, String modelName) {

		List<FieldColumnPojo> condition_list = new ArrayList<FieldColumnPojo>();

		for (FieldColumnPojo obj : list) {
			if (obj.getCondition()) {
				condition_list.add(obj);
			}
		}

		StringBuffer sb = new StringBuffer();

		// 添加页面头
		sb.append(this.getJspHeader());

		sb.append("<div><div class=\"divStyle\">");

		if (condition_list.size() > 0) {
			sb.append(
					"<div style=\"float:left\"><form id=\"queryForm\" style=\"margin:10;\"><table width=\"100%\"><tr>");
		}

		// 添加主页面中的条件
		for (FieldColumnPojo obj : condition_list) {
			sb.append("<td  width=\"300px\">").append(obj.getLabelName())
					.append(":<input name=\"" + obj.getFieldName() + "\" style=\"height: 20px\"></td>");
		}

		if (condition_list.size() > 0) {
			sb.append("<td><input type=\"button\" name=\"search\" onclick=\"javascript:load_" + modelName
					+ "grid(true);\" value='查询' />");
		}

		if (condition_list.size() > 0) {
			sb.append("</tr></table></form></div>");
		}

		sb.append(
				"<div style=\"float:right\"><div style=\"height:20px;line-height:20px;margin:10px;display:inline-block;\">");

		// 添加权限标签
		sb.append("<limit:weight type=\"add\"><input type=\"button\" value=\"添加\" onclick=\"javascript:addupdate_"
				+ modelName + "();\"/></limit:weight>");

		// 清除浮动
		sb.append("</div></div><div style=\"clear:both\"></div></div>");

		// 加载分页
		sb.append("<div id=\"" + modelName + "Grid\"></div><div id=\"pager\" class=\"pagination\"></div></div>");

		sb.append(this.indexScript(modelName));

		return sb.toString();
	}

	/**
	 * 添加主页中的script脚本
	 * 
	 * @param modelName
	 *            模块名称
	 */
	public String indexScript(String modelName) {
		StringBuffer sb = new StringBuffer();

		sb.append("\r\n" + "<script type=\"text/javascript\">" + "\r\n");

		// 分页变量
		sb.append("var beginRecord = 0;var maxRecord = 20;var currentPage=0;" + "\r\n");

		// 加载分页的主方法
		sb.append("load_" + modelName
				+ "grid = function(state){ \r\n if(state){ \r\n  beginRecord = 0; \r\n maxRecord = 20; \r\n }");

		// 加载分页方法的ajax
		sb.append("$.ajax({type: \"POST\", \r\n url: '<%=path%>/" + modelName
				+ "/grid.action?page='+currentPage+'&rows='+maxRecord, \r\n data:$(\"#queryForm\").serialize(), \r\n ");

		sb.append("success: function(response){ \r\n $(\"#" + modelName
				+ "Grid\").html(response); \r\n  $.ligerDialog.closeWaitting(); \r\n },error:function(){ \r\n $.ligerDialog.error('服务器繁忙，请稍后再试');} \r\n }); \r\n };"
				+ "\r\n");

		// 分页的附加方法
		sb.append(
				"pageselectCallback = function(page_id,perpage,jq){ \r\n beginRecord = page_id*perpage; \r\n  maxRecord   = perpage; \r\n currentPage = page_id; \r\n load_"
						+ modelName + "grid(); \r\n };" + "\r\n");

		// 更新或者添加方法
		sb.append("addupdate_" + modelName + " = function(id){ \r\n $.ligerDialog.open({ url: '<%=path%>/" + modelName
				+ "/forwordEdit.action?id='+id, width:500,height:150, modal: true,title:'" + modelName + "'}); \r\n };"
				+ "\r\n");

		// 删除主方法
		sb.append("del_" + modelName
				+ "=function(id){ \r\n $.ligerDialog.confirm({content:'确认删除这条数据吗?'}, function(r){ \r\n if(r==true){ \r\n");
		sb.append("$.ajax({type: \"POST\", \r\n url: '<%=path%>/" + modelName
				+ "/delete.action', \r\n  data:'id='+id, \r\n  success: function(msg){  \r\n $.ligerDialog.success('删除成功'); \r\n");
		sb.append("load_" + modelName
				+ "grid(false); \r\n },error:function(msg){  \r\n  $.ligerDialog.error('服务器繁忙，请稍后再试');} \r\n }); \r\n }}); \r\n };"
				+ "\r\n");

		// 默认加载区域
		sb.append(" $(function(){ \r\n  load_" + modelName + "grid(true); \r\n  load_button_css(); \r\n }); \r\n");

		sb.append("</script>");

		return sb.toString();
	}

	/**
	 * 生成grid页面
	 * 
	 * @param list
	 * @param modelName
	 */
	public String getGridContentJsp(List<FieldColumnPojo> list, String modelName) {

		StringBuffer sb = new StringBuffer();

		// 加载文件头
		sb.append(this.getJspHeader());

		// 加载分页控件
		sb.append("<script type=\"text/javascript\">$(function(){");

		sb.append(
				"$(\"#pager\").pagination(\"${pageInfo.totalResult}\", {items_per_page : maxRecord ,current_page : currentPage,callback: pageselectCallback});");

		sb.append(" });</script>");

		// 加载数据页面
		sb.append("<div><table class=\"tableMainStyle\"><thead><tr>");

		sb.append(" <th>序号</th>");

		for (FieldColumnPojo obj : list) {
			if (!obj.getId()) {
				sb.append(" <th>" + obj.getLabelName() + "</th>");
			}
		}

		sb.append(" <th>操作</th>");

		sb.append("</tr></thead><tbody id=\"" + modelName + "GridTbody\"><c:if test=\"${empty " + modelName
				+ "_list }\"><tr>");

		sb.append("<td colspan=\"13\" align=\"center\"><spring:message code='grid.nodata'/></td></tr></c:if>");

		sb.append(
				" <c:forEach var=\"" + modelName + "\" items=\"${" + modelName + "_list}\" varStatus=\"status\"><tr>");

		sb.append("<td align=\"center\"><c:out value=\"${status.index+1}\"/></td>");

		FieldColumnPojo temp = null;
		for (FieldColumnPojo obj : list) {
			if (!obj.getId()) {
				sb.append("  <td align=\"center\"><c:out value=\"${" + modelName + "." + obj.getFieldName()
						+ "}\"/></td>");
			} else { // 如果有组件的话增加操作这列
				temp = obj;
			}
		}

		if (temp != null) {
			sb.append("<td align=\"center\"><limit:weight type=\"update\"><a href=\"#\" onclick=\"javascript:addupdate_"
					+ modelName + "('${" + modelName + "." + temp.getFieldName()
					+ "}');return false;\">编辑</a></limit:weight>");

			// 删除信息
			sb.append(" <limit:weight type=\"update\"><a href=\"#\" onclick=\"javascript:del_" + modelName + "('${"
					+ modelName + "." + temp.getFieldName() + "}');return false;\">删除</a></limit:weight> ");
			// 查看信息
			sb.append(" <a href=\"#\" onclick=\"javascript:view_" + modelName + "('${" + modelName + "."
					+ temp.getFieldName() + "}');return false;\">查看</a></td>");
		}

		sb.append("</tr></c:forEach></tbody></table></div>");

		return sb.toString();
	}

	/**
	 * 生成POJO编辑页面jsp
	 * 
	 * @param list
	 * @param modelName
	 * @return
	 */
	public String getEditJspContent(List<FieldColumnPojo> list, String modelName) {
		StringBuffer sb = new StringBuffer();

		// 生成验证框架的代码
		StringBuffer validate_sb = new StringBuffer("$(\"#edit" + modelName + "Form\").validate({onclick:true,rules:{");

		// 验证框架中使用的内容
		StringBuffer validateField_sb = new StringBuffer();
		// StringBuffer validateMessage_sb = new StringBuffer();

		// 加载文件头
		sb.append(this.getJspHeader());

		sb.append("<div align=\"center\" style=\"margin-top:10px;\"><form id=\"edit" + modelName
				+ "Form\" method=\"post\"><table align=\"center\">");

		// 记录非必须输入的input字段
		List<FieldColumnPojo> notRequired_list = new ArrayList<FieldColumnPojo>();

		// 先生成必填的input 然后再生成非必填的input
		for (FieldColumnPojo obj : list) {

			StringBuffer ForValidateField_sb = new StringBuffer();

			System.out.println("====" + obj.getValidteType() + "  " + obj.getLength());

			// 验证框架中不判断主键
			if (!obj.getId()) {

				String v_type = obj.getValidteType();

				// 判断验证类型 integer date float double string
				ForValidateField_sb.append(obj.getFieldName() + ":{  \r\n");

				// 判断值是否允许为空
				boolean state = obj.isPermitNull();
				if (!state) {
					ForValidateField_sb.append("required:true,");
				} // end if

				if (v_type != null) {
					if (v_type.indexOf("integer") != -1) {
						ForValidateField_sb.append("digits:true,");
					} else if (v_type.indexOf("date") != -1) {
						ForValidateField_sb.append("date:true,");
					} else if (v_type.indexOf("float") != -1) {
						ForValidateField_sb.append("number:true,");
					} else if (v_type.indexOf("double") != -1) {
						ForValidateField_sb.append("number:true,");
					} else if (v_type.indexOf("string") != -1) {
						Integer length = obj.getLength();

						ForValidateField_sb.append("maxlength:" + length + ",");
					}
				} // end if

				// 去掉最后的一个,号
				String filedValidate = ForValidateField_sb.toString().substring(0, ForValidateField_sb.length() - 1);

				validateField_sb.append(filedValidate + " \r\n },");

			} // end if

			if (!obj.isPermitNull()) {
				sb.append("<tr><td align=\"right\">" + obj.getLabelName() + "<font color='red'>*</font>：</td>");
				sb.append("<td><input type=\"text\" id=\"" + obj.getFieldName() + "\" name=\"" + obj.getFieldName()
						+ "\" value=\"${" + modelName + "_obj." + obj.getFieldName() + "}\"/></td></tr>");
			} else {
				notRequired_list.add(obj);
			}
		} // end for

		// 非必填项的界面输出
		for (FieldColumnPojo obj : notRequired_list) {
			sb.append("<tr><td align=\"right\">" + obj.getLabelName() + "：</td>");
			sb.append("<td><input type=\"text\" id=\"" + obj.getFieldName() + "\" name=\"" + obj.getFieldName()
					+ "\" value=\"${" + modelName + "_obj." + obj.getFieldName() + "}\"/></td></tr>");
		}

		// 去掉最后一个逗号
		String validateField_str = validateField_sb.toString().trim().substring(0, validateField_sb.length() - 1);

		validate_sb.append(validateField_str + "}});");

		sb.append(" <tr><td colspan=\"2\" align=\"center\" height=\"26px\">");
		sb.append(" <div style=\"margin-top:10px; height: 26px;\">");
		sb.append(" <input type=\"button\" id=\"submitbutton\" name=\"submitbutton\" onclick=\"javascript:submit"
				+ modelName + "Data();return false;\" value='提交'/>");
		sb.append(
				" <input type=\"button\" name=\"reset\" value='取消' onclick=\"javascript:parent.$.ligerDialog.close();\"/>");
		sb.append("</div></td></tr>");

		sb.append("</table></form></div>");
		sb.append("<script type=\"text/javascript\">  \r\n");

		sb.append("$(function(){  \r\n");

		// 生成提交按钮的方法
		sb.append("submit" + modelName + "Data = function(){  \r\n");
		sb.append("   if($(\"#edit" + modelName + "Form\").valid()){  \r\n");
		sb.append("                  $.ajax({  \r\n");
		sb.append("                          type: \"POST\",  \r\n");
		sb.append("                          url: '<%=path%>/" + modelName + "/saveupdate.action',  \r\n");
		sb.append("                          data:$(\"#edit" + modelName + "Form\").serialize(), \r\n");
		sb.append("                          success: function(msg){  \r\n");
		sb.append("                              load_" + modelName + "grid(); \r\n");
		sb.append("                              parent.$.ligerDialog.close(); \r\n");
		sb.append("                              $.ligerDialog.success('操作成功！'); \r\n");
		sb.append("                          },error:function(msg){ \r\n");
		sb.append("                              $.ligerDialog.error('服务器繁忙，请稍后再试'); \r\n");
		sb.append("                          } \r\n");
		sb.append("                        });  \r\n");
		sb.append("     } \r\n");
		sb.append("}; \r\n");

		// 添加验证框架
		sb.append(validate_sb);

		// 加载按钮的样式
		sb.append("load_button_css();  \r\n");
		sb.append("}); \r\n");
		sb.append("</script>");

		return sb.toString();
	}

}

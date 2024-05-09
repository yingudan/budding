package util.createClass.gencode.modelcontent;

/**
 * 构建Action中的代码
 * 
 * @author shadow
 * @version 1.0
 */
public class ModelActionUtils {

	/**
	 * 构建Action中的content
	 * 
	 * @return String
	 */
	public String modelActionContent(String packageName, String pojoClassName, String modelName, String fieldName) {

		StringBuffer sb = new StringBuffer();

		// 声明package
		sb.append("package " + packageName + ".action;");

		// 声明需要导入的包
		sb.append("import java.util.List;");
		sb.append("import java.util.HashMap;");

		sb.append("import javax.annotation.Resource;");
		sb.append("import javax.servlet.http.HttpServletRequest;");
		sb.append("import org.apache.commons.logging.Log;");
		sb.append("import javax.servlet.http.HttpSession;");
		sb.append("import org.apache.commons.logging.LogFactory;");
		sb.append("import org.springframework.http.HttpStatus;");
		sb.append("import javax.servlet.http.HttpServletRequest;");
		sb.append("import org.springframework.stereotype.Controller;");
		sb.append("import org.springframework.web.bind.annotation.RequestMapping;");
		sb.append("import org.springframework.web.bind.annotation.RequestMethod;");
		sb.append("import org.springframework.web.bind.annotation.ResponseBody;");
		sb.append("import org.springframework.web.bind.annotation.ResponseStatus;" + "\r\n");

		// 添加分页
		sb.append("import net.lwyj.base.page.PageInfo;");

		// 把类名的首字母大写
		StringBuffer classname = new StringBuffer(modelName);
		classname.setCharAt(0, Character.toUpperCase(classname.charAt(0)));

		sb.append("import " + packageName + ".service." + classname.toString() + "Service;" + "\r\n");

		// 声明类
		sb.append("@Controller" + "\r\n");
		sb.append("@RequestMapping(\"/" + modelName + "\")" + "\r\n");
		sb.append("public class " + classname.toString() + "Action{");

		sb.append("@Resource" + "\r\n");
		sb.append("private " + classname.toString() + "Service service;");

		// 声明方法

		// 转到系统主页的方法
		sb.append("	@RequestMapping(value=\"index\")" + "\r\n");
		sb.append("public String forward" + modelName
				+ "IndexJsp(HttpServletRequest request,HttpSession session)throws Exception{");
		sb.append("return \"" + modelName + "/index\";");
		sb.append("}");

		// 转到系统的列表页面方法
		sb.append("	@RequestMapping(value=\"grid\",method=RequestMethod.POST)" + "\r\n");
		sb.append("public String forward" + modelName
				+ "Grid(int page, int rows,HttpServletRequest request)throws Exception{");

		sb.append("PageInfo pageInfo=new PageInfo();pageInfo.setPage(page+1);pageInfo.setShowCount(rows);");

		sb.append(" HashMap<String, Object> params = new HashMap<String, Object>();params.put(\"page\", pageInfo);");

		sb.append("List<" + pojoClassName + "> " + modelName + "_list = service.get" + modelName + "ByPage(params);");

		sb.append("request.setAttribute(\"" + modelName + "_list\", " + modelName
				+ "_list);request.setAttribute(\"pageInfo\", pageInfo);");

		sb.append("return \"" + modelName + "/grid\";");

		sb.append("}");

		// 转到增加的页面
		sb.append("@RequestMapping(value=\"forwordEdit\")" + "\r\n");// forwordEdit
		sb.append("public String forwardEditJsp(HttpServletRequest request,HttpSession session)throws Exception{");

		sb.append(" String id_str = request.getParameter(\"id\");");

		sb.append(" if(id_str!=null&&(id_str.length())>0&&(!id_str.trim().equals(\"undefined\"))){");
		sb.append(pojoClassName + " pojo_model = service.get" + modelName + "ById(id_str);");
		sb.append(" request.setAttribute(\"" + modelName + "_obj\",pojo_model);");
		sb.append(" }");

		sb.append("return \"" + modelName + "/edit\";");
		sb.append("}");

		// 增加修改方法
		sb.append("	@RequestMapping(value=\"saveupdate\",method=RequestMethod.POST)" + "\r\n");
		sb.append(" @ResponseStatus(value=HttpStatus.OK)" + "\r\n");
		sb.append("public void saveOrupdate" + modelName
				+ "(HttpServletRequest request,HttpSession session)throws Exception{");

		sb.append("}");

		// 删除方法
		sb.append("	@RequestMapping(value=\"delete\",method=RequestMethod.POST)" + "\r\n");
		sb.append(" @ResponseStatus(value=HttpStatus.OK)" + "\r\n");
		sb.append("public void delete" + modelName + "(HttpServletRequest request,String id)throws Exception{");
		sb.append("service.delete" + modelName + "(id);");
		sb.append("}");

		sb.append("}");

		return sb.toString();
	}

}

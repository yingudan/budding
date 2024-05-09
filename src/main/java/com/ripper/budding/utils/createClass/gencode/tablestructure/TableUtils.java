/**
 * 
 */
package util.createClass.gencode.tablestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.createClass.gencode.utils.DBPropertiesUtil;


/**
 * 表的结构
 * 
 * @author desert
 * @version 1.0 2014/02/17
 */
public class TableUtils {

	/**
	 * 连接mysql数据库
	 * 
	 * @param tableName
	 *            表的名称
	 * 
	 */
	public List<RowStructs> connectDataBase(String tableName, String databaseName) throws Exception {
		//
		// List<TableStructs> ts_list = new ArrayList<TableStructs>();
		//
		// DBPropertiesUtil dbutile = new DBPropertiesUtil();
		//
		// Connection con = null; //表示数据库的连接对象
		// Statement stmt = null; //表示数据库的更新操作
		// Statement stmt0 = null; //表示数据库的更新操作
		// Class.forName(dbutile.jdbcdrive); //1、使用CLASS 类加载驱动程序
		// con =
		// DriverManager.getConnection(dbutile.jdbcurl,dbutile.jdbcuser,dbutile.jdbcpassword);
		// //2、连接数据库
		// System.out.println(con);
		// stmt0 = con.createStatement(); //3、Statement 接口需要通过Connection
		// 接口进行实例化操
		//
		// List<String> columnKey_list = new ArrayList<String>();
		//
		// //获取表的主键 这个是mysql 跟sql server
		//// String sql =" SELECT COLUMN_NAME FROM
		// INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_NAME='"+tableName+"'
		// ";
		// String sql =" SELECT COLUMN_NAME FROM user_tab_columns WHERE
		// TABLE_NAME='"+tableName+"' ";
		//
		// ResultSet rs0 = stmt0.executeQuery(sql);
		// while(rs0.next()){
		// String columname = rs0.getString("COLUMN_NAME");
		// columnKey_list.add(columname);
		// }
		//
		// rs0.close();
		// stmt0.close();
		//
		//
		//
		// stmt = con.createStatement(); //3、Statement 接口需要通过Connection 接口进行实例化操
		//
		// StringBuilder sb = new StringBuilder();
		//
		// sb.append("select sys.columns.name columnname, sys.types.name
		// typename, sys.columns.max_length, sys.columns.is_nullable, ");
		// sb.append("(select count(*) from sys.identity_columns where
		// sys.identity_columns.object_id = sys.columns.object_id and
		// sys.columns.column_id = sys.identity_columns.column_id) as
		// is_identity ,");
		// sb.append("(select value from sys.extended_properties where
		// sys.extended_properties.major_id = sys.columns.object_id and
		// sys.extended_properties.minor_id = sys.columns.column_id) as
		// description");
		// sb.append(" from sys.columns, sys.tables, sys.types where
		// sys.columns.object_id = sys.tables.object_id and
		// sys.columns.system_type_id=sys.types.system_type_id and
		// sys.tables.name='"+tableName+"' order by sys.columns.column_id");
		//
		// //String sql = "SELECT
		// tco.COLUMN_NAME,tco.IS_NULLABLE,tco.COLUMN_TYPE,tco.COLUMN_KEY,tco.COLUMN_COMMENT,tco.CHARACTER_MAXIMUM_LENGTH
		// FROM information_schema.COLUMNS tco WHERE
		// tco.TABLE_NAME='"+tableName+"' AND
		// tco.TABLE_SCHEMA='"+databaseName+"'";
		// ResultSet rs = stmt.executeQuery(sb.toString());
		//
		//
		//
		// //column name
		// //columnname/typename/max_length/is_nullable/is_identity/description
		//
		// while(rs.next()){
		// TableStructs ts_obj = new TableStructs();
		//
		// ts_obj.setColumnName(rs.getString("columnname"));
		//
		// ts_obj.setColumnisNull(rs.getString("is_nullable")); //是否允许为空
		//
		// ts_obj.setColumnType(rs.getString("typename"));
		//
		// //主键
		// if(columnKey_list.contains(ts_obj.getColumnName())){
		// ts_obj.setColumniskey("pri");
		// }else{
		// ts_obj.setColumniskey("");
		// }
		//
		//
		//
		// ts_obj.setColumnComent(rs.getString("description"));
		//
		// ts_obj.setTextlength(rs.getString("max_length"));//文本的最大长度
		//
		// ts_list.add(ts_obj);
		//
		// }
		//
		// rs.close();
		// con.close(); // 4、关闭数据库
		//
		// return ts_list;

		List<RowStructs> ts_list = new ArrayList<RowStructs>();

		DBPropertiesUtil dbutile = new DBPropertiesUtil();

		Connection con = null; // 表示数据库的连接对象
		Statement stmt = null; // 表示数据库的更新操作
		Class.forName(dbutile.jdbcdrive); // 1、使用CLASS 类加载驱动程序
		con = DriverManager.getConnection(dbutile.jdbcurl, dbutile.jdbcuser, dbutile.jdbcpassword); // 2、连接数据库
		stmt = con.createStatement(); // 3、Statement 接口需要通过Connection 接口进行实例化操
		// System.out.println(stmt);
		// String sql = "SELECT tco.COLUMN_NAME,tco.IS_NULLABLE,"
		// + "tco.COLUMN_TYPE,tco.COLUMN_KEY,tco.COLUMN_COMMENT,"
		// + "tco.CHARACTER_MAXIMUM_LENGTH FROM user_tab_columns tco"
		// + " WHERE tco.TABLE_NAME='"+tableName+"' AND
		// tco.TABLE_SCHEMA='"+databaseName+"'";

		// String sql = "SELECT ucc.COLUMN_NAME,ucc.COMMENTS,"
		// + "utc.DATA_TYPE,utc.DATA_PRECISION,utc.DATA_SCALE FROM
		// user_col_comments ucc "
		// + "LEFT JOIN user_tab_columns utc ON ( ucc.TABLE_NAME =
		// utc.TABLE_NAME AND utc.COLUMN_NAME = ucc.COLUMN_NAME) "
		// + "WHERE ucc.TABLE_NAME='" + tableName + "'";

		String sql = "SELECT DISTINCT  column_name  COLUMN_NAME,column_comment COMMENTS,	data_type DATA_TYPE,"
				+ "character_maximum_length DATA_PRECISION,is_nullable IS_NULLABLE 	FROM information_schema. COLUMNS"
				+ " WHERE table_name ='" + tableName + "'";

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			RowStructs ts_obj = new RowStructs();

			ts_obj.setColumnName(rs.getString("COLUMN_NAME"));

			ts_obj.setColumnisNull(rs.getString("IS_NULLABLE")); // 是否允许为空

			ts_obj.setColumnType(rs.getString("DATA_TYPE"));

			// ts_obj.setColumniskey(rs.getString("COLUMN_KEY"));

			ts_obj.setColumnComent(rs.getString("COMMENTS"));

			ts_obj.setTextlength(rs.getString("DATA_PRECISION"));// 文本的最大长度

			// ts_obj.setColumnScale(rs.getString("DATA_SCALE"));

			ts_list.add(ts_obj);

		}

		rs.close();
		con.close(); // 4、关闭数据库

		return ts_list;
	}

	/**
	 * @param tableName
	 * @param databaseName
	 * @return 查询所有的表名
	 */
	public static List<TableStructs> getAllTable() {
		DBPropertiesUtil dbutile = new DBPropertiesUtil();
		List<TableStructs> list = new ArrayList<>();
		Connection con = null; // 表示数据库的连接对象
		Statement stmt = null; // 表示数据库的更新操作 ;
		try {
			Class.forName(dbutile.jdbcdrive); // 1、使用CLASS 类加载驱动程序
			con = DriverManager.getConnection(dbutile.jdbcurl, dbutile.jdbcuser, dbutile.jdbcpassword); // 2、连接数据库
			stmt = con.createStatement(); // 3、Statement 接口需要通过Connection
											// 接口进行实例化操
			String sql = "SELECT UTC.TABLE_NAME,UTC.COMMENTS FROM user_tab_comments  utc";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TableStructs ts = new TableStructs();
				ts.setTableDesc(rs.getString("COMMENTS"));
				ts.setTableName(rs.getString("TABLE_NAME"));
				// list.add(rs.getString("TABLE_NAME"));
				list.add(ts);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	/**
	 * 生成pojo
	 * 
	 * @param tableName
	 * @param databaseName
	 * @return
	 */
	public String construtsPojo(String tableName, String databaseName) {
		StringBuffer sb = new StringBuffer();
		try {
			List<RowStructs> ts_list = this.connectDataBase(tableName, databaseName);
			if (ts_list != null && ts_list.size() > 0) {
				// import class
				sb.append("");
				boolean iskeyExist = false;
				String prototype = "";
				// 产生属性
				for (RowStructs obj : ts_list) {
					System.out.println(obj.getColumnName() + "  " + obj.getColumnType() + "  " + obj.getColumniskey());

					sb.append("	@GenField(labelname=\"" + obj.getColumnComent() + "\",column=\"" + obj.getColumnName()
							+ "\"");
					// 主键
					if (obj.getColumnName().equalsIgnoreCase("id")) {
						sb.append(",id=true");
					}
					// if(obj.getColumniskey()!=null&&obj.getColumniskey().toLowerCase().equals("pri")&&!iskeyExist){
					// sb.append(",id=true");
					// }
					// 字符的长度
					String length = obj.getTextlength();

					if (length != null && !length.trim().equals("")) {
						sb.append(",length=" + length);
					}
					// 生成页面验证时使用
					String isnull = obj.getColumnisNull();
					if (isnull != null && isnull.toLowerCase().trim().equals("no")) {
						sb.append(",isnull=false");
					} else {
						sb.append(",isnull=true");
					}
					String columnType = obj.getColumnType().toLowerCase();
					sb.append(") \r\n");
					// 对数据库中的属性分类
					// 包含int的数据类型为 int
					if (columnType.indexOf("int") != -1) {
						prototype = "Integer";
					}
					
					if (columnType.indexOf("char") != -1) {
						prototype = "String";
					}
					
					if (columnType.indexOf("decimal") != -1) {
						prototype = "BigDecimal";
					}

					// 判断字符型
					if (columnType.indexOf("blob") != -1 || columnType.indexOf("text") != -1
							|| columnType.indexOf("varchar") != -1) {
						prototype = "String";
					}
					// 判断日期型
					if (columnType.indexOf("date") != -1 || columnType.indexOf("year") != -1
							|| columnType.indexOf("time") != -1) {
						prototype = "Date";
					}
					// 判断否点型
					if (columnType.indexOf("real") != -1 || columnType.indexOf("float") != -1
							|| columnType.indexOf("numeric") != -1) {

						prototype = "Float";
					}
					// 双精度
					if (columnType.indexOf("double") != -1) {
						prototype = "Double";
					}
					// bit
					if (columnType.indexOf("bit") != -1) {
						prototype = "Short";
					}
					// 二进制 暂时不 提供生成
					if (columnType.equalsIgnoreCase("NUMBER")) {
						if (Integer.valueOf(obj.getTextlength()) > 12) {
							if (Integer.valueOf(obj.getColumnScale()) > 0) {
								prototype = "BigDecimal";
							} else {
								prototype = "Long";
							}
						} else {
							prototype = "Integer";
						}
					}
					sb.append("	private " + prototype + " " + obj.getColumnName().toLowerCase() + "; \r\n\r\n");
				}
				// 构建setter getter方法
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static void main(String[] arg) throws Exception {
		TableUtils tu = new TableUtils();

		List<RowStructs> list = tu.connectDataBase("t_watch_type", "jeecg_test");

		String sb = tu.construtsPojo("t_watch_type", "jeecg_test");

		System.out.println(sb.toString());
	}

}

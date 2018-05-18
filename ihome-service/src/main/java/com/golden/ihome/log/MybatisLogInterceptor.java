package com.golden.ihome.log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }), })
public class MybatisLogInterceptor implements Interceptor {

	private Logger logger = LoggerFactory.getLogger(MybatisLogInterceptor.class);

	/**
	 * mapper.xml中需要拦截的ID(正则匹配)
	 */

	public Object intercept(Invocation ivk) throws Throwable {
		ResultSet rs = null;
		PreparedStatement countStmt = null;
		Object object = null;
		MappedStatement mappedStatement = (MappedStatement) ivk.getArgs()[0];
		Object parameter = null;
		if (ivk.getArgs().length > 1) {
			parameter = ivk.getArgs()[1];
		}
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		Object parameterObject = boundSql.getParameterObject();
		String sql = toUpperCase(boundSql.getSql());
		String where = sql.substring(sql.indexOf(" WHERE "), sql.length());
		String Table = sql.substring(0, sql.indexOf("SET")).replace("UPDATE", "");
		String listSql = "select * FROM " + Table + where;
		Connection connection = getConnection();
		List<Map<String, Object>> list = getBusiness(connection, Table);
		if (list.size() == 0) {// 数据库中无记录 不记录日志
			return ivk.proceed();
		}
		if (sql.indexOf("UPDATE") == 0) {// 更新
			List<Map<String, Object>>  oldList = getOld_u(list,listSql,connection,mappedStatement,boundSql,parameterObject);
			object = ivk.proceed();// 执行更新,更新之后从新查询获取数据
			List<Map<String, Object>>  newList = getnew_u(list,oldList,connection,mappedStatement,parameterObject,Table);
		}

		return object;
	}
	
	/**
	 * matchingOldNew:(匹配新老值). <br/>
	 *
	 * @author Administrator
	 * @return
	 * @throws Exception 
	 * @since JDK 1.7
	 */
		
	private static void matchingOldNew(List<Map<String, Object>> newList,List<Map<String, Object>> oldList,List<Map<String, Object>> businessList) throws Exception {
		if(newList.size()!=oldList.size()){
			throw new Exception();
		}
		List<Map<String, Object>> returnList = new ArrayList<>();
		Map<String, Object> t = null;
		for (int i = 0; i < newList.size(); i++) {
			for (int j = 0; j < businessList.size(); j++) {
				t = new HashMap<>();
				String index = businessList.get(j).get("INDEX").toString();
				if(newList.get(i).get(index).equals(oldList.get(i).get(index))){//数据发生了改变
					t.put("old", oldList.get(i).get(index));//老值
					t.put("new", newList.get(i).get(index));//新值
					t.put("idvalue", newList.get(i).get("ID"));//本条数据的id
					t.put("buinessid", newList.get(i).get("ID"));//对应的业务表信息id
				}
			}
		}
		
	}
	
	
	
	private List<Map<String, Object>> getnew_u(
			List<Map<String, Object>> businessList,
			List<Map<String, Object>> oldList,
			Connection connection,
			MappedStatement mappedStatement,
			Object parameterObject,
			String table) throws SQLException {
		ResultSet rs = null;
		PreparedStatement countStmt = null;
		//拼装sql
		String sql = "SELECT * FROM "+table+"WHERE ID IN (";
		for (int i = 0; i < oldList.size(); i++) {
			sql+=oldList.get(i).get("ID");
			if(i!=oldList.size()-1){
				sql+=",";
			}
		}
		sql+=")";
		countStmt = connection.prepareStatement(sql);
		rs = countStmt.executeQuery();
		List<Map<String, Object>> list = new ArrayList<>();
		while(rs.next()){
			Map<String, Object> map = new HashMap<>();
			for (int i = 0; i < businessList.size(); i++) {//找到每个字段
				String t = businessList.get(i).get("INDEX").toString();
				map.put(t, rs.getString(Integer.valueOf(t).intValue()));
				map.put(t+"_", businessList.get(i).get("ID"));
			}
			map.put("ID", rs.getString(1));
			list.add(map);
		}
		return list;
	}
	
	
	
	private List<Map<String, Object>> getOld_u(
			List<Map<String, Object>> listBusiness,
			String listSql,
			Connection connection,
			MappedStatement mappedStatement,
			BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ResultSet rs = null;
		PreparedStatement countStmt = null;
		countStmt = connection.prepareStatement(listSql);
		BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), listSql, boundSql.getParameterMappings(),
				parameterObject);
		setParameters(countStmt, mappedStatement, countBS, parameterObject);
		rs = countStmt.executeQuery();
		List<Map<String, Object>> list = new ArrayList<>();
		while(rs.next()){
			Map<String, Object> map = new HashMap<>();
			for (int i = 0; i < listBusiness.size(); i++) {//找到每个字段
				String t = listBusiness.get(i).get("INDEX").toString();
				map.put(t, rs.getString(Integer.valueOf(t).intValue()));
				map.put(t+"_", listBusiness.get(i).get("ID"));
			}
			map.put("ID", rs.getString(1));
			list.add(map);
		}
		return list;
	}

	private List<Map<String, Object>> getBusiness(Connection connection, String Table) throws SQLException {
		PreparedStatement countStmt = null;
		String sel = "SELECT * FROM LOG_BUSINESS WHERE TABLENAME='" + Table.replaceAll(" ", "") + "'";
		countStmt = connection.prepareStatement(sel);
		countStmt.executeQuery();
		ResultSet rs2 = countStmt.executeQuery();
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;
		while (rs2.next()) {
			map = new HashMap<>();
			map.put("ID", rs2.getInt(1));
			map.put("TABLENAME", rs2.getString(2));
			map.put("FIELDNAME", rs2.getString(3));
			map.put("DATATYPE", rs2.getString(4));
			map.put("NAME", rs2.getString(5));
			map.put("VERSION", rs2.getString(6));
			map.put("DELETE", rs2.getString(7));
			map.put("TYPE", rs2.getString(8));
			map.put("INDEX", rs2.getString(9));
			list.add(map);
		}
		return list;
	}

	private static Connection getConnection() throws IOException {
		@SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				"/src/main/resources/spring/ApplicationContext.xml");
		SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		return sqlSession.getConnection();
	}

	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

	/**
	 * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.
	 * DefaultParameterHandler
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
			int s = parameterMappings.size() - ((boundSql.getSql() + "asd").split("\\?").length - 1);
			for (int i = s; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)
							&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value)
									.getValue(propertyName.substring(prop.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject.getValue(propertyName);
					}
					@SuppressWarnings("rawtypes")
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName
								+ " of statement " + mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1 - s, value, parameterMapping.getJdbcType());
				}
			}
		}
	}


	/**
	 * toUpperCase:(去掉多余空格). <br/>
	 *
	 * @author Administrator
	 * @param sql
	 * @return
	 * @since JDK 1.7
	 */

	private static String toUpperCase(String sql) {
		String[] s = sql.replaceAll("\t", " ").replaceAll("\n", " ").split(" ");
		sql = "";
		for (String string : s) {
			if (!string.equals("")) {
				sql += string + " ";
			}
		} // 去掉多余空格
		Pattern pt = Pattern.compile("^\\s*|\\s*$");
		Matcher mt = pt.matcher(sql);
		sql = mt.replaceAll("");// 去掉首尾空格
		// 替换关键字
		sql.replaceAll("update ", "UPDATE ").replaceAll(" insert", "INSERT ").replaceAll(" into  ", " INTO ")
				.replaceAll(" values ", " VALUES ").replaceAll(" set ", " SET ").replaceAll(" and ", " AND ")
				.replaceAll(" or ", " OR ").replaceAll(" end ", " END ").replaceAll(" between  ", " BETWEEN ")
				.replaceAll(" where ", " WHERE ");
		return sql;
	}

}

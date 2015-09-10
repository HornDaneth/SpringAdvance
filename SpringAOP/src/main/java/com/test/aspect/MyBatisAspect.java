package com.test.aspect;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.apache.ibatis.executor.Executor;
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
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
  
@Intercepts({  
       	@Signature(type = Executor.class, method = "update", args = {  
                MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = {  
                MappedStatement.class, Object.class, RowBounds.class,  
                ResultHandler.class })
		})  
public class MyBatisAspect implements Interceptor {  
  
 
    /* 
     * (non-Javadoc) 
     *  
     * @see 
     * org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin 
     * .Invocation) 
     */  
    public Object intercept(Invocation invocation) throws Throwable {  
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];  
        BoundSql boundSql = mappedStatement.getBoundSql(null);
        String sql = boundSql.getSql();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		Object parameterObject = invocation.getArgs()[1];
        List<ParameterMapping> list = new ArrayList<ParameterMapping>(parameterMappings);  
        while(sql.indexOf("?") != -1 && list.size() > 0 && parameterMappings.size() > 0)  
        {  
        	sql = sql.replaceFirst("\\?", "" + getValue(parameterMappings.get(0), mappedStatement, parameterObject));  
            list.remove(0);  
        }  
        sql = sql.replaceAll("(\r?\n(\\s*\r?\n)+)", "\r\n");  
        System.out.println(sql);
        return invocation.proceed();  
    }  
    
    
    
    private Object getValue(ParameterMapping parameterMapping,MappedStatement mappedStatement,Object parameterObject){
		BoundSql boundSql = mappedStatement.getBoundSql(null);
		Configuration configuration = mappedStatement.getConfiguration();
		TypeHandlerRegistry typeHandlerRegistry = mappedStatement.getConfiguration().getTypeHandlerRegistry();
		MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
		Object value = null;
		if (parameterMapping.getMode() != ParameterMode.OUT) {
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
				  value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
				}
			} else {
			  value = metaObject == null ? null : metaObject.getValue(propertyName);
			}
		}
		return value;
    }
    /* 
     * (non-Javadoc) 
     *  
     * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object) 
     */  
    public Object plugin(Object target) {  
        return Plugin.wrap(target, this);  
    }  
  
    /* 
     * (non-Javadoc) 
     *  
     * @see 
     * org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties) 
     */  
    public void setProperties(Properties properties) {  
  
    }  
    
  
  
}  
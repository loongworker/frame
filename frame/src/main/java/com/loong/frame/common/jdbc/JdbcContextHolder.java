package com.calm.b.common.jdbc;

/**
 * 连接哪个数据源的环境变量
 * @author luhj
 */
public class JdbcContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
	
    public static void setJdbcType(String jdbcType) {    
        contextHolder.set(jdbcType);  
    }    
    
    /**
     * 在选用business_write数据源前，执行此方法
     */
    public static void setBusinessWrite(){  
        setJdbcType("business_write");  
    }  
    /**
     * 在选用business_read数据源前，执行此方法
     */
    public static void setBusinessRead(){  
    	setJdbcType("business_read"); 
    }  
    public static String getJdbcType(){    
        return (String) contextHolder.get();   
    }   
    /**
     * 恢复成默认的数据源，即defaultTargetDataSource，执行此方法
     */
    public static void clearJdbcType() {    
        contextHolder.remove();    
    }    
}

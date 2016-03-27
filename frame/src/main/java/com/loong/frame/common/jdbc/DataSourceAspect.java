package com.calm.b.common.jdbc;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 设置数据源环境变量
 * @author luhj
 */
@Aspect //该注解标示该类为切面类 
@Component //注入依赖
@Order(1)
public class DataSourceAspect {
	/**
     * 设置数据源
     */
    @Before("@annotation(ds)")
    public void setDataSource(JoinPoint jp, DataSource ds)
            throws Exception {
        JdbcContextHolder.setJdbcType(ds.value());
    }
    
    /**
     * 标注的方法执行完成后，恢复数据源为默认数据源，以防止数据源使用错误
     */
    @AfterReturning("@annotation(ds)")
    public void removeDataSouce(JoinPoint jp, DataSource ds)
            throws Exception {
        JdbcContextHolder.clearJdbcType();
    }
}

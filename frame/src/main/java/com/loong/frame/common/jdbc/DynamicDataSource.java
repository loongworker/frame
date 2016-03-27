package com.calm.b.common.jdbc;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @author luhj
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return JdbcContextHolder.getJdbcType();
	}

}

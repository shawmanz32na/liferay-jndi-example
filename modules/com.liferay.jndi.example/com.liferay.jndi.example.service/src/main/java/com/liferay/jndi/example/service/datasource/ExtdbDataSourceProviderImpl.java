package com.liferay.jndi.example.service.datasource;

import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataSourceProvider;
import com.liferay.portal.kernel.util.PropsUtil;

import javax.sql.DataSource;

public class ExtdbDataSourceProviderImpl implements DataSourceProvider {

	@Override
	public DataSource getDataSource() {
		try {
			return DataSourceFactoryUtil.initDataSource(
				PropsUtil.getProperties("jdbc.extdb.", true));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
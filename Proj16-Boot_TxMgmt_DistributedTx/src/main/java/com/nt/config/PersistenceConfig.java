package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistenceConfig {

	@Bean(name = "oraAkDs")
	public AtomikosDataSourceBean createAkDsBeanForOracle() {
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		ds.setUniqueResourceName("oraXA");
		ds.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		Properties props = new Properties();
		props.setProperty("databaseName", "system");
		props.setProperty("user", "scott");
		props.setProperty("password", "tiger");
		props.setProperty("URL", "jdbc:oracle:thin:@localhost:1521:system");
		ds.setXaProperties(props);
		ds.setMaxPoolSize(1000);
		ds.setMinPoolSize(10);
		ds.setMaxIdleTime(2000);
		return ds;
	}

	@Bean(name = "mySqlAkDs")
	public AtomikosDataSourceBean createAkDsBeanForMysql() {
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		ds.setUniqueResourceName("mysqlXA");
		ds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		Properties props = new Properties();
		props.setProperty("databaseName", "ntsp613");
		props.setProperty("user", "root");
		props.setProperty("password", "root");
		props.setProperty("URL", "jdbc:mysql:///ntsp613");
		ds.setXaProperties(props);
		ds.setMaxPoolSize(1000);
		ds.setMinPoolSize(10);
		ds.setMaxIdleTime(2000);
		return ds;
	}
	
	@Bean(name = "oraJT")
	public JdbcTemplate createJTForOracle() {
		return new JdbcTemplate(createAkDsBeanForOracle());
	}

	@Bean(name = "mysqlJT")
	public JdbcTemplate createJTForMysql() {
		return new JdbcTemplate(createAkDsBeanForMysql());
	}
}

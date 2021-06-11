package com.lib.tech.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Amrut Bugde
 *
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	@Bean
	public LocalSessionFactoryBean getSessionFactory()  {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
//		hibernateProperties.put("hibernate.generate_statistics", "true");

		bean.setHibernateProperties(hibernateProperties);
		bean.setDataSource(getDataSource());
		bean.setPackagesToScan("com.lib.tech");
		return bean;
	}

	@Bean
	public BasicDataSource getDataSource()  {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:~/data/demo;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO");//jdbc:h2:mem:test
		dataSource.setUsername("sa");
//		dataSource.setPassword("sa");

		return dataSource;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() throws PropertyVetoException {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}

	 @Bean
	    public PlatformTransactionManager hibernateTransactionManager() {
	        HibernateTransactionManager transactionManager
	          = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(getSessionFactory().getObject());
	        return transactionManager;
	    }
}

/**
 * 
 */
package com.doj.springapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@EnableTransactionManagement
public class InfrastructureConfig {
 //have infrastructure related beans like DataSource, JNDI, etc. dbcp, c3p0
	@Bean
	public DataSource dataSource(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2);//in-memory
		builder.addScript("schema.sql");
		builder.addScript("data.sql");
		return builder.build();
		
		/*<jdbc:embedded-database id="dataSouurce" type="H2">
 		<jdbc:script location="schema.sql"/>
 		<jdbc:script location="data.sql"/>
 	    </jdbc:embedded-database>*/
	}
	
	@Bean //implementation
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
}

package com.misiontic.backend032;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


@SpringBootApplication
public class Backend032Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Backend032Application.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
	  System.out.println("Hello world from Command Line Runner");
	}
  
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	  //dataSource.setUrl("jdbc:mysql://localhost:3306/db_spring_rest?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false");
	  dataSource.setUrl("jdbc:mysql://localhost:3306/vuelafacil2?useSSL=false");
	  dataSource.setUsername("root");
	  dataSource.setPassword("");
  
	  // schema init
	  Resource initSchema = new ClassPathResource("schema.sql");
	  Resource initData = new ClassPathResource("data.sql");
	  DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
	  DatabasePopulatorUtils.execute(databasePopulator, dataSource);
  
	  return dataSource;
	}
  

}

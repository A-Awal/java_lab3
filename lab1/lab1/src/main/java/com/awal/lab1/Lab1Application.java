package com.awal.lab1;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// import com.awal.AppConfig;

@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);

		// BeanFactory bf =
		
		// ApplicationContext context = new ClassPathXmlApplicationContext();
		// ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		// context.getBean("hello");
	}

}

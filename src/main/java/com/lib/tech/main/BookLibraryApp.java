package com.lib.tech.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lib.tech.service.StarterService;

/**
 * @author Amrut Bugde
 *
 */
@ComponentScan("com.lib.tech")
@Configuration
public class BookLibraryApp {
	

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookLibraryApp.class);
		StarterService service = ctx.getBean(StarterService.class);
		
		service.start();
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}

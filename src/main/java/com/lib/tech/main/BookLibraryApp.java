package com.lib.tech.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lib.tech.service.LibService;

@ComponentScan("com.lib.tech")
@Configuration
public class BookLibraryApp {
	

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookLibraryApp.class);
		LibService libService = ctx.getBean(LibService.class);
		libService.showStock();
		libService.addStock();
		libService.showStock();
		libService.removeStock();
		libService.showStock();
	}

}

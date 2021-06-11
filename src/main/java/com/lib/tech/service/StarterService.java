package com.lib.tech.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarterService {

	@Autowired
	private LibService libService;

	public void start() {
		System.out.println("Welcome to Book Library");
		do {
			String input = input();
			switch (input) {
			case "1":
				libService.saveBook();
				break;
			case "2":
				libService.removeBook();
				break;
			case "3":
				libService.getAllBooks();
				break;
			case "4":
				libService.saveStock();
				break;
			case "5":
				libService.removeStock();
				break;
			case "6":
				libService.getAllStock();
				break;

			default:
				break;
			}
			if (Integer.parseInt(input) == 0) {
				System.out.println("#+#+#+#+#+#+#+#+#+#+#+#+#+#+#+#+#");
				break;
			}

		} while (true);

	}

	private String input() {
		System.out.println("What do you want to do?");
		System.out.println("1. Add book");
		System.out.println("2. delete book");
		System.out.println("3. show book list");
		System.out.println("4. Add stock");
		System.out.println("5. delete stock");
		System.out.println("6. show stock list");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		in.close();
		return input;
	}
}

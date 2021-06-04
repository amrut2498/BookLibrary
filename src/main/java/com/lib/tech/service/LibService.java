package com.lib.tech.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.tech.model.Book;
import com.lib.tech.model.Stock;

@Service
public class LibService {

	@Autowired
	private Book book;
	
	@Autowired
	private Stock stock;
	
	private List<Stock> stockList = new ArrayList<>();
	
	public void addStock() {
		System.out.println("** Adding the stock **");
		book.setBookId(1);
		book.setBookName("The secret");
		book.setPrice(999.99);
		book.setAuthor("Mark woods");
		book.setPublisher("McGrawHill");
		
		stock.setBookId(book.getBookId());
		stock.setQuantity(5);
		stock.setStockId(12L);
		stock.setModifiedDate(new Date());
		stock.setDescription("test");
		
		stockList.add(stock);
	}
	
	public void removeStock() {
		if(stockList.size()>0) {
			System.out.println("** removing the stock **");
			stockList.remove(0);
		}
	}
	
	public void showStock() {
		if(stockList.size() < 1) {
			System.out.println("==================================");
			System.out.println("Stock is empty");
			System.out.println("==================================");
		}
		else {
			System.out.println("****** Stock List *****");
			stockList.forEach(stock -> {
				System.out.println("** Stock "+stock.getStockId()+" **");
				System.out.println("Stock Id : "+stock.getStockId());
				System.out.println("Book Id : "+stock.getBookId());
				System.out.println("Quantity : "+stock.getQuantity());
				System.out.println("Modify date : "+stock.getModifiedDate());
			});
			System.out.println("****** End of stock *****");
		}
	}
}

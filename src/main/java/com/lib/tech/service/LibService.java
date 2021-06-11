package com.lib.tech.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.tech.model.Book;
import com.lib.tech.model.Stock;
import com.lib.tech.repository.BookRepository;
import com.lib.tech.repository.StockRepository;

/**
 * @author Amrut Bugde
 *
 */
@Service
public class LibService {

	@Autowired
	private BookRepository repository;
	@Autowired
	private StockRepository stockRepository;


// ============== Book Operations =================
	
	public void getAllBooks() {
		System.out.println("****** Fetching book List *****");
		List<Book> list = repository.getAllBooks();
		displayBook(list);
	}

	public void saveBook() {
		Book book = new Book();
		book.setBookName("The secret");
		book.setPrice(999.99);
		book.setAuthor("Mark woods");
		book.setPublisher("McGrawHill");

		repository.save(book);
		System.out.println("Book saved successfully");
	}

	public void removeBook() {
		List<Book> list = repository.getAllBooks();
		if (list.size() > 0) {
			repository.deleteBook(list.get(0));
		}
	}
	
	public void displayBook(List<Book> list) {
		System.out.println("=========================Book List=====================");
		System.out.println("Book ID | Book Name | Author | Price | Publisher");
		for (Iterator<Book> iterator = list.iterator(); iterator.hasNext();) {
			Book stock = (Book) iterator.next();
			System.out.format("%-8s",stock.getBookId()+"");
			System.out.format("|");
			System.out.format("%-11s",stock.getBookName()+"");
			System.out.format("|");
			System.out.format("%-6s",stock.getAuthor()+"");
			System.out.format("|");
			System.out.format("%-7s",stock.getPrice()+"");
			System.out.format("|");
			System.out.format("%-8s",stock.getPublisher()+"");
			System.out.println("");
		}
		System.out.println("========================================================");
	}
	
// ================== Stock Operations ==============

	public void saveStock() {
		Stock stock = new Stock();
		stock.setBookId(repository.getAllBooks().get(0).getBookId());
		stock.setQuantity(5);
		stock.setStockId(12L);
		stock.setModifiedDate(new Date());
		stock.setDescription("test");

		stockRepository.save(stock);
	}

	public void getAllStock() {
		System.out.println("****** Fetching stock List *****");
		List<Stock> list = stockRepository.getAllStock();
		displayStock(list);
			}
	
	public void removeStock() {
		List<Stock> list = stockRepository.getAllStock();
		if (list.size() > 0) {
			stockRepository.deleteStock(list.get(0));
		}
	}
	
	public void displayStock(List<Stock> list) {
		System.out.println("=========================Stock List=====================");
		System.out.println("Stock ID | Book ID | Quantity | Date");
		for (Iterator<Stock> iterator = list.iterator(); iterator.hasNext();) {
			Stock stock = (Stock) iterator.next();
			System.out.format("%-9s",stock.getStockId()+"");
			System.out.format("|");
			System.out.format("%-9s",stock.getBookId()+"");
			System.out.format("|");
			System.out.format("%-10s",stock.getQuantity()+"");
			System.out.format("|");
			System.out.format("%-8s",stock.getModifiedDate()+"");
			System.out.println("");
		}
		System.out.println("========================================================");
	}
}

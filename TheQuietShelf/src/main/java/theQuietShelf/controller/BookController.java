package theQuietShelf.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import theQuietShelf.entity.Book;
import theQuietShelf.entity.MyBookList;
import theQuietShelf.services.BookService;
import theQuietShelf.services.MyBookListService;

import java.util.*;

/* Never it is Possible that one HTML will directly send the control to another HTML
 it means , always HTML should send the control to CONTROLLER
 
Controller - whenever i have to send the response from controller to view that i will tell CONTROLLER 

*/
@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	// Get Mapping - indicating that whenever user will send the request then that request should come to these specific methods
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("bookList","book",list);
	}
	
	@GetMapping("/history")
	public String history() {
		return "history";
	}
	
// Model Attribute- whenever i don't want to take the individual values, rather i want to take a group then i have to use this
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model) // MODEL- reference of the model interface
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list); // for adding the data inside the model
		return "myBooks";
		
// Request Mapping - by using this annotation, i can specify that in which class output will came
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
// Path Variable - here i am sending one single type of data, one single value 
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
}

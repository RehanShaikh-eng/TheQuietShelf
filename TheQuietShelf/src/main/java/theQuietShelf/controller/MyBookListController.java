package theQuietShelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import theQuietShelf.services.MyBookListService;

//Controller - whenever i have to send the response from controller to view that i will tell CONTROLLER 

@Controller
public class MyBookListController {
	
	@Autowired
	private MyBookListService service;
	
	// Request Mapping - by using this annotation, i can specify that in which class output will came
	// Path Variable - here i am sending one single type of data, one single value 
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_books";
	}
}

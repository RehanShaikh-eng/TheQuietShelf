package theQuietShelf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import theQuietShelf.entity.MyBookList;
import theQuietShelf.repository.MyBookRepository;


// if in case we will not give this service annotation , spring boot will not be able to understand which is service class
@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository mybook;
	
	
//we have never given the body of save method , it is a in-built method present inside the JPA repository	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}

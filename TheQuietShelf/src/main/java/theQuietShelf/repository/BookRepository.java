package theQuietShelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theQuietShelf.entity.Book;


/* JPA - repository will take two things <name of the Entity class, what type of id >
 
it means that Spring Boot framework internally includes HIBERNATE, so whatever HIBERNATE have to do , Spring Boot already knows that
and all the functionalities and everything has been provided internally in JPA Repository 

NOTE:- so basically as a developer i just have to use this particular Repository so that i will include all the functionalities
of a HIBERNATE inside interface
*/


@Repository
public interface BookRepository extends JpaRepository<Book,Integer>  {

	// extends - i m using extends because one interface is connecting to another interface
	

}

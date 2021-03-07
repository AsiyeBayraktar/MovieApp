package net.java;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.java.movie.Movie;
import net.java.movie.MovieRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MovieTests {
	
	@Autowired
	private MovieRepository repo;
	
	@Test
	public void testCreateMovie(){
		Movie movie = new Movie("Hobbit",2012,"Fantastik/Macera","Hobbit: Beklenmedik Yolculuk.","WingNut Films","English");
		Movie savedMovie =repo.save(movie);
		
		assertNotNull(savedMovie);
	}
	

	@Test
	public void testFindMovie(){
		String name = "Dağ";
		List<Movie> searchMovie = repo.findByText(name);
		assertNotNull(searchMovie);
		
	}
	

	@Test
	public void testUpdateMovie(){
		
		String name = "Dağ 2";
		Movie movie = new Movie("Hobbit",2012,"Fantastik/Macera","Hobbit: Beklenmedik Yolculuk.","WingNut Films","English");
		repo.save(movie);
		movie.setName(name);
		Optional<Movie> updateMovie = repo.findById(movie.getId());
		
		assertEquals(name, updateMovie.get().getName());

	}
	
	@Test
	public void testDeleteProduct(){
	
		Movie movie = new Movie("Hobbit",2012,"Fantastik/Macera","Hobbit: Beklenmedik Yolculuk.","WingNut Films","English");
		repo.save(movie);
		repo.delete(movie);

	}

}


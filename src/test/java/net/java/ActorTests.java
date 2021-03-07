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

import net.java.actor.Actor;
import net.java.actor.ActorRepository;
import net.java.movie.Movie;
import net.java.movie.MovieRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ActorTests {
	
	@Autowired
	private ActorRepository repo;
	
	@Test
	public void testCreateActor(){
		Actor actor = new Actor("Leonardo DiCaprio","Cobb");
		Actor savedActor =repo.save(actor);
		
		assertNotNull(savedActor);
	}
	

	@Test
	public void testFindActor(){
		
		Actor actor = new Actor("Leonardo DiCaprio","Jack");
		repo.save(actor);
		Actor searchActor = repo.findByName(actor.getName());
		assertNotNull(searchActor);
		
	}
	

	@Test
	public void testUpdateActor(){
		
		String name = "Johnny Depp";
		Actor actor = new Actor("Leonardo DiCaprio","Jack");
		repo.save(actor);
		actor.setName(name);
		Actor updateActor = repo.findByName(actor.getName());
		
		assertEquals(name, updateActor.getName());

	}
	
	@Test
	public void testDeleteActor(){
	
		Actor actor = new Actor("Leonardo DiCaprio","Jack");
		repo.save(actor);
		repo.delete(actor);

	}

	

}

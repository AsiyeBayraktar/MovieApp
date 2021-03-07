package net.java.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.java.actor.Actor;
import net.java.actor.ActorRepository;




@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository repo;
	
	@Autowired
	private ActorRepository actorRepo;
	
	@GetMapping("/")
	public String listMovies(Model model){
		List<Movie> listMovies = repo.findAll();
		List<Actor> listActors =  actorRepo.findAll();
		model.addAttribute("listActors", listActors);
		model.addAttribute("listMovies",listMovies);
		
		
		return "index";
		
	}
	
	@GetMapping("/movies")
	public String listMovie(Model model){
		List<Movie> listMovies = repo.findAll();
		model.addAttribute("listMovies", listMovies);
		return "movies";
	}
	

	
	@GetMapping("/movies/new")
	public String showNewMovieForm(Model model){
		List<Actor> listActors =  actorRepo.findAll();
		model.addAttribute("movie", new Movie());
		
		model.addAttribute("listActors", listActors);
		
		return "movie_form";
	}

	
	
	@PostMapping("/movies/save")
	public String saveMovie(Movie movie){
		repo.save(movie);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/movies/edit/{id}")
	public String showEditMovieForm(@PathVariable("id") Integer id,Model	model){
		
		List<Actor> listActors =  actorRepo.findAll();
		Movie movie = repo.findById(id).get();
			
		model.addAttribute("listActors", listActors);
		model.addAttribute("movie", movie);
		
		
		return "movie_form";
	}
	
	@GetMapping("/movies/delete/{id}")
	public String deleteMovie(@PathVariable("id") Integer id,Model	model){
		repo.deleteById(id);
		
		return "redirect:/movies";
		
		
	}
	
	@GetMapping("/movies/select/{name}")
	public String showSearchMovieForm(@PathVariable("name") String name,Model	model){
		
		List<Actor> listActors =  actorRepo.findAll();
		return "movie_form";
	}
	
	
	@GetMapping("/movies/search")
	public String searchMovie(@Param("search") String search, Model model) {
		List<Movie> searchMovie = repo.findByText(search);
		model.addAttribute("searchMovie",searchMovie);
			     
	    return "search";
	}
	
	@GetMapping("/movies/sort")
	public String sortByYear(Model model) {
	    List<Movie> listMovies = repo.sortByYear();
	  
	    model.addAttribute("listMovies",listMovies);
	 
	    return "movies";    
	}

}

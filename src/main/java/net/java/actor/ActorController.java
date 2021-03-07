package net.java.actor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.java.movie.Movie;





@Controller
public class ActorController {
	
	@Autowired
	private ActorRepository repo;
	
	@GetMapping("/actors")
	public String listActors(Model model){
		List<Actor> listActors = repo.findAll();
		model.addAttribute("listActors",listActors);
		
		return "actors";
	}
	
	@GetMapping("/actors/new")
	public String showActorNewForm(Model model){
		model.addAttribute("actor", new Actor());
		
		return "actor_form";
	}
	
	@PostMapping("/actors/save")
	public String saveActor(Actor actor){
		repo.save(actor);
		
		return "redirect:/actors";
	}
	
	@GetMapping("/actors/edit/{id}")
	public String showEditActorForm(@PathVariable("id") Integer id,Model	model){
							
		Actor actor = repo.findById(id).get();
		model.addAttribute("actor", new Actor());
		repo.deleteById(id);
		model.addAttribute("actor", actor);
		return "actor_form";
	}
	
	@GetMapping("/actors/delete/{id}")
	public String deleteCategory(@PathVariable("id") Integer id,Model	model){
		repo.deleteById(id);
		
		return "redirect:/actors";
		
		
	}
	
	
	
	

}

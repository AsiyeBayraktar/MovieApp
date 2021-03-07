package net.java.movie;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;


import net.java.actor.Actor;



@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=45 , nullable=false, unique = true)
	private String name;
	
	@Column
	private Integer year;
	@Column
	private String type;
	@Column
	private String explanation;
	@Column
	private String media;
	@Column
	private String language;
	
	@OneToMany
	@JoinColumn(name = "movie_id")
	private List<Actor> actors = new ArrayList<>();
	
	
	

	
	
	public Movie(String name, Integer year, String type, String explanation, String media, String language) {
		
		this.name = name;
		this.year = year;
		this.type = type;
		this.explanation = explanation;
		this.media = media;
		this.language = language;
	}

	public Movie() {
	
	}

	public Movie(String name, Integer year, String type, String explanation, String media, String language,
			List<Actor> actors) {
		
		this.name = name;
		this.year = year;
		this.type = type;
		this.explanation = explanation;
		this.media = media;
		this.language = language;
		this.actors = actors;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	
	


	
	
	

}

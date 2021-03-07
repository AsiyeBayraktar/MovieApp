package net.java.movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	
	//@Query(value=" select distinct* from moviedb.movie left join moviedb.actor on movie.id = actor.movie_id where moviedb.movie.name LIKE %?1% or moviedb.movie.type LIKE  %?1% or moviedb.actor.name LIKE %?1%", nativeQuery=true)

	@Query(value=" select distinct* from moviedb.movie left join moviedb.actor on movie.id = actor.movie_id where match(movie.name,movie.type) against(?1) or  match(moviedb.actor.name) against(?1) group by moviedb.movie.name",nativeQuery=true)
	public List<Movie> findByText(String search);
	
	
	@Query(value=" select * from moviedb.movie order by moviedb.movie.year desc", nativeQuery=true)
	public List<Movie> sortByYear();
	
	@Query(value=" select * from moviedb.movie where moviedb.movie.name = ?1 ", nativeQuery=true)
	public Movie findByName(String name);

	
	
//	@Query(value=" select distinct * from moviedb.movie left join moviedb.actor on movie.id = actor.movie_id where moviedb.movie.name LIKE %?1% or moviedb.movie.type LIKE  %?1% or moviedb.actor.name LIKE %?1%", nativeQuery=true)
}

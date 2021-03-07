package net.java.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.java.actor.Actor;


public interface ActorRepository extends JpaRepository<Actor, Integer> {
	@Query(value=" select * from moviedb.actor where moviedb.actor.name = ?1 ", nativeQuery=true)
	public Actor findByName(String name);

}

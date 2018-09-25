package com.vanessamartin.web.lookify.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanessamartin.web.lookify.models.Song;

@Repository
public interface LookifyRepo extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findByTitleContaining(String search);
	Optional<List<Song>> findByArtistContaining(String search);
	List<Song> findTop10ByOrderByRatingDesc();
}

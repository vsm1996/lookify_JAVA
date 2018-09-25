package com.vanessamartin.web.lookify.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vanessamartin.web.lookify.models.Song;
import com.vanessamartin.web.lookify.repository.LookifyRepo;

@Service
public class LookifyService {
	private final LookifyRepo l_repo;
	
	public LookifyService(LookifyRepo lookifyrepo) {
		this.l_repo= lookifyrepo;
	}
	
	public List<Song> allSongs(){
		return l_repo.findAll();
	}
	
	public Song create(Song song) {
		return l_repo.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = l_repo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
		
	}
	
	public Song updateSong(Song song) {
		Optional<Song> optionalSong = l_repo.findById(song.getId());
		if(optionalSong.isPresent()) {
			Song updatedSong = optionalSong.get();
			updatedSong.setArtist(song.getArtist());
			updatedSong.setTitle(song.getTitle());
			updatedSong.setRating(song.getRating());
			return l_repo.save(updatedSong);
			
		} else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		l_repo.deleteById(id);
	}
	
	public List<Song> findByArtist(String artist){
		Optional<List<Song>> optionalSongs = (Optional<List<Song>>) l_repo.findByArtistContaining(artist);
		if(optionalSongs.isPresent()) {
			return optionalSongs.get();
		}else {
			return null;
		}
	}
	
	public List<Song> findTopTen(){
		return l_repo.findTop10ByOrderByRatingDesc();
	}
}

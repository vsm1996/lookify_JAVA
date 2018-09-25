package com.vanessamartin.web.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vanessamartin.web.lookify.models.Song;
import com.vanessamartin.web.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService l_service;
	public LookifyController(LookifyService l_service) {
		this.l_service=l_service;
	}
	@RequestMapping("/")
	public String index() {
		return "/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("searchInput") String search, Model model) {
		List<Song> songs = l_service.allSongs();
		model.addAttribute("songs", songs);
		return "/dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String loadAdd(@ModelAttribute("Song") Song song, Model model) {
		return "/add.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("Song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/add.jsp";
		} else {
			l_service.create(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = l_service.findSong(id);
		model.addAttribute("song", song);
		return "/show.jsp";
	}
	
	@RequestMapping("/songs/{id}/delete")
	public String deleteSong(@PathVariable("id") Long id) {
		l_service.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/search")
	public String searchSongsByArtist(Model model, @Valid @ModelAttribute("searchInput") String search, BindingResult result) {
		if(result.hasErrors()) {
			return "/dashbaord.jsp";
		} else {
			List<Song> songs = l_service.findByArtist(search);
			model.addAttribute("artistSongs", songs);
			return "/artist.jsp";
		}
	}
	
	@RequestMapping("/search/{artist}")
	public String showSongsByArtist(@ModelAttribute("searchInput") String search) {
		
		return null;
	}
	
	@RequestMapping("/search/TopTen")
	public String topTen(Model model) {
		List<Song> songs = l_service.findTopTen();
		model.addAttribute("songs", songs);
		return "/topten.jsp";
	}

}

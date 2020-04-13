package com.zemoso.songApp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.zemoso.songApp.entity.Song;
import com.zemoso.songApp.service.SongService;

@Controller
@RequestMapping("/songs")
public class SongsController {

	
	
	@Autowired
    SongService songService;

	
	
	public SongsController(SongService songService) {
		super();
		this.songService = songService;
	}


	@GetMapping("/list")
	public String getAllSongs(Model theModel) {

		List<Song> songsList = songService.findAll();

		theModel.addAttribute("allSongs", songsList);

		return "list-songs";
	}

	
	@GetMapping("/showPlayPage")
	public String getPlayPage(@RequestParam("songId") int theId, Model theModel) {

		Song theSong = songService.findById(theId);
		
		theModel.addAttribute("theSong", theSong);
		return "song-play";
	}
	
	

	@GetMapping("/showFormForAddNewSong")
	public String showFormForAddNewSong(Model theModel) {

		Song newSong = new Song();

		theModel.addAttribute("theSong", newSong);

		return "add-song";
	}

	@PostMapping("/save")
	public String saveSong(@ModelAttribute("theSong") Song theSong) {

		songService.save(theSong);

		return "redirect:/songs/list";
	}
	
	
	@GetMapping("/deleteSong")
	public String delete(@RequestParam("songId") int theId) {
		
		songService.deleteById(theId);
		
		return "redirect:/songs/list";
	}
	
	
	
	//Favourite Songs
		  
		  @GetMapping("/addToPlaylist")
		  public String addToPlayList(@RequestParam("songId") int theId ) {
		  
		 try {
			 Song theSong= songService.findById(theId);
		  
			 if(theSong.getFavourite().equals("YES"))
				return "song-already";
			 else {	 
			
				 theSong.setFavourite("YES");
				 songService.save(theSong);
			 }
			 return "redirect:/songs/list";  
		  
		 }
		 
		 catch(Exception e) {
			 
			 return "error";
		 }
		 
		 
		  
		  }
		  
		 

	@GetMapping("/displayPlaylist")
	public String displayPlaylist(Model theModel) {

		List<Song> playListSongs = songService.findByFavourite("YES");

		theModel.addAttribute("playListSongs", playListSongs);

		return "playlist";
	}
	
	
	@GetMapping("/removeSongFromPlaylist")
	public String removeSongFromPlaylist(@RequestParam("songId") int theId ) {
		  
		  Song theSong = songService.findById(theId);
		 
		 theSong.setFavourite("NO");
	
		 songService.save(theSong);
	
		return "redirect:/songs/displayPlaylist";
	}

}

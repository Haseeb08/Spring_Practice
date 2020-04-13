package com.zemoso.songApp.controller;

import java.util.ArrayList;
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
import com.zemoso.songApp.entity.SongDTO;
import com.zemoso.songApp.service.SongService;

@Controller
@RequestMapping("/songs")
public class SongsController {

	@Autowired
	SongService songService;

	// Converter class is used for conversion of Entity to DTO
	@Autowired
	ConverterClass converter;

	// Getting all available songs from DB.
	// Converting  Songs into DTO type and SongDTOs are sent to view.
	@GetMapping("/list")
	public String getAllSongs(Model theModel) {

		List<Song> songsList = songService.findAll();

		List<SongDTO> songsDTOList = new ArrayList<>();

		for (Song theSong : songsList) {
			songsDTOList.add(converter.convertToDTO(theSong));
		}

		theModel.addAttribute("allSongs", songsDTOList);

		return "list-songs";
	}

	// Get the Song play page
	@GetMapping("/showPlayPage")
	public String getPlayPage(@RequestParam("songId") int theId, Model theModel) {

		Song theSong = songService.findById(theId);

		theModel.addAttribute("theSong", theSong);
		return "song-play";
	}

	// Get the page for downloading a new song.
	@GetMapping("/showFormForAddNewSong")
	public String showFormForAddNewSong(Model theModel) {

		//Song newSong = new Song();

		SongDTO newSongDTO = new SongDTO();
		theModel.addAttribute("theSong", newSongDTO);

		return "add-song";
	}

	// Saving the newly downloaded song into DB.
	@PostMapping("/save")
	public String saveSong(@ModelAttribute("theSong") SongDTO theSongDTO) {

		theSongDTO.setFavourite("NO");
			
		if (theSongDTO.getSingerName().isEmpty())
			theSongDTO.setSingerName("Unknown");
		
		Song theSong = converter.convertToEntity(theSongDTO);
		
		Song thesong = songService.save(theSong);

		return "redirect:/songs/list";
	}

//	@GetMapping("/search")
//	public String searchSongByName(@RequestParam("songName") String songName, Model theModel) {
//		
//		Song theSearchedSong = songService.findBySongName(songName)	;
//				
//		if(theSearchedSong.equals(null)	)	
//				return "showFormForAddNewSong";
//		else {
//			List<SongDTO> songsDTOList = new ArrayList<>();
//			songsDTOList.add(converter.convertToDTO(theSearchedSong));
//			theModel.addAttribute("allSongs", songsDTOList);
//
//			return "list-songs";
//		}
//	}

	
	// Deleting the song from Db.
	@GetMapping("/deleteSong")
	public String delete(@RequestParam("songId") int theId) {

		songService.deleteById(theId);

		return "redirect:/songs/list";
	}
	
	
	
	// Adding that particular song to favourites.
	// Checking whether its already present in favorites or not.
	@GetMapping("/addToPlaylist")
	public String addToPlayList(@RequestParam("songId") int theId) {

		try {
			Song theSong = songService.findById(theId);
			
			
			if (theSong.getFavourite().equals("YES"))
				return "song-already";
			else {

				theSong.setFavourite("YES");
				songService.save(theSong);
			}
			return "redirect:/songs/list";

		}

		catch (Exception e) {

			return "error";
		}

	}

	// Displaying the favorites list of song.
	@GetMapping("/displayPlaylist")
	public String displayPlaylist(Model theModel) {

		List<Song> playListSongs = songService.findByFavourite("YES");

		theModel.addAttribute("playListSongs", playListSongs);

		return "playlist";
	}

	// Removing the song from favorite songs.
	@GetMapping("/removeSongFromPlaylist")
	public String removeSongFromPlaylist(@RequestParam("songId") int theId) {

		Song theSong = songService.findById(theId);

		theSong.setFavourite("NO");

		songService.save(theSong);

		return "redirect:/songs/displayPlaylist";
	}

}

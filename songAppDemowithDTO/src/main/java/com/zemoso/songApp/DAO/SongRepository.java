package com.zemoso.songApp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zemoso.songApp.entity.Song;
import com.zemoso.songApp.entity.SongDTO;

public interface SongRepository extends JpaRepository< Song ,Integer> {

	
	//custom method to get all the fav songs
	List<Song> findByFavourite(String favourite);

	//Song findBySongName(String name);
}

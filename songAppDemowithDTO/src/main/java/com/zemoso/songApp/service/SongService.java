package com.zemoso.songApp.service;

import java.util.List;

import com.zemoso.songApp.entity.Song;



public interface SongService {

	public List<Song> findAll();
	
	public Song findById(int theId);
	
	public Song save(Song theSong);
	
	public void deleteById(int theId);

	public List<Song> findByFavourite(String string);
	
//	public Song findBySongName(String name);
}

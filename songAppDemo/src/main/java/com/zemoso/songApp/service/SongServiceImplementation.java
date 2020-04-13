package com.zemoso.songApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.songApp.DAO.SongRepository;
import com.zemoso.songApp.entity.Song;

@Service
public class SongServiceImplementation implements SongService {

	@Autowired
	private final SongRepository songRep;
	
	

	public SongServiceImplementation(SongRepository songRep) {
		this.songRep = songRep;
	}

	@Override
	public List<Song> findAll() {
		return songRep.findAll();
	}
	
	@Override
	public Song findById(int theId) {
		
		Optional<Song> result = songRep.findById(theId);

		if (result.isPresent())
			return result.get();
		else
			throw new RuntimeException("Song ID not found :" + theId);
	}

	@Override
	public void save(Song theSong) {
		
		songRep.save(theSong);
	}

	@Override
	public void deleteById(int theId) {
		
		songRep.deleteById(theId);
	}

	@Override
	public List<Song> findByFavourite(String string) {
		return songRep.findByFavourite(string);
	}

	

}

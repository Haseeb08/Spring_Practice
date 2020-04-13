package com.zemoso.songApp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zemoso.songApp.entity.Song;
import com.zemoso.songApp.entity.SongDTO;

@Component
public class ConverterClass {

	@Autowired
	private ModelMapper mapper;
	
	public SongDTO convertToDTO(Song theSong)
	{
		SongDTO theSongDTO= mapper.map(theSong, SongDTO.class);
	
		return theSongDTO;
	}
	
	public Song convertToEntity(SongDTO theSongDTO)
	{
		Song theSong = mapper.map(theSongDTO, Song.class);	
		return theSong;
	}
}

package com.zemoso.songApp.entity;

import org.springframework.stereotype.Component;

@Component
public class SongDTO {

	private int id;
	
	private String songName;

	private String singerName;
	
	private String favourite;

	public SongDTO() {
	
	}

	public SongDTO(int id, String songName, String singerName, String favourite) {
		
		this.id = id;
		this.songName = songName;
		this.singerName = singerName;
		this.favourite = favourite;
	}

	public SongDTO(String songName, String singerName) {
		
		this.songName = songName;
		this.singerName = singerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getFavourite() {
		return favourite;
	}

	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}
	
	
}

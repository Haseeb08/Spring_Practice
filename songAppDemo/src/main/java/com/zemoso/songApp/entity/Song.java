package com.zemoso.songApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="song_name")
	private String songName;

	@Column(name="singer_name")
	private String singerName;
	
	@Column(name="favourite")
	private String favourite;

// Constructors	
	
	

	public Song() {
		
	}


	public String getFavourite() {
		return favourite;
	}


	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}


	public Song(String songName, String singerName) {
		
		this.songName = songName;
		this.singerName = singerName;
	}


	public Song(int id, String songName, String singerName) {
	
		this.id = id;
		this.songName = songName;
		this.singerName = singerName;
	}

	
	public Song(String songName, String singerName, String favourite) {
		super();
		this.songName = songName;
		this.singerName = singerName;
		this.favourite = favourite;
	}


	// Getter and setter


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


	// Tostring method
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", singerName=" + singerName + "]";
	}
			
	
}

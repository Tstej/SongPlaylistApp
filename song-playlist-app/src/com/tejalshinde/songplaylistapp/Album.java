package com.tejalshinde.songplaylistapp;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	
	private String albamName;
	private String artistName;
	private ArrayList<Song> songs;
	
	
	public Album() {
		super();
	}

	public Album(String albamName, String artistName) {
		super();
		this.albamName = albamName;
		this.artistName = artistName;
		this.songs = new ArrayList<Song>();
	}
	
	
//	Method to find a existing song
	private Song findSong(String title) {
		for(Song checkedSong : songs) {
			if(checkedSong.getTitle().equals(title)) return checkedSong;
		}
		return null;
	}
	
//	Method to add a new song 
	public boolean addSong(String title, double duration) {
		if(findSong(title) == null) {
			songs.add(new Song(title, duration));

			return true;
		}else {
			return false;
		}	
	}

	
//	ACHIEVING METHOD OVERLOADING
	
//	Method to add song into playlist with track number
	public boolean addToPlaylist(int trackNumber, LinkedList<Song> PlayList) {
		int index = trackNumber - 1;
		if(index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}
		return false;
		
	}
	
	
//	Method to add song into playlist with title
	public boolean addToPlaylist(String title, LinkedList<Song> PlayList) {
		for(Song checkedSong : this.songs) {
			if(checkedSong.getTitle().equals(title)){
				PlayList.add(checkedSong);
				return true;
			}
		}
		System.out.println(title+" there is no such song in album.");
		return false;
		
	}
	

}

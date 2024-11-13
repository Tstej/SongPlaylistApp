package com.tejalshinde.songplaylistapp;

public class Song {
	
	String title;
	double duration;
	
//	constructors
	public Song() {
		super();
	}

	public Song(String title, double duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	
	
//  getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	
//	toString() method
	@Override
	public String toString() {
		return "Song [title=" + title + ", duration=" + duration + "]";
	}
	
	
	

}

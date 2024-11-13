package com.tejalshinde.songplaylistapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Iterator;

public class Main {
	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {

		Album album;

		album = new Album("Album1", "AC/DC");
		album.addSong("TNT", 4.5);
		album.addSong("Highway To Hell", 3.5);
		album.addSong("Thunder Struck", 5.0);
		albums.add(album);

		album = new Album("Album2", "Eminem");
		album.addSong("Rap God", 4.5);
		album.addSong("Not Afraid", 3.5);
		album.addSong("Lose Yourself", 5.0);
		albums.add(album);

		LinkedList<Song> playlist1 = new LinkedList<>();

		albums.get(0).addToPlaylist("TNT", playlist1);
		albums.get(0).addToPlaylist("Highway To Hell", playlist1);
		albums.get(1).addToPlaylist("Rap God", playlist1);
		albums.get(1).addToPlaylist("Lose Yourself", playlist1);

		play(playlist1);
	}

	private static void play(LinkedList<Song> playlist) {
		Scanner sc = new Scanner(System.in);

		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playlist.listIterator();

		if (playlist.size() == 0) {
			System.out.println("This playlist have no song.");
		} else {
			System.out.println("Now playing " + listIterator.next().toString());
			printOptions();
		}

		while (!quit) {
			int action = sc.nextInt();
			sc.nextLine();

			switch (action) {
			case 0:
				System.out.println("Playlist cpmplete.");
				quit = true;
				break;

			case 1: // Play next song
				if (!forward) { // If we were moving backwards, move forward one step
					if (listIterator.hasNext())
						listIterator.next();
					forward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now playing " + listIterator.next().toString());
				} else {
					System.out.println("No song available, reached the end of the playlist.");
					forward = false; // Prevents further 'next' attempts when at the end
				}
				break;

			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if (listIterator.hasPrevious()) {
					System.out.println("Now playing " + listIterator.previous().toString());
				} else {
					System.out.println("We are at the first song");
					forward = true;
				}
				break;

			case 3:
				if (forward) {
					if (listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
						forward = false;
					} else {
						System.out.println("We are at the start of the list");
					}

				} else {
					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
						forward = true;
					} else {
						System.out.println("We have reached to the end of the list");
					}
				}
				break;

			case 4:
				printList(playlist);
				break;

			case 5:
				printOptions();
				break;

			case 6:
				if (playlist.size() > 0) {
					listIterator.remove();

					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
						forward = true;
					} else {
						if (listIterator.hasPrevious()) {
							System.out.println("Now playing " + listIterator.previous().toString());
							 forward = false;
						}

					}
				}

			}
		}
	}

	private static void printOptions() {
		System.out.println("Available options \n press");

		System.out.println("0 - To Quit \n" + "1 - To play next song \n" + "2 - To play previous song \n"
				+ "3 - To replay the current song \n" + "4 - List of all songs \n"
				+ "5 - Print all available options \n" + "6 - Delete current song");
	}

	private static void printList(LinkedList<Song> playlist) {
		Iterator<Song> iterator = playlist.iterator();
		System.out.println("------------------------------");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-------------------------------");
	}

}

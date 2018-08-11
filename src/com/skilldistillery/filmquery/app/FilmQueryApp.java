package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		try {
			app.launch();
		} catch (InputMismatchException e) {
			System.out.println("That is not a valid selection.");
			app.launch();
		}
	}

//	private void test() {
//		Film film = db.getFilmById(1);
//		System.out.println(film);
//	
//		Actor actor = db.getActorById(1);
//		System.out.println(actor);
//		
//		List<Actor> actors = db.getActorsByFilmId(1);
//		System.out.println(actors);
//		
//		List<Film> films = db.getFilmsByActorId(1);
//		System.out.println(films);
//
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		input.reset();

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		printMenu();
		int menuSelect = input.nextInt();
		do {

			if (menuSelect == 1) {
				System.out.println("Enter Film ID #: ");
				int filmId = input.nextInt();
				System.out.println(db.getFilmById(filmId));

			} else if (menuSelect == 2) {
				System.out.println("Search keyword: ");
				String keyWord = input.nextLine();
				

			} else {
				System.out.println("That is not a valid selection.");
				input.reset();
				printMenu();
				menuSelect = input.nextInt();
			}
		} while (menuSelect != 0);
		System.out.println("Bye");
		input.close();
	}

	private void printMenu() {
		System.out.println("~~~**Menu**~~~");
		System.out.println("1: Look up a Film by ID");
		System.out.println("2: Look up a Film by search keyword");
		System.out.println("0: Exit");
	}

}

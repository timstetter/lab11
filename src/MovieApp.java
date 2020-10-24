import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MovieApp {

	static Set<String> categories = new HashSet<>();
	static List<Movie> movies = new ArrayList<>();
	static List<String> categoriesList;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		for (int i = 1; i <= 100; i++) {
			movies.add(MovieIO.getMovie(i));
		}

		for (Movie movie : movies) {
			categories.add(movie.getCategory());
		}
		categoriesList = new ArrayList<>(categories.size());
		for (String x : categories) {
			categoriesList.add(x);
		}
		
		//sort list alpha
		Collections.sort(categoriesList);
		
		System.out.println("Welcome to the Movie List application!\n");
		System.out.println("There are " + movies.size() + " movies in the list\n");

		int menuChoice = -1;
		
		printMenu();
		
		menuChoice = scnr.nextInt();
		
		while (menuChoice != categoriesList.size() + 1) {
			switch (menuChoice) {
			case 1:
				for (Movie movie : movies) {
					if (movie.getCategory().equals("animated")) {
						System.out.println(movie.getTitle());
					}
				}
				break;
			case 2:
				for (Movie movie : movies) {
					if (movie.getCategory().equals("comedy")) {
						System.out.println(movie.getTitle());
					}
				}
				break;
			case 3:
				for (Movie movie : movies) {
					if (movie.getCategory().equals("drama")) {
						System.out.println(movie.getTitle());
					}
				}
				break;
			case 4:
				for (Movie movie : movies) {
					if (movie.getCategory().equals("horror")) {
						System.out.println(movie.getTitle());
					}
				}
				break;
			case 5:
				for (Movie movie : movies) {
					if (movie.getCategory().equals("musical")) {
						System.out.println(movie.getTitle());
					}
				}
				break;
			case 6:
				for (Movie movie : movies) {
					if (movie.getCategory().equals("scifi")) {
						System.out.println(movie.getTitle());
					}
				}
				break;
			default:
				System.out.println("***** Please choose a correct menu option *****\n");
			}

			printMenu();
			menuChoice = scnr.nextInt();

		}
		scnr.close();

		System.out.println("Thanks for using the Movies App!");

	}

	public static void printMenu() {
		System.out.println("Please choose a category to learn more:");
		for (int i = 0; i < categoriesList.size(); i++) {
			System.out.print((i + 1) + ") " + categoriesList.get(i) + "\n");
		}
		System.out.println(categoriesList.size() + 1 + ") Exit");
	}

}

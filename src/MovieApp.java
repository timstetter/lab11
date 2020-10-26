import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MovieApp {

	static Set<String> categories = new HashSet<>();
	static List<Movie> movies = new ArrayList<>();
	static List<String> categoriesList;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		// Get 100 movies from the MovieIO class

		for (int i = 1; i <= 100; i++) {
			movies.add(MovieIO.getMovie(i));
		}

		// add the categories to a set

		for (Movie movie : movies) {
			categories.add(movie.getCategory());
		}

		// make the set into a list for printing to menu
		categoriesList = new ArrayList<>(categories.size());
		for (String x : categories) {
			categoriesList.add(x);
		}

		// sort list alpha
		Collections.sort(categoriesList);

		System.out.println("Welcome to the Movie List application!\n");
		System.out.println("There are " + movies.size() + " movies in the list\n");

		int menuChoice = -1;

		printMenu();

		try {
			menuChoice = scnr.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please type the number for the menu option\n");
			scnr.nextLine();
		}

		while (menuChoice != categoriesList.size() + 1) {
			switch (menuChoice) {
			case 1:
				printList(0);
				break;
			case 2:
				printList(1);
				break;
			case 3:
				printList(2);
				break;
			case 4:
				printList(3);
				break;
			case 5:
				printList(4);
				break;
			case 6:
				printList(5);
				break;
			default:
				System.out.println("***** Please choose a correct menu option *****\n");
			}

			printMenu();
			try {
				menuChoice = scnr.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please type the number for the menu option\n");
				scnr.nextLine();
			}
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

	public static void printList(int listNum) {
		for (Movie movie : movies) {
			if (movie.getCategory().equals(categoriesList.get(listNum))) {
				System.out.println(movie.getTitle());
			}
		}
	}

}

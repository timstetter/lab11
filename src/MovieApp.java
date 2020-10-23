import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MovieApp {

	static Set<String> categories = new HashSet<>();
	static List<Movie> movies = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		for (int i = 1; i <= 100; i++) {
			movies.add(MovieIO.getMovie(i));
		}

		for (Movie movie : movies) {
			categories.add(movie.getCategory());
		}

		System.out.println("Welcome to the Movie List applcation");
		System.out.println("There are " + movies.size() + " movies in the list");
		

		do {

			String userCategory = Validator.getString(scnr, "What category are you interested in? \n" + categories.toString() + ": ");

			for (Movie movie : movies) {
				if (userCategory.equalsIgnoreCase(movie.getCategory())) {
					System.out.println(movie.getTitle());					
				} else {
					System.out.println("Please choose a listed category");
					break;
				}
				
			}
			

		} while (Validator.getYesNo(scnr, "Continue? (y/n)"));

		System.out.println("Thanks for using the Movies App!");

	}

}

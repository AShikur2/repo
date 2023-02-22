import java.util.Scanner;
public class MovieDriver {

	public static void main(String[] args) {
		Scanner sObj = new Scanner(System.in);
		Movie mObj = new Movie();
		String cont = "y";
		while (cont.equals("y")) {
			System.out.println("Enter the title of a movie: ");
			String title = sObj.nextLine();
			mObj.setTitle(title);
			System.out.println("Enter the the rating of the movie: ");
			String rating = sObj.nextLine();
			mObj.setRating(rating);
			System.out.println("Enter the number of tickets sold for this movie: ");
			int soldTickets = sObj.nextInt();
			mObj.setSoldTickets(soldTickets);
			System.out.println(mObj.toString());
			System.out.println("Do you want to enter another? (y/n) ");
			sObj.nextLine();
			cont = sObj.nextLine();
		}
		System.out.println("\nThanks for using my program");

	}

}

package HangMan;

import java.util.Scanner;

public class HangManMain {

	public static void main(String[] args) throws Exception {
		HangMan h1 = new HangMan();
		h1.getrandomWord();

		int WrongCount = 0;
		Scanner sc = new Scanner(System.in);

		while (WrongCount < 7) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println(h1.getGraphRepresentation(WrongCount));
			System.out.println("\n" + h1.getWrongLetter());
			System.out.println(h1.toString());
			// System.out.println(h1.getWord());
			System.out.print("\nGuess a letter: ");
			String help = sc.nextLine();
			help = help.toLowerCase();

			boolean check = false;
			for (int i = 0; i < h1.getWordSize(); i++) {
				if (h1.isLetterinWord(help, i)) {
					h1.changeUnderscoreArray(i, help);
					check = true;
				}
			}
			if (h1.isEqual()) {
				System.out.println("\n Congratulation, You have WON");
				break;
			}

			if (check == false) {
				WrongCount++;
				h1.addWrongLetter(help);

			}
			
		}
		System.out.println(h1.getGraphRepresentation(7));
		sc.close();
		System.out.print("");
	}

}

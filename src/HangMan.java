package HangMan;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

	private File DataBase;
	private String Path;
	private ArrayList<String> AllTheWords;
	private int Wordsize;
	private String TheWord;
	private String[] WordArray;
	private String[] UnderScoreA;
	private String[] GraphRepresentation;
	private ArrayList<String> WrongLetters;

	public HangMan() {
		AllTheWords = new ArrayList<String>();
		Path = "C:\\Users\\Loic PC\\Documents\\java_courses\\1DV600\\src\\HangMan\\Database.txt";
		DataBase = new File(Path);
		GraphRepresentation = createGraphRepresentation();
		WrongLetters = new ArrayList<String>();
	}

	public void getrandomWord() {
		getAllTheWords(DataBase);
		Random rd = new Random();
		int randomnb = rd.nextInt(AllTheWords.size());
		TheWord = AllTheWords.get(randomnb);
		WordArray = TheWord.split("");
		UnderScoreA = new String[WordArray.length];
		for (int i = 0; i < UnderScoreA.length; i++)
			UnderScoreA[i] = "_";
		Wordsize = WordArray.length;
	}

	private void getAllTheWords(File file) {
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String word = sc.nextLine();
				AllTheWords.add(word);
			}
			sc.close();
		} catch (Exception ioe) {
			System.out.println("WHERE THE FUCK IS THE FILE");
		}

	}

	public boolean isLetterinWord(String c, int pos) {

		if (WordArray[pos].equals(c))
			return true;
		else
			return false;
	}

	public int getWordSize() {
		return Wordsize;
	}

	public String getGraphRepresentation(int pos) {
		return GraphRepresentation[pos];
	}

	public void addWrongLetter(String wl) {
		WrongLetters.add(wl);
	}

	public String[] getUnderscoreArray() {
		return UnderScoreA;
	}

	public String getWord() {
		return TheWord;
	}
	
	public boolean isEqual(){
		if (Arrays.equals(WordArray, UnderScoreA))
			return true;
		else
			return false;
	}

	public String getWrongLetter() {
		String help = "Wrong Letters: ";
		for (int i = 0; i < WrongLetters.size(); i++)
			help += WrongLetters.get(i) + ", ";
		return help;
	}

	public String[] changeUnderscoreArray(int pos, String change) throws Exception {
		if (pos < 0 || pos > Wordsize)
			throw new Exception("The position is outside the boundries");
		else {
			UnderScoreA[pos] = change;
			return UnderScoreA;
		}

	}

	private String[] createGraphRepresentation() {

		String firstpos = " \n" + " \n" + " \n" + " \n" + " \n" + " \n" + " \n" + " \n" + "_______________";
		String secondpos = " ________\n" + "|\n" + "|\n" + "|\n" + "|\n" + "|\n" + "|\n" + "|\n" + "|\n"
				+ "_______________";
		String thirdpos = " ________\n" + "|     |\n" + "|   [o_O]\n" + "|\n" + "|\n" + "|\n" + "|\n" + "|\n" + "|\n"
				+ "_______________";
		String fourthpos = " ________\n" + "|     |\n" + "|   [o_O]\n" + "|     |\n" + "|     |\n" + "|     |\n" + "|\n"
				+ "|\n" + "|\n" + "_______________";
		String fifthpos = " ________\n" + "|     |\n" + "|   [o_O]\n" + "|     |\n" + "|     |\n" + "|     |\n"
				+ "|    /\n" + "|\n" + "|\n" + "_______________";
		String sixthpos = " ________\n" + "|     |\n" + "|   [o_O]\n" + "|     |\n" + "|     |\n" + "|     |\n"
				+ "|    / \\ \n" + "|\n" + "|\n" + "_______________";
		String seventhpos = " ________\n" + "|     |\n" + "|   [o_O]\n" + "|     |\n" + "|    /| \n" + "|     |\n"
				+ "|    / \\ \n" + "|\n" + "|\n" + "_______________";
		String heighthpos = " ________\n" + "|     |\n" + "|   [x_X]\n" + "|     |\n" + "|    /|\\ \n" + "|     |\n"
				+ "|    / \\ \n" + "|\n" + "|    DEAD\n" + "_______________";

		String[] AllPics = { firstpos, secondpos, thirdpos, fourthpos, fifthpos, sixthpos, seventhpos, heighthpos };

		return AllPics;
	}

	@Override
	public String toString() {
		String help = "";
		for (int i = 0; i < UnderScoreA.length; i++)
			help += UnderScoreA[i] + " ";
		return help;
	}
}

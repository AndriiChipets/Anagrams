package ua.prom.roboticsdmc.anagramcreater;

import java.util.Scanner;

public class AnagramChecker {

	public static void main(String[] args) {

		AnagramCreater sourceInput = new AnagramCreater();

		Scanner in = new Scanner(System.in);
		System.out.println("Enter sentance: ");
		sourceInput.source = in.nextLine();
		in.close();

		System.out.println(sourceInput.createAllSentanceAnagram());

	}
}

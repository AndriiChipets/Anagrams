package ua.prom.roboticsdmc.anagramcreater;

public class AnagramCreater {

	String source;
	final String[] alphabetLetters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public String createAllSentanceAnagram() {

		StringBuilder sentanceReverse = new StringBuilder();

		String[] sourceSplitByWhiteSpace = source.split(" ");

		for (int i = 0; i < sourceSplitByWhiteSpace.length; i++) {

			sentanceReverse.append(createOneWordAnagram(sourceSplitByWhiteSpace[i]));

			sentanceReverse.append(" ");
		}

		return String.valueOf(sentanceReverse).trim();
	}

	private String createOneWordAnagram(String singleWord) {

		StringBuilder sourceCharacterNonLetterSeparateByWhiteSpase = new StringBuilder();

		StringBuilder wordReverse = new StringBuilder();

		char[] sourceSingleWord = singleWord.toCharArray();

		OUT: for (int i = 0; i < sourceSingleWord.length; i++) {

			String sourceSingleCharacter = String.valueOf(sourceSingleWord[i]);

			int j = 0;

			while (j < alphabetLetters.length)

				if (sourceSingleCharacter.toLowerCase().equals(alphabetLetters[j])) {

					sourceCharacterNonLetterSeparateByWhiteSpase.append(sourceSingleCharacter);

					continue OUT;

				} else {

					j++;
				}

			sourceCharacterNonLetterSeparateByWhiteSpase.append(" " + sourceSingleCharacter + " ");
		}

		String theSourceCharacterNonLetterSplitByWhiteSpase = String.valueOf(sourceCharacterNonLetterSeparateByWhiteSpase).replace("  ", " ");

		String[] wordSplitByWhiteSpace = theSourceCharacterNonLetterSplitByWhiteSpase.split(" ");

		for (int i = 0; i < wordSplitByWhiteSpace.length; i++) {

			char[] resultCharacter = wordSplitByWhiteSpace[i].toCharArray();

			for (int j = resultCharacter.length - 1; j >= 0; j--) {
				wordReverse.append(resultCharacter[j]);
			}
		}

		return String.valueOf(wordReverse);
	}

	public void getSource(String source) {
		this.source = source;
	}

}

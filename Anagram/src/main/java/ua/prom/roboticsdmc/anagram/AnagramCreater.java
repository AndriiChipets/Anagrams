package ua.prom.roboticsdmc.anagram;

public class AnagramCreater {

    private static final String SPACE_DELIMITER = " ";

    public String createAllSentenceAnagram(String source) {

        validateSource(source);

        StringBuilder sentanceReverse = new StringBuilder();
        String[] sourceSpaceDelim = source.split(SPACE_DELIMITER);

        for (int i = 0; i < sourceSpaceDelim.length; i++) {
            sentanceReverse.append(createOneWordAnagram(sourceSpaceDelim[i]));
            sentanceReverse.append(SPACE_DELIMITER);
        }
        return String.valueOf(sentanceReverse).trim();
    }

    private String createOneWordAnagram(String singleWord) {

        char[] sourceSingleWord = singleWord.toCharArray();
        int indexStart = 0;
        int indexEnd = sourceSingleWord.length - 1;

        while (indexStart < indexEnd) {

            char currentCharacter = sourceSingleWord[indexStart];
            boolean isLetterStart = Character.isLetter(sourceSingleWord[indexStart]);
            boolean isLetterEnd = Character.isLetter(sourceSingleWord[indexEnd]);

            if (isLetterStart && isLetterEnd) {
                sourceSingleWord[indexStart] = sourceSingleWord[indexEnd];
                sourceSingleWord[indexEnd] = currentCharacter;
                indexStart++;
                indexEnd--;
            } else if (isLetterEnd == isLetterStart) {
                indexStart++;
                indexEnd--;
            } else if (!isLetterEnd) {
                indexEnd--;
            } else {
                indexStart++;
            }
        }
        return String.valueOf(sourceSingleWord);
    }

    private void validateSource(String source) {
        if (source == null) {
            throw new IllegalArgumentException("Source is null");
        }
        if (source.isEmpty()) {
            throw new IllegalArgumentException("Source is empty");
        }
        if (source.trim().isEmpty()) {
            throw new IllegalArgumentException("Source is contain only space or tab");
        }
    }
}

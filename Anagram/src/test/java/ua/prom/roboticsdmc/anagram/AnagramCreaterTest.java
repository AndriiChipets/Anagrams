package ua.prom.roboticsdmc.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AnagramCreaterTest {

    AnagramCreater anagramCreater = new AnagramCreater();

    @Test
    void createAllSentenceAnagram_shouldReturnIllegalArgumentException_whenInputStringIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> anagramCreater.createAllSentenceAnagram(null));
        assertEquals("Source is null", exception.getMessage());
    }

    @Test
    void createAllSentenceAnagram_shouldReturnIllegalArgumentException_whenInputStringIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> anagramCreater.createAllSentenceAnagram(""));
        assertEquals("Source is empty", exception.getMessage());
    }

    @Test
    void createAllSentenceAnagram_shouldReturnIllegalArgumentException_whenInputStringIsSingleSpace() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> anagramCreater.createAllSentenceAnagram(" "));
        assertEquals("Source is contain only space or tab", exception.getMessage());
    }

    @Test
    void createAllSentenceAnagram_shouldReturnIllegalArgumentException_whenInputStringContainsSeveralSpaces() {
        assertThrows(IllegalArgumentException.class, () -> anagramCreater.createAllSentenceAnagram("   "));
    }

    @Test
    void createAllSentenceAnagram_shouldReturnTheSameCharacter_whenInputStringIsSingleCharacter() {
        assertEquals("1", anagramCreater.createAllSentenceAnagram("1"));
    }

    @Test
    void createAllSentenceAnagram_shouldReturnTheSameLetters_whenInputStringContainsMultipleSameLetters() {
        assertEquals("AAAAA", anagramCreater.createAllSentenceAnagram("AAAAA"));
    }

    @Test
    void createAllSentenceAnagram_shouldReturnTheReversedCharactersInLowerAndUpperCases_whenInputStringContainsTheSameMixedCharactersInLowerAndUpperCases() {
        assertEquals("aA", anagramCreater.createAllSentenceAnagram("Aa"));
    }

    @Test
    void createAllSentenceAnagram_shouldReturnReversedSingleWordWithDifferentLetters_whenInputStringContainsSingleWordWithDifferentLetters() {
        assertEquals("eEdDcCbBaA", anagramCreater.createAllSentenceAnagram("AaBbCcDdEe"));
    }

    @Test
    void createAllSentenceAnagram_shouldReturnAllSymbolsOnTheSamePlaces_whenInputStringContainsOnlySymbols() {
        assertEquals("1234567890!@#$%^&*()_+=-", anagramCreater.createAllSentenceAnagram("1234567890!@#$%^&*()_+=-"));
    }

    @Test
    void createAllSentenceAnagram_shouldReturnSeverWordsInWhichAllLettersIsReversedAndNonLettersStayOnTheSamePlaces_whenInputStringContainsSeveralWords() {
        assertEquals("012345gFeDcbA6789 pOnml12345KhgFEdcba !@#$%^ gfEdcbA",
                anagramCreater.createAllSentenceAnagram("012345AbcDeFg6789 abcdE12345FghKlmnOp !@#$%^ AbcdEfg"));
    }

    @Test
    void createAllSentenceAnagram_shouldReturnReversedAllLettersInTheFirstPartAndAllNonLetteresFromTheLastPartOnTheSamePlace_whenInputStringContainsFirstPartOfWorldAreLettersAndLastPartAreNonLetters() {
        assertEquals("GfEdcBA1234567", anagramCreater.createAllSentenceAnagram("ABcdEfG1234567"));
    }
    
}

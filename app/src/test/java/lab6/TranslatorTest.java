package lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import lab6.Translator;

public class TranslatorTest {
    private Translator translator;

    @BeforeEach
    void setUp() {
        translator = new Translator();
        translator.addWord("hello", "привіт");
        translator.addWord("my", "мій");
        translator.addWord("friend", "друг");
    }

    @Test
    void testAddWords() {
        Translator t = new Translator();
        t.addWord("blue", "синій");
        assertEquals("синій", t.translatePhrase("blue"));
    }

    @Test
    void testOverwriteWord() {
        translator.addWord("", "");
    }

    @Test
    void testTranslateKnownWords() {
        String result = translator.translatePhrase("hello my friend");
        assertEquals("привіт мій друг", result);
    }

    @Test
    void testTranslateUnknownWords() {
        String result = translator.translatePhrase("unknown word");
        assertEquals("[unknown] [word]", result);
    }

    @Test
    void testTranslateMixedWords() {
        String result = translator.translatePhrase("hello good friend");
        assertEquals("привіт [good] друг", result);
    }

    @Test
    void testCaseInsensitive() {
        String result = translator.translatePhrase("HeLLO fRIEND");
        assertEquals("привіт друг", result);
    }

    @Test
    void testMultipleSpaces() {
        String result = translator.translatePhrase("hello   my    friend");
        assertEquals("привіт мій друг", result);
    }

    @Test
    void testEmptyPhrase() {
        String result = translator.translatePhrase("");
        assertEquals("[]", result);
    }

    @Test
    void testAddWordIsLowercased() {
        translator.addWord("DOG", "Собака");
        assertEquals("собака", translator.translatePhrase("dog"));
    }

    @Test
    void integrationTestFullCycle() {
        Translator t = new Translator();
        t.addWord("my", "мій");
        t.addWord("father", "батько");
        t.addWord("is", "це");

        String result = t.translatePhrase("my father is lawyer");
        assertEquals("мій батько це [lawyer]", result);
    }
}

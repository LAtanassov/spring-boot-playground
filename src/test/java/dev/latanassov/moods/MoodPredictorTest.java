package dev.latanassov.moods;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoodPredictorTest {

    @Test(expected = NullPointerException.class)
    public  void shouldNotBeNull() {
        MoodPredictor.predict(null);
    }
    
    @Test
    public void shouldNotBeEmpty() {
        final String emptyArticle = "";
        final Mood actual = MoodPredictor.predict(emptyArticle);
        assertEquals(Mood.UNKNOWN, actual);
    } 
    
    @Test
    public void shouldBeHappy() {
        final String article = "I feel happy.";
        final Mood actual = MoodPredictor.predict(article);
        assertEquals(Mood.HAPPY, actual);
    }

    @Test
    public void shouldBeSad() {
        final String article = "I feel sad.";
        final Mood actual = MoodPredictor.predict(article);
        assertEquals(Mood.SAD, actual);
    }

    @Test
    public void shouldBeExcited() {
        final String article = "I feel excited";
        final Mood actual = MoodPredictor.predict(article);
        assertEquals(Mood.EXCITED, actual);
    }

}
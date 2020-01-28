package dev.latanassov.moods;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class MoodPredictor {

    private static final String[] HAPPY_KEYWORDS = {"happy"};
    private static final String[] SAD_KEYWORDS = {"sad"};
    private static final String[] EXCITED_KEYWORDS = {"excited"};

    private MoodPredictor() {
    }

    public static Mood predict(@NonNull String article) {

        boolean isHappy = Stream.of(HAPPY_KEYWORDS).anyMatch(article::contains);
        if (isHappy) {
            return Mood.HAPPY;
        }

        boolean isSad = Stream.of(SAD_KEYWORDS).anyMatch(article::contains);
        if (isSad) {
            return Mood.SAD;
        }

        boolean isExcited = Stream.of(EXCITED_KEYWORDS).anyMatch(article::contains);
        if (isExcited) {
            return Mood.EXCITED;
        }

        return Mood.UNKNOWN;
    }
}

package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSearchRepositoryTest {

    @Test
    void searchSuggestions() {
        List<String> repo = List.of("Moate", "moUSe", "monitor", "marvel", "mousepad", "mercedes");
        List<List<String>> searchSuggestions = WordSearchRepository.searchSuggestions(repo, "mouse");
        List<List<String>> searchSuggestionsTest = List.of(
                List.of("Moate", "monitor", "moUSe"),
                List.of("moUSe", "mousepad"),
                List.of("moUSe", "mousepad"),
                List.of("moUSe", "mousepad")
        );
        for (int i = 0; i < searchSuggestionsTest.size(); i++) {
            assertEquals(searchSuggestionsTest.get(i), searchSuggestions.get(i));
        }
    }
}
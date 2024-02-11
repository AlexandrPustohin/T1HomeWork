package org.example;

import org.example.entity.Phrase;

public interface SupportService {
    Phrase getPhraseById();
    Phrase getRandomPhrase();
    void addPhrase(Phrase phrase);
}

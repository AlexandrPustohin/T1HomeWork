package org.example;

import org.example.entity.Phrase;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SupportServiceImpl implements SupportService {
    List<Phrase> phrases = new CopyOnWriteArrayList<>();

    @Override
    public Phrase getPhraseById() {
        return null;
    }

    @Override
    public Phrase getRandomPhrase(){
        Collections.shuffle(phrases);
        return phrases.stream().findFirst().get();
    }

    @Override
    public void addPhrase(Phrase phrase) {
        phrases.add(phrase);
    }


}

package org.learn;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements IMusic {

    @Override
    public String getSong() {
        return "ClassicalSong";
    }
}
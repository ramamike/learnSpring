package org.learn;

import org.springframework.stereotype.Component;

public class RockMusic implements IMusic {

    @Override
    public String getSong() {
        return "RockSong";
    }
}

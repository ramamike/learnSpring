package org.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private IMusic music1;
    private IMusic music2;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") IMusic music1,
                       @Qualifier("rockMusic") IMusic music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic() {
        return "Play " + music1.getSong() + " and " + music2.getSong();
    }

}

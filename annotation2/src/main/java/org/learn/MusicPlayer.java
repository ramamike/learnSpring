package org.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    @Autowired
    private IMusic music;

    public MusicPlayer(IMusic music) {
        this.music=music;
    }

    public String playMusic() {
        return "Play" + music.getSong();
    }

}

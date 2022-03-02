package org.learn;

import org.springframework.stereotype.Component;

public class MusicPlayer {
    private IMusic music;

    //IoC
    public MusicPlayer(IMusic music) {
        this.music=music;
    }

    public void playMusic() {
        System.out.println(music.getSong());
    }

}

package org.learn;

import java.util.ArrayList;

public class MusicPlayer {
    private ArrayList<IMusic> musicList=new ArrayList<>();
    private String songName;
    private int valume;

    //IoC and DI with setter

    public MusicPlayer() {
    }

 //   public MusicPlayer(IMusic music) {
 //       this.music=music;
 //   }
 //   public void setMusic(IMusic music) {
 //       this.music = music;
 //   }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    public int getValume() {
        return valume;
    }

    public void setValume(int valume) {
        this.valume = valume;
    }

    public ArrayList<IMusic> addMusicList(IMusic ob) {
        musicList.add(ob);
        return musicList;
    }


    public void playMusic() {
        for(IMusic ob :musicList)
        System.out.println(ob.getSong());
    }

}

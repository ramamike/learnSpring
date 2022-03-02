package org.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("applicationContext.xml");

        //Dependency injection
        MusicPlayer musicPlayer=context.getBean("musicPlayer", MusicPlayer.class);
        ClassicalMusic classicalMusic=new ClassicalMusic();
        RockMusic rockMusic=new RockMusic();

        musicPlayer.addMusicList(classicalMusic);
        musicPlayer.addMusicList(rockMusic);

        musicPlayer.playMusic();

        //System.out.println(musicPlayer.getSongName());
        //System.out.println(musicPlayer.getValume());

        context.close();
    }

}

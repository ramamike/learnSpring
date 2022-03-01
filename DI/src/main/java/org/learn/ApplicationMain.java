package org.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("applicationContext.xml");

        //Dependency injection
        //IMusic music=context.getBean("musicBean", IMusic.class);
        //MusicPlayer musicPlayer=new MusicPlayer(music);

        MusicPlayer musicPlayer=context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

        context.close();

    }

}

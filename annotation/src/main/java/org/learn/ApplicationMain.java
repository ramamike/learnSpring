package org.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("applicationContext.xml");

        IMusic music=context.getBean("classicalMusic", IMusic.class);
        MusicPlayer musicPlayer=new MusicPlayer(music);
        musicPlayer.playMusic();

        context.close();
    }

}

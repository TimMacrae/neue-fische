package com.oop;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        VideoPlayer videoPlayer = new VideoPlayer();
        MediaController mediaController = new MediaController();

        mediaController.playMedia(musicPlayer);
        mediaController.playMedia(videoPlayer);

    }
}
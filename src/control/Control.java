/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Soren
 */
public class Control implements WordPairControlInterface {

    private Engine engine;
    private Clip myClip;

    public Control() {
        engine = new Engine();

    }

    @Override
    public void add(String question, String answer) {
        engine.addToMap(question, answer);
    }

    @Override
    public int size() {
        return engine.size();
    }

    @Override
    public String getRandomQuestion() {

        return engine.ruller();
    }

    @Override
    public boolean checkGuess(String question, String quess) {

        String answer = engine.gettemp(question);

        if (quess.equalsIgnoreCase(answer)) {
            engine.MoveToList2(question, quess);
            //vind();
            return true;
        } else {
            //music2stop();
            //tab();
            return false;
        }

    }

    @Override
    public String lookup(String question) {

        String answer = engine.gettemp(question);

        return answer;
    }

    @Override
    public boolean load(String filename) {
        return engine.load(filename);

    }

    @Override
    public boolean save(String filename) {

        return engine.save2(filename);

    }

    @Override
    public void clear() {

        engine.clear();

    }

    public void music2(String fileName) {

        try {
            File file = new File(fileName);
            if (file.exists()) {
                myClip = AudioSystem.getClip();
                AudioInputStream ais = AudioSystem.getAudioInputStream(file.toURI().toURL());
                myClip.open(ais);

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Sound: Malformed URL: " + e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        } catch (IOException e) {
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException("Sound: Line Unavailable: " + e);
        }

    }

    public void music2play() {
        if (myClip.isRunning()) {
        } else {
            myClip.start();
            myClip.loop(Clip.LOOP_CONTINUOUSLY);
        }

    }

    public void music2stop() {
        myClip.stop();
    }

    public void vind() {

        InputStream in;
        try {
            in = new FileInputStream(new File("C:\\Users\\Soren\\Desktop\\smb_coin.wav"));
            AudioStream audiotstream = new AudioStream(in);
            AudioPlayer.player.start(audiotstream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void næste() {
/**
        InputStream in;
        try {
            in = new FileInputStream(new File("C:\\Users\\Soren\\Desktop\\smb_jump-small.wav"));
            AudioStream audiotstream = new AudioStream(in);
            AudioPlayer.player.start(audiotstream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
**/

    }

    public void tab() {

        InputStream in;
        try {
            in = new FileInputStream(new File("C:\\Users\\Soren\\Desktop\\smb_mariodie.wav"));
            AudioStream audiotstream = new AudioStream(in);
            AudioPlayer.player.start(audiotstream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void getbig() {

        InputStream in;
        try {
            in = new FileInputStream(new File("C:\\Users\\Soren\\Desktop\\smb_powerup.wav"));
            AudioStream audiotstream = new AudioStream(in);
            AudioPlayer.player.start(audiotstream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}

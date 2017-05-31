/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectreloj;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author ricky_000
 */
public class Alarma {

    static boolean ringOn;
    static Clip melodia;

    /**
     *
     * @param ringOn Activa la alarma
     * @param melodia Melodia que suena cuando se activa la alarma
     */
    public Alarma(boolean ringOn, Clip melodia) {
        this.ringOn = ringOn;
        this.melodia = melodia;
    }

    public Alarma() {

    }

    /**
     * Método que activa la alarma
     */
    public static void playSound() {
        try {
            melodia = AudioSystem.getClip();
            try {
                melodia.open(AudioSystem.getAudioInputStream(new File("")));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Alarma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Alarma.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (LineUnavailableException ex) {
            System.out.println("Error :" + ex.getMessage());
        }

    }
}

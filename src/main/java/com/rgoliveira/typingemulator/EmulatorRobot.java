/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rgoliveira.typingemulator;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class EmulatorRobot implements Runnable {
    String  str;
    int     keystrokeDelayInMs;
    
    public EmulatorRobot(String str, int keystrokeDelayInMs) {
        this.str = str;
        this.keystrokeDelayInMs = keystrokeDelayInMs;
    }

    @Override
    public void run() {
        try {
            Robot r = new Robot();
            for (char c : str.toCharArray()) {
                int keycode = Character.toUpperCase(c);
                if (Character.isUpperCase(c)) r.keyPress(KeyEvent.VK_SHIFT);
                r.keyPress(keycode);
                r.keyRelease(keycode);
                if (Character.isUpperCase(c)) r.keyRelease(KeyEvent.VK_SHIFT);
                r.delay(keystrokeDelayInMs);
            }
        } catch (AWTException ex) {
            Logger.getLogger(EmulatorRobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

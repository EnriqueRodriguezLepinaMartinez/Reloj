/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectreloj;

/**
 *
 * @author ricky_000
 */
public class Display {

    static boolean ledClock;
    static boolean ledAlarm;
    static boolean ledSet;

    /**
     * Método para mostrar la hora
     */

    public static void mostrarHora() {
        if (Display.ledAlarm == true) {
            System.out.println(ProjectReloj.horaAlarma.getHour() + ": " + ProjectReloj.horaAlarma.getMinute());
        } else {
            System.out.println(ProjectReloj.horaActual.getHour() + ": " + ProjectReloj.horaActual.getMinute());
        }
    }
    
    /**
     * Método para mostrar configuracion y almacenar el estado del led.
     * @param clock
     * @param alarm
     * @param set 
     */
    public static void MostrarLed(boolean clock, boolean alarm, boolean set) {
        ledClock = clock;
        ledAlarm = alarm;
        ledSet = set;

    }
}

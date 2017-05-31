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
public class Botonera {

    static boolean alarmmActive;
    static boolean setHr;
    static boolean setAlarm;

    /**
     * Constructor para cargar la posibilidad de configuracion de la
     * hora,alarma,etc...
     *
     * @param showAlarmActive shows if the alarm is on or off
     * @param showSetHr allow you to set the hour
     * @param showSetAlarm allow you to see when de alarm is set
     */
    public Botonera(boolean showAlarmActive, boolean showSetHr, boolean showSetAlarm) {
        this.alarmmActive = showAlarmActive;
        this.setAlarm = showSetAlarm;
        this.setHr = showSetHr;
    }

    public Botonera() {

    }

    /**
     * Muestra si la alarma está activada
     */
    public static void alarmaOn() {
        Display.MostrarLed(false, true, false);

    }

    /**
     * Muestra si la alarma está desactivada
     */
    public static void alarmaOff() {
        Display.MostrarLed(false, false, false);
    }

    /**
     * Método para configurar la hora
     *
     */
    public static void cambiarHora() {
        if (Display.ledAlarm == true) {
            ProjectReloj.horaAlarma = ProjectReloj.horaAlarma.plusHours(1);
            Display.mostrarHora();
        } else {
            ProjectReloj.horaActual = ProjectReloj.horaActual.plusHours(1);

            Display.mostrarHora();
        }

    }

    /**
     * Método para configurar los minutos
     */
    public static void cambiarMinutos() {
        if (Display.ledAlarm == true) {
            ProjectReloj.horaAlarma = ProjectReloj.horaAlarma.plusMinutes(1);

        } else {
            ProjectReloj.horaActual = ProjectReloj.horaActual.plusMinutes(1);
            Display.mostrarHora();
        }

    }

    /**
     * Método para parar la alarma
     */
    public static void stopAlarma() {
        ProjectReloj.timer.cancel();

    }

    /**
     * Método para configurar la hora actual
     */
    public static void configHr() {

        Display.MostrarLed(true, false, true);
        Display.mostrarHora();

    }

    /**
     * Método para configurar la hora de la alarma
     */
    public static void configAlarm() {

        Display.MostrarLed(false, true, true);

        Display.mostrarHora();

    }

}

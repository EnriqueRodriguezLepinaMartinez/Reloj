/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectreloj;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author ricky_000
 */
public class ProjectReloj {


    static LocalTime horaActual;
    static LocalTime horaAlarma;
    static Timer timer;
    static TimerTask tarea;
    static boolean pararAlarma = true;

    /**
     * Usamos el main para comprobar la alarma, saber la hora actual y un do while para poder modificar horario y alarma.
     * @param args 
     */
    public static void main(String[] args) {
        tarea = new TimerTask() {
            @Override
            public void run() {
                
                if (horaAlarma.getMinute() == LocalTime.now().getMinute() && horaAlarma.getHour() == LocalTime.now().getHour()&& Display.ledAlarm==true) {
                    JOptionPane.showMessageDialog(null, "ALARMA!!!");
                    Alarma.playSound();
                    

                } else {
                    JOptionPane.showMessageDialog(null, "La hora Actual es : " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
                }
            }
        };
        timer = new Timer();
        horaActual = LocalTime.now();
        horaAlarma = LocalTime.now();
        int select;
        timer.schedule(tarea, 10, 10000);
        do {
            select = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la opción Deseada \n 1. configurar Hora  \n 2. hora +  \n 3. Min + \n 4. Configurar Alarma"
   + "\n 5. Mostrar Hora y minutos \n 6. Parar Alarma \n 7.AlarmOn \n 8.AlarmOff"
            ));

            switch (select) {

                case 1:
                    Botonera.configHr();
                    break;
                case 2:
                    Botonera.cambiarHora();
                    break;
                case 3:
                    Botonera.cambiarMinutos();
                    break;
                case 4:
                    Botonera.configAlarm();
                    break;
                case 5:
                    Display.mostrarHora();
                    break;
                case 6:
                    Botonera.stopAlarma();
                    break;
                case 7:
                    Botonera.alarmaOn();
                    break;
                case 8:
                    Botonera.alarmaOff();
                    break;
            }

        } while (select != 0);
     
tarea.cancel();
    }

}

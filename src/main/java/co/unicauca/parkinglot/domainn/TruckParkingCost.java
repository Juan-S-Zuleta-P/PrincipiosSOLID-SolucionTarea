/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domainn;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 *
 * @author Rivera
 */
public class TruckParkingCost implements IParkingCost {
    
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        
        
        Utilities util = new Utilities();
        util.calculateTime(input, output);
        long result = 15000;
        long aux = 0;
        int horas = util.getHour();

        if (util.getDias() > 0) {
            result = util.getDias() * result;
            aux = result;
            if (util.getHour() != 0) {
                result = result + (util.getHour() * 625);

            }
        } else{
            if (util.getHour() <= 12) {
                result = 10000;

            }
        }
        
        
        //Llamado metodo sorteo 
        if(util.sorteo()){
            result = 0;
        }
        System.out.println("hora:" + util.getHour() + " minutos: " + util.getMinute());
        System.out.println("result: " + result);
        System.out.println("aux: " + aux);
        System.out.println("horas: " + horas);
        System.out.println("Dias: " + util.getDias());
        System.out.println("random" + util.sorteo());
        return util.redondeo(result);

    }

}

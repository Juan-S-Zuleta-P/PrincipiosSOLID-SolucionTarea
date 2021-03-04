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
public class CarParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Utilities util = new Utilities();
        util.calculateTime(input, output);
        long result = 2000;
        long aux = 0;
        int horas = util.getHour();
//        if (util.getMinute() != 0) {
//            horas = util.getHour() - 1;
//        }

        if (horas >= 2) {
            result = result + (horas * 500);
            aux = result;
            if (util.getMinute() > 30) {
                result = result + 250;
                if (util.getMinute() >= 45) {
                    result = result + 125;
                }
            } else {
                result = result + 125;
            }
        } else {
            if (horas <= 1 && horas != 0) {
                if (util.getMinute() >= 30) {
                    result = result + 500;
                    if (util.getMinute() >= 45) {
                        result = result + 250;
                    }
                }
            }

        }
        System.out.println("hora:" + util.getHour() + " minutos: " + util.getMinute());
        System.out.println("result: " + result);
        System.out.println("aux: " + aux);
        System.out.println("horas: " + horas);

        return util.redondeo(result);

    }

}

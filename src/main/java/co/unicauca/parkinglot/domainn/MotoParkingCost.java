/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domainn;

import java.time.LocalDateTime;
import co.unicauca.parkinglot.infra.Utilities;

/**
 *
 * @author Rivera
 */
public class MotoParkingCost implements IParkingCost {

    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        Utilities util = new Utilities();
        util.calculateTime(input, output);
        long result = 1000;

        if (util.getHour() > 0) {
            result = (util.getHour() +1) * 500;
            if(util.getMinute() >= 30) {
                result = result + 250;
                if (util.getMinute() >= 45) {
                    result = result + 125;
                }
            }else{
            result = result + 125;
            }
        }
        System.out.println("hora:" + util.getHour() + " minutos: " + util.getMinute());
        System.out.println("result: " + result);
        return util.redondeo(result);
    }

}

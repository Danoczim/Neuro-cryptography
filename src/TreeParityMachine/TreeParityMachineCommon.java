/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeParityMachine;

/**
 *
 * @author Matt
 */
public class TreeParityMachineCommon {
     public static final String keyDictionary = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
        
     public static int signum(double r) {
        if (r > 0) {
            return 1;
        } else {
            return - 1;
        }
    }
     
}

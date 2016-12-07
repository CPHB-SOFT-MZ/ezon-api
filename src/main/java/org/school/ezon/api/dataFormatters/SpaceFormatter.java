/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataFormatters;

/**
 *
 * @author Mikkel
 */
public class SpaceFormatter {
    public static String format(String stringToFormat){
        return stringToFormat.trim().replaceAll(" +", "+");
    }
}

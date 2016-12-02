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
public class KeywordFormatter {
    public static String format(String keyword){
        String lowercaseKeyword = keyword.toLowerCase();
        return lowercaseKeyword.trim().replaceAll("\\s+", " ");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.encoder;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author philliphbrink
 */
public class Encoding {
    public String encodeBase64(){
        String base64 = "DanielWi-3Semeste-PRD-c45f64428-bc9a0454:PRD-45f644282866-ce70-4c00-abe8-5006";
        byte[] base64Encoded = Base64.encodeBase64(base64.getBytes());
        return new String(base64Encoded);
    }
}

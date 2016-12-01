/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api;

import org.school.ezon.api.encoder.Encoding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author philliphbrink
 */
public class GetEbayKey implements Runnable {

    private final Encoding encode = new Encoding();
    private String key = "";

    public void fetchKey() {
        try {
            URL url = new URL("https://api.ebay.com/identity/v1/oauth2/token");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            //First header ContentType
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            //Second header Authorization to eBay (Consist ClientId and Client Secret)
            conn.setRequestProperty("Authorization", "Basic <" + encode.encodeBase64() + ">");

            conn.setDoOutput(true);
            conn.setDoInput(true);

            /*
            The Body in the Post call.
            First: grant_type=client_credentials
            second: redirect_uri=(Users)RUname from eBay
            Thrid: Scopes we want to use from eBay. (The Api's you want to call)
             */
            String contentOfBody = "grant_type=client_credentials&redirect_uri=<Daniel_Winkel-P-DanielWi-3Semes-tqergylcr>&scope=https://api.ebay.com/oauth/api_scope";
            byte[] body = contentOfBody.getBytes();
            OutputStream os = conn.getOutputStream();
            os.write(body);
            os.flush();
            os.close();

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            key = response.toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(APIKeys.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(APIKeys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getKey() {
        return key;
    }

    @Override
    public void run() {
        getKey();
    }
}

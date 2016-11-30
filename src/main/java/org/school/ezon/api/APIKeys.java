/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Mikkel
 */
public class APIKeys {

    public static String DBAKey() {
        return "087157d7-84d5-4f2b-1d02-08d282f6c857";
    }

    public static String AmazonKey() {
        return "";
    }

    public static String EbayKey() {
        URL url = "";
        try {
            url = new URL("https://api.ebay.com/identity/v1/oauth2/token");
        } catch (MalformedURLException ex) {
            Logger.getLogger(APIKeys.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //Base64 encode here 
            conn.setRequestProperty("Authorization", "Basic <""");
            //In scope enter right scopes
            String contentOfBody = "grant_type=client_credentials&redirect_uri=<Daniel_Winkel-P-DanielWi-3Semes-tqergylcr>&scope=https://api.ebay.com/oauth/api_scope";
            byte[] body = contentOfBody.getBytes();
            OutputStream os = conn.getOutputStream();
            os.write(body);
            conn.setUseCaches(false);
        } catch (IOException ex) {
            Logger.getLogger(APIKeys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return target.request().
    }
}

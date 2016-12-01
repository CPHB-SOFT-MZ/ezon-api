/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.apache.commons.codec.binary.Base64;

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
        GetEbayKey GEK = new GetEbayKey();
        return GEK.getKey();
    }
}

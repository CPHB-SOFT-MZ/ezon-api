package org.school.ezon.api.dataFormatters;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class CurrencyConverter {

    public static float getExchangeRate() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://quote.yahoo.com/d/quotes.csv?s=USDDKK=X&f=l1&e=.csv");
        return Float.parseFloat(target.request(MediaType.TEXT_HTML).get(String.class));
    }
}

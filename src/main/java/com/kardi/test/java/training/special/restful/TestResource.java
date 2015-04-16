package com.kardi.test.java.training.special.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * JSR311 - Restful implementation using Jersey
 *
 * Created by m.lysenchuk on 4/16/15.
 */

@Path("get")
public class TestResource {

    @GET
    @Path("text")
    @Produces("text/plain")
    public String getTextServerResponse() {
        return "Text result";
    }

    @GET
    @Path("json")
    @Produces("application/json")
    public TestRestfulBean getJsonServerResponse() {

        TestRestfulBean bean = new TestRestfulBean();
        bean.name = "Name";
        bean.number = 1999;

        return bean;
    }

    @GET
     @Path("xml")
     @Produces("application/xml")
     public TestRestfulBean getXmlServerResponse() {

        TestRestfulBean bean = new TestRestfulBean();
        bean.name = "Name";
        bean.number = 1999;

        return bean;
    }

    @GET
    @Path("html")
    @Produces("text/html")
    public String getHtmlServerResponse() {

        return "<html><body>Restful response in <b>HTML</b></body></html>";
    }
}

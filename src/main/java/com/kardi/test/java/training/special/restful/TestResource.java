package com.kardi.test.java.training.special.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
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

}

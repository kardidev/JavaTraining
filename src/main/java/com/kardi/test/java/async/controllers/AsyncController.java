package com.kardi.test.java.async.controllers;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.View;

/**
 * Created by m.lysenchuk on 4/2/15.
 */

@Controller
public class AsyncController {

    @RequestMapping(value= "/async-request", method = RequestMethod.POST)
    @ResponseBody
    public DeferredResult<String> processAsyncTest() {
        final DeferredResult<String> deferredResult = new DeferredResult<String>();

        new Thread() {

            @Override
            public void run() {
                deferredResult.setResult("1");
            }

        }.start();

        return deferredResult;
    }

}

package com.company;

import java.util.List;
import java.util.Map;

public class Response {

    private Object args;
    private String date;
    private Map<String, String> form;
    private Map<String, String> headers;
    private Map<String, String> json;
    private String url;

    public Response(List<String> args, String date, Map<String, String> form, Map<String,
            String> headers, Map<String, String> json, String url) {
        this.args = args;
        this.date = date;
        this.form = form;
        this.headers = headers;
        this.json = json;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Response: " + '\n' +
                "args: " + args + '\n' +
                "date: " + date + '\n' +
                "form: " + form +  '\n' +
                "headers: " + headers + '\n' +
                "json: " + json + '\n' +
                "url: " + url;
    }
}

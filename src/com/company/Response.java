package com.company;

import java.util.List;

public class Response {

    private String date;
    private List<Value> exchangeRate;

    public Response() {
    }

    public Response(String date, List<Value> exchangeRate, Value value) {
        this.date = date;
        this.exchangeRate = exchangeRate;
    }

    public List<Value> getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "Response{" +
                "date='" + date + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}

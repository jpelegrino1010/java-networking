package com.julioluis.javanetworking.singletthread;

import java.util.HashMap;
import java.util.Map;

public class QuoteService {

    private Map<String,String> map=new HashMap<>();

    public QuoteService() {
        map.put("a","100");
        map.put("b","200");
    }

    public String getQuote(String code) {
        return map.get(code);
    }
}

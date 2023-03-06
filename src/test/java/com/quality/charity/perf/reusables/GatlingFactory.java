package com.quality.charity.perf.reusables;

import com.quality.charity.perf.simulation.GatlingBuilderImpl;

import java.util.HashMap;
import java.util.Map;

public class GatlingFactory {

    private Map<String, Object> MAP = new HashMap<>();

    {
        MAP.put(GatlingTestName.GETUSERLISTPERFTEST.toString(),  new GatlingBuilderImpl());
    }

    public Object getGatling(String className)
    {
        System.out.println(className);
        return MAP.get(className.toUpperCase());
    }
}

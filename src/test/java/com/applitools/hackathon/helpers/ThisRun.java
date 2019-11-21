package com.applitools.hackathon.helpers;

import java.util.HashMap;

public final class ThisRun {
    private static ThisRun thisRun;
    private static HashMap<String, Object> store = new HashMap<>();

    private ThisRun() {
    }

    public static ThisRun getInstance() {
        if (thisRun == null) {
            thisRun = new ThisRun();
        }
        return thisRun;
    }

    public void add(String key, Object value) {
        store.put(key, value);
    }

    public Object get(String key) {
        return store.get(key);
    }
}

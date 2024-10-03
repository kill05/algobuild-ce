package com.github.kill05.algobuildce.package_a.k;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public final class ActionMap {

    private final Map<String, Action> actionMap;

    public ActionMap() {
        this.actionMap = new TreeMap<>();
    }

    public void putAction(String var1, Action var2) {
        this.actionMap.put(var1, var2);
    }

    public Action getAction(String key) {
        Action action = this.actionMap.get(key);

        if (action == null) {
            System.err.println("null ACTION for key:" + key);
        }

        return action;
    }

}

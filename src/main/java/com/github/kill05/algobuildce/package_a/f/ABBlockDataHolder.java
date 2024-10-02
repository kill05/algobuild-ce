package com.github.kill05.algobuildce.package_a.f;

import java.util.TreeMap;

public final class ABBlockDataHolder {

    private final TreeMap<String, String> data = new TreeMap<>();

    public void putData(String key, String value) {
        this.data.put(key, value.replace("\n", "\\n"));
    }

    public String getData(String key) {
        String value = this.data.get(key);

        if (value != null) {
            value = value.replace("\\n", "\n");
        }

        return value;
    }

    public String toString() {
        return "ABPElement [data=" + this.data + "]";
    }
}

package com.flyme.common.base;

import com.flyme.common.utils.ObjectUtils;

import java.util.HashMap;
/**自定义Map*/
public class EntityMap extends HashMap<String, Object> {


    public EntityMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }
    public <T> T get(String key) {
        T t = null;
        Object obj = super.get(key);
        if (ObjectUtils.isNotEmpty(obj)) {
            t = (T) obj;
        }
        return t;
    }
    public <T> T get(String key, T def) {
        Object obj = super.get(key);
        if (ObjectUtils.isNotEmpty(obj)) {
            return (T) obj;
        } else {
            return def;
        }
    }

}

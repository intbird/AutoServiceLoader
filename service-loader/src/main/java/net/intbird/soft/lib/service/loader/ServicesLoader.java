package net.intbird.soft.lib.service.loader;

import java.util.Iterator;
import java.util.ServiceLoader;

public final class ServicesLoader {

    public static <T> T load(Class<T> tClass) {
        Iterator<T> iterator = ServiceLoader.load(tClass)
                .iterator();
        if (iterator.hasNext()) {
            return iterator
                    .next();
        } else {
            return null;
        }
    }
}
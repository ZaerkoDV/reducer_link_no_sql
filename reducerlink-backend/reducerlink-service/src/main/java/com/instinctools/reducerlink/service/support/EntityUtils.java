package com.instinctools.reducerlink.service.support;

import java.util.Arrays;
import java.util.List;

public final class EntityUtils {
    private EntityUtils() {
    }

    public static <T> T getFirst(List<T> list) {
        return ((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static <T> List<T> makeList(T item) {
        return Arrays.asList(item);
    }
}

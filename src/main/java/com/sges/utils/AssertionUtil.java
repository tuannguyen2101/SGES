package com.sges.utils;

import java.util.List;

public class AssertionUtil {
	public static void assertNotNull(Object obj, String messages) throws Exception {
        if (obj != null) return;
        throw new Exception(messages);
    }

    public static void assertNotEmpty(String value, String messages) throws Exception {
        if (value != null && value.length() > 0) return;
        throw new Exception(messages);
    }

    public static boolean isNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }
}

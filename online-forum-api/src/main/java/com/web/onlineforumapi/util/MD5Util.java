package com.web.onlineforumapi.util;

import java.util.UUID;

public class MD5Util {

    public static String returnUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}

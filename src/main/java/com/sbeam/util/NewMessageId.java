
package com.sbeam.util;


public class NewMessageId {

    public static String getMessageId(String name) {
        long time = System.currentTimeMillis();
        int nowtime=(int)(time*-1);
        return name+nowtime;
    }
}
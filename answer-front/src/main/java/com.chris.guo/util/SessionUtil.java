package com.chris.guo.util;



import com.chris.guo.Exception.UnautorizedException;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    private static final String SESSION_USER="username";
    public static String getUser(HttpSession session){
        String username = (String) session.getAttribute(SESSION_USER);
        if(username==null){
            throw new UnautorizedException("this no logged or timed out");
        }
        return username;
    }
}

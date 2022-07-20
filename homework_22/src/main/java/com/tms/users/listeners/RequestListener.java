package com.tms.users.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("--------------Servlet Request is destroyed.-------------------------");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        String remoteAddr = sre.getServletRequest().getRemoteAddr();
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String method = request.getMethod();
        System.out.println("-------------Request from address: "+remoteAddr+"\nMethod:"+method);
    }
}

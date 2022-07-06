package com.tms.users.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/car/cookies")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd|hh-mm-ss");
        String currentTime = format.format(new Date());
        Cookie cookie = new Cookie("lastAccessTime", currentTime);
        resp.addCookie(cookie);

        Cookie[] cookies = req.getCookies();
        String lastVisitTime = null;
        if(cookies!=null){
            for(Cookie el : cookies){
                if("lastAccessTime".equals(el.getName())){
                    lastVisitTime = el.getValue().replace(" ","-");
                }
            }
        }
        resp.getWriter().write("Time of last visit:");
        if(lastVisitTime==null){
            resp.getWriter().write(format.format(LocalDateTime.now()));
        }else{
            resp.getWriter().write(lastVisitTime);
        }

    }

}

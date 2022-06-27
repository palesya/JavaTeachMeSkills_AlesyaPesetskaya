package com.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = format.format(new Date());
        Cookie cookie = new Cookie("lastTime", currentTime);
        resp.addCookie(cookie);

        String lastVisitTime = null;
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(Cookie el : cookies){
                if("lastAccessTime".equals(el.getName())){
                    lastVisitTime = el.getValue().replace(" ", "");
                }
            }
        }
        resp.getWriter().write("Time of last visit:");
        if(lastVisitTime==null){
            resp.getWriter().write(LocalDate.now().toString());
        }else{
            resp.getWriter().write(lastVisitTime);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate date = LocalDate.from(LocalDate.now());
        Cookie currentDate = new Cookie("date", date.toString());
        Cookie userName = new Cookie("user_name", "Alesya");
        resp.addCookie(currentDate);
        resp.addCookie(userName);
    }
}

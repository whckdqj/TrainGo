package kr.traingo.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static boolean setPrevPage(HttpServletRequest request){
        if(request != null){
            String referer = request.getHeader("Referer");
            request.getSession().setAttribute("prevPage", referer);
            return true;
        }
        else{
            return false;
        }
    }
}

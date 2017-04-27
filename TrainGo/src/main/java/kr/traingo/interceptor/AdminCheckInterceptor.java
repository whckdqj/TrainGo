package kr.traingo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
    
    private Logger log = Logger.getLogger(this.getClass());
    
    /* 
     * Enter the Page Call this Handle for Pre-Handle
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Login Check Pre-Handle
    	if(log.isDebugEnabled()){
            log.debug("**TrainGo[DEBUG] : "+this.toString()+"**");
        }
    	
    	HttpSession session = request.getSession();
    	String id = (String)session.getAttribute("userId");
    	int lev = Integer.valueOf(session.getAttribute("userLev")+"");
    	String redirectUrl = (String)session.getAttribute("pagePrev");
    	
    	if(lev==1 && id.equals("admin")){
    	    // ID : admin / Lev : 1
    		return true;
    	}
    	else{
    	    if(redirectUrl!=null){
    	        session.removeAttribute("pagePrev");
    	        response.sendRedirect(redirectUrl);
    	        return false;
    	    }
    	    else{
    	        response.sendRedirect(request.getContextPath()+"/home.do");
    	        return false;
    	    }
    	}
    }
}

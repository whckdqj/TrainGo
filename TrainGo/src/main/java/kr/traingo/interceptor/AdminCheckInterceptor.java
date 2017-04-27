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
    	int lev = Integer.valueOf((String)session.getAttribute("userLev"));
    	
    	if(lev==0 || id==null || id.equals("")){
    	    // ID : X / Lev : X
    	    session.invalidate();
    		response.sendRedirect(request.getContextPath()+"/member/memberLogin.do");
    		return false;
    		
    	}
    	else if((id==null || id.equals("")) && lev==0){
    	    // ID : X / Lev : 0
    	    session.invalidate();
    		response.sendRedirect(request.getContextPath()+"/member/memberWrite.do");
    		return false;
    	}
    	else if((id==null || id.equals("")) && lev==1){
    	    // ID : X / Lev : 1
    	    session.invalidate();
            response.sendRedirect(request.getContextPath()+"/member/memberWrite.do");
    		return false;
    	}
    	else if(id!=null && lev==0){
    	    // ID : O / Lev : X
    	    session.invalidate();
            response.sendRedirect(request.getContextPath()+"/member/memberLogin.do");
            return false;
        }
        else if(id!=null && (lev==0 || lev==1)){
            if(id.equals("admin") && lev==1){
                return true;
            }
            else{
                return false;
            }
        }
    	else{
    	    session.invalidate();
            response.sendRedirect(request.getContextPath()+"/member/memberLogin.do");
            return false;
    	}
    }
}

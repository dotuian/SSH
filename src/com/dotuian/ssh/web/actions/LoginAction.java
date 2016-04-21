package com.dotuian.ssh.web.actions;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dotuian.ssh.web.forms.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	    // 登录session存在，直接跳转到主页
	    if(request.getSession().getAttribute("user") != null) {
	        return mapping.findForward("success");
	    }
	    
		LoginForm loginForm = (LoginForm) form;
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if ("admin".equals(username) && "admin".equals(password)) {
			String remoteAddr = request.getRemoteAddr();
			System.out.println("remoteAddr==" + remoteAddr);
			String[] allowIps = request.getSession().getServletContext().getInitParameter("allow_ip").split(",");
			Arrays.sort(allowIps);
			if (Arrays.binarySearch(allowIps, remoteAddr) < 0) {
				return mapping.findForward("login");
			}
			
			// 登录成功
			request.getSession().setAttribute("user", username);
			return mapping.findForward("success");
		} else {
			// 登录失败
			return mapping.findForward("login");
		}
	}

}

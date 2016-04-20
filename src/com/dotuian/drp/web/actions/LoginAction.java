package com.dotuian.drp.web.actions;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.dotuian.drp.web.forms.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		LoginForm laf = (LoginForm) form;
		String username = laf.getUsername();
		String password = laf.getPassword();
		
		if ("admin".equals(username) && "admin".equals(password)) {
			String remoteAddr = request.getRemoteAddr();
			System.out.println("remoteAddr==" + remoteAddr);
			String[] allowIps = request.getSession().getServletContext().getInitParameter("allow_ip").split(",");
			Arrays.sort(allowIps);
			if (Arrays.binarySearch(allowIps, remoteAddr) < 0) {
				return mapping.findForward("index");
			}
			
			// 登录成功
			request.getSession().setAttribute("user", username);
			return mapping.findForward("success");
		} else {
			// 登录失败
			return mapping.findForward("index");
		}
	}

}

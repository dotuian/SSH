package com.dotuian.ssh.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


/**
 * Action的基类
 * @author SHOU
 */
public class BaseAction extends DispatchAction {

    /**
     * 用户检测当前用户是否登录。
     */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getSession().getAttribute("user") == null) {
			return mapping.findForward("login");
		}
		return super.execute(mapping, form, request, response);
	}
}

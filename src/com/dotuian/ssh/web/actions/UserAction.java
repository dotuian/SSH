package com.dotuian.ssh.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dotuian.ssh.domain.User;
import com.dotuian.ssh.service.UserService;
import com.dotuian.ssh.web.forms.UserForm;

public class UserAction extends BaseAction {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * url后面没有指定参数时，执行的方法
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<User> userlist = this.userService.getAllUsers();
		request.setAttribute("userlist", userlist);

		return mapping.findForward("userlist");
	}
	
	/**
	 * 查询
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String key = request.getParameter("key");
		List<User> userlist = this.userService.findUsersByValue(key);
		request.setAttribute("userlist", userlist);

		return mapping.findForward("userlist");
	}

    /**
     * 用户一览
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<User> userlist = this.userService.getAllUsers();
		request.setAttribute("userlist", userlist);

		return mapping.findForward("userlist");
	}

	/**
	 * 用户详细信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward showDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;

		User user = this.userService.getUserById(userForm.getId());
		request.setAttribute("user", user);

		// 跳转到用户详细画面
		return mapping.findForward("userdetail");
	}

    /**
     * 创建用户页面
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward createuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserForm userForm = new UserForm();
		request.setAttribute("userForm", userForm);
		
		// 操作完成之后，跳转到用户列表页面
		return mapping.findForward("createuser");
	}
	
    /**
     * 创建用户
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		String username = userForm.getUsername();
		String password = userForm.getPassword();
		String email = userForm.getEmail();

		this.userService.createUser(username, password, email);

		// 操作完成之后，跳转到用户列表页面
		return mapping.findForward("index");
	}

    /**
     * 删除用户
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward deleteuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		this.userService.deleteUserById(userForm.getId());

		// 操作完成之后，跳转到用户列表页面
		return mapping.findForward("index");
	}

    /**
     * 更新用户页面
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward updateuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;

		User user = this.userService.getUserById(userForm.getId());
		request.setAttribute("user", user);

		return mapping.findForward("updateuser");
	}

    /**
     * 更新确认页面
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward confirmuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;

		User user = this.userService.getUserById(userForm.getId());
		request.setAttribute("user", user);
		request.setAttribute("form", userForm);

		return mapping.findForward("confirmuser");
	}

    /**
     * 更新用户信息
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;

		this.userService.updateUser(userForm.getId(), userForm.getUsername(), userForm.getPassword(),
				userForm.getEmail());

		return mapping.findForward("index");
	}

}

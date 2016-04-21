package com.dotuian.drp.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dotuian.drp.domain.Item;
import com.dotuian.drp.domain.User;
import com.dotuian.drp.service.UserService;
import com.dotuian.drp.web.forms.UserForm;

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

	public ActionForward query(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String key = request.getParameter("key");
		List<User> userlist = this.userService.findUsersByValue(key);
		request.setAttribute("userlist", userlist);

		return mapping.findForward("userlist");
	}

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<User> userlist = this.userService.getAllUsers();
		request.setAttribute("userlist", userlist);

		return mapping.findForward("userlist");
	}

	/**
	 * 显示详细信息
	 * 
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

	public ActionForward createuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserForm userForm = new UserForm();
		request.setAttribute("userForm", userForm);
		
		// 操作完成之后，跳转到用户列表页面
		return mapping.findForward("createuser");
	}
	
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

	public ActionForward deleteuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		this.userService.deleteUserById(userForm.getId());

		// 操作完成之后，跳转到用户列表页面
		return mapping.findForward("index");
	}

	public ActionForward updateuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;

		User user = this.userService.getUserById(userForm.getId());
		request.setAttribute("user", user);

		return mapping.findForward("updateuser");
	}

	public ActionForward confirmuser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;

		User user = this.userService.getUserById(userForm.getId());
		request.setAttribute("user", user);
		request.setAttribute("form", userForm);

		return mapping.findForward("confirmuser");
	}

	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;

		this.userService.updateUser(userForm.getId(), userForm.getUsername(), userForm.getPassword(),
				userForm.getEmail());

		return mapping.findForward("index");
	}

	//
	// @Override
	// protected ActionForward unspecified(ActionMapping mapping, ActionForm
	// form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// ItemActionForm iaf = (ItemActionForm)form;
	// int pageNo = iaf.getPageNo();
	// int pageSize =
	// Integer.parseInt(request.getSession().getServletContext().getInitParameter("page-size"));
	// String queryString = iaf.getClientIdOrName();
	//
	// PageModel pageModel = itemService.findAllItem(queryString, pageNo,
	// pageSize);
	// request.setAttribute("pageModel", pageModel);
	// return mapping.findForward("list");
	// }
	//
	// /**
	// * 显示添加页面
	// * @param mapping
	// * @param form
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// public ActionForward showAdd(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// //DataDictService dataDictService =
	// (DataDictService)BeanFactory.getInstance().getBean(DataDictService.class);
	// List itemCategoryList = dataDictService.getItemCategoryList();
	// List itemUnitList = dataDictService.getItemUnitList();
	// request.setAttribute("itemCategoryList", itemCategoryList);
	// request.setAttribute("itemUnitList", itemUnitList);
	// return mapping.findForward("show_add");
	// }
	//
	// /**
	// * 添加
	// * @param mapping
	// * @param form
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// public ActionForward add(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// ItemActionForm iaf = (ItemActionForm)form;
	// Item item = new Item();
	// BeanUtils.copyProperties(item, iaf);
	//
	// ItemCategory itemCategory = new ItemCategory();
	// itemCategory.setId(iaf.getCategory());
	// item.setItemCategory(itemCategory);
	//
	// ItemUnit itemUnit = new ItemUnit();
	// itemUnit.setId(iaf.getUnit());
	// item.setItemUnit(itemUnit);
	//
	// //ItemService itemService =
	// (ItemService)BeanFactory.getInstance().getBean(ItemService.class);
	// itemService.addItem(item);
	// return mapping.findForward("item_index");
	// }
	//
	// /**
	// * 删除
	// * @param mapping
	// * @param form
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// public ActionForward del(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// ItemActionForm iaf = (ItemActionForm)form;
	// //ItemService itemService =
	// (ItemService)BeanFactory.getInstance().getBean(ItemService.class);
	// itemService.delItem(iaf.getSelectFlag());
	// return mapping.findForward("item_index");
	// }
	//
	// /**
	// * 显示修改
	// * @param mapping
	// * @param form
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// public ActionForward showModify(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// ItemActionForm iaf = (ItemActionForm)form;
	// //ItemService itemService =
	// (ItemService)BeanFactory.getInstance().getBean(ItemService.class);
	// Item item = itemService.findItemById(iaf.getItemNo());
	// request.setAttribute("item", item);
	//
	// //DataDictService dataDictService =
	// (DataDictService)BeanFactory.getInstance().getBean(DataDictService.class);
	// List itemCategoryList = dataDictService.getItemCategoryList();
	// List itemUnitList = dataDictService.getItemUnitList();
	// request.setAttribute("itemCategoryList", itemCategoryList);
	// request.setAttribute("itemUnitList", itemUnitList);
	// return mapping.findForward("show_modify");
	// }
	//
	// /**
	// * 修改
	// * @param mapping
	// * @param form
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// public ActionForward modify(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// ItemActionForm iaf = (ItemActionForm)form;
	// Item item = new Item();
	// BeanUtils.copyProperties(item, iaf);
	//
	// ItemCategory itemCategory = new ItemCategory();
	// itemCategory.setId(iaf.getCategory());
	// item.setItemCategory(itemCategory);
	//
	// ItemUnit itemUnit = new ItemUnit();
	// itemUnit.setId(iaf.getUnit());
	// item.setItemUnit(itemUnit);
	// //ItemService itemService =
	// (ItemService)BeanFactory.getInstance().getBean(ItemService.class);
	// itemService.modifyItem(item);
	// return mapping.findForward("item_index");
	// }
	//
	// /**
	// * 显示上传
	// * @param mapping
	// * @param form
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// public ActionForward showUpload(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// ItemActionForm iaf = (ItemActionForm)form;
	// //ItemService itemService =
	// (ItemService)BeanFactory.getInstance().getBean(ItemService.class);
	// Item item = itemService.findItemById(iaf.getItemNo());
	// request.setAttribute("item", item);
	//
	// return mapping.findForward("show_upload");
	// }
	//
	// /**
	// * 上传
	// * @param mapping
	// * @param form
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// public ActionForward upload(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// ItemActionForm iaf = (ItemActionForm)form;
	// String itemNo = iaf.getItemNo();
	// FormFile myFile = iaf.getItemFile();
	// String fileName = myFile.getFileName();
	// //ItemService itemService =
	// (ItemService)BeanFactory.getInstance().getBean(ItemService.class);
	// itemService.modifyUploadFileNameField(itemNo, fileName);
	//
	// String realPath =
	// request.getSession().getServletContext().getRealPath("/images");
	// FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);
	// fos.write(myFile.getFileData());
	// fos.flush();
	// fos.close();
	// return mapping.findForward("item_index");
	// }
	//
	// /**
	// * 显示详细信息
	// * @param mapping
	// * @param form
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// public ActionForward showDetail(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// ItemActionForm iaf = (ItemActionForm)form;
	// //ItemService itemService =
	// (ItemService)BeanFactory.getInstance().getBean(ItemService.class);
	// Item item = itemService.findItemById(iaf.getItemNo());
	// request.setAttribute("item", item);
	//
	// return mapping.findForward("show_detail");
	// }

}

package com.dotuian.drp.dao;

import com.dotuian.drp.PageModel;
import com.dotuian.drp.domain.Item;

/**
 * ItemDao接口
 * 
 * @author Administrator
 * 
 */
public interface ItemDao {

	/**
	 * 添加物料
	 * 
	 * @param conn
	 * @param item
	 */
	public void addItem(Item item);

	/**
	 * 根据id查询
	 * 
	 * @param conn
	 * @param itemNo
	 * @return 如果存在返回Item对象，否则返回null
	 */
	public Item findItemById(String itemNo);

	/**
	 * 分页查询
	 * 
	 * @param conn
	 * @param queryString
	 *            查询条件（物料代码或名称）
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel findAllItem(String queryString, int pageNo, int pageSize);
	
	public int getTotalRecords(String queryString);

	
	/**
	 * 修改物料
	 * 
	 * @param conn
	 * @param item
	 */
	public void modifyItem(Item item);

	/**
	 * 修改物料
	 * 
	 * @param conn
	 * @param item
	 */
	public void delItem(String[] itemNos);

	/**
	 * 保存上传的文件名称
	 * 
	 * @param conn
	 * @param itemNo
	 * @param uploadFileName
	 */
	public void modifyUploadFileNameField(String itemNo, String uploadFileName);
}

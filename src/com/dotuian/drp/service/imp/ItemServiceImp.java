package com.dotuian.drp.service.imp;

import com.dotuian.drp.AppException;
import com.dotuian.drp.PageModel;
import com.dotuian.drp.dao.DataDictDao;
import com.dotuian.drp.dao.ItemDao;
import com.dotuian.drp.domain.Item;
import com.dotuian.drp.service.ItemService;

public class ItemServiceImp implements ItemService {

	private ItemDao itemDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public void addItem(Item item) {
		try
		{
			itemDao.addItem(item);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AppException("操作失败");
			
		}

	}

	@Override
	public void delItem(String[] itemNos) {
		try
		{
			itemDao.delItem(itemNos);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AppException("操作失败");
			
		}
	}

	@Override
	public PageModel findAllItem(String queryString, int pageNo, int pageSize) {
		try
		{
			return itemDao.findAllItem(queryString, pageNo, pageSize);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AppException("操作失败");
			
		}
	}

	@Override
	public Item findItemById(String itemNo) {
		try
		{
			return itemDao.findItemById(itemNo);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AppException("操作失败");
			
		}
	}

	@Override
	public void modifyItem(Item item) {
		try
		{
			itemDao.modifyItem(item);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AppException("操作失败");
			
		}

	}

	@Override
	public void modifyUploadFileNameField(String itemNo, String uploadFileName) {
		try
		{
			itemDao.modifyUploadFileNameField(itemNo, uploadFileName);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AppException("操作失败");
			
		}

	}

}

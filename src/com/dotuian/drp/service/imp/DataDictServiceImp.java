package com.dotuian.drp.service.imp;

import java.util.List;

import com.dotuian.drp.AppException;
import com.dotuian.drp.dao.DataDictDao;
import com.dotuian.drp.domain.ItemCategory;
import com.dotuian.drp.domain.ItemUnit;
import com.dotuian.drp.service.DataDictService;

public class DataDictServiceImp implements DataDictService {

	private DataDictDao dataDictDao;
	
	
	public void setDataDictDao(DataDictDao dataDictDao) {
		this.dataDictDao = dataDictDao;
	}

	@Override
	public List<ItemCategory> getItemCategoryList() {
		try
		{
			return dataDictDao.getItemCategoryList();
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AppException("操作失败");
		}
	}

	@Override
	public List<ItemUnit> getItemUnitList() {
		try
		{
			return dataDictDao.getItemUnitList();
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AppException("操作失败");
		}
	}

}

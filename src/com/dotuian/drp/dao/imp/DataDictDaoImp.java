package com.dotuian.drp.dao.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dotuian.drp.dao.DataDictDao;
import com.dotuian.drp.domain.ItemCategory;
import com.dotuian.drp.domain.ItemUnit;

public class DataDictDaoImp extends HibernateDaoSupport implements DataDictDao {

	@Override
	public List<ItemCategory> getItemCategoryList() {
		return getHibernateTemplate().find("from ItemCategory");
	}

	@Override
	public List<ItemUnit> getItemUnitList() {
		return getHibernateTemplate().find("from ItemUnit");
	}

}

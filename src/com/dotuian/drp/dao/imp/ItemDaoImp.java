package com.dotuian.drp.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dotuian.drp.PageModel;
import com.dotuian.drp.dao.ItemDao;
import com.dotuian.drp.domain.Item;

public class ItemDaoImp extends HibernateDaoSupport implements ItemDao {

	@Override
	public void addItem(Item item) {
		this.getSession().save(item);
	}

	@Override
	public void delItem(String[] itemNos) {
		for (int i=0; i<itemNos.length; i++) {
			getHibernateTemplate().delete( 
					getHibernateTemplate().load(Item.class, itemNos[i])
			);
		}
	}

	@Override
	public PageModel findAllItem(final String queryString, final int pageNo, final int pageSize) {
		List itemList = new ArrayList();
		if (queryString != null && !"".equals(queryString)) {
			itemList = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from Item i where i.itemNo like ? i.itemName like ? order by i.itemNo")
								.setParameter(0, queryString + "%")
								.setParameter(1, queryString + "%")
								.setFirstResult((pageNo-1) * pageSize)
								.setMaxResults(pageSize)
								.list();
				}
			});
			
		}else {
			itemList = getHibernateTemplate().executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createQuery("from Item i join fetch i.itemCategory join fetch i.itemUnit order by i.itemNo")
								.setFirstResult((pageNo-1) * pageSize)
								.setMaxResults(pageSize)
								.list();
				}
			});
		}
		PageModel pageModel = new PageModel();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		pageModel.setList(itemList);
		pageModel.setTotalRecords(getTotalRecords(queryString));
		return pageModel;
	}

	@Override
	public Item findItemById(String itemNo) {
		return (Item)this.getSession().load(Item.class,itemNo);
	}

	@Override
	public void modifyItem(Item item) {
		this.getSession().update(item);
	}

	@Override
	public int getTotalRecords(String queryString) {
//		List list = new ArrayList();
//		if (queryString != null && !"".equals(queryString)) {
//			list = getHibernateTemplate().find("select count(*) from Item i where i.itemNo like ? i.itemName like ?", 
//					new Object[]{queryString + "%", queryString + "%"});
//		}else {
//			list = getHibernateTemplate().find("select count(*) from Item i");
//		}
//		return ((Long)list.get(0)).intValue();
		
		int count = 0;
		if (queryString != null && !"".equals(queryString)) {
			count = ((Long)getSession().createQuery("select count(*) from Item i where i.itemNo like ? i.itemName like ?")
							.setParameter(0, queryString + "%")
							.setParameter(1, queryString + "%")
							.uniqueResult()).intValue();
		}else {
			count = ((Long)getSession().createQuery("select count(*) from Item i")
					.uniqueResult()).intValue();
		}
		return count;
	}

	@Override
	public void modifyUploadFileNameField(String itemNo, String uploadFileName) {
		Item item=(Item)this.getSession().load(Item.class,itemNo);
		item.setUploadFileName(uploadFileName);
	}

}

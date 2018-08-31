package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HqlDAO extends HibernateDaoSupport{
	
	
	public FullTextSession getFullTextSession(){
		Session session=getHibernateSession();
		FullTextSession fullTextSession=Search.createFullTextSession(session);
		return fullTextSession;
	}
	
	public int update(String hql, Object[] params) {
		return getHibernateTemplate().bulkUpdate(hql, params);
	}
	
	
	
	
	
	
	
	public List query(String hql,Object ...p)
	{
		return super.getHibernateTemplate().find(hql,p);
	}
	public List findByHQL(final String hql,final Object ...p)
	{
		List list=getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery(hql);
				for (int i = 0; i < p.length; i++) {
					query.setParameter(i, p[i]);
				}
				return query.list();
			}
			
		});
		return list;
	}
	public int zsg(String hql, Object ...p)
	{
		return super.getHibernateTemplate().bulkUpdate(hql,p);
	}
	public Session getHibernateSession()
	{
		Session session=super.getHibernateTemplate().execute(new HibernateCallback<Session>() {
			
			public Session doInHibernate(Session s)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				return s;
			}
		});
		return session;
	}
	public List pageQuery(String hql, int size,int page , Object ...p)
	{
		try {
			Session session=getHibernateSession();
			Query query=session.createQuery(hql);
			if(p!=null)
			{
				for (int i = 0; i < p.length; i++) {
					query.setParameter(i, p[i]);
				}
			}
			query.setFirstResult((page-1)*size).setMaxResults(size);
			List list=query.list();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList();
	}
	public void bulkUpdate(String hql, Object... p) {
		getHibernateTemplate().bulkUpdate(hql, p);
	}
	 public float unique(final String hql ,final Object...p) {
			
		 List list = query(hql, p);
		 
			if (list.size()>0)
			{
				Object obj = list.get(0);
				if (obj!=null){
					return Float.parseFloat(obj.toString());
				}
			}
			return 0;
	 }
	 public List sqlPageCreateQuery(String sql, int page, int size, Object... p) {
			Session session = getHibernateSession();
			Query query = session.createSQLQuery(sql);
			if (p != null) {
				for (int i = 0; i < p.length; i++) {
					query.setParameter(i, p[i]);
				}
			}
			query.setFirstResult((page - 1) * size).setMaxResults(size);
			List list = query.list();
			return list;
		}

		public List sqlCreateQuery(String sql, Object... p) {
			Session session = getHibernateSession();
			Query query = session.createSQLQuery(sql);
			if (p != null) {
				for (int i = 0; i < p.length; i++) {
					query.setParameter(i, p[i]);
				}
			}
			List list = query.list();
			return list;
		}
	
}

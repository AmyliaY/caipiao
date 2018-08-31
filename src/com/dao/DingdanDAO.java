package com.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Dingdan;

/**
 * A data access object (DAO) providing persistence and search support for
 * Dingdan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pojo.Dingdan
 * @author MyEclipse Persistence Tools
 */
public class DingdanDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(DingdanDAO.class);
	// property constants
	public static final String NUM = "num";
	public static final String MONEY = "money";
	public static final String STATUS = "status";

	protected void initDao() {
		// do nothing
	}

	public void save(Dingdan transientInstance) {
		log.debug("saving Dingdan instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dingdan persistentInstance) {
		log.debug("deleting Dingdan instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dingdan findById(java.lang.String id) {
		log.debug("getting Dingdan instance with id: " + id);
		try {
			Dingdan instance = (Dingdan) getHibernateTemplate().get("com.pojo.Dingdan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dingdan instance) {
		log.debug("finding Dingdan instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Dingdan instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Dingdan as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Dingdan instances");
		try {
			String queryString = "from Dingdan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dingdan merge(Dingdan detachedInstance) {
		log.debug("merging Dingdan instance");
		try {
			Dingdan result = (Dingdan) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dingdan instance) {
		log.debug("attaching dirty Dingdan instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dingdan instance) {
		log.debug("attaching clean Dingdan instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DingdanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DingdanDAO) ctx.getBean("DingdanDAO");
	}
}
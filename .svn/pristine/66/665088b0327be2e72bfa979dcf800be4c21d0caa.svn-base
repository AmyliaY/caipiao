package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Userstixian;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userstixian entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.Userstixian
 * @author MyEclipse Persistence Tools
 */
public class UserstixianDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(UserstixianDAO.class);
	// property constants
	public static final String MONEY = "money";
	public static final String STATUS = "status";
	public static final String DID = "did";
	public static final String RETURN_ID = "returnId";

	protected void initDao() {
		// do nothing
	}

	public void save(Userstixian transientInstance) {
		log.debug("saving Userstixian instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userstixian persistentInstance) {
		log.debug("deleting Userstixian instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userstixian findById(java.lang.Integer id) {
		log.debug("getting Userstixian instance with id: " + id);
		try {
			Userstixian instance = (Userstixian) getHibernateTemplate().get("com.pojo.Userstixian", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userstixian instance) {
		log.debug("finding Userstixian instance by example");
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
		log.debug("finding Userstixian instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Userstixian as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByDid(Object did) {
		return findByProperty(DID, did);
	}

	public List findByReturnId(Object returnId) {
		return findByProperty(RETURN_ID, returnId);
	}

	public List findAll() {
		log.debug("finding all Userstixian instances");
		try {
			String queryString = "from Userstixian";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userstixian merge(Userstixian detachedInstance) {
		log.debug("merging Userstixian instance");
		try {
			Userstixian result = (Userstixian) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userstixian instance) {
		log.debug("attaching dirty Userstixian instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userstixian instance) {
		log.debug("attaching clean Userstixian instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserstixianDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserstixianDAO) ctx.getBean("UserstixianDAO");
	}
}
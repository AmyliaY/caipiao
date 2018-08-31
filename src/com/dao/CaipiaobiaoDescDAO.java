package com.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.CaipiaobiaoDesc;

/**
 * A data access object (DAO) providing persistence and search support for
 * CaipiaobiaoDesc entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.CaipiaobiaoDesc
 * @author MyEclipse Persistence Tools
 */
public class CaipiaobiaoDescDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CaipiaobiaoDescDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String STATUS = "status";
	public static final String JIANGCHI = "jiangchi";

	protected void initDao() {
		// do nothing
	}

	public void save(CaipiaobiaoDesc transientInstance) {
		log.debug("saving CaipiaobiaoDesc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CaipiaobiaoDesc persistentInstance) {
		log.debug("deleting CaipiaobiaoDesc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CaipiaobiaoDesc findById(java.lang.Integer id) {
		log.debug("getting CaipiaobiaoDesc instance with id: " + id);
		try {
			CaipiaobiaoDesc instance = (CaipiaobiaoDesc) getHibernateTemplate().get("com.pojo.CaipiaobiaoDesc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CaipiaobiaoDesc instance) {
		log.debug("finding CaipiaobiaoDesc instance by example");
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
		log.debug("finding CaipiaobiaoDesc instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CaipiaobiaoDesc as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByJiangchi(Object jiangchi) {
		return findByProperty(JIANGCHI, jiangchi);
	}

	public List findAll() {
		log.debug("finding all CaipiaobiaoDesc instances");
		try {
			String queryString = "from CaipiaobiaoDesc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CaipiaobiaoDesc merge(CaipiaobiaoDesc detachedInstance) {
		log.debug("merging CaipiaobiaoDesc instance");
		try {
			CaipiaobiaoDesc result = (CaipiaobiaoDesc) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CaipiaobiaoDesc instance) {
		log.debug("attaching dirty CaipiaobiaoDesc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CaipiaobiaoDesc instance) {
		log.debug("attaching clean CaipiaobiaoDesc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CaipiaobiaoDescDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CaipiaobiaoDescDAO) ctx.getBean("CaipiaobiaoDescDAO");
	}
}
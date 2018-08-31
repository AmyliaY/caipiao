package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Userschongzhijilu;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userschongzhijilu entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.Userschongzhijilu
 * @author MyEclipse Persistence Tools
 */
public class UserschongzhijiluDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(UserschongzhijiluDAO.class);
	// property constants
	public static final String MONEY = "money";
	public static final String STATUS = "status";
	public static final String TYPE = "type";
	public static final String DID = "did";
	public static final String RETURN_ID = "returnId";

	protected void initDao() {
		// do nothing
	}

	public void save(Userschongzhijilu transientInstance) {
		log.debug("saving Userschongzhijilu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userschongzhijilu persistentInstance) {
		log.debug("deleting Userschongzhijilu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userschongzhijilu findById(java.lang.Integer id) {
		log.debug("getting Userschongzhijilu instance with id: " + id);
		try {
			Userschongzhijilu instance = (Userschongzhijilu) getHibernateTemplate().get("com.pojo.Userschongzhijilu",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userschongzhijilu instance) {
		log.debug("finding Userschongzhijilu instance by example");
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
		log.debug("finding Userschongzhijilu instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Userschongzhijilu as model where model." + propertyName + "= ?";
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

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByDid(Object did) {
		return findByProperty(DID, did);
	}

	public List findByReturnId(Object returnId) {
		return findByProperty(RETURN_ID, returnId);
	}

	public List findAll() {
		log.debug("finding all Userschongzhijilu instances");
		try {
			String queryString = "from Userschongzhijilu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userschongzhijilu merge(Userschongzhijilu detachedInstance) {
		log.debug("merging Userschongzhijilu instance");
		try {
			Userschongzhijilu result = (Userschongzhijilu) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userschongzhijilu instance) {
		log.debug("attaching dirty Userschongzhijilu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userschongzhijilu instance) {
		log.debug("attaching clean Userschongzhijilu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserschongzhijiluDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserschongzhijiluDAO) ctx.getBean("UserschongzhijiluDAO");
	}
}
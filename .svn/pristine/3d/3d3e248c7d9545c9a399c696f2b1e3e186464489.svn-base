package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Appversion;

/**
 * A data access object (DAO) providing persistence and search support for
 * Appversion entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pojo.Appversion
 * @author MyEclipse Persistence Tools
 */

public class AppversionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AppversionDAO.class);
	// property constants
	public static final String AVAPPID = "avappid";
	public static final String AVURL = "avurl";
	public static final String AVERSION = "aversion";
	public static final String AVTYPE = "avtype";

	protected void initDao() {
		// do nothing
	}

	public void save(Appversion transientInstance) {
		log.debug("saving Appversion instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Appversion persistentInstance) {
		log.debug("deleting Appversion instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Appversion findById(java.lang.Integer id) {
		log.debug("getting Appversion instance with id: " + id);
		try {
			Appversion instance = (Appversion) getHibernateTemplate().get(
					"com.pojo.Appversion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Appversion instance) {
		log.debug("finding Appversion instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Appversion instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Appversion as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAvappid(Object avappid) {
		return findByProperty(AVAPPID, avappid);
	}

	public List findByAvurl(Object avurl) {
		return findByProperty(AVURL, avurl);
	}

	public List findByAversion(Object aversion) {
		return findByProperty(AVERSION, aversion);
	}

	public List findByAvtype(Object avtype) {
		return findByProperty(AVTYPE, avtype);
	}

	public List findAll() {
		log.debug("finding all Appversion instances");
		try {
			String queryString = "from Appversion";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Appversion merge(Appversion detachedInstance) {
		log.debug("merging Appversion instance");
		try {
			Appversion result = (Appversion) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Appversion instance) {
		log.debug("attaching dirty Appversion instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Appversion instance) {
		log.debug("attaching clean Appversion instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AppversionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AppversionDAO) ctx.getBean("AppversionDAO");
	}
}
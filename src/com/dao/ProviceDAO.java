package com.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Provice;

/**
 * A data access object (DAO) providing persistence and search support for
 * Provice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pojo.Provice
 * @author MyEclipse Persistence Tools
 */

public class ProviceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ProviceDAO.class);
	// property constants
	public static final String PR_NAME = "prName";

	protected void initDao() {
		// do nothing
	}

	public void save(Provice transientInstance) {
		log.debug("saving Provice instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Provice persistentInstance) {
		log.debug("deleting Provice instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Provice findById(java.lang.Integer id) {
		log.debug("getting Provice instance with id: " + id);
		try {
			Provice instance = (Provice) getHibernateTemplate().get(
					"com.pojo.Provice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Provice instance) {
		log.debug("finding Provice instance by example");
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
		log.debug("finding Provice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Provice as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPrName(Object prName) {
		return findByProperty(PR_NAME, prName);
	}

	public List findAll() {
		log.debug("finding all Provice instances");
		try {
			String queryString = "from Provice";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Provice merge(Provice detachedInstance) {
		log.debug("merging Provice instance");
		try {
			Provice result = (Provice) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Provice instance) {
		log.debug("attaching dirty Provice instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Provice instance) {
		log.debug("attaching clean Provice instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProviceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProviceDAO) ctx.getBean("ProviceDAO");
	}
}
package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Caipiandianyuangong;

/**
 * A data access object (DAO) providing persistence and search support for
 * Caipiandianyuangong entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.Caipiandianyuangong
 * @author MyEclipse Persistence Tools
 */

public class CaipiandianyuangongDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CaipiandianyuangongDAO.class);
	// property constants
	public static final String SHOUJIHAO = "shoujihao";
	public static final String MIMA = "mima";
	public static final String ZHUANGTAI = "zhuangtai";
	public static final String IMAGE = "image";

	protected void initDao() {
		// do nothing
	}

	public void save(Caipiandianyuangong transientInstance) {
		log.debug("saving Caipiandianyuangong instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Caipiandianyuangong persistentInstance) {
		log.debug("deleting Caipiandianyuangong instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Caipiandianyuangong findById(java.lang.Integer id) {
		log.debug("getting Caipiandianyuangong instance with id: " + id);
		try {
			Caipiandianyuangong instance = (Caipiandianyuangong) getHibernateTemplate()
					.get("com.pojo.Caipiandianyuangong", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Caipiandianyuangong instance) {
		log.debug("finding Caipiandianyuangong instance by example");
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
		log.debug("finding Caipiandianyuangong instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Caipiandianyuangong as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShoujihao(Object shoujihao) {
		return findByProperty(SHOUJIHAO, shoujihao);
	}

	public List findByMima(Object mima) {
		return findByProperty(MIMA, mima);
	}

	public List findByZhuangtai(Object zhuangtai) {
		return findByProperty(ZHUANGTAI, zhuangtai);
	}

	public List findByImage(Object image) {
		return findByProperty(IMAGE, image);
	}

	public List findAll() {
		log.debug("finding all Caipiandianyuangong instances");
		try {
			String queryString = "from Caipiandianyuangong";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Caipiandianyuangong merge(Caipiandianyuangong detachedInstance) {
		log.debug("merging Caipiandianyuangong instance");
		try {
			Caipiandianyuangong result = (Caipiandianyuangong) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Caipiandianyuangong instance) {
		log.debug("attaching dirty Caipiandianyuangong instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Caipiandianyuangong instance) {
		log.debug("attaching clean Caipiandianyuangong instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CaipiandianyuangongDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CaipiandianyuangongDAO) ctx.getBean("CaipiandianyuangongDAO");
	}
}
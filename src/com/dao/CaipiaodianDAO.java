package com.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Caipiaodian;

/**
 * A data access object (DAO) providing persistence and search support for
 * Caipiaodian entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.Caipiaodian
 * @author MyEclipse Persistence Tools
 */
public class CaipiaodianDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CaipiaodianDAO.class);
	// property constants
	public static final String CLIENT_ID = "clientId";
	public static final String NAME = "name";
	public static final String ISTICAI = "isticai";
	public static final String ISFUCAI = "isfucai";
	public static final String PHONE = "phone";
	public static final String PASSWORD = "password";
	public static final String IMGID = "imgid";
	public static final String KETIXIAN = "ketixian";
	public static final String DONGJIE = "dongjie";
	public static final String YITIXIAN = "yitixian";
	public static final String ADDRESS = "address";
	public static final String JINGDU = "jingdu";
	public static final String WEIDU = "weidu";
	public static final String BEGINGTIME = "begingtime";
	public static final String ENDTIME = "endtime";
	public static final String STATUS = "status";

	protected void initDao() {
		// do nothing
	}

	public void save(Caipiaodian transientInstance) {
		log.debug("saving Caipiaodian instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Caipiaodian persistentInstance) {
		log.debug("deleting Caipiaodian instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Caipiaodian findById(java.lang.Integer id) {
		log.debug("getting Caipiaodian instance with id: " + id);
		try {
			Caipiaodian instance = (Caipiaodian) getHibernateTemplate().get("com.pojo.Caipiaodian", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Caipiaodian instance) {
		log.debug("finding Caipiaodian instance by example");
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
		log.debug("finding Caipiaodian instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Caipiaodian as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClientId(Object clientId) {
		return findByProperty(CLIENT_ID, clientId);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByIsticai(Object isticai) {
		return findByProperty(ISTICAI, isticai);
	}

	public List findByIsfucai(Object isfucai) {
		return findByProperty(ISFUCAI, isfucai);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByImgid(Object imgid) {
		return findByProperty(IMGID, imgid);
	}

	public List findByKetixian(Object ketixian) {
		return findByProperty(KETIXIAN, ketixian);
	}

	public List findByDongjie(Object dongjie) {
		return findByProperty(DONGJIE, dongjie);
	}

	public List findByYitixian(Object yitixian) {
		return findByProperty(YITIXIAN, yitixian);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByJingdu(Object jingdu) {
		return findByProperty(JINGDU, jingdu);
	}

	public List findByWeidu(Object weidu) {
		return findByProperty(WEIDU, weidu);
	}

	public List findByBegingtime(Object begingtime) {
		return findByProperty(BEGINGTIME, begingtime);
	}

	public List findByEndtime(Object endtime) {
		return findByProperty(ENDTIME, endtime);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Caipiaodian instances");
		try {
			String queryString = "from Caipiaodian";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Caipiaodian merge(Caipiaodian detachedInstance) {
		log.debug("merging Caipiaodian instance");
		try {
			Caipiaodian result = (Caipiaodian) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Caipiaodian instance) {
		log.debug("attaching dirty Caipiaodian instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Caipiaodian instance) {
		log.debug("attaching clean Caipiaodian instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CaipiaodianDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CaipiaodianDAO) ctx.getBean("CaipiaodianDAO");
	}
}
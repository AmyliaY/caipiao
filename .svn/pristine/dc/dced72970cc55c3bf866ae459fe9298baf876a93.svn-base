package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Dingdanxiangqing;

/**
 * A data access object (DAO) providing persistence and search support for
 * Dingdanxiangqing entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.Dingdanxiangqing
 * @author MyEclipse Persistence Tools
 */
public class DingdanxiangqingDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(DingdanxiangqingDAO.class);
	// property constants
	public static final String HONGQIU1 = "hongqiu1";
	public static final String HONGQIU2 = "hongqiu2";
	public static final String HONGQIU3 = "hongqiu3";
	public static final String HONGQIU4 = "hongqiu4";
	public static final String HONGQIU5 = "hongqiu5";
	public static final String HONGQIU6 = "hongqiu6";
	public static final String LANQIU = "lanqiu";
	public static final String ZHUSHU = "zhushu";
	public static final String BEISHU = "beishu";
	public static final String IS_ZHONGJIANG = "isZhongjiang";
	public static final String ZHONGJIANGJINE = "zhongjiangjine";
	public static final String IS_LINGJIANG = "isLingjiang";
	public static final String PAY_MONEY = "payMoney";

	protected void initDao() {
		// do nothing
	}

	public void save(Dingdanxiangqing transientInstance) {
		log.debug("saving Dingdanxiangqing instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dingdanxiangqing persistentInstance) {
		log.debug("deleting Dingdanxiangqing instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dingdanxiangqing findById(java.lang.Integer id) {
		log.debug("getting Dingdanxiangqing instance with id: " + id);
		try {
			Dingdanxiangqing instance = (Dingdanxiangqing) getHibernateTemplate().get("com.pojo.Dingdanxiangqing", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dingdanxiangqing instance) {
		log.debug("finding Dingdanxiangqing instance by example");
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
		log.debug("finding Dingdanxiangqing instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Dingdanxiangqing as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHongqiu1(Object hongqiu1) {
		return findByProperty(HONGQIU1, hongqiu1);
	}

	public List findByHongqiu2(Object hongqiu2) {
		return findByProperty(HONGQIU2, hongqiu2);
	}

	public List findByHongqiu3(Object hongqiu3) {
		return findByProperty(HONGQIU3, hongqiu3);
	}

	public List findByHongqiu4(Object hongqiu4) {
		return findByProperty(HONGQIU4, hongqiu4);
	}

	public List findByHongqiu5(Object hongqiu5) {
		return findByProperty(HONGQIU5, hongqiu5);
	}

	public List findByHongqiu6(Object hongqiu6) {
		return findByProperty(HONGQIU6, hongqiu6);
	}

	public List findByLanqiu(Object lanqiu) {
		return findByProperty(LANQIU, lanqiu);
	}

	public List findByZhushu(Object zhushu) {
		return findByProperty(ZHUSHU, zhushu);
	}

	public List findByBeishu(Object beishu) {
		return findByProperty(BEISHU, beishu);
	}

	public List findByIsZhongjiang(Object isZhongjiang) {
		return findByProperty(IS_ZHONGJIANG, isZhongjiang);
	}

	public List findByZhongjiangjine(Object zhongjiangjine) {
		return findByProperty(ZHONGJIANGJINE, zhongjiangjine);
	}

	public List findByIsLingjiang(Object isLingjiang) {
		return findByProperty(IS_LINGJIANG, isLingjiang);
	}

	public List findByPayMoney(Object payMoney) {
		return findByProperty(PAY_MONEY, payMoney);
	}

	public List findAll() {
		log.debug("finding all Dingdanxiangqing instances");
		try {
			String queryString = "from Dingdanxiangqing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dingdanxiangqing merge(Dingdanxiangqing detachedInstance) {
		log.debug("merging Dingdanxiangqing instance");
		try {
			Dingdanxiangqing result = (Dingdanxiangqing) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dingdanxiangqing instance) {
		log.debug("attaching dirty Dingdanxiangqing instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dingdanxiangqing instance) {
		log.debug("attaching clean Dingdanxiangqing instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DingdanxiangqingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DingdanxiangqingDAO) ctx.getBean("DingdanxiangqingDAO");
	}
}
package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Caipiaodianshenqing;

/**
 * A data access object (DAO) providing persistence and search support for
 * Caipiaodianshenqing entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.pojo.Caipiaodianshenqing
 * @author MyEclipse Persistence Tools
 */
public class CaipiaodianshenqingDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CaipiaodianshenqingDAO.class);
	// property constants
	public static final String CLIENT_ID = "clientId";
	public static final String SHOUJIHAO = "shoujihao";
	public static final String MIMA = "mima";
	public static final String DIANMING = "dianming";
	public static final String XIANGXIDIZHI = "xiangxidizhi";
	public static final String JINGDU = "jingdu";
	public static final String WEIDU = "weidu";
	public static final String YINYEZHIZHAO = "yinyezhizhao";
	public static final String YINYEZHIZHAOMINGZI = "yinyezhizhaomingzi";
	public static final String YINYEZHIZHAO_IMG = "yinyezhizhaoImg";
	public static final String ZHENSHIXINGMING = "zhenshixingming";
	public static final String SHENFENZHENGBIANHAO = "shenfenzhengbianhao";
	public static final String ZHENMIAN = "zhenmian";
	public static final String FANMIAN = "fanmian";
	public static final String BANK = "bank";
	public static final String XINGMING = "xingming";
	public static final String ZHANGHAO = "zhanghao";
	public static final String ISTICAI = "isticai";
	public static final String ISFUCAI = "isfucai";
	public static final String ZHUANGTAI = "zhuangtai";
	public static final String JUJUELIYOU = "jujueliyou";

	protected void initDao() {
		// do nothing
	}

	public void save(Caipiaodianshenqing transientInstance) {
		log.debug("saving Caipiaodianshenqing instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Caipiaodianshenqing persistentInstance) {
		log.debug("deleting Caipiaodianshenqing instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Caipiaodianshenqing findById(java.lang.Integer id) {
		log.debug("getting Caipiaodianshenqing instance with id: " + id);
		try {
			Caipiaodianshenqing instance = (Caipiaodianshenqing) getHibernateTemplate()
					.get("com.pojo.Caipiaodianshenqing", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Caipiaodianshenqing instance) {
		log.debug("finding Caipiaodianshenqing instance by example");
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
		log.debug("finding Caipiaodianshenqing instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Caipiaodianshenqing as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClientId(Object clientId) {
		return findByProperty(CLIENT_ID, clientId);
	}

	public List findByShoujihao(Object shoujihao) {
		return findByProperty(SHOUJIHAO, shoujihao);
	}

	public List findByMima(Object mima) {
		return findByProperty(MIMA, mima);
	}

	public List findByDianming(Object dianming) {
		return findByProperty(DIANMING, dianming);
	}

	public List findByXiangxidizhi(Object xiangxidizhi) {
		return findByProperty(XIANGXIDIZHI, xiangxidizhi);
	}

	public List findByJingdu(Object jingdu) {
		return findByProperty(JINGDU, jingdu);
	}

	public List findByWeidu(Object weidu) {
		return findByProperty(WEIDU, weidu);
	}

	public List findByYinyezhizhao(Object yinyezhizhao) {
		return findByProperty(YINYEZHIZHAO, yinyezhizhao);
	}

	public List findByYinyezhizhaomingzi(Object yinyezhizhaomingzi) {
		return findByProperty(YINYEZHIZHAOMINGZI, yinyezhizhaomingzi);
	}

	public List findByYinyezhizhaoImg(Object yinyezhizhaoImg) {
		return findByProperty(YINYEZHIZHAO_IMG, yinyezhizhaoImg);
	}

	public List findByZhenshixingming(Object zhenshixingming) {
		return findByProperty(ZHENSHIXINGMING, zhenshixingming);
	}

	public List findByShenfenzhengbianhao(Object shenfenzhengbianhao) {
		return findByProperty(SHENFENZHENGBIANHAO, shenfenzhengbianhao);
	}

	public List findByZhenmian(Object zhenmian) {
		return findByProperty(ZHENMIAN, zhenmian);
	}

	public List findByFanmian(Object fanmian) {
		return findByProperty(FANMIAN, fanmian);
	}

	public List findByBank(Object bank) {
		return findByProperty(BANK, bank);
	}

	public List findByXingming(Object xingming) {
		return findByProperty(XINGMING, xingming);
	}

	public List findByZhanghao(Object zhanghao) {
		return findByProperty(ZHANGHAO, zhanghao);
	}

	public List findByIsticai(Object isticai) {
		return findByProperty(ISTICAI, isticai);
	}

	public List findByIsfucai(Object isfucai) {
		return findByProperty(ISFUCAI, isfucai);
	}

	public List findByZhuangtai(Object zhuangtai) {
		return findByProperty(ZHUANGTAI, zhuangtai);
	}

	public List findByJujueliyou(Object jujueliyou) {
		return findByProperty(JUJUELIYOU, jujueliyou);
	}

	public List findAll() {
		log.debug("finding all Caipiaodianshenqing instances");
		try {
			String queryString = "from Caipiaodianshenqing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Caipiaodianshenqing merge(Caipiaodianshenqing detachedInstance) {
		log.debug("merging Caipiaodianshenqing instance");
		try {
			Caipiaodianshenqing result = (Caipiaodianshenqing) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Caipiaodianshenqing instance) {
		log.debug("attaching dirty Caipiaodianshenqing instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Caipiaodianshenqing instance) {
		log.debug("attaching clean Caipiaodianshenqing instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CaipiaodianshenqingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CaipiaodianshenqingDAO) ctx.getBean("CaipiaodianshenqingDAO");
	}
}
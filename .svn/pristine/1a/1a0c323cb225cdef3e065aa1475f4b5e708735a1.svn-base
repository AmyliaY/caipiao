package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.PailiewuDdxq;

/**
 	* A data access object (DAO) providing persistence and search support for PailiewuDdxq entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.PailiewuDdxq
  * @author MyEclipse Persistence Tools 
 */
public class PailiewuDdxqDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(PailiewuDdxqDAO.class);
		//property constants
	public static final String NUM1 = "num1";
	public static final String NUM2 = "num2";
	public static final String NUM3 = "num3";
	public static final String NUM4 = "num4";
	public static final String NUM5 = "num5";
	public static final String ZHUSHU = "zhushu";
	public static final String BEISHU = "beishu";
	public static final String IS_ZHONGJIANG = "isZhongjiang";
	public static final String ZHONGJIANGJINE = "zhongjiangjine";
	public static final String IS_LINGJIANG = "isLingjiang";
	public static final String PAY_MONEY = "payMoney";



	protected void initDao() {
		//do nothing
	}
    
    public void save(PailiewuDdxq transientInstance) {
        log.debug("saving PailiewuDdxq instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PailiewuDdxq persistentInstance) {
        log.debug("deleting PailiewuDdxq instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PailiewuDdxq findById( java.lang.Integer id) {
        log.debug("getting PailiewuDdxq instance with id: " + id);
        try {
            PailiewuDdxq instance = (PailiewuDdxq) getHibernateTemplate()
                    .get("com.pojo.PailiewuDdxq", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PailiewuDdxq instance) {
        log.debug("finding PailiewuDdxq instance by example");
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
      log.debug("finding PailiewuDdxq instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PailiewuDdxq as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNum1(Object num1
	) {
		return findByProperty(NUM1, num1
		);
	}
	
	public List findByNum2(Object num2
	) {
		return findByProperty(NUM2, num2
		);
	}
	
	public List findByNum3(Object num3
	) {
		return findByProperty(NUM3, num3
		);
	}
	
	public List findByNum4(Object num4
	) {
		return findByProperty(NUM4, num4
		);
	}
	
	public List findByNum5(Object num5
	) {
		return findByProperty(NUM5, num5
		);
	}
	
	public List findByZhushu(Object zhushu
	) {
		return findByProperty(ZHUSHU, zhushu
		);
	}
	
	public List findByBeishu(Object beishu
	) {
		return findByProperty(BEISHU, beishu
		);
	}
	
	public List findByIsZhongjiang(Object isZhongjiang
	) {
		return findByProperty(IS_ZHONGJIANG, isZhongjiang
		);
	}
	
	public List findByZhongjiangjine(Object zhongjiangjine
	) {
		return findByProperty(ZHONGJIANGJINE, zhongjiangjine
		);
	}
	
	public List findByIsLingjiang(Object isLingjiang
	) {
		return findByProperty(IS_LINGJIANG, isLingjiang
		);
	}
	
	public List findByPayMoney(Object payMoney
	) {
		return findByProperty(PAY_MONEY, payMoney
		);
	}
	

	public List findAll() {
		log.debug("finding all PailiewuDdxq instances");
		try {
			String queryString = "from PailiewuDdxq";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PailiewuDdxq merge(PailiewuDdxq detachedInstance) {
        log.debug("merging PailiewuDdxq instance");
        try {
            PailiewuDdxq result = (PailiewuDdxq) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PailiewuDdxq instance) {
        log.debug("attaching dirty PailiewuDdxq instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PailiewuDdxq instance) {
        log.debug("attaching clean PailiewuDdxq instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PailiewuDdxqDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (PailiewuDdxqDAO) ctx.getBean("PailiewuDdxqDAO");
	}
}
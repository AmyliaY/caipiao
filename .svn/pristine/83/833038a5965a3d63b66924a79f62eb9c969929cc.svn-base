package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.PailiesanDdxq;

/**
 	* A data access object (DAO) providing persistence and search support for PailiesanDdxq entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.PailiesanDdxq
  * @author MyEclipse Persistence Tools 
 */
public class PailiesanDdxqDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(PailiesanDdxqDAO.class);
		//property constants
	public static final String NUM1 = "num1";
	public static final String NUM2 = "num2";
	public static final String NUM3 = "num3";
	public static final String ZHUSHU = "zhushu";
	public static final String BEISHU = "beishu";
	public static final String IS_ZHONGJIANG = "isZhongjiang";
	public static final String ZHONGJIANGJINE = "zhongjiangjine";
	public static final String IS_LINGJIANG = "isLingjiang";
	public static final String PAY_MONEY = "payMoney";



	protected void initDao() {
		//do nothing
	}
    
    public void save(PailiesanDdxq transientInstance) {
        log.debug("saving PailiesanDdxq instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PailiesanDdxq persistentInstance) {
        log.debug("deleting PailiesanDdxq instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PailiesanDdxq findById( java.lang.Integer id) {
        log.debug("getting PailiesanDdxq instance with id: " + id);
        try {
            PailiesanDdxq instance = (PailiesanDdxq) getHibernateTemplate()
                    .get("com.pojo.PailiesanDdxq", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PailiesanDdxq instance) {
        log.debug("finding PailiesanDdxq instance by example");
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
      log.debug("finding PailiesanDdxq instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PailiesanDdxq as model where model." 
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
		log.debug("finding all PailiesanDdxq instances");
		try {
			String queryString = "from PailiesanDdxq";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PailiesanDdxq merge(PailiesanDdxq detachedInstance) {
        log.debug("merging PailiesanDdxq instance");
        try {
            PailiesanDdxq result = (PailiesanDdxq) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PailiesanDdxq instance) {
        log.debug("attaching dirty PailiesanDdxq instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PailiesanDdxq instance) {
        log.debug("attaching clean PailiesanDdxq instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PailiesanDdxqDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (PailiesanDdxqDAO) ctx.getBean("PailiesanDdxqDAO");
	}
}
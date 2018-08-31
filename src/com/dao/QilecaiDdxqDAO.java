package com.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.QilecaiDdxq;

/**
 	* A data access object (DAO) providing persistence and search support for QilecaiDdxq entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.QilecaiDdxq
  * @author MyEclipse Persistence Tools 
 */
public class QilecaiDdxqDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(QilecaiDdxqDAO.class);
		//property constants
	public static final String QIU1 = "qiu1";
	public static final String QIU2 = "qiu2";
	public static final String QIU3 = "qiu3";
	public static final String QIU4 = "qiu4";
	public static final String QIU5 = "qiu5";
	public static final String QIU6 = "qiu6";
	public static final String QIU7 = "qiu7";
	public static final String ZHUSHU = "zhushu";
	public static final String BEISHU = "beishu";
	public static final String IS_ZHONGJIANG = "isZhongjiang";
	public static final String ZHONGJIANGJINE = "zhongjiangjine";
	public static final String IS_LINGJIANG = "isLingjiang";
	public static final String PAY_MONEY = "payMoney";



	protected void initDao() {
		//do nothing
	}
    
    public void save(QilecaiDdxq transientInstance) {
        log.debug("saving QilecaiDdxq instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(QilecaiDdxq persistentInstance) {
        log.debug("deleting QilecaiDdxq instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public QilecaiDdxq findById( java.lang.Integer id) {
        log.debug("getting QilecaiDdxq instance with id: " + id);
        try {
            QilecaiDdxq instance = (QilecaiDdxq) getHibernateTemplate()
                    .get("com.pojo.QilecaiDdxq", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(QilecaiDdxq instance) {
        log.debug("finding QilecaiDdxq instance by example");
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
      log.debug("finding QilecaiDdxq instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from QilecaiDdxq as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByQiu1(Object qiu1
	) {
		return findByProperty(QIU1, qiu1
		);
	}
	
	public List findByQiu2(Object qiu2
	) {
		return findByProperty(QIU2, qiu2
		);
	}
	
	public List findByQiu3(Object qiu3
	) {
		return findByProperty(QIU3, qiu3
		);
	}
	
	public List findByQiu4(Object qiu4
	) {
		return findByProperty(QIU4, qiu4
		);
	}
	
	public List findByQiu5(Object qiu5
	) {
		return findByProperty(QIU5, qiu5
		);
	}
	
	public List findByQiu6(Object qiu6
	) {
		return findByProperty(QIU6, qiu6
		);
	}
	
	public List findByQiu7(Object qiu7
	) {
		return findByProperty(QIU7, qiu7
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
		log.debug("finding all QilecaiDdxq instances");
		try {
			String queryString = "from QilecaiDdxq";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public QilecaiDdxq merge(QilecaiDdxq detachedInstance) {
        log.debug("merging QilecaiDdxq instance");
        try {
            QilecaiDdxq result = (QilecaiDdxq) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(QilecaiDdxq instance) {
        log.debug("attaching dirty QilecaiDdxq instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(QilecaiDdxq instance) {
        log.debug("attaching clean QilecaiDdxq instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static QilecaiDdxqDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (QilecaiDdxqDAO) ctx.getBean("QilecaiDdxqDAO");
	}
}
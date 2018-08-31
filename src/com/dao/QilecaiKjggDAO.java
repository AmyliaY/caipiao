package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.QilecaiKjgg;

/**
 	* A data access object (DAO) providing persistence and search support for QilecaiKjgg entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.QilecaiKjgg
  * @author MyEclipse Persistence Tools 
 */
public class QilecaiKjggDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(QilecaiKjggDAO.class);
		//property constants
	public static final String QIHAO = "qihao";
	public static final String HONGQIU1 = "hongqiu1";
	public static final String HONGQIU2 = "hongqiu2";
	public static final String HONGQIU3 = "hongqiu3";
	public static final String HONGQIU4 = "hongqiu4";
	public static final String HONGQIU5 = "hongqiu5";
	public static final String HONGQIU6 = "hongqiu6";
	public static final String HONGQIU7 = "hongqiu7";
	public static final String LANQIU = "lanqiu";



	protected void initDao() {
		//do nothing
	}
    
    public void save(QilecaiKjgg transientInstance) {
        log.debug("saving QilecaiKjgg instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(QilecaiKjgg persistentInstance) {
        log.debug("deleting QilecaiKjgg instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public QilecaiKjgg findById( java.lang.Integer id) {
        log.debug("getting QilecaiKjgg instance with id: " + id);
        try {
            QilecaiKjgg instance = (QilecaiKjgg) getHibernateTemplate()
                    .get("com.pojo.QilecaiKjgg", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(QilecaiKjgg instance) {
        log.debug("finding QilecaiKjgg instance by example");
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
      log.debug("finding QilecaiKjgg instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from QilecaiKjgg as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByQihao(Object qihao
	) {
		return findByProperty(QIHAO, qihao
		);
	}
	
	public List findByHongqiu1(Object hongqiu1
	) {
		return findByProperty(HONGQIU1, hongqiu1
		);
	}
	
	public List findByHongqiu2(Object hongqiu2
	) {
		return findByProperty(HONGQIU2, hongqiu2
		);
	}
	
	public List findByHongqiu3(Object hongqiu3
	) {
		return findByProperty(HONGQIU3, hongqiu3
		);
	}
	
	public List findByHongqiu4(Object hongqiu4
	) {
		return findByProperty(HONGQIU4, hongqiu4
		);
	}
	
	public List findByHongqiu5(Object hongqiu5
	) {
		return findByProperty(HONGQIU5, hongqiu5
		);
	}
	
	public List findByHongqiu6(Object hongqiu6
	) {
		return findByProperty(HONGQIU6, hongqiu6
		);
	}
	
	public List findByHongqiu7(Object hongqiu7
	) {
		return findByProperty(HONGQIU7, hongqiu7
		);
	}
	
	public List findByLanqiu(Object lanqiu
	) {
		return findByProperty(LANQIU, lanqiu
		);
	}
	

	public List findAll() {
		log.debug("finding all QilecaiKjgg instances");
		try {
			String queryString = "from QilecaiKjgg";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public QilecaiKjgg merge(QilecaiKjgg detachedInstance) {
        log.debug("merging QilecaiKjgg instance");
        try {
            QilecaiKjgg result = (QilecaiKjgg) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(QilecaiKjgg instance) {
        log.debug("attaching dirty QilecaiKjgg instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(QilecaiKjgg instance) {
        log.debug("attaching clean QilecaiKjgg instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static QilecaiKjggDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (QilecaiKjggDAO) ctx.getBean("QilecaiKjggDAO");
	}
}
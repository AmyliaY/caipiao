package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.ShiyixuanwuKjgg;

/**
 	* A data access object (DAO) providing persistence and search support for ShiyixuanwuKjgg entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.ShiyixuanwuKjgg
  * @author MyEclipse Persistence Tools 
 */
public class ShiyixuanwuKjggDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ShiyixuanwuKjggDAO.class);
		//property constants
	public static final String QIHAO = "qihao";
	public static final String QIU1 = "qiu1";
	public static final String QIU2 = "qiu2";
	public static final String QIU3 = "qiu3";
	public static final String QIU4 = "qiu4";
	public static final String QIU5 = "qiu5";



	protected void initDao() {
		//do nothing
	}
    
    public void save(ShiyixuanwuKjgg transientInstance) {
        log.debug("saving ShiyixuanwuKjgg instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ShiyixuanwuKjgg persistentInstance) {
        log.debug("deleting ShiyixuanwuKjgg instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ShiyixuanwuKjgg findById( java.lang.Integer id) {
        log.debug("getting ShiyixuanwuKjgg instance with id: " + id);
        try {
            ShiyixuanwuKjgg instance = (ShiyixuanwuKjgg) getHibernateTemplate()
                    .get("com.pojo.ShiyixuanwuKjgg", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ShiyixuanwuKjgg instance) {
        log.debug("finding ShiyixuanwuKjgg instance by example");
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
      log.debug("finding ShiyixuanwuKjgg instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ShiyixuanwuKjgg as model where model." 
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
	

	public List findAll() {
		log.debug("finding all ShiyixuanwuKjgg instances");
		try {
			String queryString = "from ShiyixuanwuKjgg";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ShiyixuanwuKjgg merge(ShiyixuanwuKjgg detachedInstance) {
        log.debug("merging ShiyixuanwuKjgg instance");
        try {
            ShiyixuanwuKjgg result = (ShiyixuanwuKjgg) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ShiyixuanwuKjgg instance) {
        log.debug("attaching dirty ShiyixuanwuKjgg instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ShiyixuanwuKjgg instance) {
        log.debug("attaching clean ShiyixuanwuKjgg instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ShiyixuanwuKjggDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ShiyixuanwuKjggDAO) ctx.getBean("ShiyixuanwuKjggDAO");
	}
}
package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.Fucai3dKjgg;

/**
 	* A data access object (DAO) providing persistence and search support for Fucai3dKjgg entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.Fucai3dKjgg
  * @author MyEclipse Persistence Tools 
 */
public class Fucai3dKjggDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(Fucai3dKjggDAO.class);
		//property constants
	public static final String QIHAO = "qihao";
	public static final String NUM1 = "num1";
	public static final String NUM2 = "num2";
	public static final String NUM3 = "num3";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Fucai3dKjgg transientInstance) {
        log.debug("saving Fucai3dKjgg instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Fucai3dKjgg persistentInstance) {
        log.debug("deleting Fucai3dKjgg instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Fucai3dKjgg findById( java.lang.Integer id) {
        log.debug("getting Fucai3dKjgg instance with id: " + id);
        try {
            Fucai3dKjgg instance = (Fucai3dKjgg) getHibernateTemplate()
                    .get("com.pojo.Fucai3dKjgg", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Fucai3dKjgg instance) {
        log.debug("finding Fucai3dKjgg instance by example");
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
      log.debug("finding Fucai3dKjgg instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Fucai3dKjgg as model where model." 
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
	

	public List findAll() {
		log.debug("finding all Fucai3dKjgg instances");
		try {
			String queryString = "from Fucai3dKjgg";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Fucai3dKjgg merge(Fucai3dKjgg detachedInstance) {
        log.debug("merging Fucai3dKjgg instance");
        try {
            Fucai3dKjgg result = (Fucai3dKjgg) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Fucai3dKjgg instance) {
        log.debug("attaching dirty Fucai3dKjgg instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Fucai3dKjgg instance) {
        log.debug("attaching clean Fucai3dKjgg instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static Fucai3dKjggDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (Fucai3dKjggDAO) ctx.getBean("Fucai3dKjggDAO");
	}
}
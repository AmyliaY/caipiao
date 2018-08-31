package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.ZucaishengfuKjgg;

/**
 	* A data access object (DAO) providing persistence and search support for ZucaishengfuKjgg entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.ZucaishengfuKjgg
  * @author MyEclipse Persistence Tools 
 */
public class ZucaishengfuKjggDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ZucaishengfuKjggDAO.class);
		//property constants
	public static final String RESULT = "result";
	public static final String SCORE = "score";



	protected void initDao() {
		//do nothing
	}
    
    public void save(ZucaishengfuKjgg transientInstance) {
        log.debug("saving ZucaishengfuKjgg instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ZucaishengfuKjgg persistentInstance) {
        log.debug("deleting ZucaishengfuKjgg instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ZucaishengfuKjgg findById( java.lang.Integer id) {
        log.debug("getting ZucaishengfuKjgg instance with id: " + id);
        try {
            ZucaishengfuKjgg instance = (ZucaishengfuKjgg) getHibernateTemplate()
                    .get("com.pojo.ZucaishengfuKjgg", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ZucaishengfuKjgg instance) {
        log.debug("finding ZucaishengfuKjgg instance by example");
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
      log.debug("finding ZucaishengfuKjgg instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ZucaishengfuKjgg as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByResult(Object result
	) {
		return findByProperty(RESULT, result
		);
	}
	
	public List findByScore(Object score
	) {
		return findByProperty(SCORE, score
		);
	}
	

	public List findAll() {
		log.debug("finding all ZucaishengfuKjgg instances");
		try {
			String queryString = "from ZucaishengfuKjgg";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ZucaishengfuKjgg merge(ZucaishengfuKjgg detachedInstance) {
        log.debug("merging ZucaishengfuKjgg instance");
        try {
            ZucaishengfuKjgg result = (ZucaishengfuKjgg) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ZucaishengfuKjgg instance) {
        log.debug("attaching dirty ZucaishengfuKjgg instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ZucaishengfuKjgg instance) {
        log.debug("attaching clean ZucaishengfuKjgg instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ZucaishengfuKjggDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ZucaishengfuKjggDAO) ctx.getBean("ZucaishengfuKjggDAO");
	}
}
package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.PailiesanKjgg;

/**
 	* A data access object (DAO) providing persistence and search support for PailiesanKjgg entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.PailiesanKjgg
  * @author MyEclipse Persistence Tools 
 */
public class PailiesanKjggDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(PailiesanKjggDAO.class);
		//property constants
	public static final String QIHAO = "qihao";
	public static final String NUM1 = "num1";
	public static final String NUM2 = "num2";
	public static final String NUM3 = "num3";



	protected void initDao() {
		//do nothing
	}
    
    public void save(PailiesanKjgg transientInstance) {
        log.debug("saving PailiesanKjgg instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PailiesanKjgg persistentInstance) {
        log.debug("deleting PailiesanKjgg instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PailiesanKjgg findById( java.lang.Integer id) {
        log.debug("getting PailiesanKjgg instance with id: " + id);
        try {
            PailiesanKjgg instance = (PailiesanKjgg) getHibernateTemplate()
                    .get("com.pojo.PailiesanKjgg", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PailiesanKjgg instance) {
        log.debug("finding PailiesanKjgg instance by example");
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
      log.debug("finding PailiesanKjgg instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PailiesanKjgg as model where model." 
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
		log.debug("finding all PailiesanKjgg instances");
		try {
			String queryString = "from PailiesanKjgg";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PailiesanKjgg merge(PailiesanKjgg detachedInstance) {
        log.debug("merging PailiesanKjgg instance");
        try {
            PailiesanKjgg result = (PailiesanKjgg) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PailiesanKjgg instance) {
        log.debug("attaching dirty PailiesanKjgg instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PailiesanKjgg instance) {
        log.debug("attaching clean PailiesanKjgg instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PailiesanKjggDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (PailiesanKjggDAO) ctx.getBean("PailiesanKjggDAO");
	}
}
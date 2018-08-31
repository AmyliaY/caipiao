package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.PailiewuKjgg;

/**
 	* A data access object (DAO) providing persistence and search support for PailiewuKjgg entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.PailiewuKjgg
  * @author MyEclipse Persistence Tools 
 */
public class PailiewuKjggDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(PailiewuKjggDAO.class);
		//property constants
	public static final String QIHAO = "qihao";
	public static final String NUM1 = "num1";
	public static final String NUM2 = "num2";
	public static final String NUM3 = "num3";
	public static final String NUM4 = "num4";
	public static final String NUM5 = "num5";



	protected void initDao() {
		//do nothing
	}
    
    public void save(PailiewuKjgg transientInstance) {
        log.debug("saving PailiewuKjgg instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PailiewuKjgg persistentInstance) {
        log.debug("deleting PailiewuKjgg instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PailiewuKjgg findById( java.lang.Integer id) {
        log.debug("getting PailiewuKjgg instance with id: " + id);
        try {
            PailiewuKjgg instance = (PailiewuKjgg) getHibernateTemplate()
                    .get("com.pojo.PailiewuKjgg", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PailiewuKjgg instance) {
        log.debug("finding PailiewuKjgg instance by example");
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
      log.debug("finding PailiewuKjgg instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PailiewuKjgg as model where model." 
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
	

	public List findAll() {
		log.debug("finding all PailiewuKjgg instances");
		try {
			String queryString = "from PailiewuKjgg";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PailiewuKjgg merge(PailiewuKjgg detachedInstance) {
        log.debug("merging PailiewuKjgg instance");
        try {
            PailiewuKjgg result = (PailiewuKjgg) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PailiewuKjgg instance) {
        log.debug("attaching dirty PailiewuKjgg instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PailiewuKjgg instance) {
        log.debug("attaching clean PailiewuKjgg instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PailiewuKjggDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (PailiewuKjggDAO) ctx.getBean("PailiewuKjggDAO");
	}
}
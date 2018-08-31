package com.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pojo.SoccerGame;

/**
 	* A data access object (DAO) providing persistence and search support for SoccerGame entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.pojo.SoccerGame
  * @author MyEclipse Persistence Tools 
 */
public class SoccerGameDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(SoccerGameDAO.class);
		//property constants
	public static final String SAISHI_NAME = "saishiName";
	public static final String ZHUCHANG_NAME = "zhuchangName";
	public static final String KECHANG_NAME = "kechangName";
	public static final String ZHUSHENG_PL = "zhushengPl";
	public static final String KESHENG_PL = "keshengPl";
	public static final String PINGJU_PL = "pingjuPl";



	protected void initDao() {
		//do nothing
	}
    
    public void save(SoccerGame transientInstance) {
        log.debug("saving SoccerGame instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SoccerGame persistentInstance) {
        log.debug("deleting SoccerGame instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SoccerGame findById( java.lang.Integer id) {
        log.debug("getting SoccerGame instance with id: " + id);
        try {
            SoccerGame instance = (SoccerGame) getHibernateTemplate()
                    .get("com.pojo.SoccerGame", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SoccerGame instance) {
        log.debug("finding SoccerGame instance by example");
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
      log.debug("finding SoccerGame instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SoccerGame as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findBySaishiName(Object saishiName
	) {
		return findByProperty(SAISHI_NAME, saishiName
		);
	}
	
	public List findByZhuchangName(Object zhuchangName
	) {
		return findByProperty(ZHUCHANG_NAME, zhuchangName
		);
	}
	
	public List findByKechangName(Object kechangName
	) {
		return findByProperty(KECHANG_NAME, kechangName
		);
	}
	
	public List findByZhushengPl(Object zhushengPl
	) {
		return findByProperty(ZHUSHENG_PL, zhushengPl
		);
	}
	
	public List findByKeshengPl(Object keshengPl
	) {
		return findByProperty(KESHENG_PL, keshengPl
		);
	}
	
	public List findByPingjuPl(Object pingjuPl
	) {
		return findByProperty(PINGJU_PL, pingjuPl
		);
	}
	

	public List findAll() {
		log.debug("finding all SoccerGame instances");
		try {
			String queryString = "from SoccerGame";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SoccerGame merge(SoccerGame detachedInstance) {
        log.debug("merging SoccerGame instance");
        try {
            SoccerGame result = (SoccerGame) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SoccerGame instance) {
        log.debug("attaching dirty SoccerGame instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SoccerGame instance) {
        log.debug("attaching clean SoccerGame instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SoccerGameDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SoccerGameDAO) ctx.getBean("SoccerGameDAO");
	}
}
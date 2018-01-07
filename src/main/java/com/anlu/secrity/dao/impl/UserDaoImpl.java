package com.anlu.secrity.dao.impl;

import com.anlu.secrity.dao.AbstractDao;
import com.anlu.secrity.dao.UserDao;
import com.anlu.secrity.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User findById(int id) {
        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }

    public User findBySSO(String sso) {
        logger.info("SSO : {}", sso);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssoId", sso));
        User user = (User) criteria.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User)crit.uniqueResult();
        delete(user);
    }

    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//避免重复数据
        List<User> users = (List<User>) criteria.list();

        return users;
    }
}

package br.unirio.wsimxp.dao.core;

import br.unirio.wsimxp.dao.ISiteDao;
import br.unirio.wsimxp.entity.Site;
import br.unirio.wsimxp.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class SiteDao implements ISiteDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Set<Site> findByUser(User user) {
        Set<Site> sites = new LinkedHashSet<Site>(sessionFactory.getCurrentSession().createCriteria(Site.class)
                .createAlias("users", "usr")
                .add(Restrictions.eq("usr.login", user.getLogin()))
                .list());

        return sites;
    }
}

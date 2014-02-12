package edu.uiowa.icts.safeseed.dao;

import edu.uiowa.icts.spring.*;
import edu.uiowa.icts.safeseed.domain.*;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/* Generated by Protogen
 *
 *
*/

@Repository("edu_uiowa_icts_safeseed_dao_FragHome")
@Transactional
public class FragHome extends GenericDao<Frag> implements FragService {


    private static final Log log =LogFactory.getLog(FragHome.class);

    public FragHome()
    {        setDomainName("edu.uiowa.icts.safeseed.domain.Frag");

    }


    public Frag  findById(Integer id)

    {
        return (Frag)this.sessionFactory.getCurrentSession().get(getDomainName(), id);

    }




}

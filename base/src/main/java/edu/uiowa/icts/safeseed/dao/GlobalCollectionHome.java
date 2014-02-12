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

@Repository("edu_uiowa_icts_safeseed_dao_GlobalCollectionHome")
@Transactional
public class GlobalCollectionHome extends GenericDao<GlobalCollection> implements GlobalCollectionService {


    private static final Log log =LogFactory.getLog(GlobalCollectionHome.class);

    public GlobalCollectionHome()
    {        setDomainName("edu.uiowa.icts.safeseed.domain.GlobalCollection");

    }


    public GlobalCollection  findById(Integer id)

    {
        return (GlobalCollection)this.sessionFactory.getCurrentSession().get(getDomainName(), id);

    }




}

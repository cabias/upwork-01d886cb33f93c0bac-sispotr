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

@Repository("edu_uiowa_icts_safeseed_dao_SubmissionHome")
@Transactional
public class SubmissionHome extends GenericDao<Submission> implements SubmissionService {


    private static final Log log =LogFactory.getLog(SubmissionHome.class);

    public SubmissionHome()
    {        setDomainName("edu.uiowa.icts.safeseed.domain.Submission");

    }


    public Submission  findById(Integer id)

    {
        return (Submission)this.sessionFactory.getCurrentSession().get(getDomainName(), id);

    }




}

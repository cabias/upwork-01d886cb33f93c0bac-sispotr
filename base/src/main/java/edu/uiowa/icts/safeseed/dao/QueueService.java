package edu.uiowa.icts.safeseed.dao;

import edu.uiowa.icts.spring.*;
import edu.uiowa.icts.safeseed.domain.*;

/* Generated by Protogen
 *
 *
*/


public interface QueueService extends GenericDaoInterface<Queue> {


    public Queue  findById(Integer id);
    public Queue  getNext();

}

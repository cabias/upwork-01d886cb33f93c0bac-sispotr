package edu.uiowa.icts.safeseed.dao;

import edu.uiowa.icts.spring.*;
import edu.uiowa.icts.safeseed.domain.*;

/* Generated by Protogen
 *
 *
*/


public interface PersonService extends GenericDaoInterface<Person> {


    public Person  findById(Integer id);
    public Person  findByUsername(String username);
    public Person  findByEmail(String email);

}

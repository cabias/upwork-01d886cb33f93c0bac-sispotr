package edu.uiowa.icts.safeseed.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uiowa.icts.spring.*;
import edu.uiowa.icts.safeseed.domain.*;
import edu.uiowa.icts.safeseed.dao.*;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/* Generated by Protogen
 *
Fri Mar 04 07:04:26 CST 2011 *
*/

@Controller
@RequestMapping("/safeseed/person/*")
public class PersonController extends AbstractSafeseedController {


    private static final Log log =LogFactory.getLog(PersonController.class);

    @RequestMapping(value = "list.html", method = RequestMethod.GET)
    public ModelAndView list()
    {
        log.debug("in list method for Person");
        ModelMap model = new ModelMap();
        model.addAttribute("personList",safeseedDaoService.getPersonService().list());
        return new ModelAndView("/safeseed/person/list",model);
    }

    @RequestMapping(value = "add.html", method = RequestMethod.GET)
    public ModelAndView add()
    {
        log.debug("in add method for Person");
        ModelMap model = new ModelMap();
        Person person = new Person();
        model.addAttribute("person",person);
        return new ModelAndView("/safeseed/person/edit",model);
    }

    @RequestMapping(value = "edit.html", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("personId") Integer personId)
    {
        log.debug("in edit method for Person");
        ModelMap model = new ModelMap();
        Person person = safeseedDaoService.getPersonService().findById(personId);
        model.addAttribute("person",person);
        return new ModelAndView("/safeseed/person/edit",model);
    }

    @RequestMapping(value = "show.html", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam("personId") Integer personId)
    {
        log.debug("in show method for Person");
        ModelMap model = new ModelMap();
        Person person = safeseedDaoService.getPersonService().findById(personId);
        model.addAttribute("person",person);
        return new ModelAndView("/safeseed/person/show",model);
    }

    @RequestMapping(value = "save.html", method = RequestMethod.POST)
    public String save(@ModelAttribute("person") Person person)
    {
        log.debug("in save method for Person");
        safeseedDaoService.getPersonService().saveOrUpdate(person);
        return "redirect:/safeseed/person/list.html";
    }

    @RequestMapping(value = "delete.html", method = RequestMethod.GET)
    public String delete(@RequestParam("personId") Integer personId)
    {
        log.debug("in delete method for Person");
        Person person = safeseedDaoService.getPersonService().findById(personId);
        safeseedDaoService.getPersonService().delete(person);
        return "redirect:/safeseed/person/list.html";
    }
    
}

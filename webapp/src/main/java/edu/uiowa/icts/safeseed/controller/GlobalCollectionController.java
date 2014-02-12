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
@RequestMapping("/safeseed/globalcollection/*")
public class GlobalCollectionController extends AbstractSafeseedController {


    private static final Log log =LogFactory.getLog(GlobalCollectionController.class);

    @RequestMapping(value = "list.html", method = RequestMethod.GET)
    public ModelAndView list()
    {
        log.debug("in list method for GlobalCollection");
        ModelMap model = new ModelMap();
        model.addAttribute("globalCollectionList",safeseedDaoService.getGlobalCollectionService().list());
        return new ModelAndView("/safeseed/globalcollection/list",model);
    }

    @RequestMapping(value = "add.html", method = RequestMethod.GET)
    public ModelAndView add()
    {
        log.debug("in add method for GlobalCollection");
        ModelMap model = new ModelMap();
        GlobalCollection globalCollection = new GlobalCollection();
        model.addAttribute("globalCollection",globalCollection);
        model.addAttribute("globalSeqList",safeseedDaoService.getGlobalSeqService().list());
        model.addAttribute("personList",safeseedDaoService.getPersonService().list());
        return new ModelAndView("/safeseed/globalcollection/edit",model);
    }

    @RequestMapping(value = "edit.html", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("personId") Integer globalCollectionId)
    {
        log.debug("in edit method for GlobalCollection");
        ModelMap model = new ModelMap();
        model.addAttribute("globalSeqList",safeseedDaoService.getGlobalSeqService().list());
        model.addAttribute("personList",safeseedDaoService.getPersonService().list());
        GlobalCollection globalCollection = safeseedDaoService.getGlobalCollectionService().findById(globalCollectionId);
        model.addAttribute("globalCollection",globalCollection);
        return new ModelAndView("/safeseed/globalcollection/edit",model);
    }

    @RequestMapping(value = "show.html", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam("personId") Integer globalCollectionId)
    {
        log.debug("in show method for GlobalCollection");
        ModelMap model = new ModelMap();
        GlobalCollection globalCollection = safeseedDaoService.getGlobalCollectionService().findById(globalCollectionId);
        model.addAttribute("globalCollection",globalCollection);
        return new ModelAndView("/safeseed/globalcollection/show",model);
    }

    @RequestMapping(value = "save.html", method = RequestMethod.POST)
    public String save(@RequestParam("globalSeq.globalSeqId") Integer globalSeqId, @RequestParam("person.personId") Integer personId, @ModelAttribute("globalCollection") GlobalCollection globalCollection)
    {
        log.debug("in save method for GlobalCollection");
        globalCollection.setGlobalSeq(safeseedDaoService.getGlobalSeqService().findById(globalSeqId));
        globalCollection.setPerson(safeseedDaoService.getPersonService().findById(personId));
        safeseedDaoService.getGlobalCollectionService().saveOrUpdate(globalCollection);
        return "redirect:/safeseed/globalcollection/list.html";
    }

    @RequestMapping(value = "delete.html", method = RequestMethod.GET)
    public String delete(@RequestParam("personId") Integer globalCollectionId)
    {
        log.debug("in delete method for GlobalCollection");
        GlobalCollection globalCollection = safeseedDaoService.getGlobalCollectionService().findById(globalCollectionId);
        safeseedDaoService.getGlobalCollectionService().delete(globalCollection);
        return "redirect:/safeseed/globalcollection/list.html";
    }
    
}

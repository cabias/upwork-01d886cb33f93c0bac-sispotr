package edu.uiowa.icts.safeseed.controller;

import java.util.Date;
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
Tue Aug 14 13:16:44 CDT 2012 *
*/

@Controller
@RequestMapping("/safeseed/sitecontent/*")
public class SiteContentController extends AbstractSafeseedController {


    private static final Log log =LogFactory.getLog(SiteContentController.class);

    @RequestMapping(value = "list.html", method = RequestMethod.GET)
    public ModelAndView list()
    {
        log.debug("in list method for SiteContent");
        ModelMap model = new ModelMap();
        model.addAttribute("siteContentList",safeseedDaoService.getSiteContentService().list());
        return new ModelAndView("/safeseed/sitecontent/list",model);
    }

    @RequestMapping(value = "add.html", method = RequestMethod.GET)
    public ModelAndView add()
    {
        log.debug("in add method for SiteContent");
        ModelMap model = new ModelMap();
        SiteContent siteContent = new SiteContent();
        model.addAttribute("siteContent",siteContent);
        return new ModelAndView("/safeseed/sitecontent/edit",model);
    }

    @RequestMapping(value = "edit.html", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("siteContentId") Integer siteContentId)
    {
        log.debug("in edit method for SiteContent");
        ModelMap model = new ModelMap();
        SiteContent siteContent = safeseedDaoService.getSiteContentService().findById(siteContentId);
        model.addAttribute("siteContent",siteContent);
        return new ModelAndView("/safeseed/sitecontent/edit",model);
    }
    
    @RequestMapping(value = "editByLabel.html", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("label") String label)
    {
        log.debug("in edit method for SiteContent");
        ModelMap model = new ModelMap();
        SiteContent siteContent = safeseedDaoService.getSiteContentService().findByLabel(label);
        model.addAttribute("siteContent",siteContent);
        return new ModelAndView("/safeseed/sitecontent/edit",model);
    }

    @RequestMapping(value = "show.html", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam("siteContentId") Integer siteContentId)
    {
        log.debug("in show method for SiteContent");
        ModelMap model = new ModelMap();
        SiteContent siteContent = safeseedDaoService.getSiteContentService().findById(siteContentId);
        model.addAttribute("siteContent",siteContent);
        return new ModelAndView("/safeseed/sitecontent/show",model);
    }

    @RequestMapping(value = "save.html", method = RequestMethod.POST)
    public String save(@ModelAttribute("siteContent") SiteContent siteContent)
    {
        log.debug("in save method for SiteContent");
        safeseedDaoService.getSiteContentService().saveOrUpdate(siteContent);
        safeseedDaoService.getSiteContentService().flush();
        populate();
        return "redirect:/safeseed/sitecontent/list.html";
    }
    
    @RequestMapping(value = "repopulate.html", method = RequestMethod.GET)
    public String repopulate()
    {
       
    	populate();
        return "redirect:/safeseed/sitecontent/list.html";
    }

    @RequestMapping(value = "delete.html", method = RequestMethod.GET)
    public String delete(@RequestParam("siteContentId") Integer siteContentId)
    {
        log.debug("in delete method for SiteContent");
        SiteContent siteContent = safeseedDaoService.getSiteContentService().findById(siteContentId);
        safeseedDaoService.getSiteContentService().delete(siteContent);
        return "redirect:/safeseed/sitecontent/list.html";
    }

}

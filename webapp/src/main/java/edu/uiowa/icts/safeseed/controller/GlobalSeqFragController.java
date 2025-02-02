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
@RequestMapping("/safeseed/globalseqfrag/*")
public class GlobalSeqFragController extends AbstractSafeseedController {


    private static final Log log =LogFactory.getLog(GlobalSeqFragController.class);

    @RequestMapping(value = "list.html", method = RequestMethod.GET)
    public ModelAndView list()
    {
        log.debug("in list method for GlobalSeqFrag");
        ModelMap model = new ModelMap();
        model.addAttribute("globalSeqFragList",safeseedDaoService.getGlobalSeqFragService().list());
        return new ModelAndView("/safeseed/globalseqfrag/list",model);
    }

    @RequestMapping(value = "add.html", method = RequestMethod.GET)
    public ModelAndView add()
    {
        log.debug("in add method for GlobalSeqFrag");
        ModelMap model = new ModelMap();
        GlobalSeqFrag globalSeqFrag = new GlobalSeqFrag();
        model.addAttribute("globalSeqFrag",globalSeqFrag);
        model.addAttribute("globalSeqList",safeseedDaoService.getGlobalSeqService().list());
        return new ModelAndView("/safeseed/globalseqfrag/edit",model);
    }

    @RequestMapping(value = "edit.html", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("globalSeqFrag") Integer globalSeqFragId)
    {
        log.debug("in edit method for GlobalSeqFrag");
        ModelMap model = new ModelMap();
        model.addAttribute("globalSeqList",safeseedDaoService.getGlobalSeqService().list());
        GlobalSeqFrag globalSeqFrag = safeseedDaoService.getGlobalSeqFragService().findById(globalSeqFragId);
        model.addAttribute("globalSeqFrag",globalSeqFrag);
        return new ModelAndView("/safeseed/globalseqfrag/edit",model);
    }

    @RequestMapping(value = "show.html", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam("globalSeqFrag") Integer globalSeqFragId)
    {
        log.debug("in show method for GlobalSeqFrag");
        ModelMap model = new ModelMap();
        GlobalSeqFrag globalSeqFrag = safeseedDaoService.getGlobalSeqFragService().findById(globalSeqFragId);
        model.addAttribute("globalSeqFrag",globalSeqFrag);
        return new ModelAndView("/safeseed/globalseqfrag/show",model);
    }

    @RequestMapping(value = "save.html", method = RequestMethod.POST)
    public String save(@RequestParam("globalSeq.globalSeqId") Integer globalSeqId, @ModelAttribute("globalSeqFrag") GlobalSeqFrag globalSeqFrag)
    {
        log.debug("in save method for GlobalSeqFrag");
        globalSeqFrag.setGlobalSeq(safeseedDaoService.getGlobalSeqService().findById(globalSeqId));
        safeseedDaoService.getGlobalSeqFragService().saveOrUpdate(globalSeqFrag);
        return "redirect:/safeseed/globalseqfrag/list.html";
    }

    @RequestMapping(value = "delete.html", method = RequestMethod.GET)
    public String delete(@RequestParam("globalSeqFrag") Integer globalSeqFragId)
    {
        log.debug("in delete method for GlobalSeqFrag");
        GlobalSeqFrag globalSeqFrag = safeseedDaoService.getGlobalSeqFragService().findById(globalSeqFragId);
        safeseedDaoService.getGlobalSeqFragService().delete(globalSeqFrag);
        return "redirect:/safeseed/globalseqfrag/list.html";
    }
    
}

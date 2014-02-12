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
@RequestMapping("/safeseed/seqrelationship/*")
public class SeqRelationshipController extends AbstractSafeseedController {


    private static final Log log =LogFactory.getLog(SeqRelationshipController.class);

    @RequestMapping(value = "list.html", method = RequestMethod.GET)
    public ModelAndView list()
    {
        log.debug("in list method for SeqRelationship");
        ModelMap model = new ModelMap();
        model.addAttribute("seqRelationshipList",safeseedDaoService.getSeqRelationshipService().list());
        return new ModelAndView("/safeseed/seqrelationship/list",model);
    }

    @RequestMapping(value = "add.html", method = RequestMethod.GET)
    public ModelAndView add()
    {
        log.debug("in add method for SeqRelationship");
        ModelMap model = new ModelMap();
        SeqRelationship seqRelationship = new SeqRelationship();
        model.addAttribute("seqRelationship",seqRelationship);
        model.addAttribute("globalSeqList",safeseedDaoService.getGlobalSeqService().list());
        model.addAttribute("seqList",safeseedDaoService.getSeqService().list());
        return new ModelAndView("/safeseed/seqrelationship/edit",model);
    }

    @RequestMapping(value = "edit.html", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("seqId") int seqId, @RequestParam("globalSeqId") int globalSeqId)
    {
        log.debug("in edit method for SeqRelationship");
        ModelMap model = new ModelMap();
        SeqRelationshipId seqRelationshipId = new SeqRelationshipId();
        seqRelationshipId.setSeqId(seqId);
        seqRelationshipId.setGlobalSeqId(globalSeqId);
        model.addAttribute("globalSeqList",safeseedDaoService.getGlobalSeqService().list());
        model.addAttribute("seqList",safeseedDaoService.getSeqService().list());
        SeqRelationship seqRelationship = safeseedDaoService.getSeqRelationshipService().findById(seqRelationshipId);
        model.addAttribute("seqRelationship",seqRelationship);
        return new ModelAndView("/safeseed/seqrelationship/edit",model);
    }

    @RequestMapping(value = "show.html", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam("seqId") int seqId, @RequestParam("globalSeqId") int globalSeqId)
    {
        log.debug("in show method for SeqRelationship");
        ModelMap model = new ModelMap();
        SeqRelationshipId seqRelationshipId = new SeqRelationshipId();
        seqRelationshipId.setSeqId(seqId);
        seqRelationshipId.setGlobalSeqId(globalSeqId);
        SeqRelationship seqRelationship = safeseedDaoService.getSeqRelationshipService().findById(seqRelationshipId);
        model.addAttribute("seqRelationship",seqRelationship);
        return new ModelAndView("/safeseed/seqrelationship/show",model);
    }

    @RequestMapping(value = "save.html", method = RequestMethod.POST)
    public String save(@RequestParam("globalSeq.globalSeqId") Integer globalSeqId, @RequestParam("seq.seqId") Integer seqId, @ModelAttribute("seqRelationship") SeqRelationship seqRelationship)
    {
        log.debug("in save method for SeqRelationship");
        SeqRelationshipId seqRelationshipId = new SeqRelationshipId();
        seqRelationshipId.setGlobalSeqId(globalSeqId);
        seqRelationshipId.setSeqId(seqId);
            seqRelationship.setId( seqRelationshipId);
        safeseedDaoService.getSeqRelationshipService().saveOrUpdate(seqRelationship);
        return "redirect:/safeseed/seqrelationship/list.html";
    }

    @RequestMapping(value = "delete.html", method = RequestMethod.GET)
    public String delete(@RequestParam("seqId") int seqId, @RequestParam("globalSeqId") int globalSeqId)
    {
        log.debug("in delete method for SeqRelationship");
        SeqRelationshipId seqRelationshipId = new SeqRelationshipId();
        seqRelationshipId.setSeqId(seqId);
        seqRelationshipId.setGlobalSeqId(globalSeqId);
        SeqRelationship seqRelationship = safeseedDaoService.getSeqRelationshipService().findById(seqRelationshipId);
        safeseedDaoService.getSeqRelationshipService().delete(seqRelationship);
        return "redirect:/safeseed/seqrelationship/list.html";
    }
    
}

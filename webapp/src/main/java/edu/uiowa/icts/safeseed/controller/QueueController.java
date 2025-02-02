package edu.uiowa.icts.safeseed.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uiowa.icts.safeseed.domain.Queue;
import edu.uiowa.icts.safeseed.domain.SeqFrag;

/* Generated by Protogen
 *
Fri Mar 04 07:04:26 CST 2011 *
*/

@Controller
@RequestMapping("/safeseed/queue/*")
public class QueueController extends AbstractSafeseedController {


    private static final Log log =LogFactory.getLog(QueueController.class);

    @RequestMapping(value = "list.html", method = RequestMethod.GET)
    public ModelAndView list()
    {
        log.debug("in list method for Queue");
        ModelMap model = new ModelMap();
        model.addAttribute("queueList",safeseedDaoService.getQueueService().list());
        return new ModelAndView("/safeseed/queue/list",model);
    }

    @RequestMapping(value = "add.html", method = RequestMethod.GET)
    public ModelAndView add()
    {
        log.debug("in add method for Queue");
        ModelMap model = new ModelMap();
        Queue queue = new Queue();
        model.addAttribute("queue",queue);
        model.addAttribute("seqFragList",safeseedDaoService.getSeqFragService().list());
        return new ModelAndView("/safeseed/queue/edit",model);
    }

    @RequestMapping(value = "edit.html", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("queueId") Integer queueId)
    {
        log.debug("in edit method for Queue");
        ModelMap model = new ModelMap();
        model.addAttribute("seqFragList",safeseedDaoService.getSeqFragService().list());
        Queue queue = safeseedDaoService.getQueueService().findById(queueId);
        model.addAttribute("queue",queue);
        return new ModelAndView("/safeseed/queue/edit",model);
    }

    @RequestMapping(value = "show.html", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam("queueId") Integer queueId)
    {
        log.debug("in show method for Queue");
        ModelMap model = new ModelMap();
        Queue queue = safeseedDaoService.getQueueService().findById(queueId);
        model.addAttribute("queue",queue);
        return new ModelAndView("/safeseed/queue/show",model);
    }

    @RequestMapping(value = "save.html", method = RequestMethod.POST)
    public String save(@RequestParam("seqFrag.seqFragId") Integer seqFragId, @ModelAttribute("queue") Queue queue)
    {
        log.debug("in save method for Queue");
        queue.setSeqFrag(safeseedDaoService.getSeqFragService().findById(seqFragId));
        safeseedDaoService.getQueueService().saveOrUpdate(queue);
        return "redirect:/safeseed/queue/list.html";
    }

    @RequestMapping(value = "delete.html", method = RequestMethod.GET)
    public String delete(@RequestParam("queueId") Integer queueId)
    {
        log.debug("in delete method for Queue");
        Queue queue = safeseedDaoService.getQueueService().findById(queueId);
        safeseedDaoService.getQueueService().delete(queue);
        return "redirect:/safeseed/queue/list.html";
    }
    
    
    @RequestMapping(value = "processNext.html", method = RequestMethod.GET)
    public ModelAndView processNext()
    {
    	log.debug("in processNext method for Queue");
    	Queue q = safeseedDaoService.getQueueService().getNext();
    	if(q==null)
    	{
    		log.debug("ERROR: no next item");
    		//TODO show error
    	    return new ModelAndView("/safeseed/queue/list");
    	}
    	

        
		log.debug("Starting recomputation....");
//		main.setVariables(lengthOfXmers, 7, gcMin, gcMax, gcRequired, gAt2, gAt3, ensureBestPots, species, numberOfReturnElements);
//		main.setSequenceText(seqText);
//		main.compute(false);
		log.debug("Computation complete....");
    	SeqFrag sf = q.getSeqFrag();
    	sf.setCompleted(true);
    	q.setComplete(true);
    	q.setDateCompleted(new Date());
    	
    	safeseedDaoService.getQueueService().save(q);
    	safeseedDaoService.getSeqFragService().save(sf);
        ModelMap model = new ModelMap();
     
        return new ModelAndView("redirect:/safeseed/queue/list.html",model);
    }

    
}

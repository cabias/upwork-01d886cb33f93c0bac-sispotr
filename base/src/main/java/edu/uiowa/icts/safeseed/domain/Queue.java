package edu.uiowa.icts.safeseed.domain;

import java.util.Set;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Table;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.annotations.*;
import javax.persistence.CascadeType;
import edu.uiowa.icts.*;

/* Generated by Protogen - www.icts.uiowa.edu/protogen
 * @date 2011/03/03 16:15:53
*/ 

@Entity(name="edu_uiowa_icts_safeseed_domain_queue")
@Table(name = "queue", schema="safeseed")
public class Queue
{
        private Integer queueId;
        private Boolean complete;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCompleted;
        private String logText;
        private Integer priorityLevel;
        private SeqFrag seqFrag;

    public Queue()    {
        this.queueId = null;
        this.complete = null;
        this.dateCompleted = null;
        this.logText = "";
        this.priorityLevel = null;
        this.seqFrag = null;
    }

    public Queue(Integer queueId, Boolean complete, Date dateCompleted, String logText, Integer priorityLevel, SeqFrag seqFrag)
    {
        this.queueId = queueId;
        this.complete = complete;
        this.dateCompleted = dateCompleted;
        this.logText = logText;
        this.priorityLevel = priorityLevel;
        this.seqFrag = seqFrag;
    }

    /*****queueId*****/
    @javax.persistence.SequenceGenerator(  name="gen",  sequenceName="safeseed.seqnum",allocationSize=1)
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO,generator="gen")
    @Column(name = "queue_id", unique = true, nullable = false)
    public Integer getQueueId()
    {
        return queueId;
    }

    public void setQueueId(Integer queueId)
    {
        this.queueId = queueId;
    }

    /*****complete*****/
    @Column(name = "complete")
    public Boolean getComplete()
    {
        return complete;
    }

    public void setComplete(Boolean complete)
    {
        this.complete = complete;
    }

    /*****dateCompleted*****/
    @Column(name = "date_completed")
    public Date getDateCompleted()
    {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted)
    {
        this.dateCompleted = dateCompleted;
    }

    public void setDateCompleted(String dateCompleted)
    {
        try{
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(true);        this.dateCompleted = formatter.parse(dateCompleted);
        } catch (ParseException e) {e.printStackTrace();}
    }

    /*****logText*****/
    @Column(name = "log_text")
    public String getLogText()
    {
        return logText;
    }

    public void setLogText(String logText)
    {
        this.logText = logText;
    }

    /*****priorityLevel*****/
    @Column(name = "priority_level")
    public Integer getPriorityLevel()
    {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel)
    {
        this.priorityLevel = priorityLevel;
    }

    /*****seqFrag*****/
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity=SeqFrag.class )
    @JoinColumn(name = "seq_frag_id",nullable = true)
    public SeqFrag getSeqFrag()
    {
        return seqFrag;
    }

    public void setSeqFrag(SeqFrag seqFrag)
    {
        this.seqFrag = seqFrag;
    }


}

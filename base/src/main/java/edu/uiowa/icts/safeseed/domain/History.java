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

@Entity(name="edu_uiowa_icts_safeseed_domain_history")
@Table(name = "history", schema="safeseed")
public class History
{
        private Integer historyId;
        private String params;
        private String notes;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastViewed;
        private SeqFrag seqFrag;
        private Person person;

    public History()    {
        this.historyId = null;
        this.params = "";
        this.notes = "";
        this.lastViewed = null;
        this.seqFrag = null;
        this.person = null;
    }

    public History(Integer historyId, String params, String notes, Date lastViewed, SeqFrag seqFrag, Person person)
    {
        this.historyId = historyId;
        this.params = params;
        this.notes = notes;
        this.lastViewed = lastViewed;
        this.seqFrag = seqFrag;
        this.person = person;
    }

    /*****historyId*****/
    @javax.persistence.SequenceGenerator(  name="gen",  sequenceName="safeseed.seqnum",allocationSize=1)
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO,generator="gen")
    @Column(name = "history_id", unique = true, nullable = false)
    public Integer getHistoryId()
    {
        return historyId;
    }

    public void setHistoryId(Integer historyId)
    {
        this.historyId = historyId;
    }

    /*****params*****/
    @Column(name = "params")
    public String getParams()
    {
        return params;
    }

    public void setParams(String params)
    {
        this.params = params;
    }

    /*****notes*****/
    @Column(name = "notes")
    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    /*****lastViewed*****/
    @Column(name = "last_viewed")
    public Date getLastViewed()
    {
        return lastViewed;
    }

    public void setLastViewed(Date lastViewed)
    {
        this.lastViewed = lastViewed;
    }

    public void setLastViewed(String lastViewed)
    {
        try{
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(true);        this.lastViewed = formatter.parse(lastViewed);
        } catch (ParseException e) {e.printStackTrace();}
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

    /*****person*****/
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity=Person.class )
    @JoinColumn(name = "person_id",nullable = true)
    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }


}

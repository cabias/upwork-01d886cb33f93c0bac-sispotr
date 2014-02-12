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

@Entity(name="edu_uiowa_icts_safeseed_domain_globalSeqFrag")
@Table(name = "global_seq_frag", schema="safeseed")
public class GlobalSeqFrag
{
        private Integer globalSeqFrag;
        private Integer fragLength;
        private Boolean completed;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCompleted;
        private Set<GlobalHistory> globalHistorys = new HashSet<GlobalHistory>(0);
        private Set<GlobalFrag> globalFrags = new HashSet<GlobalFrag>(0);
        private GlobalSeq globalSeq;

    public GlobalSeqFrag()    {
        this.globalSeqFrag = null;
        this.fragLength = null;
        this.completed = null;
        this.dateCompleted = null;
        this.globalHistorys = new HashSet<GlobalHistory>(0);
        this.globalFrags = new HashSet<GlobalFrag>(0);
        this.globalSeq = null;
    }

    public GlobalSeqFrag(Integer globalSeqFrag, Integer fragLength, Boolean completed, Date dateCompleted, Set<GlobalHistory> globalHistorys, Set<GlobalFrag> globalFrags, GlobalSeq globalSeq)
    {
        this.globalSeqFrag = globalSeqFrag;
        this.fragLength = fragLength;
        this.completed = completed;
        this.dateCompleted = dateCompleted;
        this.globalHistorys = globalHistorys;
        this.globalFrags = globalFrags;
        this.globalSeq = globalSeq;
    }

    /*****globalSeqFrag*****/
    @javax.persistence.SequenceGenerator(  name="gen",  sequenceName="safeseed.seqnum",allocationSize=1)
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO,generator="gen")
    @Column(name = "global_seq_frag", unique = true, nullable = false)
    public Integer getGlobalSeqFrag()
    {
        return globalSeqFrag;
    }

    public void setGlobalSeqFrag(Integer globalSeqFrag)
    {
        this.globalSeqFrag = globalSeqFrag;
    }

    /*****fragLength*****/
    @Column(name = "frag_length")
    public Integer getFragLength()
    {
        return fragLength;
    }

    public void setFragLength(Integer fragLength)
    {
        this.fragLength = fragLength;
    }

    /*****completed*****/
    @Column(name = "completed")
    public Boolean getCompleted()
    {
        return completed;
    }

    public void setCompleted(Boolean completed)
    {
        this.completed = completed;
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

    /*****globalHistorys*****/
    @OneToMany(fetch = FetchType.LAZY,   mappedBy = "globalSeqFrag", targetEntity=GlobalHistory.class, cascade=CascadeType.REMOVE)
    public Set<GlobalHistory> getGlobalHistorys()
    {
        return globalHistorys;
    }

    public void setGlobalHistorys(Set<GlobalHistory> globalHistorys)
    {
        this.globalHistorys = globalHistorys;
    }

    /*****globalFrags*****/
    @OneToMany(fetch = FetchType.LAZY,   mappedBy = "globalSeqFrag", targetEntity=GlobalFrag.class, cascade=CascadeType.REMOVE)
    public Set<GlobalFrag> getGlobalFrags()
    {
        return globalFrags;
    }

    public void setGlobalFrags(Set<GlobalFrag> globalFrags)
    {
        this.globalFrags = globalFrags;
    }

    /*****globalSeq*****/
    @ManyToOne(fetch = FetchType.LAZY,  targetEntity=GlobalSeq.class )
    @JoinColumn(name = "global_seq_id",nullable = true)
    public GlobalSeq getGlobalSeq()
    {
        return globalSeq;
    }

    public void setGlobalSeq(GlobalSeq globalSeq)
    {
        this.globalSeq = globalSeq;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author rezalt
 */
@Entity
public class Project implements Serializable
{

    

    @ManyToMany(mappedBy = "projects")
    List<ProjectUser> contributers = new ArrayList<>();
    
    @OneToMany
    List<Task> task = new ArrayList<>();

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private DateTime created;
    private DateTime lastModified;
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<ProjectUser> getContributers()
    {
        return contributers;
    }

    public List<Task> getTask()
    {
        return task;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public DateTime getCreated()
    {
        return created;
    }

    public DateTime getLastModified()
    {
        return lastModified;
    }

    public void setContributers(List<ProjectUser> contributers)
    {
        this.contributers = contributers;
    }

    public void setTask(List<Task> task)
    {
        this.task = task;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setCreated(DateTime created)
    {
        this.created = created;
    }

    public void setLastModified(DateTime lastModified)
    {
        this.lastModified = lastModified;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project))
        {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Project[ id=" + id + " ]";
    }
    
    
}

package facade;
import entity.ProjectUser;
import entity.Project;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Facade
{
    
    EntityManagerFactory emf;
    
    public Facade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    public ProjectUser getUser(int id)
    {
        EntityManager em = emf.createEntityManager();

        ProjectUser p = null;
        
        try
        {
            em.getTransaction().begin();
            p = em.find(ProjectUser.class, id);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }    
    }
    
    public List<ProjectUser> getUser()
    {
        EntityManager em = emf.createEntityManager();

        List<ProjectUser> persons = null;
        
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from ProjectUser p").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }

    public ProjectUser createUser(ProjectUser p)
    {
        EntityManager em = emf.createEntityManager();
       
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
    
    public ProjectUser deleteUser(int id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            ProjectUser p = em.find(ProjectUser.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
    
    public Project addUserToProject(Project project, ProjectUser pUser)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Project p = em.find(Project.class, project.getId());
            ProjectUser pU = em.find(ProjectUser.class, pUser.getId());
            if(p != null)
            {
                List<ProjectUser> contributers = new ArrayList<>();
                contributers = p.getContributers();
                contributers.add(pU);
                
                p = project; 
                
                em.merge(p);
                em.getTransaction().commit();
                return p;
            }
        }
        finally
        {
            em.close();
        }  
        
        return null;
    }
}

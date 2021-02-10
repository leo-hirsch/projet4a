package fr.polytech.TPRest.Servlet.DBManager;
import fr.polytech.TPRest.Servlet.Warframe;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import java.util.List;
import static fr.polytech.TPRest.Servlet.DBManager.HibernateFactory.getSession;

public class WarframeManager {
    /**
     * Permet de récupérer tous les magasins
     *
     * @return liste de tous les magasins
     */
    public Warframe create(Warframe warframe) {
        Session session = getSession();
        session.beginTransaction();
        session.save(warframe.getElement());
        session.getTransaction().commit();
        if(warframe.getGeneration().getId() == 0){
            session.beginTransaction();
            session.save(warframe.getGeneration());
            session.getTransaction().commit();
        }
        session.beginTransaction();
        session.save(warframe);
        session.getTransaction().commit();
        return warframe;
    }

    public Warframe update(Warframe warframe) {
        Session session = getSession();
        session.beginTransaction();
        session.update(warframe);
        session.getTransaction().commit();
        Query query = session.createQuery("select warframe from Warframe as warframe where warframe.id =:id");
        query.setParameter("id", warframe.getId());
        return (Warframe) query.getSingleResult();
    }

    public List<Warframe> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select warframe from Warframe as warframe");
        return query.getResultList();
    }

    public Response delete(Warframe warframe) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(warframe);
        session.getTransaction().commit();
        return Response.ok().build();
    }
}
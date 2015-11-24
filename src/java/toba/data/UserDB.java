
package toba.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import toba.business.User;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDB {

    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //EntityTransaction trans = em.getTransaction();
        //trans.begin();        
        try {
            em.persist(user);
           // trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            //trans.rollback();
        } finally {
            em.close();
        }
    }
public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
       // EntityTransaction trans = em.getTransaction();
       // trans.begin();       
        try {
            em.merge(user);
           // trans.commit();
        } catch (Exception e) {
            System.out.println(e);
           // trans.rollback();
        } finally {
            em.close();
        }
    }}
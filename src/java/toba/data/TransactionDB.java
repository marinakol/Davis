package toba.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import toba.business.Transaction;
import toba.business.User;

public class TransactionDB {
		
	public static void insert(Transaction transaction) {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();        
            try {
                em.persist( transaction);
                trans.commit();
            } catch (Exception e) {
                System.out.println(e);
                trans.rollback();
            } finally {
                em.close();
            }
         }
        
        
        public static List select(User user) {
            EntityManager em = DBUtil.getEmFactory().createEntityManager();
            List<Transaction> results = null;
            List<Transaction> finalList = new ArrayList<Transaction>();
            
            try {
                String qString = "SELECT u FROM Transaction u";
                TypedQuery<Transaction> q = em.createQuery(qString, Transaction.class);
                results = q.getResultList();
            } catch (NoResultException e) {
                return null;
            } finally {
                em.close();
            }
            
            try {
                for ( Transaction list : results) {
                    if ( user.getUserID().equals( list.getUser().getUserID())) {
                        finalList.add(list);
                    }
                }
            } catch (NoResultException e) {
                return null;
            }
            return finalList;
        }
        
	public static void update( Transaction transaction) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge( transaction);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
        
    public static void delete( Transaction transaction) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge( transaction));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
}

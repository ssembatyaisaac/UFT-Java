package UFT.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import UFT.business.Admin;

public class AdminDB {
        public static Admin selectAdminById(String adminID) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                try {
                        Admin admin = em.find(Admin.class, adminID);
                        return admin;
                } finally {
                        em.close();
                }
        }

        public static void insertAdmin(Admin admin) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(admin);
                        trans.commit();
                } catch (Exception ex) {
                        trans.rollback();
                } finally {
                        em.close();
                }
        }

        public static Admin selectAdmin (String email) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                String qString = "SELECT a from Admin a "+
                                "WHERE a.emailAddress = :email";
                TypedQuery<Admin> q = em.createQuery(qString, Admin.class);
                q.setParameter("email", email);
                Admin result = null;
                try {
                        result = q.getSingleResult();
                } catch (NoResultException ex) {
                        return null;
                } finally {
                        em.close();
                }
                return result;
        }

        public static boolean adminExists (String email) {
                Admin a = selectAdmin(email);
                return a != null;
        }
}
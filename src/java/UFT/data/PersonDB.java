package UFT.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import UFT.business.Person;

public class PersonDB {
        public static Person getPersonById(long PersonId){
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                try{
                        Person person = em.find(Person.class, PersonId);
                        return person;
                } finally {
                        em.close();
                }
        }

        public static void insertPerson(Person person){
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(person);
                        trans.commit();
                } catch (Exception ex) {
                        trans.rollback();
                }finally{
                        em.close();
                }
        }

        public static Person selectPerson(String email) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                String qString = "SELECT p FROM Person p "+
                                "WHERE p.emailAddress = :email";
                TypedQuery<Person> q = em.createQuery(qString, Person.class);
                q.setParameter("email", email);
                Person result = null;
                try {
                        result = q.getSingleResult();
                } catch (NoResultException ex) {
                        return null;
                }finally{
                        em.close();
                }

                return result;
                
        }

        
        public static boolean personExists(String email) {
                Person p = selectPerson(email);
                return p != null;
        }

}
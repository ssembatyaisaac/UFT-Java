/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFT.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import UFT.business.Member;

/**
 *
 * @author ducky
 */
public class MemberDB {
        public static Member getMemberById(String memberID){
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                try{
                        Member member = em.find(Member.class, memberID);
                        return member;
                } finally {
                        em.close();
                }
        }
    

        public static void insertMember(Member member) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(member);
                        trans.commit();
                } catch (Exception ex) {
                        trans.rollback();
                } finally {
                        em.close();
                }
        }


        public static Member selectMember(String email) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                String qString = "SELECT m from Member m "+
                                "WHERE m.emailAddress = :email";
                TypedQuery<Member> q = em.createQuery(qString, Member.class);
                q.setParameter("email", email);
                Member result = null;
                try {
                        result = q.getSingleResult();
                } catch (NoResultException ex) {
                        return null;
                } finally {
                        em.close();
                }

                return result;
        }

        public static boolean memberExists(String email) {
                Member m = selectMember(email);
                return m != null;
        }
}

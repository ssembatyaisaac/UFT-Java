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

import UFT.business.Agent;

/**
 *
 * @author ducky
 */
public class AgentDB {
        public static Agent selectAgentById(String agentID) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                try {
                        Agent agent = em.find(Agent.class, agentID);
                        return agent;
                } finally {
                        em.close();
                }
        }


        public static void insertAgent(Agent agent) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                EntityTransaction trans = em.getTransaction();
                try {
                        trans.begin();
                        em.persist(agent);
                        trans.commit();
                } catch (Exception ex) {
                        trans.rollback();
                } finally {
                        em.close();
                }
        }


        public static Agent selectAgent (String email) {
                EntityManager em = DBUtil.getEmFactory().createEntityManager();
                String qString = "SELECT a from Agent a "+
                                "WHERE emailAddress = :email";
                TypedQuery<Agent> q = em.createQuery(qString, Agent.class);
                q.setParameter("email", email);
                Agent result = null;
                try {
                        result = q.getSingleResult();
                } catch (NoResultException ex) {
                        return null;
                } finally {
                        em.close();
                }

                return result;
        }


        public static boolean agentExists (String email) {
                Agent a = selectAgent(email);
                return a != null;
        }
    
}

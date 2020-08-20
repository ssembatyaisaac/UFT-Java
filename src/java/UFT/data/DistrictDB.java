/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFT.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import UFT.business.Agent;
import UFT.business.District;

/**
 *
 * @author ducky
 */
public class DistrictDB {
    public static District getDistrictById(long districtID){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            District district = em.find(District.class, districtID);
            return district;
        } finally {
            em.close();
        }
    }

    public static void insertDistrict(District district) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(district);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static District selectDistrict(String districtName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT d from District d "+
            "WHERE d.districtName = :districtName";
        TypedQuery<District> q = em.createQuery(qString, District.class);
        q.setParameter("districtName", districtName);
        District result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
        return null;
    } finally {
            em.close();
        }

        return result;
    }

    public static boolean districtExists(String districtName) {
        District d = selectDistrict(districtName);
        return d != null;
    }

    public static District selectlowestAgents() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT d FROM District d";
        TypedQuery<District> q = em.createQuery(qString, District.class);

        List<District> districts;
        District lowestdDistrict = null;
        int lowest = 1000;
        try {
            districts = q.getResultList();
            if (districts == null || districts.isEmpty())
                districts = null;
            else {
                for (District district : districts) {
                    //String name = district.getDistrictName();
                    List<Agent> agents = district.getAgents();
                    int numberOfAgents = agents.size();
                    if (numberOfAgents <= lowest) {
                        lowest =  numberOfAgents;
                        lowestdDistrict = district;
                    }/*else {
                        lowest =  numberOfAgents;
                        lowestdDistrict = district;
                    }*/
                }
                
            }
        } finally {
            em.close();
        }
        return lowestdDistrict;
    }
    
    public static void update (District district) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(district);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}

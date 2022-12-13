package happiness.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import happiness.business.Country;

public class CountryDB {

    //Method that inserts the country into the mysql database
    public static int insertCountry(Country country) {
        //Creates an entity manager to handle transactions
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            //Transaction keeps track of changes
            em.persist(country);
            trans.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            //Entity manager is closed after the transaction
            em.close();
        }
        return -1;
    }

    //Method that updates country information in the db
    public static int updateCountry(Country country) {
        //Creates an entity manager to handle transactions
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            //Transaction keeps track of changes
            em.merge(country);
            trans.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            //Entity manager is closed after the transaction
            em.close();
        }
        return -1;
    }

    //Method that deletes a country record from the db
    public static int deleteCountry(Country country) {
        //Creates an entity manager to handle transactions
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            //Transaction keeps track of changes
            em.remove(em.merge(country));
            trans.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            //Entity manager is closed after the transaction
            em.close();
        }       
        return -1;
    }
    
    //Method to get info from the db about a specific country
    public static Country selectCountry(int countryId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //Query that selects a country from the db by id
        String qString = "SELECT c FROM Country c " +
                "WHERE c.countryId = :countryId";
        TypedQuery<Country> q = em.createQuery(qString, Country.class);
        q.setParameter("countryId", countryId);
        try {
            Country country = q.getSingleResult();
            return country;
        } 
        catch (NoResultException e) {
            return null;
        } 
        finally {
            //Entity manager is closed 
            em.close();
        }
    }

    //Method to get all of the info from the country table in the db
    public static List<Country> selectCountries() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //Query that selects all countries from the country entity/table
        String qString = "SELECT c from Country c";
        TypedQuery<Country> q = em.createQuery(qString, Country.class);

        List<Country> country;
        try {
            country = q.getResultList();
            if (country == null || country.isEmpty())
                country = null;
        } 
        finally {
            em.close();
        }
        //Return the list of countries stored in the db
        return country;
    }
}
package happiness.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Instantiable country class (JavaBean) used to build country objects
@Entity
public class Country implements Serializable {
    
    //Country data member variables
    private int countryId;
    
    private String overall_rank;
    private String country_or_region;
    private String score;
    private String gdp_per_capita;
    private String social_support;
    private String healthy_life_expectancy;
    private String freedom_to_make_life_choices;
    private String generosity;
    private String perceptions_of_corruption;

     
    //Country constructor
    public Country() {
        overall_rank = "";
        country_or_region = "";
        score = "";
        gdp_per_capita = "";
        social_support = "";
        healthy_life_expectancy = "";
        freedom_to_make_life_choices = "";
        generosity = "";
        perceptions_of_corruption = "";
    }

    //Get and set methods for the country class
    
    //JPA annotations to identify the country id as the primary key/id for the country
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    
    public void setOverall_rank(String overall_rank) {
        this.overall_rank = overall_rank;
    }

    public String getOverall_rank() {
        return overall_rank;
    }

    public void setCountry_or_region(String country_or_region) {
        this.country_or_region = country_or_region;
    }

    public String getCountry_or_region() {
        return country_or_region;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setGdp_per_capita(String gdp_per_capita) {
        this.gdp_per_capita = gdp_per_capita;
    }

    public String getGdp_per_capita() {
        return gdp_per_capita;
    }
    
    public void setSocial_support(String social_support) {
        this.social_support = social_support;
    }

    public String getSocial_support() {
        return social_support;
    }
    
    public void setHealthy_life_expectancy(String healthy_life_expectancy) {
        this.healthy_life_expectancy = healthy_life_expectancy;
    }

    public String getHealthy_life_expectancy() {
        return healthy_life_expectancy;
    }
    
    public void setFreedom_to_make_life_choices(String freedom_to_make_life_choices) {
        this.freedom_to_make_life_choices = freedom_to_make_life_choices;
    }

    public String getFreedom_to_make_life_choices() {
        return freedom_to_make_life_choices;
    }
    
    public void setGenerosity(String generosity) {
        this.generosity = generosity;
    }

    public String getGenerosity() {
        return generosity;
    }
    
    public void setPerceptions_of_corruption(String perceptions_of_corruption) {
        this.perceptions_of_corruption = perceptions_of_corruption;
    }

    public String getPerceptions_of_corruption() {
        return perceptions_of_corruption;
    }

}
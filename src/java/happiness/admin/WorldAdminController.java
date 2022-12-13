package happiness.admin;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import happiness.business.Country;
import happiness.data.CountryDB; //created new CountryDB class

public class WorldAdminController extends HttpServlet {
    
    //Variable that checks whether the action performed was successful or not
    int operationApproved;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayCountries";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/admin/index.jsp";
        if (action.equals("displayCountries")) {
            url = displayCountries(request, response);
        } 
        else if (action.equals("displayCountry")) {
            url = displayCountry(request, response);
        } 
        else if (action.equals("addCountry")) {
            url = "/admin/country.jsp";
        } 
        else if (action.equals("deleteCountry")) {
            url = deleteCountry(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayCountries";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/admin/index.jsp";
        if (action.equals("updateCountry")) {
            url = updateCountry(request, response);
        } 
        else if (action.equals("deleteCountry")) {
            url = deleteCountry(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    //Method to display the list of countries currently in the db
    private String displayCountries(HttpServletRequest request,
            HttpServletResponse response) {

        List<Country> countries = CountryDB.selectCountries();
        request.setAttribute("countries", countries);
        return "/admin/countries.jsp";
    }

    //Method to display a specific country
    private String displayCountry(HttpServletRequest request,
            HttpServletResponse response) {

        String countryId = request.getParameter("countryId");
        Country country;
        if (countryId == null || countryId.isEmpty()) {
            country = new Country();
        } 
        else {
            country = CountryDB.selectCountry(Integer.parseInt(countryId));
        }

        request.setAttribute("country", country);
        return "/admin/country.jsp";
    }

    //Method that sends the user to the country page to add a country to the list
    private String addCountry(HttpServletRequest request,
            HttpServletResponse response) {
        return "/admin/country.jsp";
    }

    //Method to update a country that is currently in the db
    private String updateCountry(HttpServletRequest request,
            HttpServletResponse response) {

        //Get the country id from the country.jsp
        String countryId = (String) request.getParameter("countryId");
        
        String overall_rank = (String) request.getParameter("overall_rank");
        String country_or_region = (String) request.getParameter("country_or_region");
        String score = (String) request.getParameter("score");
        String gdp_per_capita = (String) request.getParameter("gdp_per_capita");
        String social_support = (String) request.getParameter("social_support");
        String healthy_life_expectancy = (String) request.getParameter("healthy_life_expectancy");
        String freedom_to_make_life_choices = (String) request.getParameter("freedom_to_make_life_choices");
        String generosity = (String) request.getParameter("generosity");
        String perceptions_of_corruption = (String) request.getParameter("perceptions_of_corruption");
        
        //Set the country id into an int variable 
        int id;
        
        //If the countryId is not blank, parse it into an int else return an error
        if(!countryId.equals("")){
            id = Integer.parseInt(countryId);
        }
        else{
            id = -1;
        }

        //Create a new country if one does not already exist
        Country country = (Country) request.getAttribute("country");
        if (country == null) {
            country = new Country();
        }
        
        //if the id is empty and returns an error call the set country id method in the country class
        if(id != -1){
            country.setCountryId(id);
        }
        
        //Set the country attributes with the data entered in the form
        country.setOverall_rank(overall_rank);
        country.setCountry_or_region(country_or_region);
        country.setScore(score);
        country.setGdp_per_capita(gdp_per_capita);
        country.setSocial_support(social_support);
        country.setHealthy_life_expectancy(healthy_life_expectancy);
        country.setFreedom_to_make_life_choices(freedom_to_make_life_choices);
        country.setGenerosity(generosity);
        country.setPerceptions_of_corruption(perceptions_of_corruption);
        request.setAttribute("country", country);

        String url;

        if (CountryDB.selectCountry(country.getCountryId()) != null) {
            //Store the value returned in the operation approved variable
            operationApproved = CountryDB.updateCountry(country);

        } 
        else {
            //Store the value returned in the operation approved variable
            operationApproved = CountryDB.insertCountry(country);
        }
        url = displayCountries(request, response);

        
        //Statement that checks whether the value of operationApproved was 1 or -1 and returns the appropritate message to the user
        if(operationApproved == 1){
            String note = "You successfully updated a country (" + country.getCountry_or_region() + ") in the database.";
            request.setAttribute("note", note);
        }
        else if (operationApproved == -1){
            String note = "ERROR: The country (" + country.getCountry_or_region() + ") was not successfully updated in the database.";
            request.setAttribute("note", note);
        }
        
        return url;
        
    }
    
    //Method that removes a country from the list by calling the delete country method in the CountryDB class
    private String deleteCountry(HttpServletRequest request,
            HttpServletResponse response) {

        String countryId = request.getParameter("countryId");
        //Selects the country to delete by the country id
        int countryId2 = Integer.parseInt(countryId);
        Country country = CountryDB.selectCountry(countryId2);
        request.setAttribute("country", country);
        
        //Confirm with the user that the country being deleted is correct
        String url;
        String yesButton = request.getParameter("yesButton");
        if (yesButton != null) {
            //Store the value returned in the operation approved variable
            operationApproved = CountryDB.deleteCountry(country);
            url = displayCountries(request, response);
        } 
        //Confirm with the user that they want to delete the selected country
        else {
            url = "/admin/confirm_country_delete.jsp";

        }
        
        //Statement that checks whether the value of operationApproved was 0 or 1 and returns the appropritate message to the user
        if(operationApproved == 1){
            String note = "You successfully deleted a country (" + country.getCountry_or_region() + ") from the database.";
            request.setAttribute("note", note);
        }
        else if (operationApproved == -1){
            String note = "ERROR: The country (" + country.getCountry_or_region() + ") was not successfully deleted in the database.";
            request.setAttribute("note", note);
        }
        
        return url;
    }    
}

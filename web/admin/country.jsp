<%-- 
    Document   : country
    Author     : c.skeim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>World Happiness Report: Country List Changes</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
    </head>
    <body>
        
        <%--This form allows the user to update countries in the database--%>
        <h1><em>Country</em></h1>
        
        <img src="Blue.png" alt="blue2">
        
        <p><i>${message}</i></p>
        
        <form action="<c:url value='/worldHappiness'/>" 
              method="post" class="inline">
            <input type="hidden" name="action" value="updateCountry">
            
            <%-- This hidden field sets an individual id for the country--%>
            <input type="hidden" name="countryId" value="${country.countryId}">
            
            <!-- Form to enter in the information for the country -->
            <label class="pad_top">Rank:</label>
            <input type="text" name="overall_rank" id="overall_rank"
                   value="${country.overall_rank}" required><br>
            
            <label class="pad_top">Country or Region:</label>
            <input type="text" name="country_or_region" id="country_or_region"
                   value="${country.country_or_region}" required><br>

            <label class="pad_top">Score:</label>
            <input type="text" name="score" id="score"
                   value="${country.score}" required><br>
            
            <label class="pad_top">GDP Per Capita:</label>
            <input type="text" name="gdp_per_capita" id="gdp_per_capita"
                   value="${country.gdp_per_capita}" required><br>
            
            <label class="pad_top">Social Support:</label>
            <input type="text" name="social_support" id="social_support"
                   value="${country.social_support}" required><br>
            
            <label class="pad_top">Healthy Life Expectancy:</label>
            <input type="text" name="healthy_life_expectancy" id="healthy_life_expectancy"
                   value="${country.healthy_life_expectancy}" required><br>
            
            <label class="pad_top">Freedom to Make Life Choices:</label>
            <input type="text" name="freedom_to_make_life_choices" id="freedom_to_make_life_choices"
                   value="${country.freedom_to_make_life_choices}" required><br>
            
            <label class="pad_top">Generosity:</label>
            <input type="text" name="generosity" id="generosity"
                   value="${country.generosity}" required><br>
            
            <label class="pad_top">Perceptions of Corruption:</label>
            <input type="text" name="perceptions_of_corruption" id="perceptions_of_corruption"
                   value="${country.perceptions_of_corruption}" required><br>

            <label class="pad_top">&nbsp;</label>
            <input type="submit" value="Update Country" class="margin_left">
        </form>

        <%--Allows the user to view the updated list of countries--%>
        <form action="<c:url value='/worldHappiness'/>" 
              method="get" class="inline">
            <input type="hidden" name="action" value="displayCountries">
            <input type="submit" value="View Countries">
        </form>
        
        <%--Displays feedback to the user about the action they performed--%>
        <p><i>${note}</i></p>   
    </body>
</html>
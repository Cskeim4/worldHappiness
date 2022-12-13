<%-- 
    Document   : confirm_country_delete
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
        
        <%--Asks the user to confirm if they want to delete the selected country--%>
        <h1><em>Are you sure you want to delete this country record?</em></h1>

        <img src="Blue.png" alt="blue"><br><br>
        
        <label>Rank:</label>
        <span>${country.overall_rank}</span><br>

        <label>Country or Region:</label>
        <span>${country.country_or_region}</span><br>

        <label>Score:</label>
        <span>${country.score}</span><br>

        <label>GDP Per Capita:</label>
        <span>${country.gdp_per_capita}</span><br>

        <label>Social Support:</label>
        <span>${country.social_support}</span><br>

        <label>Healthy Life Expectancy:</label>
        <span>${country.healthy_life_expectancy}</span><br>

        <label>Freedom to Make Life Choices:</label>
        <span>${country.freedom_to_make_life_choices}</span><br>

        <label>Generosity:</label>
        <span>${country.generosity}</span><br>

        <label>Perceptions of Corruption:</label>
        <span>${country.perceptions_of_corruption}</span><br>

        <%--Delete was confirmed, delete the selected country--%>
        <form action="" method="post" class="inline">
            <input type="hidden" name="action" value="deleteCountry">
            <input type="hidden" name="countryRank" value="${country.overall_rank}">
            <input name="yesButton" type="submit" value="Yes" class="confirm_button">
        </form>

        <%--Delete was not confirmed, cancel the process--%>
        <form action="" method="get" class="inline">
            <input type="hidden" name="action" value="displayCountries">
            <input type="submit" value="No" class="confirm_button">
        </form>   

    </body>
</html>
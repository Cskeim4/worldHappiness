<%-- 
    Document   : countries
    Author     : c.skeim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>World Happiness Report Interactive: 2019</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
    </head>
    <body>
        
        <img src="logo.png" alt="logo">
        
        <h1><em>World Happiness Report Interactive: 2019</em></h1>

        <%--Displays each country in the database in a tablular format--%>
        <table>
            <tr>
                <th>Rank</th>
                <th>Country or Region</th>
                <th>Score</th>
                <th>GDP Per Capita</th>
                <th>Social Support</th>
                <th>Healthy Life Expectancy</th>
                <th>Freedom to Make Life Choices</th>
                <th>Generosity</th>
                <th class="right">Perceptions of Corruption</th>
                <th></th>
                <th></th>
            </tr>
            <!--Loops through the list of countries and prints out each one in the table -->
            <c:forEach var="c" items="${countries}">
            <tr>
                <td>${c.overall_rank}</td>
                <td>${c.country_or_region}</td>
                <td>${c.score}</td>
                <td>${c.gdp_per_capita}</td>
                <td>${c.social_support}</td>
                <td>${c.healthy_life_expectancy}</td>
                <td>${c.freedom_to_make_life_choices}</td>
                <td>${c.generosity}</td>
                <td class="right">${c.perceptions_of_corruption}</td>
                <td>
                    <!-- Send the country id to the display country method-->
                    <a href="<c:url value='/worldHappiness?action=displayCountry&countryId=${c.countryId}'/>">Edit</a>
                </td>
                <td>
                    <a href="<c:url value='/worldHappiness?action=deleteCountry&countryId=${c.countryId}'/>">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <%--Form that sends the information entered by the user to the add country method for processing--%>
        <form action="<c:url value='/worldHappiness'/>" method="get" class="pad_top">
            <input type="hidden" name="action" value="addCountry">
            <input type="submit" value="Add Country">
        </form>
            
        <%--Displays feedback to the user about the action they performed--%>
        <p><i>${note}</i></p> 
    </body>
</html>
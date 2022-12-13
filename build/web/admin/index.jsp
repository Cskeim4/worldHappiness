<%-- 
    Document   : index
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
        <div class="divCentered">
            <div>
                <h1><em>Happiness Rankings by Country</em></h1>
                
                <img src="../Blue.png" alt="green">
                
                <!-- Text to provide background on the happiness report scoring-->
                <p>
                    The happiness scores and rankings use data from the Gallup World Poll.
                    The scores are based on answers to the main life evaluation question 
                    asked in the poll. This question, known as the Cantril ladder, asks
                    respondents to think of a ladder with the best possible life for them
                    being a 10 and the worst possible life being a 0 and to rate their own
                    current lives on that scale. The scores are from nationally representative
                    samples for the years 2013-2016 and use the Gallup weights to make the 
                    estimates representative. The columns following the happiness score estimate
                    the extent to which each of six factors – economic production, social support,
                    life expectancy, freedom, absence of corruption, and generosity – contribute
                    to making life evaluations higher in each country than they are in Dystopia,
                    a hypothetical country that has values equal to the world’s lowest national
                    averages for each of the six factors. They have no impact on the total score
                    reported for each country, but they do explain why some countries rank higher
                    than others.
                </p>
                
                <%--Displays the current list of countries to the user--%>
                <a href="<c:url value='/worldHappiness?action=displayCountries'/>">Admin Panel: View Countries</a>
            </div>
        </div>
    </body>
</html>
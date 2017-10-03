<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>News Aggregator</title>

    <!-- Bootstrap Core CSS -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/resources/css/main.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">
      <div class="header">
        <h3 class="text-muted">News Aggregator</h3>
      </div>
        <p><a href="/desc">Show older news</a></p>
      <c:if test="${not empty items}">
        <c:forEach var="fi" items="${items}">
          <div class="jumbotron">
            <h1><c:out value="${fi.feedTitle}"/></h1>
            <p class="lead"><c:out value="${fi.feedDescription}"/></p>
            <p><a class="btn btn-primary" href="<c:out value="${fi.feedUrl}"/>" role="button">See more</a></p>
              <p><b>Date:</b> <c:out value="${fi.feedPubDate.toLocaleString()}"/><br> <b>Views:</b> <c:out value="${fi.feedViewerCount}"/><br><b>Source: </b><c:out value="${fi.feedChannel.channelTitle}"/></p>
          </div>
        </c:forEach>
      </c:if>


      <div class="footer">
        <p>&copy; 19-team 2017</p>
      </div>

    </div> <!-- /container -->

  </body>
</html>
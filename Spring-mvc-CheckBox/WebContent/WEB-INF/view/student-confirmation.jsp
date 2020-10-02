
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
        The student is Confirmed : ${student.firstName} ${student.lastName} 
        <br><br>
        Country : ${student.country}
        <br><br>
        Favorite Language : ${student.favoriteLanguage}
        
        <br><br>
        OperatingSystem:
        <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">
        
        <li>${temp}</li>
        
        </c:forEach>
        </ul>
    </body>
</html>
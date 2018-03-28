<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<body>
<spring:message code="welcome" arguments="${requestScope.user.username}"/>
</body>
</html>
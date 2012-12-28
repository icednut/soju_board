<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article Form</title>
</head>
<body>
<h2>Article Form</h2>
<form:form commandName="article" method="post">
	<div id="memberInfo">
		<form:errors path="member" />
	</div>
	<form:hidden path="member.id" /><form:errors path="title" />
	<form:input path="title"/><form:errors path="contents" />
	<form:textarea path="contents"/><br/>
	<form:button>저장</form:button>
</form:form>

</body>
</html>
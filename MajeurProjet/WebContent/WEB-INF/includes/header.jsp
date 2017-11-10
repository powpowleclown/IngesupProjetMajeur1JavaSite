<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/index.css"
	type="text/css" />
<link
	href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
	

	
<title>${title}</title>
</head>
<body>
<c:out value="${sessionScope.userlog.getRole().getRole()}"/>
	<c:choose>
		<c:when test="${sessionScope.userlog.getRole().getRole() == 'admin'}">
			<header>
				<nav class="topnav" id="myTopnav"> 
					<a href="<c:url value="/Home/Home"></c:url>">Home</a>
					<a href="<c:url value="/Home/Connection"></c:url>">Connection</a>
					<a href="/MajeurProjet/BackOffice/Room/List">Rooms</a> 
					<a href="/MajeurProjet/BackOffice/Incident/List">Incidents</a>
					<a href="/MajeurProjet/BackOffice/Computer/List">Computers</a>
					<a href="/MajeurProjet/BackOffice/Role/List">Roles</a>
					<a href="/MajeurProjet/BackOffice/State/List">States</a>
					<a href="/MajeurProjet/BackOffice/User/List">Users</a>
					<a href="<c:url value= "/Home/Logout"></c:url>">Logout</a>
				</nav> 
			</header>
		</c:when>
		<c:otherwise>
			<header>
				<nav class="topnav" id="myTopnav"> 
					<a href="<c:url value="/Home/Home"></c:url>">Home</a>
					<a href="<c:url value="/Home/Connection"></c:url>">Connection</a>
					<a href="<c:url value= "/Home/Logout"></c:url>">Logout</a>
				</nav> 
			</header>
		</c:otherwise>
	</c:choose>
	
	
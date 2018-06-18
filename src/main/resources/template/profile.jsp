<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Betting Application</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" />

<!-- icons -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />

<link rel="stylesheet" href="static/css/style.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script>
	/*<![CDATA[*/	
	    var loggedInUser = "${userId}";
	/*]]>*/
	</script>
</head>
<body class="container profilePage">
	<div class="row brandlogo-cnt">
		<div class="brandLogo">
			<img src="static/img/logo.gif" alt="PushToTest" />
		</div>
	</div>
	<c:choose>
    	<c:when test="${userName == null}">
		<div id="loginPage">
			<div id="signin-wrap" class="row signin-wrap">
				<form method="post" action="j_security_check"
					class="col s10 m8 l6 xl6 offset-s1 offset-m2 offset-l3 center-align signin-form">
					<div class="titleText">Log in to your account</div>
					<div class="row">
						<div class="input-field col s12">
							<input type="email" name="j_username" id="userId" class="validate" />
							<label for="signin-userId" data-error="Invalid email">Email</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input type="password" name="j_password" id="password"
								class="validate" /> <label for="signin-password">Password</label>
						</div>
					</div>
					<div id="signin-error" class="row"
						th:classappend="${showError} ? show : hide">
						<div class="error-field col s12">
							<label for="signin-error" th:text="${errorMessage}"></label>
						</div>
					</div>
					<button type="submit" class="waves-effect waves-light btn"
						name="action">Sign In</button>
					<div id="signupBtn" class="signupBtn">
						<a href="registration">Sign up for an account</a>
					</div>
				</form>
			</div>
		</div>
		</c:when>
        <c:otherwise>
		<div id="userPage" class="row ShareCnt">
			<div
				class="col s10 m8 l6 xl6 offset-s1 offset-m2 offset-l3 center-align">
				<div class="titleText">Profile</div>
				<div class="row">
					<table>
						<tbody>
							<tr>
								<td>Name</td>
								<td>${userName}</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>${userEmail}></td>
							</tr>
							<tr>
								<td>Balance</td>
								<td>${balance}$</td>
							</tr>
						</tbody>
					</table>
					<form action="logout">
						<button id="logoutBtn" class="waves-effect waves-light btn">Logout</button>
					</form>
				</div>
			</div>
		</div>

		<div class="row customRow menuWrap z-depth-1 center-align">
			<div class="col s5ths">
				<a class="material-icons menuIcon" href="index">home</a>
			</div>
			<div class="col s5ths messageIcon">
				<a class="material-icons menuIcon" href="message">message</a>
			</div>
			<div class="col s5ths">
				<a class="material-icons menuIcon" href="redeem">redeem</a>
			</div>
			<div class="col s5ths">
				<a class="material-icons menuIcon" href="share">share</a>
			</div>
			<div class="col s5ths">
				<a class="material-icons menuIcon" href="profile">person</a>
			</div>
		</div>
		</c:otherwise>
	</c:choose>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
	<script src="static/js/script.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Betting Application</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"/>
    
    <!-- icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>

    <link rel="stylesheet" href="static/css/style.css"/>
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
            <img src="static/img/logo.gif" alt="PushToTest"/>
        </div>
    </div>
    <div id="loginPage">
        <div id="signup-wrap" class="row signup-wrap">
            <form method="post" action="registration" class="col s10 m8 l6 xl6 offset-s1 offset-m2 offset-l3 center-align signup-form">
                <div class="titleText">Sign up for your account</div>
                <div class="row">
                    <div class="input-field col s12">
                        <input type="text" name="firstName" id="firstName" class="validate"/>
                        <label for="signup-fullName">First Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input type="text" name="lastName" id="lastName" class="validate"/>
                        <label for="signup-fullName">Last Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input type="email" name="userId" id="userId" class="validate"/>
                        <label for="signup-userId" data-error="Invalid a valid email" data-success="right">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input type="password" name="password" id="password" class="validate"/>
                        <label for="signup-password">Password</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input type="password" name="cfmPassword" id="cfmPassword" class="validate"/>
                        <label for="signup-cfmPassword">Confirm Password</label>
                    </div>
                </div>
                <button type="submit" class="waves-effect waves-light btn" name="action">Sign In</button>
                <div id="signinBtn" class="signinBtn">
                    Already have an account? <a href="login">Log in</a>
                </div>
            </form>
        </div>
    </div>

    <!--<div id="userPage" class="row ShareCnt hide">
        <div class="col s10 m8 l6 xl6 offset-s1 offset-m2 offset-l3 center-align">
            <div class="titleText">Profile</div>
            <div class="row">
                <table>
                    <tbody>
                        <tr>
                            <td>
                                Name
                            </td>
                            <td>
                                Hello
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Email
                            </td>
                            <td>
                                Hello@hello.com
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Balance
                            </td>
                            <td>
                                $1000
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>  
    </div>
    
    <div id="loginBtn">Login</div>
    <div id="profileBtn">Profile</div>-->

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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script src="static/js/script.js"></script>
</body>
</html>
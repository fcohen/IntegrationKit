<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Tibco</title>
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
<body class="container center-align sharePage">
    <div class="row brandlogo-cnt">
        <div class="brandLogo">
            <img src="static/img/logo.gif" alt="PushToTest"/>
        </div>
    </div>
    <div class="row ShareCnt">
        <div class="col s10 m8 l6 xl6 offset-s1 offset-m2 offset-l3 center-align">
            <div class="titleText">Share your Details</div>
            <div class="row">
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <input type="checkbox" id="userName"/>
                                <label for="userName"></label>
                            </td>
                            <td>
                                Name
                            </td>
                            <td>${userName}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="checkbox" id="userEmail"/>
                                <label for="userEmail"></label>
                            </td>
                            <td>
                                Email
                            </td>
                            <td>${userEmail}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="checkbox" id="userBalance"/>
                                <label for="userBalance"></label>
                            </td>
                            <td>
                                Balance
                            </td>
                            <td>${balance}$
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            
            <button id="shareBtn" class="waves-effect waves-light btn">share</button>
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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script src="static/js/script.js"></script>
</body>
</html>
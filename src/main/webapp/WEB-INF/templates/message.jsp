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
	    var loggedInUser = "${userId}"";
	/*]]>*/
	 var page = "message";
	</script>
</head>

<body class="container">
    <div class="row userInfo z-depth-1">
        <div class="col s6">
            <div class="row customRow">
                <div class="brandLogo">
                    <img src="static/img/logo.gif" alt="PushToTest"/>
                </div>
 static/         </div>
        </div>
        <div class="col s6 right-align">
            <div class="row customRow">
                <div class="userName">${userName}</div>
                <div class="userCash">${balance}</div>
            </div>
        </div>
    </div>
    <div id="message" class="message">
        <div class="row customRow messageTitle center-align">
            <h5>Message</h5>
        </div>
        <div class="row messageList-Wrap">
            <div id="messageCol" class="col s12">
                <!-- <div class="row customRow matchRow unreadMsg">
                    <div class="col s2 center-align">
                        <img src="static/img/fn.png" class="msgIcon" alt="logo"/>
                    </div>
                    <div class="col s10">
                        <div class="msgCnt">
                            Your Account has been verified successfully, Welcome to the Family of Knowledge.
                        </div>
                        <div class="msgTime right-align">
                            19-09-2017
                        </div>
                    </div>
                </div>
                <div class="row customRow matchRow">
                    <div class="col s2 center-align">
                        <img src="static/img/fn.png" class="msgIcon" alt="logo"/>
                    </div>
                    <div class="col s10">
                        <div class="msgCnt">
                            Your Account has been verified successfully, Welcome to the Family of Knowledge.
                        </div>
                        <div class="msgTime right-align">
                            19-09-2017
                        </div>
                    </div>
                </div> -->
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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script src="static/js/script.js"></script>
</body>

</html>
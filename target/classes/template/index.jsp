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
	var page = "index";
	</script>
</head>

<body class="container">
    <div class="row userInfo z-depth-1">
        <div class="col s6">
            <div class="row customRow">
                <div class="brandLogo">
                    <img src="static/img/logo.gif" alt="PushToTest"/>
                </div>
            </div>
        </div>
        <div class="col s6 right-align">
            <div class="row customRow">
                <div class="userName">${userName}</div>
                <div class="userCash">${balance}$</div>
            </div>
        </div>
    </div>
    <div id="home" class="home">
        <!-- <div class="row matchTab z-depth-1">
            <div class="tabs">
                <div class="col s12">
                    <ul class="tabs">
                        <li class="tab col s3">
                            <a href="#football">Football</a>
                        </li>
                        <li class="tab col s3">
                            <a href="#cricket">Cricket</a>
                        </li>
                        <li class="tab col s3">
                            <a href="#tennis">Tennis</a>
                        </li>
                        <li class="tab col s3">
                            <a href="#basketball">Basketball</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="football" class="row matchList-wrap center-align">
            <div class="col s12">
                <div class="row matchRow z-depth-1">
                    <div class="col s3">
                        <div class="matchInfo">
                            <div class="team1 fontStyle-bold">
                                FCB
                            </div>
                            <div class="fontStyle1">
                                VS
                            </div>
                            <div class="team2 fontStyle-bold">
                                RM
                            </div>
                            <div class="matchDetails fontStyle1">
                                Sunday 12:30
                            </div>
                        </div>
                    </div>
                    <div class="col s3">
                        <div class="bet bet1">
                            <div class="betTitle fontStyle-bold">Home</div>
                            <div class="betAmount">
                                2/7
                            </div>
                        </div>
                    </div>
                    <div class="col s3">
                        <div class="bet bet2">
                            <div class="betTitle fontStyle-bold">Draw</div>
                            <div class="betAmount">
                                4/7
                            </div>
                        </div>
                    </div>
                    <div class="col s3">
                        <div class="bet bet3">
                            <div class="betTitle fontStyle-bold">Away</div>
                            <div class="betAmount">
                                3/7
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> -->
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

    <!-- modal -->
    <!-- Modal Trigger -->
    <!-- <a class="waves-effect waves-light btn modal-trigger" href="#popup">Popup Open</a> -->
  
    <!-- Modal Structure -->
    <!-- <div id="popup" class="modal">
      <div class="modal-content">
        <h5>Condition</h5>
        <p>Agree with the Terms and Condition</p>
      </div>
      <div class="modal-footer">
        <a href="#" class="modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
      </div>
    </div> -->

    <!-- Alert -->
    <!-- <a class="waves-effect waves-light btn modal-trigger" href="#alert">Alert Open</a> -->
    <div id="alert" class="modal">
        <div class="modal-content">
            <h5>Congratulations</h5>
            <p>You have successfully redeemed to account</p>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script src="static/js/script.js"></script>
</body>

</html>
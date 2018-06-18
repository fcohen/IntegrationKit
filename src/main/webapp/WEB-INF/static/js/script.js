// common function
var page;
var messageIcon = document.getElementsByClassName('messageIcon')[0];

function popup(data) {
    var popup = document.createElement('div');
    popup.classList = "modal";
    popup.id = data._id;
    var modal_content = document.createElement('div');
    modal_content.classList = "modal-content";
    if(data.headertext){
        var h5 = document.createElement('h5');
        h5.classList = "center-align";
        h5.innerHTML = data.headertext;
        modal_content.appendChild(h5);
    }
    if(data.body){
        var body_ele = document.createElement('p');
        body_ele.innerHTML = data.body;
        modal_content.appendChild(body_ele);
    }
    popup.appendChild(modal_content);
    if(data.footer){
        var footer_ele =  document.createElement('div');
        footer_ele.classList = "modal-footer";
        for(var i in data.footer){
            var footerBtn = document.createElement('button');
            footerBtn.classList = "modal-action modal-close waves-effect waves-green btn-flat";
            footerBtn.innerHTML = data.footer[i];
            if(data['footer'+i]){
                footerBtn.setAttribute("count",i);
                footerBtn.onclick = function(){ 
                    var temp = this.getAttribute('count');
                    data['footer'+temp](); 
                };
            }
            footer_ele.appendChild(footerBtn);
        }
        popup.appendChild(footer_ele);
    }
    document.body.appendChild(popup);
    $('.modal').modal();
}

var data = {"_id":"popup", "headertext":"Condition","body":"Agree with the Terms and Condition","footer":{"1":"agree","2":"cancel"},"footer1": agree};
popup(data);

function agree(){
    console.log("agree");
}

function cancel() {
    console.log("cancel");
}


$(document).ready(function(){
    $('ul.tabs').tabs();
    $('.menuWrap.tabs').tabs();
    $('select').material_select();
    $('.modal').modal();
});

// profile page
$('#signupBtn').on('click',function(){
    //$('#signin-wrap').addClass('hide');
    //$('#signup-wrap').removeClass('hide');
    //$('.signin-form').trigger('reset');
	window.location.href = "/register.html";
});
$('#signinBtn').on('click',function(){
    $('#signin-wrap').removeClass('hide');
    $('#signup-wrap').addClass('hide');
    $('.signup-form').trigger('reset');
});
$('#loginBtn').on('click',function(){
    $('#userPage').addClass('hide');
    $('#loginPage').removeClass('hide');
});
$('#profileBtn').on('click',function(){
    $('#userPage').removeClass('hide');
    $('#loginPage').addClass('hide');
});
$('#userId').on('keyup',function(){
	$('#signin-error').addClass('hide');
});
$('#password').on('keyup',function(){
	$('#signin-error').addClass('hide');
});
// profile page end

// index page 
// Dyanmic update table

function create_element(ele_tag,ele_id,ele_class,ele_attr){
    var ele = document.createElement(ele_tag);
    if(ele_id != "null"){
        ele.id = ele_id;
    }
    if(ele_class != "null"){
        ele.classList = ele_class;
    }
    if(ele_attr != "null"){ 
        ele.setAttribute(ele_attr[0],ele_attr[1]);
    }
    return ele;
}

var home = document.getElementById('home');

//create table
function intialTable(initial_data){

    var matchTabs_wrap = create_element("div","null","row matchTabs-wrap z-depth-1","null");
    var tabs_col = create_element("div","null","col s12","null");
    var tabs = create_element("ul","null","tabs","null");
    var sports_count = initial_data.length;
    var tabCol_size;
    if(sports_count == 5){
        tabCol_size = "s5ths";
    }else{
        tabCol_size = "s"+(12 / sports_count);
    }

    for(var i in initial_data){
        var tab = create_element("li","null","tab col "+tabCol_size,"null");
        tab.innerHTML = '<a href="#'+initial_data[i]+'">'+initial_data[i]+'</a>';
        tabs.appendChild(tab);
    }
    tabs_col.appendChild(tabs);
    matchTabs_wrap.appendChild(tabs_col);
    home.appendChild(matchTabs_wrap);
}

//var initial_data = ["football","cricket","tennis","rugby","basketball"];


function createTable(sport,create_data){
    var sport_wrap = create_element("div",sport,"row matchList-wrap center-align","null");
    var sport_col = create_element("div","null","col s12","null");
    for(var i in create_data){
        var matchRow = create_element("div","null","row matchRow z-depth-1",["game_id" , create_data[i].game_id]);
        var date_conversion = new Date(create_data[i].date);
        var days_arry = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
        matchRow.innerHTML = '<div class="col s3">'
                               +' <div class="matchInfo">'
                                    +'<div class="team1 fontStyle-bold">'
                                        +create_data[i].team1
                                    +'</div>'
                                    +'<div class="fontStyle1">'
                                        +'VS'
                                    +'</div>'
                                    +'<div class="team2 fontStyle-bold">'
                                        +create_data[i].team2
                                    +'</div>'
                                    +'<div class="matchDetails fontStyle1">'
                                        +days_arry[date_conversion.getDay()]+'  '+date_conversion.getHours()+':'+("0" + date_conversion.getMinutes()).slice(-2)
                                    +'</div>'
                                +'</div>'
                            +'</div>'
                            +'<div class="col s3">'
                                +'<div class="bet bet1">'
                                    +'<div class="betTitle fontStyle-bold">Home</div>'
                                    +'<div class="betAmount homeBet">'
                                       +create_data[i].homebet
                                    +'</div>'
                                +'</div>'
                            +'</div>'
                            +'<div class="col s3">'
                                +'<div class="bet bet2">'
                                    +'<div class="betTitle fontStyle-bold">Draw</div>'
                                    +'<div class="betAmount drawbet">'
                                        +create_data[i].drawbet
                                    +'</div>'
                                +'</div>'
                            +'</div>'
                            +'<div class="col s3">'
                                +'<div class="bet bet3">'
                                    +'<div class="betTitle fontStyle-bold">Away</div>'
                                    +'<div class="betAmount awaybet">'
                                        +create_data[i].awaybet
                                    +'</div>'
                                +'</div>'
                            +'</div>';
        sport_col.appendChild(matchRow);  
    }
    sport_wrap.appendChild(sport_col);
    home.appendChild(sport_wrap);
}

//inital JSON
//var create_data = [{"game_id":"100","team1":"FCB", "team2":"RM", "date":"Fri, 05 Jan 2018 05:35:57 GMT", "homebet":"3/7", "drawbet":"2/7", "awaybet":"1/7"}, {"game_id":"101","team1":"CSK", "team2":"RCB", "date":"Fri, 05 Jan 2018 05:35:57 GMT", "homebet":"1/7", "drawbet":"2/7", "awaybet":"5/7"}];
//var create_data1 = [{"game_id":"200","team1":"RR", "team2":"KKR", "date":"Fri, 05 Jan 2018 05:35:57 GMT", "homebet":"3/7", "drawbet":"2/7", "awaybet":"1/7"}, {"game_id":"201","team1":"CSK", "team2":"RCB", "date":"Fri, 05 Jan 2018 05:35:57 GMT", "homebet":"1/7", "drawbet":"2/7", "awaybet":"5/7"}];
//var create_data2 = [{"game_id":"300","team1":"RF", "team2":"Naddal", "date":"Fri, 05 Jan 2018 05:35:57 GMT", "homebet":"3/7", "drawbet":"2/7", "awaybet":"1/7"}, {"game_id":"301","team1":"CSK", "team2":"RCB", "date":"Fri, 05 Jan 2018 05:35:57 GMT", "homebet":"1/7", "drawbet":"2/7", "awaybet":"5/7"}];
if(page == "index"){
	$.ajax({
		url: "rest/api/gamesType",
		method: "GET",
		success: function(initial_data){
			intialTable(initial_data);
			
			for(var i in initial_data){
				$.ajax({
					url: "rest/api/gamesList?game="+initial_data[i],
					method: "GET",
					async: false,
					success: function(create_data){
						console.log(initial_data[i] + ":" + JSON.stringify(create_data));
						createTable(initial_data[i],create_data);
					},
					error: function(){
						
					}
				});
			}
		    //createTable("cricket",create_data1);
		    //createTable("tennis",create_data2);
		},
		error: function(){
			console.log("error");
		}
	});
}


// update data
function updateTable(sport, update_data){
    var sport_wrap = document.getElementById(sport);
    for(var i in update_data){
        if (update_data[i].homebet) {
            sport_wrap.querySelector('[game_id="'+update_data[i].game_id+'"] .homebet').innerHTML = update_data[i].homebet;
        }
        if(update_data[i].drawbet){
            sport_wrap.querySelector('[game_id="'+update_data[i].game_id+'"] .drawbet').innerHTML = update_data[i].drawbet;
        }
        if(update_data[i].awaybet){
            sport_wrap.querySelector('[game_id="'+update_data[i].game_id+'"] .awaybet').innerHTML = update_data[i].awaybet;
        }
    }
}

//update JSON
var create_data_updated = [{"game_id":"100", "homebet":"7/7", "drawbet":"1/7", "awaybet":"5/7"}, {"game_id":"101", "awaybet":"5/7"}];

if(page == "index"){
    setTimeout(function() {
        //updateTable("football",create_data_updated);
    }, 5000);
}

var stompClient = null;

function setConnected(connected) {
    if (connected) {} else {}
}

function connect() {
    var socket = new SockJS('/messaging-service');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        //console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/notifications', function (response) {
        	response_data = JSON.parse(response.body);
        	if(response_data.length){
        		!messageIcon.classList.contains('unreadMsg-count') ? messageIcon.classList.add('unreadMsg-count') : "";
    			messageIcon.setAttribute('data-unreadMsg-count',response_data.length);
    			if(page == "message"){
                	updateMessage(response_data);
                }
        	}else{
        		messageIcon.classList.contains('unreadMsg-count') ? messageIcon.classList.remove('unreadMsg-count') : "";
        		messageIcon.removeAttribute('data-unreadMsg-count');
        	}
        });
        
        stompClient.subscribe('/topic/bettingodds', function (response) {
            console.log(response_data);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    //console.log("Disconnected");
}

function askForNotification() {
    stompClient.send("/app/notify", {}, JSON.stringify({'id': loggedInUser}));
}

function askForBettingUpdates(){
	stompClient.send("/app/getOdds", {}, JSON.stringify({'id': loggedInUser}));
}

if(loggedInUser != null && loggedInUser !=""){
	connect();
	setInterval(function(){
		askForNotification();
	}, 1000);
	var intervalTime = 10000 + (Math.floor(Math.random() * 10) + 1) * 1000;
	
	setInterval(function(){
		askForBettingUpdates();
	}, intervalTime);
	
	//profile page menu
	document.getElementsByClassName('menuWrap')[0].style.display = "block";
}


//message dynamic update
var message = document.getElementById('message');

function createMessage(inital_data){
	var messageCol = document.getElementById('messageCol');
	var messageRow;
	for(var i in inital_data){
		if(inital_data[i].status == "UNREAD"){
			messageRow = create_element("div","null","row customRow messageRow unreadMsg",["nId",inital_data[i].nId]);
		}else if(inital_data[i].status == "READ"){
			messageRow = create_element("div","null","row customRow messageRow",["nId",inital_data[i].nId]);
		}
		messageRow.innerHTML = '<div class="col s2 center-align">'
							        +'<img src="./img/fn.png" class="msgIcon" alt="logo"/>'
							    +'</div>'
							    +'<div class="col s10">'
							    	+'<div class="msgTitle">'
							    		+inital_data[i].title
						    		+'</div>'
							        +'<div class="msgCnt">'
							        	+inital_data[i].description
							        +'</div>'
							        +'<div class="msgTime right-align">'
							        	+inital_data[i].date
							        +'</div>'
						        +'</div>'
//        messageRow.onclick = function(){
//			if(this.classList.contains('unreadMsg')){
//				this.getAttribute('nId');
//				this.classList.remove('unreadMsg');
//				if(updated_unreadCount == 0){
//					messageIcon.classList.contains('unreadMsg-count') ? messageIcon.classList.remove('unreadMsg-count') : "";
//	        		messageIcon.removeAttribute('data-unreadMsg-count');
//				}else{
//					!messageIcon.classList.contains('unreadMsg-count') ? messageIcon.classList.add('unreadMsg-count') : "";
//	    			messageIcon.setAttribute('data-unreadMsg-count',response.body.length);
//				}
//				//add message as read
//				$.ajax({
//					url: "/api/markAsRead",
//					type: "GET",
//					data: "{userId: "+ loggedInUser +",nId: "+ setAsRead_nId +"}",
//					dataType: "json",
//					success: function(result){
//				        console.log(result);
//				    }
//				});
//			}
//		}
	    messageCol.appendChild(messageRow);
	}
}

function updateMessage(update_data){
	var messageCol = document.getElementById('messageCol');
	var messageRow;
	for(var i in update_data){
		if(!document.querySelector('[nId="'+update_data[i].nId+'"]')){
			if(update_data[i].status == "UNREAD"){
				messageRow = create_element("div","null","row customRow messageRow unreadMsg",["nId",update_data[i].nId]);
			}else if(update_data[i].status == "READ"){
				messageRow = create_element("div","null","row customRow messageRow",["nId",update_data[i].nId]);
			}
			messageRow.innerHTML = '<div class="col s2 center-align">'
								        +'<img src="./img/fn.png" class="msgIcon" alt="logo"/>'
								    +'</div>'
								    +'<div class="col s10">'
								    	+'<div class="msgTitle">'
								    		+update_data[i].title
							    		+'</div>'
								        +'<div class="msgCnt">'
								        	+update_data[i].description
								        +'</div>'
								        +'<div class="msgTime right-align">'
								        	+update_data[i].date
								        +'</div>'
							        +'</div>'
	        messageRow.onclick = function(){
				if(this.classList.contains('unreadMsg')){
					setAsRead_nId = this.getAttribute('nId');
					this.classList.remove('unreadMsg');
					updated_unreadCount = messageIcon.getAttribute('data-unreadMsg-count') - 1;
					if(updated_unreadCount == 0){
						messageIcon.classList.contains('unreadMsg-count') ? messageIcon.classList.remove('unreadMsg-count') : "";
		        		messageIcon.removeAttribute('data-unreadMsg-count');
					}else{
						!messageIcon.classList.contains('unreadMsg-count') ? messageIcon.classList.add('unreadMsg-count') : "";
		    			messageIcon.setAttribute('data-unreadMsg-count',updated_unreadCount);
					}
					//add message as read
					$.ajax({
						url: "rest/api/markAsRead",
						type: "GET",
						data: "userId="+loggedInUser+"&nId="+setAsRead_nId,
						dataType: "json",
						success: function(result){
					        console.log(result);
					    }
					});
				}
			}
		    messageCol.insertBefore(messageRow, messageCol.childNodes[0]);
		}
	}
}

// need to call createMessage
if(page == "message"){
	$.ajax({
		url: "rest/api/getReadNotifications",
		type: "GET",
		data: "userId="+loggedInUser,
		success: function(result){
	        console.log(result);
	        createMessage(result);
	    }
	});
}


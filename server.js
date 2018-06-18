'use strict';

var Http = require('http');
var Express = require('express');
var BodyParser = require('body-parser');
var Swaggerize = require('swaggerize-express');
var Path = require('path');
var Cors = require('cors');
var Logger = require('./util/logger');
//added
var mongoose = require('mongoose');
var session = require('express-session');
var MongoStore = require('connect-mongo')(session);

var corsOptions = {};

var App = Express();

var Server = Http.createServer(App);

App.use(Cors(corsOptions));
App.use(BodyParser.json());
App.use(BodyParser.urlencoded({
    extended: true
}));

//connect to MongoDB
//mongoose.connect('mongodb://localhost/testForAuth');
mongoose.connect('mongodb://18.236.73.205:27017/tibcoNodeJS');
var db = mongoose.connection;

//handle mongo error
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function () {
  // we're connected!
});

//use sessions for tracking logins
App.use(session({
  secret: 'work hard',
  resave: true,
  saveUninitialized: false,
  store: new MongoStore({
    mongooseConnection: db
  })
}));

App.use(Swaggerize({
    api: Path.resolve('./config/swagger.json'),
    handlers: Path.resolve('./handler')
}));
App.use(Express.static(__dirname + '/template'));
var sockjs = require('sockjs');
var multiplex_server = require('websocket-multiplex');

// 1. Setup SockJS server
var sockjs_opts = {sockjs_url: "http://cdn.sockjs.org/sockjs-0.3.min.js"};
var service = sockjs.createServer(sockjs_opts);

// 2. Setup multiplexing
var multiplexer = new multiplex_server.MultiplexServer(service);

var notification = multiplexer.registerChannel('notification');
notification.on('connection', function(conn) {
    conn.write('notification');
    conn.on("data", req => {
        //var {api,id} = req;
        //delete req.id;
        //delete req.api;
        console.log("req: " + req);
        //console.log(res);
        // assuming you have some apis written here
       /* App.get('/multiplex/notification',function(req,res,next){
            console.log("entered");
            conn.write(JSON.stringify(merge({},res,{id: "id"})));
        });*/
       /* service.get("multiplex/notification")
            .then( res => conn.write(JSON.stringify(merge({},res,{id: "id"}))) );*/
            
     });
     
     
  /*  conn.on('data', function(data) {
        conn.write('notification: ' + data);
    });*/
});

var betting = multiplexer.registerChannel('betting');
betting.on('connection', function(conn) {
    conn.write('betting');
    conn.on('data', function(data) {
        service.get("mulitplex/notification").
        conn.write('betting ' + data);
    });
});

service.installHandlers(Server, {prefix:'/multiplex'});

/*var echo = sockjs.createServer({ sockjs_url: 'http://cdn.jsdelivr.net/sockjs/1.0.1/sockjs.min.js' });
echo.on('connection', function(conn) {
    conn.on('data', function(message) {
        conn.write(message);
    });
    conn.on('close', function() {});
});

echo.installHandlers(Server, {prefix:'/echo'}); */

Server.listen(8000, function () {
    App.swagger.api.host = this.address().address + ':' + this.address().port;
    /* eslint-disable no-console */
    Logger.log(Logger.LOG_INFO, `App running on ${this.address().address}:${this.address().port}`);
    /* eslint-disable no-console */
});

/*App.get('/', function (req, res, next) {
  return res.sendFile(path.join(__dirname + '/template/index.html'));
});*/

App.get('/', function (req, res, next) {
    return res.sendFile(path.join(__dirname + '/template/index.html'));
  });
  

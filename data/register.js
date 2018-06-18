var Mockgen = require('./mockgen.js');
var User = require('../models/user.js');

function userCreation(req,res,callback) {
  console.log("flag is ready");
  // confirm that user typed same password twice
  if (req.body.password !== req.body.passwordConf) {
    var data = JSON.parse('{"responses": {"message": "Passwords do not match."}}');
    callback(null, data)
  }
  if (req.body.email &&
    req.body.username &&
    req.body.password &&
    req.body.passwordConf) {
      console.log("user data creations");

    var userData = {
      email: req.body.email,
      username: req.body.username,
      password: req.body.password,
      passwordConf: req.body.passwordConf,
    }
    console.log("step1");
    User.create(userData, function (error, user) {
      if (error) {
        console.log("step2");
        var data = JSON.parse('{"responses": {"message": "unable to register."}}');
        callback(null, data)
      } else {
        console.log("step3");
        req.session.userId = user._id;
        console.log("user: " + user + " json: " + JSON.stringify(user));
        var userData = JSON.stringify(user);
        var data = JSON.parse('{"responses": {"message": "registered successfully.","user":"' + user.email + '"}}');
        callback(null, data);
      }
    });

  } else {
    console.log("else block");
    var data = JSON.parse('{"responses": {"message": "All fields required."}}');
    callback(null, data)
  }
  console.log("end")
  
}

module.exports = {
  post: {
    200: function (req, res, callback) {
      var flag = 0;
      // console.log("email: " + req.body.email + " password: " + req.body.password);
      User.find({ "email": req.body.email })
        .exec(function (error, user) {
          if (error) {
            var data = JSON.parse('{"responses": {"message": "UnExpected Error.","status":"500"}}');
            callback(null, data)
          } else {
            if (user === null || user.email === undefined) {
              console.log("flag is set to 1")
              flag = 1;
              userCreation(req,res,callback);
            } else {
              console.log("user: " + user.email);
              var data = JSON.parse('{"responses": {"message": "User Already Exist","user":"' + req.body.email + '"}}');
              callback(null, data)
              //console.log("after call");
            }
          }
        });
        console.log("after first call");
     /* if (flag === 1) {
        console.log("flag is ready");
        // confirm that user typed same password twice
        if (req.body.password !== req.body.passwordConf) {
          var data = JSON.parse('{"responses": {"message": "Passwords do not match."}}');
          callback(null, data)
        }
        if (req.body.email &&
          req.body.username &&
          req.body.password &&
          req.body.passwordConf) {
            console.log("user data creations");

          var userData = {
            email: req.body.email,
            username: req.body.username,
            password: req.body.password,
            passwordConf: req.body.passwordConf,
          }
          console.log("step1");
          User.create(userData, function (error, user) {
            if (error) {
              console.log("step2");
              var data = JSON.parse('{"responses": {"message": "unable to register."}}');
              callback(null, data)
            } else {
              console.log("step3");
              req.session.userId = user._id;
              console.log("user: " + user + " json: " + JSON.stringify(user));
              var userData = JSON.stringify(user);
              var data = JSON.parse('{"responses": {"message": "registered successfully.","user":"' + user.name + '"}}');
              callback(null, data);
            }
          });

        } else {
          console.log("else block");
          var data = JSON.parse('{"responses": {"message": "All fields required."}}');
          callback(null, data)
        }
        console.log("end")
      }*/

    }
  }
};
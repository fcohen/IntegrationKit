//var express = require('express');
//var router = express.Router();
var Mockgen = require('./mockgen.js');
//var User = require('../models/user');
module.exports = {
  /**
   * summary: 
   * description: 
   * parameters: name
   * produces: application/json
   * responses: 200
   * operationId: 
   */
  get: {
      200: function (req, res, callback) {
          /**
           * Using mock data generator module.
           * Replace this by actual data for the api.
           */
         /* Mockgen().responses({
              path: '/login',
              operation: 'get',
              response: '200'
          }, callback);*/

          var data = JSON.parse('{"responses": {"message": "Home page"}}');
            callback(null,data);
      }
  }
};
/*
// GET route for reading data
router.get('/', function (req, res, next) {
  //return res.sendFile(path.join(__dirname + '/templateLogReg/index.html'));
  res.send("login page created");
});
*/
/*
//POST route for updating data
router.post('/', function (req, res, next) {
  // confirm that user typed same password twice
  if (req.body.password !== req.body.passwordConf) {
    var err = new Error('Passwords do not match.');
    err.status = 400;
    res.send("passwords dont match");
    return next(err);
  }

  if (req.body.email &&
    req.body.username &&
    req.body.password &&
    req.body.passwordConf) {

    var userData = {
      email: req.body.email,
      username: req.body.username,
      password: req.body.password,
      passwordConf: req.body.passwordConf,
    }

    User.create(userData, function (error, user) {
      if (error) {
        return next(error);
      } else {
        req.session.userId = user._id;
        return res.redirect('/profile');
      }
    });

  } else if (req.body.logemail && req.body.logpassword) {
    User.authenticate(req.body.logemail, req.body.logpassword, function (error, user) {
      if (error || !user) {
        var err = new Error('Wrong email or password.');
        err.status = 401;
        return next(err);
      } else {
        req.session.userId = user._id;
        return res.redirect('/profile');
      }
    });
  } else {
    var err = new Error('All fields required.');
    err.status = 400;
    return next(err);
  }
})

// GET route after registering
router.get('/profile', function (req, res, next) {
  User.findById(req.session.userId)
    .exec(function (error, user) {
      if (error) {
        return next(error);
      } else {
        if (user === null) {
          var err = new Error('Not authorized! Go back!');
          err.status = 400;
          return next(err);
        } else {
          return res.send('<h1>Name: </h1>' + user.username + '<h2>Mail: </h2>' + user.email + '<br><a type="button" href="/logout">Logout</a>')
        }
      }
    });
});

// GET for logout logout
router.get('/logout', function (req, res, next) {
  if (req.session) {
    // delete session object
    req.session.destroy(function (err) {
      if (err) {
        return next(err);
      } else {
        return res.redirect('/');
      }
    });
  }
});*/

//module.exports = router;
var Mockgen = require('./mockgen.js');
var User = require('../models/user.js');

module.exports = {
    /**
     * summary: 
     * description: 
     * parameters: name
     * produces: application/json
     * responses: 200
     * operationId: 
     */
    post: {
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
            var email = req.body.properties.logemail.id;
            var password = req.body.properties.logpassword.id;
           // console.log("email: " + email + " password: " + password);
            if (email && password) {
               // console.log(req.body.logemail);
                User.authenticate(email, password, function (error, user) {
                  if (error || !user) {
                    /*var err = new Error('Wrong email or password.');
                    err.status = 401;
                    return next(err);*/
                    var data = JSON.parse('{"responses": {"message": "loggedin failed"}}');
                    callback(null,data)
                  } else {
                    req.session.userId = user._id;
                    //return res.redirect('/profile');
                    var data = JSON.parse('{"responses": {"message": "loggedin successfully"}}');
                    callback(null,data) 
                  }
                });
              } 
        }
    }
  };
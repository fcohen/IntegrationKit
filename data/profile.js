var Mockgen = require('./mockgen.js');
var User = require('../models/user.js');

module.exports = {
    get: {
        200: function (req, res, callback) {
            User.findById(req.session.userId)
                .exec(function (error, user) {
                    if (error) {
                        var data = JSON.parse('{"responses": {"message": "UnExpected Error.","status":"500"}}');
                        callback(null, data)
                    } else {
                        if (user === null) {
                            var data = JSON.parse('{"responses": {"message": "Not authorized!.","status":"401"}}');
                            callback(null, data)
                        } else {
                            //var userData = JSON.stringify(user);
                           
                             //console.log("username: " + user.username);
                             //console.log("username: " + userData.username);
                             //console.log("username: " + JSON.parse(userData));
                            var data = JSON.parse('{"responses": {"message": "profile success","user":"' + user.username + '"}}');
                            callback(null, data)
                        }
                    }
                });
        }
    }
};
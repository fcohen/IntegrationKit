var Mockgen = require('./mockgen.js');
var User = require('../models/user.js');


module.exports = {
    get: {
        200: function (req, res, callback) {
            if (req.session) {
                // delete session object
                req.session.destroy(function (err) {
                  if (err) {
                    var data = JSON.parse('{"responses": {"message": "UnExpected Error.","status":"500"}}');
                    callback(null, data)
                  } else {
                    //var data = JSON.parse('{"responses": {"message": "UnExpected Error.","status":"500"}}');
                    callback(null, null)
                  }
                });
            }
        }
    }
};
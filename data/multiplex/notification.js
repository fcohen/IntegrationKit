var Mockgen = require('../mockgen.js');
//var User = require('../models/user.js');

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
            console.log("notification data");
            var data = JSON.parse('{"responses": {"message": "notification done"}}');
            callback(null,data) 
        }
    }
  };
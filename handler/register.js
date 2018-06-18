'use strict';
var dataProvider = require('../data/register.js');

module.exports = {
    /**
     * summary: 
     * description: 
     * parameters: name
     * produces: application/json
     * responses: 200
     */
    post: function (req, res, next) {
        /**
         * Get the data for response 200
         * For response `default` status 200 is used.
         */
        var status = 200;
        var provider = dataProvider['post']['200'];
        provider(req, res, function (err, data) {
            if (err) {
                console.log("error");
                next(err);
                return;
            }
            res.status(status).send(data && data.responses);
        });
    }
};
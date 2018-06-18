'use strict';
var dataProvider = require('../data/logout.js');

module.exports = {
    get: function (req, res, next) {
        /**
         * Get the data for response 200
         * For response `default` status 200 is used.
         */
        var status = 301;
        var provider = dataProvider['get']['200'];
        provider(req, res, function (err, data) {
            if (err) {
                console.log("error");
                next(err);
                return;
            }
            if(data == null) {
                res.writeHead(status, {Location: '/index'});
                res.end();
            }else {
                res.status(500).send(data && data.responses);
            }
            
        });
    }
};
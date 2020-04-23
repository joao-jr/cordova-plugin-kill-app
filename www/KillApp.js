var exec = require('cordova/exec');


exports.kill = function () {
    exec(null, null, 'KillApp', 'kill', []);
};

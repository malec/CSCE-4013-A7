var fs = require('fs');
var path = require('path');
var filePath = path.join(__dirname, 'input.txt');
fs.readFile(filePath, {encoding: 'utf-8'}, function (err, data) {
    if(!err) {
        console.log(data.split(" ").filter(x => x != "").length);
    } else {
        console.log(err);
    }
});
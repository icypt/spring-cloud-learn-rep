var http =  require('http');
var url =  require('url');
var path =  require('path');
//创建server
var server = http.createServer(function(req, res) {
	//获得请求的路径
	var pathName = url.parse(req.url).pathname;
	res.writeHead(200, {'Content-Type': 'application/json; charset=utf-8'})
	if(pathName === '/'){
		res.end(JSON.stringify({"index": "欢迎来到首页"}));
	} else if(pathName === '/health.json') {
		res.end(JSON.stringify({"status": "UP"}));
	} else {
		res.end("404");
	}
});


server.listen(8060, function() {
	console.log("listening on localhost:8060");
});
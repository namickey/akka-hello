request = require 'request'
module.exports = (robot) ->
  robot.router.get '/pug', (req, res) ->
    request
      url: 'http://pugme.herokuapp.com/random'
    , (err, res2, body) ->
      res.type 'html'
      res.send '<html><body><img src=\'' + JSON.parse(body).pug + '\'></body></html>'


$(window).on("resize", function () {
  var positionTop = window.innerHeight / 2;
  $('nav ul').css('top', positionTop);
  var marginTop = $('nav ul').height() / 2;
  $('nav ul').css('margin-top', -marginTop);
}).resize();
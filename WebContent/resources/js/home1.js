 var d = 100;
  var s = 0;
  var m = 0;
  var h = 0;
var duree=90;
var participant =0;

function validation(){
	
	alert("hello world !!!");
	participant=3;
	$("#time1").text(time).css(styles);
	t();
}

var setTime = function t(){
	if(participant > 0){

  parsIt(duree);
  var time = h+":"+m+":"+s;
  if(h==0 & m==0){
  var styles = {
      'color': 'hsla(' + (s*3) +', 90%, 50%, 1)',
      'textShadow': '0px 0px 5px hsla(' + (s*3) +', 100%, 70%, .5)',
      'borderColor': 'hsla(' + (s*3) +', 50%, 20%, .4)',
      'backgroundColor': 'hsla(' + (s*3) +', 80%, 20%, .9)'
    };}else{
       var styles = {
      'color': 'hsla(' + (60*3) +', 90%, 50%, 1)',
      'textShadow': '0px 0px 5px hsla(' + (60*3) +', 100%, 70%, .5)',
      'borderColor': 'hsla(' + (60*3) +', 50%, 20%, .4)',
      'backgroundColor': 'hsla(' + (60*3) +', 80%, 20%, .9)'
    };
    }
  $("#time1").text(time).css(styles);
  setTimeout(setTime, 1000);
  duree--;
  participant--;
	}
}

function parsIt(duree){
  if(duree<0){
    duree=90;
  }
  var inter=duree;
  h=(duree-(duree%3600))/3600;
  inter=inter-(h*3600);
  m=((inter)-((inter)%60))/60;
  inter=inter-(m*60);
  s=inter;
  if(s<10){
    s=0+""+s;
  }
  if(m<10){
    m=0+""+m;
  }
}

setTime();

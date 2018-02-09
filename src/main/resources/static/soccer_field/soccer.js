var vec2d = vec.vec2d;

function Soccer(field) {
  this.x_4_4_2 = [20,80,80,80,80,142,142,142,142,230,230];
  this.y_4_4_2 = [75,10,140,50,100,10,140,46,105,95,55];
  this.x_4_3_3 = [20,80,80,80,80,142,142,200,142,230,230];
  this.y_4_3_3 = [75,10,140,50,100,10,140,75,75,111,40];
  this.x_3_5_2 = [20,80,80,80,130,142,142,142,142,230,230];
  this.y_3_5_2 = [75,10,140,75,75,10,140,46,105,95,55];
  this.x_5_4_1 = [20,80,80,80,80,142,142,160,100,160,230];
  this.y_5_4_1 = [75,10,140,50,100,10,140,46,75,105,75];
  this.players = [];

  var soccer = this;
  var system1 = document.getElementById("4-3-3")
  system1.addEventListener('click', function(){soccer.s1()});
  var system2 = document.getElementById("3-5-2")
  system2.addEventListener('click', function(){soccer.s2()});
  var system3 = document.getElementById("5-4-1")
  system3.addEventListener('click', function(){soccer.s3()});
  
  var system4 = document.getElementById("4-4-2")
  system4.addEventListener('click', function(){soccer.s4()});
  
  this.ctx = field.getContext("2d");
  this.timestamp = null;
  window.requestAnimationFrame(function(ts) { soccer.timestamp = ts; })
  this.WIDTH = field.width;
  this.HEIGHT = field.height;
  //this.b = new ball(new vec2d(100,100));

  function ConstrainToField(p) {
    if (p.x < 0) p.x = 5;
    if (p.x > this.WIDTH) p.x = this.WIDTH - 10;
    if (p.y < 0) p.y = 5;
    if (p.y > this.WIDTH) p.y = this.HEIGHT - 10;
  }

  

  function ball(loc) {
    this.location = loc;
    this.vel = new vec2d(30,0);  // m/s
    this.DRAG = 1.5;  // 1.5m/s^2
  }

  ball.prototype.UpdatePos = function(step) {
    this.location.IPApplyVelocity(this.vel, step);
    this.vel.IPApplyDrag(this.DRAG, step);
  }
}

  function player(loc) {
    this.location = loc;
    this.color = "yellow";
    this.name = '';
    this.rotation = 0;
    this.dest = new vec2d(25,10);
  }

Soccer.prototype.s1 = function() {
  var that = this;
  var i = 0;
  this.players.forEach(function(p) {
    p.dest.x = that.x_4_3_3[i];
    p.dest.y = that.y_4_3_3[i];
    i++;
  });
}

Soccer.prototype.s2 = function() {
	  var that = this;
	  var i = 0;
	  this.players.forEach(function(p) {
	    p.dest.x = that.x_3_5_2[i];
	    p.dest.y = that.y_3_5_2[i];
	    i++;
	  });
	}

Soccer.prototype.s3 = function() {
	  var that = this;
	  var i = 0;
	  this.players.forEach(function(p) {
	    p.dest.x = that.x_5_4_1[i];
	    p.dest.y = that.y_5_4_1[i];
	    i++;
	  });
	}
Soccer.prototype.s4 = function() {
	  var that = this;
	  var i = 0;
	  this.players.forEach(function(p) {
	    p.dest.x = that.x_4_4_2[i];
	    p.dest.y = that.y_4_4_2[i];
	    i++;
	  });
	}

Soccer.prototype.click2 = function(plr) {
	  var that = this;
	  var i =0;
	  var html ='<tr><th style="width: 10px">#</th><th>Name</th><th class="pull-right">Position</th></tr>';
	  plr.forEach(function(pr) {
		  if(i<11){
			  var p = new player(new vec2d(100, 50));
			  p.dest.x = that.x_4_4_2[i];
			  p.dest.y = that.y_4_4_2[i];
			  p.name = pr.playerName;
			  that.players.push(p);
			  
			  
		  }
		  if(i >=11 && i <17){
	            
	            html = html + '<tr> <td>'+(i-10)+'.</td><td>'+pr.playerName+'</td> <td><span class="badge bg-green pull-right">'+pr.position+'</span></td></tr>';
				  
			  }
		  i++;
	  });
      document.getElementById("table").innerHTML = html;
	}

Soccer.prototype.iniciar = function() {
	$.ajax({
		url: 'onfield',
		method: 'GET', 
		success: this.click2.bind(this)
	});
}

Soccer.prototype.MainLoop = function(ts) {
  var step = ts - this.timestamp;
  step = 1.0 / 60.0;
  this.timestamp = ts;

  // game logic
  this.players.forEach(function(p) {
    p.location.IPMoveTowards(p.dest, 4);
  });
  //playerToGame.setX(x[i]);

  // render logic
  var ctx = this.ctx;
  ctx.clearRect(0, 0, this.WIDTH, this.HEIGHT);
  this.players.forEach(function(p) {
    ctx.fillStyle = p.color;
    var PLAYER_SIZE = 10;
    ctx.translate(p.location.x, p.location.y);
    ctx.rotate(p.rotation);
    //ctx.fillRect(-PLAYER_SIZE*0.5, -PLAYER_SIZE*0.5, PLAYER_SIZE, PLAYER_SIZE);
    ctx.font = '11px serif';
    ctx.fillText(p.name,-5,3);
    ctx.rotate(-p.rotation);
    ctx.translate(-p.location.x, -p.location.y);
  });
  ctx.fillStyle = "black";
 // ctx.translate(this.b.location.x, this.b.location.y);
  ctx.fillRect(-1, -1, 2, 2);
 // ctx.translate(-this.b.location.x, -this.b.location.y);
  //document.getElementById("debug").innerHTML = this.b.location.str() + " vel: " + this.b.vel.str();

  // request next frame
  var soccer = this;
  window.requestAnimationFrame(function(ts){soccer.MainLoop(ts)});
}

window.onload = function() {
  var soccer = new Soccer(document.getElementById("field"));
  window.requestAnimationFrame(function(step){soccer.MainLoop(step)});
  soccer.iniciar();
}

function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

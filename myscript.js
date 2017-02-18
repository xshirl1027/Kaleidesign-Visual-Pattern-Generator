
      function getMousePos(canvas, evt) {
        var rect = canvas.getBoundingClientRect();
        return {
          x: evt.clientX - rect.left,
          y: evt.clientY - rect.top
        };
      }
      var canvas = document.getElementById('myCanvas');
      var context = canvas.getContext('2d');
	  var mousePos;
	  var isdown = false;
      canvas.addEventListener('mousemove', function(evt) {
        mousePos = getMousePos(canvas, evt);
		if(isdown){
			//context.fillRect(mousePos.x,mousePos.y,5,5);
			context.rotate(90*Math.PI/180);
			//context.translate(canvasWidth/2, canvasWidth/2);
			context.fillRect(mousePos.x,mousePos.y,5,5);
		}
		
      }, false);
	   canvas.addEventListener('mousedown', function(evt) {var mousePos = getMousePos(canvas, evt);
		isdown=true;
		}, false);
		canvas.addEventListener('mouseup', function(evt) {var mousePos = getMousePos(canvas, evt);
		isdown=false;
		}, false);
	  
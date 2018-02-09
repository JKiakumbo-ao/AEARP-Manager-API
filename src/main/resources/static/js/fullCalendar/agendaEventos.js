$(document).ready(function() {
	
	var data = new Date();
	/*PEGA O DIA*/
	var dia  = data.getDate();	
	/*PEGA O MÊS E SOMA MAIS UM PARA CHEGAR NO MÊS ATUAL(JAVASCRIPT O MÊS COMEÇA EM 0(iNDEX DO MÊS))*/
	var mes  = (data.getMonth() + 1);
	/*PEGA O ANO*/
	var ano  = data.getFullYear();
	
	/*MONTA A DATA*/
	var dataAtual = ano +'-'+mes+'-'+dia;
	
	$('#div-agenda-events').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		defaultDate: dataAtual,		
		editable: true,
		eventLimit: true,
		lang:'en',
		buttonText: {
		    today: 'Today',
		    month: 'Month',
		    week: 'Week',
		    day: 'Day'
		},
		events: {
			url: 'getEvents.json'
		},
		  eventDrop: function(event, delta, revertFunc) {

		        alert(event.title + " was dropped on " + event.start.format());

		        if (!confirm("Are you sure about this change?")) {
		            revertFunc();
		        }

		    }
	});
	
});
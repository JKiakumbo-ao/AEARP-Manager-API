var Brewer = Brewer || {};

Brewer.GraficoVendaPorMes = (function() {
	
	function GraficoVendaPorMes() {
		this.ctx = $('#defenceStatsGraph')[0].getContext('2d');
	}
	
	GraficoVendaPorMes.prototype.iniciar = function() {
		$.ajax({
			url: 'defence',
			method: 'GET', 
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(vendaMes) {
		var playersName = [];
		var goals = [];
		var assists = [];
		var yellowCards = [];
		var redCards = [];
		var productives = [];
		var games = [];
		vendaMes.forEach(function(obj) {
			playersName.unshift(obj.playerName);
			goals.unshift(obj.goals);
			assists.unshift(obj.assists);
			yellowCards.unshift(obj.yellowCards);
			redCards.unshift(obj.redCards);
			productives.unshift(obj.productive)
			games.unshift(obj.games)
		});
		
		var graficoVendasPorMes = new Chart(this.ctx, {
		    type: 'bar',
		    data: {
		    	labels: playersName,
		    	datasets: [{
		    		label: 'Goals',
		    		backgroundColor: "rgba(0,128,0,0.5)",
	                data: goals
		    	},{
		            label: 'Assists',
		            backgroundColor: "rgba(0,255,255,0.5)",
		            data: assists,
		          },{
			            label: 'Yellow cards',
			            backgroundColor: "rgba(255,255,0,0.5)",
			            data: yellowCards,
			          },{
				            label: 'Red cards',
				            backgroundColor: "rgba(255,0,0,0.5)",
				            data: redCards,
				          },{
					            label: 'Played games',
					            backgroundColor: "rgba(0,0,255,1)",
					            data: games,
					            type: 'bubble'
					          }, {
		            label: 'Productivity',
		            backgroundColor: "rgba(26,179,148,0.3)",
		            pointBorderColor: "rgba(26,179,148,1)",
	                pointBackgroundColor: "#fff",
		            data: productives,

		            // Changes this dataset to become a line
		            type: 'line'
		          }]
		    },
		    options: {
		        legend: {
		            display: true,
		            labels: {
		               fontSize:14,
		            }
		        }
		},
		});
	}
	
	return GraficoVendaPorMes;
	
}());


$(function() {
	var graficoVendaPorMes = new Brewer.GraficoVendaPorMes();
	
	graficoVendaPorMes.iniciar();
	
});
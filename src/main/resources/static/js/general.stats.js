var Brewer = Brewer || {};

Brewer.GraficoVendaPorMes = (function() {
	
	function GraficoVendaPorMes() {
		if($('#statsGraph')[0] != undefined){
			this.ctx = $('#statsGraph')[0].getContext('2d');
		}
		
	}
	
	GraficoVendaPorMes.prototype.iniciar = function() {
		$.ajax({
			url: 'general',
			method: 'GET', 
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(vendaMes) {
		var playersName = [];
		var goals = [];
		
		vendaMes.forEach(function(obj) {
			playersName.unshift(obj.playerName);
			goals.unshift(obj.score);
		});
		
		var graficoVendasPorMes = new Chart(this.ctx, {
		    type: 'line',
		    data: {
		    	labels: playersName,
		    	datasets: [{
		    		label: 'Goals',
		    		backgroundColor: "rgba(67,205,128,0.5)",
	                data: goals
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
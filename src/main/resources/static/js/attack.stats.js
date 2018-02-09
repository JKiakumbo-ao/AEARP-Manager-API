var Brewer = Brewer || {};

Brewer.AttackStatsGraph = (function() {
	
	function AttackStatsGraph() {
		if($('#attackStatsGraph')[0] != undefined){
			this.ctx = $('#attackStatsGraph')[0].getContext('2d');
		}
	}
	
	AttackStatsGraph.prototype.iniciar = function() {
		$.ajax({
			url: 'attack',
			method: 'GET', 
			success: onDadosRecebidos.bind(this)
		});
	}
	
	function onDadosRecebidos(vendaMes) {
		var playersName = [];
		var shots = [];
		var goals = [];
		var shotsOnTarget = [];
		var goalsFromHeader = [];
		var goalsFromPenalty = [];
		var goalsFromFreeKick = [];
		var offSides = [];
		var crosses = [];
		var productives = [];
		var games = [];
		
		vendaMes.forEach(function(obj) {
			playersName.unshift(obj.playerName);
			goalsFromFreeKick.unshift(obj.goalsFromFreeKick);
			offSides.unshift(obj.offSides);
			crosses.unshift(obj.crosses);
			shots.unshift(obj.shots);
			shotsOnTarget.unshift(obj.shotsOnTarget);
			goalsFromHeader.unshift(obj.goalsFromHeader);
			goalsFromPenalty.unshift(obj.goalFromPenalty);
			productives.unshift(obj.productive)
			games.unshift(obj.games)
			goals.unshift(obj.goals)
		});
		
		var attackStatsGraph = new Chart(this.ctx, {
		    type: 'bar',
		    data: {
		    	labels: playersName,
		    	datasets: [{
		    		label: 'Shots',
		    		backgroundColor: "rgba(255,69,0,0.5)",
	                data: shots
		    	},{
		            label: 'Shots on target',
		            backgroundColor: "rgba(128,0,0,1)",
		            data: shotsOnTarget,
		          },{
			            label: 'Total of goals',
			            backgroundColor: "rgba(0,128,0,0.5)",
			            data: goals,
			          },{
			            label: 'Goals from header',
			            backgroundColor: "rgba(0,255,255,1)",
			            data: goalsFromHeader,
			          },{
				            label: 'Goals from penalty',
				            backgroundColor: "rgba(255,165,0,1)",
				            data: goalsFromPenalty,
				          },{
						            label: 'Goals from free kick',
						            backgroundColor: "rgba(0,100,0,1)",
						            data: goalsFromFreeKick,
						          },{
							            label: 'Offsides',
							            backgroundColor: "rgba(255,0,0,1)",
							            data: offSides,
							          },{
									            label: 'crosses',
									            backgroundColor: "rgba(0,255,0,1)",
									            data: crosses,
									          },{
					            label: 'Played games',
					            backgroundColor: "rgba(0,0,255,1)",
					            data: games,
					            type: 'bubble'
					          }, {
		            label: 'Productivity',
		            backgroundColor: "rgba(26,179,148,0.1)",
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
	
	return AttackStatsGraph;
	
}());


$(function() {
	var attackStatsGraph = new Brewer.AttackStatsGraph();
	
	attackStatsGraph.iniciar();
	
});
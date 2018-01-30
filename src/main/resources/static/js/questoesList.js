const test = (target,arg) => {
		if(arg == 'any')
			return true;
	return target.indexOf(arg) > -1;
};


$("#btFilter").click(() => {
				var materia = $('#selectMateria').val();
				var dificuldade= $('#selectDificuldade').val();
				
			    $("#tableQuestoes tr").filter(function() {
			    	
			      $(this).toggle(test($(this).text(), materia) &&
			    		  test($(this).text(), dificuldade));
			    });
			    
			    if ($("#tableQuestoes tr:visible").length == 0)
			    	$(".col-centered").prepend(`
			    	<div class="container" id="warning">
				     	<div class="row">
						     <div class=" col-centered">
						     	<p class="text-warning">Sem Questões</p>
					     	</div>
			    		</div>
				    </div>
			    	`);
			    else
			    	$('#warning').remove();
			});

function buildModal(id) {
	$.get("/questao/" + id, (data, status)=> {
		if(status =='success') {			
			$('#modalLabel').text(`Questão de ${data.materia.nome} - ${data.dificuldade}`);
			$('#modalCorpo').text(data.corpo);
			
			$('#modalUsadaEm').text(data.usadaEm != null ? `Questão utilizada em ${dateFormatter(new Date(data.usadaEm))}` :
				'');
						
			$('#modalQuestaoImg').attr('src',data.urlQuestao != null ? data.urlQuestao : 'img/semImagem.png');
			
			$("#modalUtilizar").val(id);
			$('#modalQuestao').modal('show');	
				
		} else {
			alert('Algo deu errado');
		}
		
	});
}
	
function utilizarQuestao() {
	let idQuestao = $("#modalUtilizar").val();
	console.log(idQuestao);
	
	$.ajax({
	    url:'/utilizarQuestao',
	    type:'POST',
	    data: JSON.stringify(idQuestao),
	    dataType: 'json',
	    contentType: "application/json; charset=utf-8",
	    success: data => {
	        $($('#line' + idQuestao).children()[3]).text(dateFormatter(new Date(data)));
	    },
	    error: res => {
	        alert("Bad thing happend! " + res.statusText);
	    }
	});
}

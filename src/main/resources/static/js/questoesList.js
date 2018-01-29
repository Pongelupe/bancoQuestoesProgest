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
			});

function buildModal(id) {
	$.get("/questao/" + id, (data, status)=> {
		if(status =='success') {			
			$('#modalLabel').text(`Questão de ${data.materia.nome} - ${data.dificuldade}`);
			$('#modalDescricao').text(data.corpo);
			
			if(data.usadaEm != null)
				$('#modalUsadaEm').text(`Questão utilizada em ${data.usadaEm}`);
			if(data.processoSeletivo)
				$('#modalProcessoSeletivo').text(`Questão de processo seletivo`);
			if(data.urlQuestao != null) {
				let imgQuestao = $('<img> </img>');
				imgQuestao.attr('src',data.urlQuestao);
				imgQuestao.appendTo('.modal-body');
			}
			$("#modalUtilizar").val(id);
			$('#modalQuestao').modal('show');	
				
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
	    success: res => {
	        alert("it works!");
	    },
	    error: res =>{
	        alert("Bad thing happend! " + res.statusText);
	    }
	});
}

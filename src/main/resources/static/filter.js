var test = (target,arg) => {
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

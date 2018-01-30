function dateFormatter(data) {

		let month = data.getMonth()+1;
		month = month < 10? ('0' + month) : month; 
        return `${data.getDate()}/${month}/${data.getFullYear()}`;
    }
// check á»Ÿ chá»— nÃ y, Æ°ng check thÃ¬ viáº¿t funtion thÃªm á»Ÿ dÆ°á»›i Ä‘Ã¢y :v
	function checkAll(id1, gioiHan1, id2, gioiHan2, id3, gioiHan3){
		if (checkUser(id1, gioiHan1) && checkUser(id2, gioiHan2) && checkSDT(id3, gioiHan3)){
			return true;
		} else return false;
	}
	
	//check cho cÃ¡c tháº» input bÃ¬nh thÆ°á»�ng nhÆ° há»� vÃ  tÃªn, Ä‘á»‹a chá»‰.
	function checkInputNormal(id, gioiHan){
		if (checkNull(id)&& checkAllSpace(id) && checkMaxLength(id, gioiHan) && checkSpecialChar(id)){
			//if (checkAllSpace(id))
				//if (checkMaxLength(id, gioiHan))
					//if (checkSpecialChar(id))
						return true;
		} else return false;
	}
	
	//check cho cÃ¡c tháº» User hoáº·c pass (ko cÃ³ kÃ­ tá»± trá»‘ng)
	function checkUser(id, gioiHan){
		if (checkNull(id)){
			if (checkAllSpace(id) && checkHaveSpace(id))
				if (checkMaxLength(id, gioiHan))
					if (checkSpecialChar(id))
						return true;
		} else return false;
	}
	
	//check cho trÆ°á»�ng sá»‘ Ä‘iá»‡n thoáº¡i
	function checkSDT(id, gioiHan){
		if (checkNull(id) && checkAllSpace(id) && checkMaxLength(id, gioiHan) && checkJustNumberic(id)){
			return true;
		}
			else return false;
	}
	
	function checkNull(id){
		var text = document.getElementById(id).value;
		if (text == null || text =="") {
			alert("Lỗi: "+id+" không được để trống.");
			return false;
		} else {
			return true;
		}
	}
	
	function checkAllSpace(id){
		var text = document.getElementById(id).value;
		if (/^\s*$/.test(text)){
			alert("Lỗi: "+id +" không được toàn bộ là khoảng trắng.");
			return false;
		}else return true;
	}
	
	function checkHaveSpace(id){
		var text = document.getElementById(id).value;
		
		if (text.indexOf(' ')>=0){
			alert("Lỗi: "+id+" có chứa khoảng trắng.");
			return false;
		} else {
			return true;
		}
	}
	
	function checkMaxLength(id, gioiHan) {
		var text = document.getElementById(id).value;
		var textlength = text.length;
		
		if (textlength>=gioiHan) {
			alert("Lỗi: "+id+" vượt quá độ dài quy định (Độ dài <= "+gioiHan+")");
			return false;
		}else {
			return true;
		}
	}
	
	function checkMaxLengthTextArea(id, gioiHan){
		var str = document.getElementById(id).value;
		var text = str.trim();
		var textlength = text.length;
		
		if (textlength>=gioiHan) {
			alert("Lỗi: "+id+" vượt quá độ dài quy định (Độ dài <= "+gioiHan+")");
			return false;
		}else {
			return true;
		}
	}
	
	function checkSpecialChar(id) {
		var text = document.getElementById(id).value;
		var regex = new RegExp(/[~`!#$%\^&*+=\-\[\]\\';,/{}|\\":<>\?]/);
		
		if (regex.test(text)){
			alert("Lỗi: " +id+ " có chứa ký tự đặc biệt. "+"(~`!#$%^&*+=-[]\\\';,/{}|\":<>?)");
			return false;
		}else return true;
	}
	
	function checkJustNormalChar(id) {
		var text = document.getElementById(id).value;
		var regex = new RegExp("^[a-zA-Z]*$");
		
		if (!regex.test(text)){
			alert("Lỗi: "+id+ " có chứa kí tự không phải là chữ.");
			return false;
		} else return true;
	}
	
	function checkJustNumberic(id) {
		var text = document.getElementById(id).value;
		var regex = new RegExp("^[0-9]*$");
		
		if (!regex.test(text)){
			alert("Lỗi: "+ id+ " có chứa ký tự không phải là số.");
			return false;
		} else return true;
	}
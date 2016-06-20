	function deleteBaiViet(){
		if (confirm("Bạn Có Chắc Muốn Xóa Bài Viết Này....?")) return true;
		else return false;
	}
	
	function deleteComment(){
		if (confirm("Bạn Có Chắc Muốn Xóa Bình Luận Này....?")) return true;
		else return false;
	}

//-----------------------------------Check sua binh luan---------------------------
	function checkSuaBinhLuan(id, gioiHan){
		if (checkNoiDung(id, gioiHan)) return true;
		else return false;
	}



//------------------------------------Check Them Bai Viet------------------------------------------
	function checkThemBaiViet(id1, gioiHan1, id2, gioiHan2) {
		if (checkTieuDe(id1, gioiHan1) && checkNoiDung(id2, gioiHan2)) return true;
		else return false;
	}

	function checkTieuDe(id, gioiHan){
		if (checkNull(id) && checkAllSpace(id) && checkMaxLength(id, gioiHan))
			return true;
		else return false;
	}
//--------------------------------------------------------------------------------
// check ở chỗ này, ưng check thì viết funtion thêm ở dưới đây :v
	function checkAll(id1, gioiHan1, id2, gioiHan2, id3, gioiHan3){
		if (checkUser(id1, gioiHan1) && checkUser(id2, gioiHan2) && checkSDT(id3, gioiHan3)){
			return true;
		} else return false;
	}
	
	//check cho các thẻ input bình thường như họ và tên, địa chỉ.
	function checkInputNormal(id, gioiHan){
		if (checkNull(id)){
			if (checkAllSpace(id))
				if (checkMaxLength(id, gioiHan))
					if (checkSpecialChar(id))
						return true;
		} else return false;
	}
	
	//check cho các thẻ User hoặc pass (ko có kí tự trống)
	function checkUser(id, gioiHan){
		if (checkNull(id)){
			if (checkAllSpace(id) && checkHaveSpace(id))
				if (checkMaxLength(id, gioiHan))
					if (checkSpecialChar(id))
						return true;
		} else return false;
	}
	
	//check cho thẻ nội dung bài viết hoặc comment
	function checkNoiDung(id, gioiHan){
		if (checkNull(id) && checkAllSpace(id) && checkMaxLengthTextArea(id, gioiHan))
			return true;
		else return false;
	}
	
	//check cho trường số điện thoại
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
	
	//---------------------------------Script hinh anh--------------------------------
	function PreviewImage() {
		var oFReader = new FileReader();
		oFReader.readAsDataURL(document.getElementById("uploadImage").files[0]);
		var s = document.getElementById("uploadImage").value;
		
		var ss = s.substring(s.lastIndexOf("."));
		console.log(ss);
		if( ss != ".jpg"  && ss != ".png" && ss != ".JPG"  && ss != ".PNG"){
			alert("Vui lòng chọn đúng định dạng ảnh là jpg hoặc png");
		}
		var img = document.getElementById("uploadImage");
		oFReader.onload = function(oFREvent) {
			document.getElementById("uploadPreview").src = oFREvent.target.result;
		};
	}
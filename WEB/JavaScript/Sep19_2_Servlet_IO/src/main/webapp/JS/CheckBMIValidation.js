function validData(){
	let myName = document.ff.myName;
	let myHeight = document.ff.myHeight;
	let myWeight = document.ff.myWeight;
	let myPhoto = document.ff.myPhoto;
	
	let Validation = true;
	//이름
	if(isEmpty(myName) || containsAnother(myName)) {
		alert("이름이 비어있거나 영어가 아닌 무언가가 있습니다.");
	Validation = false;
	}
	//키
	if(isEmpty(myHeight) || isNotNumber(myHeight)) {
		alert("키가 비어있거나 숫자만 입력가능합니다.");
		Validation = false;
		}
	//몸무게
	if(isEmpty(myWeight) || isNotNumber(myWeight)) {
		alert("몸무게가 비어있거나 숫자만 입력가능합니다.");
		Validation = false;
		}
	//파일
	let type = ["PNG","JPG","png","jpg"];
	if(isEmpty(myPhoto) || isNotType( myPhoto, type )) {
		alert("photo가 비어있거나 파일 양식이 잘못 되었습니다.");
		Validation = false;
		}
	return Validation;
}



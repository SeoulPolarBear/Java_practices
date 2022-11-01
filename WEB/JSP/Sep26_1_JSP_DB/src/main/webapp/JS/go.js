function goMeatDetail(id){
	location.href = "MeatDetailController?m_id=" + id;
}

function deleteMeatDetail(id){
	let t = confirm("삭제하겠습니까?");
	if(t)
	location.href = "MeatDeleteController?m_id=" +id;
}
function goMeatDetail(id){
	location.href = "MeatDetailController?m_id=" + id;
}

function deleteMeatDetail(id){
	let t = confirm("�����ϰڽ��ϱ�?");
	if(t)
	location.href = "MeatDeleteController?m_id=" +id;
}
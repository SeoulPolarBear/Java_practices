const validation = () => {
	let m_price = document.f.m_price;

	if (isEmpty(m_price) || containsAnother(m_price) || isNotNumber(m_price)) {
		alert("비었거나 특수문자가 있거나 숫자가 아닙니다.");
		return false;
	}
	return true;
}
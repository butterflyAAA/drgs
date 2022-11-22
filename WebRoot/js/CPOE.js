function loginHTCPOE(userid) {
	return window.external.HTCPOELogin(userid);
}

function setDutyHTCPOE(dutyType,deptCode,wardCode) {
	return window.external.HTCPOEDuty(dutyType,deptCode,wardCode);
}


function getFuncsXml() {
	return window.external.getFuncTreeXml();
}

function setPatientHTCPOE(ipid) {
	window.external.HTCPOEPatient(ipid);
}

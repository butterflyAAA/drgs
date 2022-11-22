package com.haitaiinc.hisdb.his.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.his.VPatientinfo;

public class VPatientinfoTableAdapter extends TableAdapter<VPatientinfo> {

	public VPatientinfoTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "PID", "INSURANCE_NO", "PATIENT_NAME", "TMP_FLAG", "LASTNAME", "FIRSTNAME", "PY", "WB", "SEX_CODE", "SEX", "DATA_OF_BIRTH", "TIME_OF_BIRTH", "MARRIAGE_STATUS_CODE", "MARRIAGE_STATUS", "OCCUPATION_CODE", "OCCUPATION", "NATIONALITY_CODE", "NATIONALITY", "COUNTRY_CODE", "COUNTRY", "FORMAL_SCHOOLING_CODE", "FORMAL_SCHOOLING", "RELIGION", "BIRTHPLACE_CODE", "BIRTHPLACE", "NATIVE_PLACE_CODE", "NATIVE_PLACE", "CERT_TYPE_CODE", "CERT_TYPE", "CERT_NO", "PATIENT_CLASS_CODE", "PATIENT_CLASS", "FEE_TYPE_CODE", "FEE_TYPE", "COMPANY", "PUBLIC_EXPENSE_NO", "CONTRACT_UNIT_CODE", "CONTRACT_UNIT", "BUSINESS_ADDRESS_CODE", "BUSINESS_ADDRESS", "BUSINESS_POSTCODE", "BUSINESS_PHONE", "HOME_ADDRESS_CODE", "HOME_ADDRESS", "MOBILE_PHONE", "CONTACT", "RELATION_CODE", "RELATION", "CONTACT_EMAIL", "CONTACT_PHONE", "VIP_TYPE", "OPERATOR_ID", "OPERATOR", "OPERATOR_TIME", "AVAILABLE", "INSURANCE_TYPE_CODE", "INSURANCE_TYPE", "REGISTERED_ADDRESS_CODE", "REGISTERED_ADDRESS", "CONTACT_ADDRESS_CODE", "CONTACT_ADDRESS", "REGISTERED_EMAIL", "HOME_POSTCODE", "BLOOD_TYPE", "RH_BLOOD_TYPE", "ORGID" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 12, 12, 12, 1, 1, 1, 12, 12, 12, 12, 12, 1, 12, 12, 1, 12, 12, 12, 12, 12, 1, 1, 1, 12, 12, 12, 12, 1, 12, 12, 12, 12, 1, 1, 12, 1, 1, 12, 1, 1, 1, 12, 1, 12, 12, 12, 12, 12, 1, 12, 1, 12, 12, 12, 1, 12, 12, 12, 12, 1, 1, 12, 12, 12, 1, 12 };
	}

	protected String initSchemaName() {
		return "HIS";
	}

	protected String initTableName() {
		return "V_PATIENTINFO";
	}
}
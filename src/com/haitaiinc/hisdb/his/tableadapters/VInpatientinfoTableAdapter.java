package com.haitaiinc.hisdb.his.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.his.VInpatientinfo;

public class VInpatientinfoTableAdapter extends TableAdapter<VInpatientinfo> {

	public VInpatientinfoTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "IPID", "PID", "ADMINISSION_NO", "ADMISSION_TIMES", "PATIENT_NAME", "SEX_CODE", "SEX", "AGE", "AGE_DESC", "MARRIAGE_STATUS_CODE", "MARRIAGE_STATUS", "FEE_TYPE_CODE", "FEE_TYPE_NAME", "PATIENT_CLASS", "ADMISSION_REGISTER_TIME", "ADMISSION_WAY", "ADMISSION_PURPOSE", "ADMISSION_TIME", "ADMISSION_HOSPITAL", "ADMISSION_DEPT_CODE", "ADMISSION_DEPT", "ADMISSION_WARD_CODE", "ADMISSION_WARD", "DEPT_CODE", "DEPT_NAME", "WARD_CODE", "WARD_NAME", "DISCHARGE_TIME", "BED_NO", "BED_FEE_TYPE", "ROOM", "STATE_OF_ILLNESS", "DOCTOR_ID", "DOCTOR", "MEDICAL_FRP_CODE", "MEDICAL_GRP", "NURSIONG_LEVEL", "NURSE_ID", "NURSE", "NURSING_GRP_CODE", "NURSIONG_GRP", "MR_STATUS", "ZZ_DOCTOR_CODE", "ZZ_DOCTOR_NAME", "ZR_DOCTOR_CODE", "ZR_DOCTOR_NAME", "IN_HOPITAL_DAY", "REGISTER_DIAGNOSIS", "REGISTER_CODE", "DQ_FYZE", "DQ_YJJZE", "D4401" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 3, 12, 12, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 12, 12, 1, 12, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 12, 12, 12, 12, 1, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 3, 12 };
	}

	protected String initSchemaName() {
		return "HIS";
	}

	protected String initTableName() {
		return "V_INPATIENTINFO";
	}
}
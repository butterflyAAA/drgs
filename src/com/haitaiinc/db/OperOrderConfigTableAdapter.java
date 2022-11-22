package com.haitaiinc.db;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.db.OperOrderConfig;

public class OperOrderConfigTableAdapter extends TableAdapter<OperOrderConfig> {

	public OperOrderConfigTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "REC_SN", "IPID", "OPERATION_NAME", "OPERATION_CODE", "OPERATION_LEVEL", "OPERATION_LEVEL_CODE", "ORDINAL", "IS_NEW", "OPERA_SN", "HEAL_GRADE", "HEAL_GRADE_CODE", "CUT_GRADE_NAME", "CUT_GRADE_CODE", "OPERATION_TIME", "OPER_TYPE", "OPERA_COMPLICATION_CODE", "OPERA_COMPLICATION_NAME", "IS_OPER_AID", "OPERATION_START_TIME", "OPERATION_END_TIME", "OPERATION_DOCTOR", "OPERATION_DOCTOR_ID", "ASSISTANT_I", "ASSISTANT_I_CODE", "ASSISTANT_II", "ASSISTANT_II_CODE", "OPERATION_ROOM", "OPERATION_ROOM_CODE", "ASA_LEVEL_CODE", "ASA_LEVEL_NAME", "ANESTHESIA", "ANESTHESIA_CODE", "ANESTHESIA_DOCTOR_CODE", "ANESTHESIA_DOCTOR", "RISK_LEVEL_CODE", "RISK_LEVEL_NAME", "IS_ELECTIVE", "IS_MAIN_OPERATION", "OPERATION_START_EXACT_TIME", "OPERATION_END_EXACT_TIME", "INTRAOPERATIVE_FOREIGN_BODY", "IS_ANTIBACTERIAL", "ANTIMICROBIALS_DAY", "UNPLANNED_SURGERY", "DAY_SURGERY", "OPERATION_CONTINUED_TIME", "IS_MAIN_DRG", "OPER_RESOURCES_ORDINAL", "OPERATION_COUNTRY_CODE", "OPERATION_COUNTRY_NAME", "IS_ORDER_SAVE", "DIP_OPERA_ORDINAL", "DIP_OPERA_NAME", "IS_OVER_THREE_HOURS" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 12, 12, 12, 12, 12, 12, 3, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
	}

	protected String initSchemaName() {
		return "INPCASE";
	}

	protected String initTableName() {
		return "OPER_ORDER_CONFIG";
	}
}
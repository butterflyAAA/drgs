package com.haitaiinc.hisdb.his.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.his.PatInpatDiagnosis;

public class PatInpatDiagnosisTableAdapter extends TableAdapter<PatInpatDiagnosis> {

	public PatInpatDiagnosisTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "ZYZDJL_ID", "PAT_ID", "ZYLSH", "YS_ID", "ZD_RQ", "ZD_ICD", "ZDLX_ID", "BRLX_ID", "TJM_ID", "ZLJG_ID", "JBA_FLAG", "RYBQ_ID", "FB_ID", "FY_ID", "CJSJ", "CJR", "ZHGXSJ", "ZHGXR", "BGK_FLAG", "DRLX", "DZBL_MC", "DZBL_CODE", "ZDSH", "SBBZ", "ZDNR" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 3, 12, 3, 12, 93, 12, 12, 12, 12, 12, 1, 12, 12, 12, 93, 12, 93, 12, 12, 12, 12, 12, 12, 1, 12 };
	}

	protected String initSchemaName() {
		return "HIS";
	}

	protected String initTableName() {
		return "PAT_INPAT_DIAGNOSIS";
	}
}
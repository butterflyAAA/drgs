package com.haitaiinc.hisdb.drgs.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.drgs.BsDiseinfo;

public class BsDiseinfoTableAdapter extends TableAdapter<BsDiseinfo> {

	public BsDiseinfoTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "PALG_NO", "IPT_PATN_DISEDIAG_TYPE_CODE", "DISEDIAG_TYPE", "MAINDIAG_FLAG", "DIAG_CODE", "DIAG_NAME", "INHOSP_DIAG_CODE", "INHOSP_DIAG_NAME", "ADM_DISE_COND_NAME", "ADM_DISE_COND_CODE", "ADM_COND", "ADM_COND_CODE", "HIGH_DIAG_EVID", "BKUP_DEG", "BKUP_DEG_CODE", "VALI_FLAG", "IPT_MEDCAS_HMPG_SN", "MDTRT_SN", "FIXMEDINS_CODE", "BRXH", "SXH", "DIAG_TYPE", "JGDM" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 3, 3, 12, 12 };
	}

	protected String initSchemaName() {
		return "DRGS";
	}

	protected String initTableName() {
		return "BS_DISEINFO";
	}
}
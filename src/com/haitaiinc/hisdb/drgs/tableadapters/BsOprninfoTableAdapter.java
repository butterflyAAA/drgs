package com.haitaiinc.hisdb.drgs.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.drgs.BsOprninfo;

public class BsOprninfoTableAdapter extends TableAdapter<BsOprninfo> {

	public BsOprninfoTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "OPRN_OPRT_DATE", "OPRN_OPRT_NAME", "OPRN_OPRT_CODE", "OPRN_OPRT_SN", "OPRN_LV_CODE", "OPRN_LV_NAME", "OPER_NAME", "ASIT1_NAME", "ASIT2_NAME", "SINC_HEAL_LV", "SINC_HEAL_LV_CODE", "ANST_MTD_NAME", "ANST_MTD_CODE", "ANST_DR_NAME", "OPRN_OPER_PART", "OPRN_OPER_PART_CODE", "OPRN_CON_TIME", "ANST_LV_NAME", "ANST_LV_CODE", "OPRN_PATN_TYPE", "OPRN_PATN_TYPE_CODE", "MAIN_OPRN_FLAG", "ANST_ASA_LV_CODE", "ANST_ASA_LV_NAME", "ANST_MEDN_CODE", "ANST_MEDN_NAME", "ANST_MEDN_DOS", "UNT", "ANST_BEGNTIME", "ANST_ENDTIME", "ANST_COPN_CODE", "ANST_COPN_NAME", "ANST_COPN_DSCR", "PACU_BEGNTIME", "PACU_ENDTIME", "CANC_OPRN_FLAG", "VALI_FLAG", "IPT_MEDCAS_HMPG_SN", "MDTRT_SN", "BRXH", "SXH", "OPER_CODE", "ANST_DR_CODE", "ASIT2_CODE", "ASIT1_CODE", "OPRN_OPRT_TYPE", "JGDM" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 93, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 93, 93, 12, 12, 12, 93, 93, 12, 12, 12, 12, 3, 3, 12, 12, 12, 12, 12, 12 };
	}

	protected String initSchemaName() {
		return "DRGS";
	}

	protected String initTableName() {
		return "BS_OPRNINFO";
	}
}
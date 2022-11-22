package com.haitaiinc.hisdb.dictmanage.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.dictmanage.DictICD;

public class DictICDTableAdapter extends TableAdapter<DictICD> {

	public DictICDTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "ICD_CODE", "JB_MC", "ZDFL_ID", "BBH", "DEL_FLAG", "PYM", "ZDYM", "CJSJ", "CJR", "ZHGXSJ", "ZHGXR", "CODE", "ZFJB", "REMARK", "JKZX_BM", "CRB_FLAG", "ICD_TNB_FLAG", "AFP_FLAG", "GL_FLAG", "CSQX_FLAG", "CRB_FHTX", "LX", "JBDM", "JSLXDM" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 12, 12, 12, 12, 1, 12, 12, 93, 12, 93, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1, 12, 12, 1 };
	}

	protected String initSchemaName() {
		return "DICTMANAGE";
	}

	protected String initTableName() {
		return "DICT_ICD";
	}
}
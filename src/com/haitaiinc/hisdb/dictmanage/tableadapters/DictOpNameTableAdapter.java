package com.haitaiinc.hisdb.dictmanage.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.dictmanage.DictOpName;

public class DictOpNameTableAdapter extends TableAdapter<DictOpName> {

	public DictOpNameTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "SS_ID", "SS_MC", "SSDJ_ID", "PYM", "ZDYM", "DEL_FLAG", "CJSJ", "CJR", "ZHGXSJ", "ZHGXR", "BACODE", "OPTYPE", "OPCODE", "SFSY" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 12, 12, 12, 12, 12, 1, 93, 12, 93, 12, 12, 12, 3, 1 };
	}

	protected String initSchemaName() {
		return "DICTMANAGE";
	}

	protected String initTableName() {
		return "DICT_OP_NAME";
	}
}
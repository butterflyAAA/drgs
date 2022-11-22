package com.haitaiinc.hisdb.dictmanage.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.dictmanage.DictDepart;

public class DictDepartTableAdapter extends TableAdapter<DictDepart> {

	public DictDepartTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ 
				"BM_ID", "BM_MC", "BM_BH", "BM_BM", "BM_LX", 
			    "DEL_FLAG", 
				"PYM", "ZDYM", "CJSJ", "CJR", "ZHGXSJ",
				"MICODE" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 
				12, 12, 12, 12, 12, 
				1, 
				12, 12, 93, 12, 93, 
				12 };
	}

	protected String initSchemaName() {
		return "WYHSXSYY";
	}

	protected String initTableName() {
		return "DICT_DEPART";
	}
}
package com.haitaiinc.hisdb.dictmanage.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.dictmanage.TplTemplate;

public class TplTemplateTableAdapter extends TableAdapter<TplTemplate> {

	public TplTemplateTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "TPL_ID", "TPL_VERSION", "TPL_NAME", "TPL_NAME_PY", "TPL_DESC", "TPL_DATA", "TPL_STATUS", "TREE_NODE", "NODE_INDEX", "CREATOR", "CREATE_TIME", "MODIFIER", "MODIFY_TIME", "OWNER_ORG", "INOUT_FLAG", "TPL_TYPE", "TPL_USE_TYPE" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 12, 12, 12, 12, 12, 2005, 12, 12, 3, 12, 12, 12, 12, 12, 12, 12, 12 };
	}

	protected String initSchemaName() {
		return "DICTMANAGE";
	}

	protected String initTableName() {
		return "TPL_TEMPLATE";
	}
}
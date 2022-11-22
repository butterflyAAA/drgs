package com.haitaiinc.hisdb.drgs.tableadapters;

import com.haitaiinc.data.DBOperator;
import com.haitaiinc.data.tableadapter.TableAdapter;
import com.haitaiinc.hisdb.drgs.FrontSheet;

public class FrontSheetTableAdapter extends TableAdapter<FrontSheet> {

	public FrontSheetTableAdapter(DBOperator dbo) {
		super(dbo);
	}

	protected String[] initColumnNames() {
		return new String[]{ "IPID", "PID", "XML_CONT", "DEPT_NAME", "DEPT_CODE", "WARD_NAME", "WARD_CODE", "CREATE_TIME", "CREATOR", "MODIFY_TIME", "MODIFIER", "TPL_ID", "TPL_VERSION" };
	}

	protected int[] initColumnTypes() {
		return new int[]{ 12, 12, 2007, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 };
	}

	protected String initSchemaName() {
		return "DRGS";
	}

	protected String initTableName() {
		return "FRONT_SHEET";
	}
}
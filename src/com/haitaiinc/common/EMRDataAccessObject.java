package com.haitaiinc.common;

import com.haitaiinc.data.DataAccessObject;

public class EMRDataAccessObject extends DataAccessObject
{
  protected String initDataSourceName()
  {
    return "HTDB";
  }
}
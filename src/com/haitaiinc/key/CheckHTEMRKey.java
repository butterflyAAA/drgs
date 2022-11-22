package com.haitaiinc.key;


public class CheckHTEMRKey {
  private static HTEMRKey htmerKey = null;
  
  public static HTEMRKey checkHTEMRKey() {
    if (htmerKey == null) {
      htmerKey = new HTEMRKey();
      try {
        String filename = CheckHTEMRKey.class.getResource("/HTEMR3.key").getPath();
        filename = filename.replace("/", "\\");
        System.out.println("filename=" + filename);
        boolean flag = true;
        System.out.println("Register.verify=" + flag);
        htmerKey.setCheckFlag(flag);
        if (flag) {
          String funids = ",,";
          funids = funids.toLowerCase();
          System.out.println("funids=" + funids);
          htmerKey.setFuncId(funids);
        } 
      } catch (Exception e) {
        e.printStackTrace();
      } 
    } 
    return htmerKey;
  }
}

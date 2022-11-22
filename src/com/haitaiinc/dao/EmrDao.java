package com.haitaiinc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.haitaiinc.Util;
import com.haitaiinc.common.EMRDataAccessObject;
import com.haitaiinc.data.DBOperator;
import com.haitaiinc.db.OperOrderConfig;
import com.haitaiinc.db.OperOrderConfigTableAdapter;
import com.haitaiinc.htdb.adt.dto.Inpatient;
import com.haitaiinc.htdb.adt.tableadapters.InpatientTableAdapter;
import com.haitaiinc.htdb.comm.dto.SystemDict;
import com.haitaiinc.htdb.comm.tableadapters.SystemDictTableAdapter;
import com.haitaiinc.htdb.inpcase.dto.AdmissionDischarge24HRec;
import com.haitaiinc.htdb.inpcase.dto.BivariateStructsSheet;
import com.haitaiinc.htdb.inpcase.dto.Death24HRec;
import com.haitaiinc.htdb.inpcase.dto.DeathRec;
import com.haitaiinc.htdb.inpcase.dto.DischargeSummary;
import com.haitaiinc.htdb.inpcase.dto.FrontSheet;
import com.haitaiinc.htdb.inpcase.dto.FrontSheetFee;
import com.haitaiinc.htdb.inpcase.dto.HospitalRecord;
import com.haitaiinc.htdb.inpcase.dto.InpAllInfo;
import com.haitaiinc.htdb.inpcase.dto.InpDiag;
import com.haitaiinc.htdb.inpcase.dto.OperationInfoRec;
import com.haitaiinc.htdb.inpcase.dto.ProgressNote;
import com.haitaiinc.htdb.inpcase.tableadapters.AdmissionDischarge24HRecTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.BivariateStructsSheetTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.Death24HRecTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.DeathRecTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.DischargeSummaryTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.FrontSheetFeeTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.FrontSheetTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.HospitalRecordTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.InpAllInfoTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.InpDiagTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.OperationInfoRecTableAdapter;
import com.haitaiinc.htdb.inpcase.tableadapters.ProgressNoteTableAdapter;
import com.haitaiinc.htdb.inpord.dto.DrugOrder;
import com.haitaiinc.htdb.inpord.dto.MedicalOrder;
import com.haitaiinc.htdb.inpord.tableadapters.DrugOrderTableAdapter;
import com.haitaiinc.htdb.inpord.tableadapters.MedicalOrderTableAdapter;
import com.haitaiinc.htdb.inptemper.dto.Temperature;
import com.haitaiinc.htdb.inptemper.dto.TemperatureDetail;
import com.haitaiinc.htdb.inptemper.tableadapters.TemperatureDetailTableAdapter;
import com.haitaiinc.htdb.inptemper.tableadapters.TemperatureTableAdapter;
import com.haitaiinc.htdb.mpi.dto.Patient;
import com.haitaiinc.htdb.mpi.tableadapters.PatientTableAdapter;
import com.haitaiinc.htdb.template.dto.TplTemplate;
import com.haitaiinc.htdb.template.tableadapters.TplTemplateTableAdapter;
import com.haitaiinc.htdb.usermgmt.dto.UserInfo;
import com.haitaiinc.htdb.usermgmt.tableadapters.UserInfoTableAdapter;

public class EmrDao extends EMRDataAccessObject{

	public List<ProgressNote> getProgressNoteByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<ProgressNote> list=new ProgressNoteTableAdapter(dbo).select("ipid=? ",new int[1],new String[]{ipid},"PN_DATE_TIME");
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public DeathRec getDeadRecByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<DeathRec> list=new DeathRecTableAdapter(dbo).select("ipid=? and rec_cfg_type='DeathRec'",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public DischargeSummary getDischargeSummaryByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			
			List<DischargeSummary> list=new DischargeSummaryTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public HospitalRecord getAdmissionDischarge24hRecByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<AdmissionDischarge24HRec> list=new AdmissionDischarge24HRecTableAdapter(dbo).select("ipid=? ",new int[1],new String[]{ipid});
			//return list!=null&&list.size()>0?list.get(0):null;
			if(list!=null&&list.size()>0){
				AdmissionDischarge24HRec ad24Hr=list.get(0);
				HospitalRecord hr=new HospitalRecord();
				hr.setXmlCont(ad24Hr.getXmlCont());
				hr.setIpid(ipid);
				hr.setCreateTime(ad24Hr.getCreateTime());
				hr.setCreator(ad24Hr.getCreator());
				return hr;
			}
			
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public HospitalRecord getHospitalRecordByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<HospitalRecord> list=new HospitalRecordTableAdapter(dbo).select("ipid=? ",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public AdmissionDischarge24HRec getAdmissionDischarge24HRecByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<AdmissionDischarge24HRec> list=new AdmissionDischarge24HRecTableAdapter(dbo).select("ipid=? ",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public Death24HRec getDeath24HRecByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<Death24HRec> list=new Death24HRecTableAdapter(dbo).select("ipid=? ",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public List<MedicalOrder> getMedicalOrderByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<MedicalOrder> list=new MedicalOrderTableAdapter(dbo).select("ipid=? ",new int[1],new String[]{ipid},"START_TIME,CREATE_TIME");
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	
	public Map<String,DrugOrder> getDrugOrderByIpid(String ipid){
		Map<String,DrugOrder> map=new HashMap<String,DrugOrder>();
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<DrugOrder> list=new DrugOrderTableAdapter(dbo).select("ipid=? ",new int[1],new String[]{ipid});
			for(int i=0;list!=null&&i<list.size();i++){
				DrugOrder dOrder=list.get(i);
				if(map.containsKey(dOrder.getOrderSN())){
					
				}else{
					map.put(dOrder.getOrderSN(), dOrder);
				}
			}
			return map;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	
	public List<OperationInfoRec> getOperationInfoRecListByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<OperationInfoRec> list=new OperationInfoRecTableAdapter(dbo).select("ipid=? and REC_CFG_TYPE='OperationRec'",new int[1],new String[]{ipid},"OPERATION_TIME");
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public List<InpDiag> getInpDiagListByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<InpDiag> list=new InpDiagTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid},"ORDINAL");
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public List<InpDiag> getInpDiagListByIpid2(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<InpDiag> list=new InpDiagTableAdapter(dbo).select("ipid=? and diag_type_code in ('cyzd','swzd')",new int[1],new String[]{ipid},"ORDINAL");
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public FrontSheetFee getFrontSheetFeeByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<FrontSheetFee> list=new FrontSheetFeeTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public Map<String,List<SystemDict>> getSystemDictListByItemType(){
		Map<String,List<SystemDict>> map=new HashMap<String,List<SystemDict>>();
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<SystemDict> list=new SystemDictTableAdapter(dbo).select("item_type in ('BloodType','naty','nat_regn_code','RhBloodType')");
			for(int i=0;list!=null&&i<list.size();i++){
				SystemDict sd=list.get(i);
				String itemType=sd.getItemType();
				if(map.containsKey(itemType)){
					List<SystemDict> tempList=map.get(itemType);
					tempList.add(sd);
					map.put(itemType, tempList);
				}else{
					List<SystemDict> tempList=new ArrayList<SystemDict>();
					tempList.add(sd);
					map.put(itemType, tempList);
				}
			}
			
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return map;
	}
	
	
//	public List<SystemDict> getSystemDictListByItemType1(String itemType){
//		DBOperator dbo = null;
//		try{
//			dbo=getDBOperator();
//			List<SystemDict> list=new SystemDictTableAdapter(dbo).select("item_type=?",new int[1],new String[]{itemType});
//			return list;
//		}catch(Exception e){
//			if(dbo!=null){
//				dbo.rollback();
//			}
//			e.printStackTrace();
//		}finally{
//			if(dbo!=null){
//				dbo.close();
//			}
//		}
//		return null;
//	}
	
	
	public Patient getPatientByPid(String pid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<Patient> list=new PatientTableAdapter(dbo).select("pid=?",new int[1],new String[]{pid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public Inpatient getInpateintByipid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<Inpatient> list=new InpatientTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public UserInfo getUserInfoByipid(String userId){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<UserInfo> list=new UserInfoTableAdapter(dbo).select("user_id=?",new int[1],new String[]{userId});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public Temperature getTemperature(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			Temperature t=new Temperature();
			List<Temperature> list=new TemperatureTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid},"measure_date");
			for(int i=0;list!=null&&i<list.size();i++){
				Temperature temper=list.get(i);
				String dp="";
				String sp="";
				if(Util.isEmpty(t.getDiastolicPressure())){
					if(!Util.isEmpty(temper.getDiastolicPressure())){
						dp=temper.getDiastolicPressure();
						sp=temper.getSystolicPressure();
					}else if(!Util.isEmpty(temper.getDiastolicPressure2())){
						dp=temper.getDiastolicPressure2();
						sp=temper.getSystolicPressure2();
					}else if(!Util.isEmpty(temper.getDiastolicPressure3())){
						dp=temper.getDiastolicPressure3();
						sp=temper.getSystolicPressure3();
					}
					t.setDiastolicPressure(dp);
					t.setSystolicPressure(sp);
				}
				
				if(Util.isEmpty(t.getWeight())&&(!Util.isEmpty(temper.getWeight()))){
					t.setWeight(temper.getWeight());
				}
				if(Util.isEmpty(t.getHeight())&&(!Util.isEmpty(temper.getHeight()))){
					t.setWeight(temper.getHeight());
				}
			}
			return t;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public TemperatureDetail getTemperatureDetail(String ipid){
		DBOperator dbo = null;
		try{
			TemperatureDetail td=new TemperatureDetail();
			dbo=getDBOperator();
			List<TemperatureDetail> list=new TemperatureDetailTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid},"measure_date,measure_time");
			for(int i=0;list!=null&&i<list.size();i++){
				TemperatureDetail temptd=list.get(i);
				if(i==0){
					td.setCreator(temptd.getCreator());
				}
				if((!Util.isEmpty(temptd.getTemper()))&&Util.isEmpty(td.getTemper())){
					td.setTemper(temptd.getTemper());
				}
				if((!Util.isEmpty(temptd.getPulse()))&&Util.isEmpty(td.getPulse())){
					td.setPulse(temptd.getPulse());
				}
				if((!Util.isEmpty(temptd.getBreath()))&&Util.isEmpty(td.getBreath())){
					td.setBreath(temptd.getBreath());
				}
				if(Util.isEmpty(td.getTemper())&&Util.isEmpty(td.getBreath())&&Util.isEmpty(td.getPulse())){
					break;
				}
			}
			return td;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public InpAllInfo getInpAllInfo(String ipid) {
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<InpAllInfo> list=new InpAllInfoTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public TplTemplate getTplTemplateByTplId(String tplId) {
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<TplTemplate> list=new TplTemplateTableAdapter(dbo).select("tpl_id=?",new int[1],new String[]{tplId});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	
	public FrontSheet getFrontSheetByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<FrontSheet> list=new FrontSheetTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid});
			return list!=null&&list.size()>0?list.get(0):null;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
	public List<BivariateStructsSheet> getBivariateStructsSheetByIpid(String ipid){
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<BivariateStructsSheet> list=new BivariateStructsSheetTableAdapter(dbo).select("ipid=?",new int[1],new String[]{ipid});
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}

	public List<OperOrderConfig> getOperOrderConfigListByIpid(String zylsh) {
		DBOperator dbo = null;
		try{
			dbo=getDBOperator();
			List<OperOrderConfig> list=new OperOrderConfigTableAdapter(dbo).select("ipid=?",new int[1],new String[]{zylsh});
			return list;
		}catch(Exception e){
			if(dbo!=null){
				dbo.rollback();
			}
			e.printStackTrace();
		}finally{
			if(dbo!=null){
				dbo.close();
			}
		}
		return null;
	}
}

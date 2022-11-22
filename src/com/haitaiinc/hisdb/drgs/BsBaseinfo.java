//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.04.24 时间 02:54:53 PM CST 
//


package com.haitaiinc.hisdb.drgs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.haitaiinc.xml.jaxb.JAXBObject;


/**
 * <p>BsBaseinfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BsBaseinfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MdtrtSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MdtrtID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PsnNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PatnIptCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Medcasno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PsnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Gend" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Brdy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ntly" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NtlyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NwbBirWt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NwbAdmWt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Birplc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Napl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NatyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Naty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Certno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Prfs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MrgStas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrAddrPoscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PsnTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResdAddrProv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResdAddrCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResdAddrCoty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResdAddrSubd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResdAddrVil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResdAddrHousnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResdAddrPoscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResdAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmprTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmprPoscode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmprAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConerTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConerAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConerRltsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmWayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmWayCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrtTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrtType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmCaty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmWard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DscgDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DscgCaty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Refldeptcatyname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DscgWard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptDays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DrugDicmFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DicmDrugName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DieAutpFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AboCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AboName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RhCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RhName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DieFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeptdrtName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChfdrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AtddrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChfpdrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptDrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RespNursName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrainDrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntnDrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QltctrlDrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QltctrlNursName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MedcasQltName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MedcasQltCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QltctrlDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DscgWayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DscgWay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AcpMedinsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AcpMedinsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dscg31DaysRinpFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dscg31DaysRinpPup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DamgIntxExtRea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DamgIntxExtReaDisecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrnDamgBfadmComaDura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrnDamgAfadmComaDura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VentUsedDura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CnfmDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PatnDiseDiagCrsp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PatnDiseDiagCrspCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptPatnDiagInscp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptPatnDiagInscpCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DscgTrtRslt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DscgTrtRsltCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MedinsOrgcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Aise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PoteIntnDrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Hbsag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Hcvab" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Hivab" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RescCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RescSuccCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HospDiseFsttime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HifPayWayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HifPayWayCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MedFeePaymtdName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MedfeePaymtdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SelfpayAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MedfeeSumamt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrdnMedServfee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrdnTrtOprtFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NursFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ComMedServOthFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PalgDiagFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LabDiagFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RdhyDiagFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClncDiseFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NsrgtrtItemFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClncPhysTrtFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RgtrtTrtFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RhabFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TcmTrtFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Wmfee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AbtlMednFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TcmpatFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TcmherbFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BloFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AlbuFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GlonFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClotfacFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CykiFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExamDspoMatlFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrtDspoMatlFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnDspoMatlFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OthFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValiFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FixmedinsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Scsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Czy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Brxh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChfdrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AtddrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptDrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RespNursCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrainDrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntnDrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QltctrlDrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QltctrlNursCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeptdrtCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OtpWmDise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WmDiseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Otpcmdise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tcmdisecode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RefldeptDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Jgdm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ybzffs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalFields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NLSFields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BsBaseinfo", propOrder = {
    "mdtrtSN",
    "mdtrtID",
    "psnNo",
    "patnIptCnt",
    "iptNo",
    "medcasno",
    "psnName",
    "gend",
    "brdy",
    "ntly",
    "ntlyName",
    "nwbBirWt",
    "nwbAdmWt",
    "birplc",
    "napl",
    "natyName",
    "naty",
    "certno",
    "prfs",
    "mrgStas",
    "currAddrPoscode",
    "currAddr",
    "psnTel",
    "resdAddrProv",
    "resdAddrCity",
    "resdAddrCoty",
    "resdAddrSubd",
    "resdAddrVil",
    "resdAddrHousnum",
    "resdAddrPoscode",
    "resdAddr",
    "emprTel",
    "emprPoscode",
    "emprAddr",
    "conerTel",
    "conerName",
    "conerAddr",
    "conerRltsCode",
    "admWayName",
    "admWayCode",
    "trtTypeName",
    "trtType",
    "admCaty",
    "admWard",
    "admDate",
    "dscgDate",
    "dscgCaty",
    "refldeptcatyname",
    "dscgWard",
    "iptDays",
    "drugDicmFlag",
    "dicmDrugName",
    "dieAutpFlag",
    "aboCode",
    "aboName",
    "rhCode",
    "rhName",
    "dieFlag",
    "deptdrtName",
    "chfdrName",
    "atddrName",
    "chfpdrName",
    "iptDrName",
    "respNursName",
    "trainDrName",
    "intnDrName",
    "codrName",
    "qltctrlDrName",
    "qltctrlNursName",
    "medcasQltName",
    "medcasQltCode",
    "qltctrlDate",
    "dscgWayName",
    "dscgWay",
    "acpMedinsCode",
    "acpMedinsName",
    "dscg31DaysRinpFlag",
    "dscg31DaysRinpPup",
    "damgIntxExtRea",
    "damgIntxExtReaDisecode",
    "brnDamgBfadmComaDura",
    "brnDamgAfadmComaDura",
    "ventUsedDura",
    "cnfmDate",
    "patnDiseDiagCrsp",
    "patnDiseDiagCrspCode",
    "iptPatnDiagInscp",
    "iptPatnDiagInscpCode",
    "dscgTrtRslt",
    "dscgTrtRsltCode",
    "medinsOrgcode",
    "age",
    "aise",
    "poteIntnDrName",
    "hbsag",
    "hcvab",
    "hivab",
    "rescCnt",
    "rescSuccCnt",
    "hospDiseFsttime",
    "hifPayWayName",
    "hifPayWayCode",
    "medFeePaymtdName",
    "medfeePaymtdCode",
    "selfpayAmt",
    "medfeeSumamt",
    "ordnMedServfee",
    "ordnTrtOprtFee",
    "nursFee",
    "comMedServOthFee",
    "palgDiagFee",
    "labDiagFee",
    "rdhyDiagFee",
    "clncDiseFee",
    "nsrgtrtItemFee",
    "clncPhysTrtFee",
    "rgtrtTrtFee",
    "anstFee",
    "oprnFee",
    "rhabFee",
    "tcmTrtFee",
    "wmfee",
    "abtlMednFee",
    "tcmpatFee",
    "tcmherbFee",
    "bloFee",
    "albuFee",
    "glonFee",
    "clotfacFee",
    "cykiFee",
    "examDspoMatlFee",
    "trtDspoMatlFee",
    "oprnDspoMatlFee",
    "othFee",
    "valiFlag",
    "fixmedinsCode",
    "scsj",
    "flag",
    "czy",
    "brxh",
    "chfdrCode",
    "atddrCode",
    "iptDrCode",
    "respNursCode",
    "trainDrCode",
    "intnDrCode",
    "codrCode",
    "qltctrlDrCode",
    "qltctrlNursCode",
    "deptdrtCode",
    "otpWmDise",
    "wmDiseCode",
    "otpcmdise",
    "tcmdisecode",
    "refldeptDept",
    "jgdm",
    "ybzffs",
    "additionalFields",
    "nlsFields"
})
public class BsBaseinfo
    extends JAXBObject
{

    @XmlElement(name = "MdtrtSN")
    protected String mdtrtSN;
    @XmlElement(name = "MdtrtID")
    protected String mdtrtID;
    @XmlElement(name = "PsnNo")
    protected String psnNo;
    @XmlElement(name = "PatnIptCnt")
    protected String patnIptCnt;
    @XmlElement(name = "IptNo")
    protected String iptNo;
    @XmlElement(name = "Medcasno")
    protected String medcasno;
    @XmlElement(name = "PsnName")
    protected String psnName;
    @XmlElement(name = "Gend")
    protected String gend;
    @XmlElement(name = "Brdy")
    protected String brdy;
    @XmlElement(name = "Ntly")
    protected String ntly;
    @XmlElement(name = "NtlyName")
    protected String ntlyName;
    @XmlElement(name = "NwbBirWt")
    protected String nwbBirWt;
    @XmlElement(name = "NwbAdmWt")
    protected String nwbAdmWt;
    @XmlElement(name = "Birplc")
    protected String birplc;
    @XmlElement(name = "Napl")
    protected String napl;
    @XmlElement(name = "NatyName")
    protected String natyName;
    @XmlElement(name = "Naty")
    protected String naty;
    @XmlElement(name = "Certno")
    protected String certno;
    @XmlElement(name = "Prfs")
    protected String prfs;
    @XmlElement(name = "MrgStas")
    protected String mrgStas;
    @XmlElement(name = "CurrAddrPoscode")
    protected String currAddrPoscode;
    @XmlElement(name = "CurrAddr")
    protected String currAddr;
    @XmlElement(name = "PsnTel")
    protected String psnTel;
    @XmlElement(name = "ResdAddrProv")
    protected String resdAddrProv;
    @XmlElement(name = "ResdAddrCity")
    protected String resdAddrCity;
    @XmlElement(name = "ResdAddrCoty")
    protected String resdAddrCoty;
    @XmlElement(name = "ResdAddrSubd")
    protected String resdAddrSubd;
    @XmlElement(name = "ResdAddrVil")
    protected String resdAddrVil;
    @XmlElement(name = "ResdAddrHousnum")
    protected String resdAddrHousnum;
    @XmlElement(name = "ResdAddrPoscode")
    protected String resdAddrPoscode;
    @XmlElement(name = "ResdAddr")
    protected String resdAddr;
    @XmlElement(name = "EmprTel")
    protected String emprTel;
    @XmlElement(name = "EmprPoscode")
    protected String emprPoscode;
    @XmlElement(name = "EmprAddr")
    protected String emprAddr;
    @XmlElement(name = "ConerTel")
    protected String conerTel;
    @XmlElement(name = "ConerName")
    protected String conerName;
    @XmlElement(name = "ConerAddr")
    protected String conerAddr;
    @XmlElement(name = "ConerRltsCode")
    protected String conerRltsCode;
    @XmlElement(name = "AdmWayName")
    protected String admWayName;
    @XmlElement(name = "AdmWayCode")
    protected String admWayCode;
    @XmlElement(name = "TrtTypeName")
    protected String trtTypeName;
    @XmlElement(name = "TrtType")
    protected String trtType;
    @XmlElement(name = "AdmCaty")
    protected String admCaty;
    @XmlElement(name = "AdmWard")
    protected String admWard;
    @XmlElement(name = "AdmDate")
    protected String admDate;
    @XmlElement(name = "DscgDate")
    protected String dscgDate;
    @XmlElement(name = "DscgCaty")
    protected String dscgCaty;
    @XmlElement(name = "Refldeptcatyname")
    protected String refldeptcatyname;
    @XmlElement(name = "DscgWard")
    protected String dscgWard;
    @XmlElement(name = "IptDays")
    protected String iptDays;
    @XmlElement(name = "DrugDicmFlag")
    protected String drugDicmFlag;
    @XmlElement(name = "DicmDrugName")
    protected String dicmDrugName;
    @XmlElement(name = "DieAutpFlag")
    protected String dieAutpFlag;
    @XmlElement(name = "AboCode")
    protected String aboCode;
    @XmlElement(name = "AboName")
    protected String aboName;
    @XmlElement(name = "RhCode")
    protected String rhCode;
    @XmlElement(name = "RhName")
    protected String rhName;
    @XmlElement(name = "DieFlag")
    protected String dieFlag;
    @XmlElement(name = "DeptdrtName")
    protected String deptdrtName;
    @XmlElement(name = "ChfdrName")
    protected String chfdrName;
    @XmlElement(name = "AtddrName")
    protected String atddrName;
    @XmlElement(name = "ChfpdrName")
    protected String chfpdrName;
    @XmlElement(name = "IptDrName")
    protected String iptDrName;
    @XmlElement(name = "RespNursName")
    protected String respNursName;
    @XmlElement(name = "TrainDrName")
    protected String trainDrName;
    @XmlElement(name = "IntnDrName")
    protected String intnDrName;
    @XmlElement(name = "CodrName")
    protected String codrName;
    @XmlElement(name = "QltctrlDrName")
    protected String qltctrlDrName;
    @XmlElement(name = "QltctrlNursName")
    protected String qltctrlNursName;
    @XmlElement(name = "MedcasQltName")
    protected String medcasQltName;
    @XmlElement(name = "MedcasQltCode")
    protected String medcasQltCode;
    @XmlElement(name = "QltctrlDate")
    protected String qltctrlDate;
    @XmlElement(name = "DscgWayName")
    protected String dscgWayName;
    @XmlElement(name = "DscgWay")
    protected String dscgWay;
    @XmlElement(name = "AcpMedinsCode")
    protected String acpMedinsCode;
    @XmlElement(name = "AcpMedinsName")
    protected String acpMedinsName;
    @XmlElement(name = "Dscg31DaysRinpFlag")
    protected String dscg31DaysRinpFlag;
    @XmlElement(name = "Dscg31DaysRinpPup")
    protected String dscg31DaysRinpPup;
    @XmlElement(name = "DamgIntxExtRea")
    protected String damgIntxExtRea;
    @XmlElement(name = "DamgIntxExtReaDisecode")
    protected String damgIntxExtReaDisecode;
    @XmlElement(name = "BrnDamgBfadmComaDura")
    protected String brnDamgBfadmComaDura;
    @XmlElement(name = "BrnDamgAfadmComaDura")
    protected String brnDamgAfadmComaDura;
    @XmlElement(name = "VentUsedDura")
    protected String ventUsedDura;
    @XmlElement(name = "CnfmDate")
    protected String cnfmDate;
    @XmlElement(name = "PatnDiseDiagCrsp")
    protected String patnDiseDiagCrsp;
    @XmlElement(name = "PatnDiseDiagCrspCode")
    protected String patnDiseDiagCrspCode;
    @XmlElement(name = "IptPatnDiagInscp")
    protected String iptPatnDiagInscp;
    @XmlElement(name = "IptPatnDiagInscpCode")
    protected String iptPatnDiagInscpCode;
    @XmlElement(name = "DscgTrtRslt")
    protected String dscgTrtRslt;
    @XmlElement(name = "DscgTrtRsltCode")
    protected String dscgTrtRsltCode;
    @XmlElement(name = "MedinsOrgcode")
    protected String medinsOrgcode;
    @XmlElement(name = "Age")
    protected String age;
    @XmlElement(name = "Aise")
    protected String aise;
    @XmlElement(name = "PoteIntnDrName")
    protected String poteIntnDrName;
    @XmlElement(name = "Hbsag")
    protected String hbsag;
    @XmlElement(name = "Hcvab")
    protected String hcvab;
    @XmlElement(name = "Hivab")
    protected String hivab;
    @XmlElement(name = "RescCnt")
    protected String rescCnt;
    @XmlElement(name = "RescSuccCnt")
    protected String rescSuccCnt;
    @XmlElement(name = "HospDiseFsttime")
    protected String hospDiseFsttime;
    @XmlElement(name = "HifPayWayName")
    protected String hifPayWayName;
    @XmlElement(name = "HifPayWayCode")
    protected String hifPayWayCode;
    @XmlElement(name = "MedFeePaymtdName")
    protected String medFeePaymtdName;
    @XmlElement(name = "MedfeePaymtdCode")
    protected String medfeePaymtdCode;
    @XmlElement(name = "SelfpayAmt")
    protected String selfpayAmt;
    @XmlElement(name = "MedfeeSumamt")
    protected String medfeeSumamt;
    @XmlElement(name = "OrdnMedServfee")
    protected String ordnMedServfee;
    @XmlElement(name = "OrdnTrtOprtFee")
    protected String ordnTrtOprtFee;
    @XmlElement(name = "NursFee")
    protected String nursFee;
    @XmlElement(name = "ComMedServOthFee")
    protected String comMedServOthFee;
    @XmlElement(name = "PalgDiagFee")
    protected String palgDiagFee;
    @XmlElement(name = "LabDiagFee")
    protected String labDiagFee;
    @XmlElement(name = "RdhyDiagFee")
    protected String rdhyDiagFee;
    @XmlElement(name = "ClncDiseFee")
    protected String clncDiseFee;
    @XmlElement(name = "NsrgtrtItemFee")
    protected String nsrgtrtItemFee;
    @XmlElement(name = "ClncPhysTrtFee")
    protected String clncPhysTrtFee;
    @XmlElement(name = "RgtrtTrtFee")
    protected String rgtrtTrtFee;
    @XmlElement(name = "AnstFee")
    protected String anstFee;
    @XmlElement(name = "OprnFee")
    protected String oprnFee;
    @XmlElement(name = "RhabFee")
    protected String rhabFee;
    @XmlElement(name = "TcmTrtFee")
    protected String tcmTrtFee;
    @XmlElement(name = "Wmfee")
    protected String wmfee;
    @XmlElement(name = "AbtlMednFee")
    protected String abtlMednFee;
    @XmlElement(name = "TcmpatFee")
    protected String tcmpatFee;
    @XmlElement(name = "TcmherbFee")
    protected String tcmherbFee;
    @XmlElement(name = "BloFee")
    protected String bloFee;
    @XmlElement(name = "AlbuFee")
    protected String albuFee;
    @XmlElement(name = "GlonFee")
    protected String glonFee;
    @XmlElement(name = "ClotfacFee")
    protected String clotfacFee;
    @XmlElement(name = "CykiFee")
    protected String cykiFee;
    @XmlElement(name = "ExamDspoMatlFee")
    protected String examDspoMatlFee;
    @XmlElement(name = "TrtDspoMatlFee")
    protected String trtDspoMatlFee;
    @XmlElement(name = "OprnDspoMatlFee")
    protected String oprnDspoMatlFee;
    @XmlElement(name = "OthFee")
    protected String othFee;
    @XmlElement(name = "ValiFlag")
    protected String valiFlag;
    @XmlElement(name = "FixmedinsCode")
    protected String fixmedinsCode;
    @XmlElement(name = "Scsj")
    protected String scsj;
    @XmlElement(name = "Flag")
    protected String flag;
    @XmlElement(name = "Czy")
    protected String czy;
    @XmlElement(name = "Brxh")
    protected String brxh;
    @XmlElement(name = "ChfdrCode")
    protected String chfdrCode;
    @XmlElement(name = "AtddrCode")
    protected String atddrCode;
    @XmlElement(name = "IptDrCode")
    protected String iptDrCode;
    @XmlElement(name = "RespNursCode")
    protected String respNursCode;
    @XmlElement(name = "TrainDrCode")
    protected String trainDrCode;
    @XmlElement(name = "IntnDrCode")
    protected String intnDrCode;
    @XmlElement(name = "CodrCode")
    protected String codrCode;
    @XmlElement(name = "QltctrlDrCode")
    protected String qltctrlDrCode;
    @XmlElement(name = "QltctrlNursCode")
    protected String qltctrlNursCode;
    @XmlElement(name = "DeptdrtCode")
    protected String deptdrtCode;
    @XmlElement(name = "OtpWmDise")
    protected String otpWmDise;
    @XmlElement(name = "WmDiseCode")
    protected String wmDiseCode;
    @XmlElement(name = "Otpcmdise")
    protected String otpcmdise;
    @XmlElement(name = "Tcmdisecode")
    protected String tcmdisecode;
    @XmlElement(name = "RefldeptDept")
    protected String refldeptDept;
    @XmlElement(name = "Jgdm")
    protected String jgdm;
    @XmlElement(name = "Ybzffs")
    protected String ybzffs;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取mdtrtSN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdtrtSN() {
        return mdtrtSN;
    }

    /**
     * 设置mdtrtSN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdtrtSN(String value) {
        this.mdtrtSN = value;
    }

    /**
     * 获取mdtrtID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdtrtID() {
        return mdtrtID;
    }

    /**
     * 设置mdtrtID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdtrtID(String value) {
        this.mdtrtID = value;
    }

    /**
     * 获取psnNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsnNo() {
        return psnNo;
    }

    /**
     * 设置psnNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsnNo(String value) {
        this.psnNo = value;
    }

    /**
     * 获取patnIptCnt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatnIptCnt() {
        return patnIptCnt;
    }

    /**
     * 设置patnIptCnt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatnIptCnt(String value) {
        this.patnIptCnt = value;
    }

    /**
     * 获取iptNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIptNo() {
        return iptNo;
    }

    /**
     * 设置iptNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIptNo(String value) {
        this.iptNo = value;
    }

    /**
     * 获取medcasno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedcasno() {
        return medcasno;
    }

    /**
     * 设置medcasno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedcasno(String value) {
        this.medcasno = value;
    }

    /**
     * 获取psnName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsnName() {
        return psnName;
    }

    /**
     * 设置psnName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsnName(String value) {
        this.psnName = value;
    }

    /**
     * 获取gend属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGend() {
        return gend;
    }

    /**
     * 设置gend属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGend(String value) {
        this.gend = value;
    }

    /**
     * 获取brdy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrdy() {
        return brdy;
    }

    /**
     * 设置brdy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrdy(String value) {
        this.brdy = value;
    }

    /**
     * 获取ntly属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNtly() {
        return ntly;
    }

    /**
     * 设置ntly属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNtly(String value) {
        this.ntly = value;
    }

    /**
     * 获取ntlyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNtlyName() {
        return ntlyName;
    }

    /**
     * 设置ntlyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNtlyName(String value) {
        this.ntlyName = value;
    }

    /**
     * 获取nwbBirWt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNwbBirWt() {
        return nwbBirWt;
    }

    /**
     * 设置nwbBirWt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNwbBirWt(String value) {
        this.nwbBirWt = value;
    }

    /**
     * 获取nwbAdmWt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNwbAdmWt() {
        return nwbAdmWt;
    }

    /**
     * 设置nwbAdmWt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNwbAdmWt(String value) {
        this.nwbAdmWt = value;
    }

    /**
     * 获取birplc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirplc() {
        return birplc;
    }

    /**
     * 设置birplc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirplc(String value) {
        this.birplc = value;
    }

    /**
     * 获取napl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNapl() {
        return napl;
    }

    /**
     * 设置napl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNapl(String value) {
        this.napl = value;
    }

    /**
     * 获取natyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNatyName() {
        return natyName;
    }

    /**
     * 设置natyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNatyName(String value) {
        this.natyName = value;
    }

    /**
     * 获取naty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaty() {
        return naty;
    }

    /**
     * 设置naty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaty(String value) {
        this.naty = value;
    }

    /**
     * 获取certno属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertno() {
        return certno;
    }

    /**
     * 设置certno属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertno(String value) {
        this.certno = value;
    }

    /**
     * 获取prfs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrfs() {
        return prfs;
    }

    /**
     * 设置prfs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrfs(String value) {
        this.prfs = value;
    }

    /**
     * 获取mrgStas属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMrgStas() {
        return mrgStas;
    }

    /**
     * 设置mrgStas属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMrgStas(String value) {
        this.mrgStas = value;
    }

    /**
     * 获取currAddrPoscode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrAddrPoscode() {
        return currAddrPoscode;
    }

    /**
     * 设置currAddrPoscode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrAddrPoscode(String value) {
        this.currAddrPoscode = value;
    }

    /**
     * 获取currAddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrAddr() {
        return currAddr;
    }

    /**
     * 设置currAddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrAddr(String value) {
        this.currAddr = value;
    }

    /**
     * 获取psnTel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsnTel() {
        return psnTel;
    }

    /**
     * 设置psnTel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsnTel(String value) {
        this.psnTel = value;
    }

    /**
     * 获取resdAddrProv属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResdAddrProv() {
        return resdAddrProv;
    }

    /**
     * 设置resdAddrProv属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResdAddrProv(String value) {
        this.resdAddrProv = value;
    }

    /**
     * 获取resdAddrCity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResdAddrCity() {
        return resdAddrCity;
    }

    /**
     * 设置resdAddrCity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResdAddrCity(String value) {
        this.resdAddrCity = value;
    }

    /**
     * 获取resdAddrCoty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResdAddrCoty() {
        return resdAddrCoty;
    }

    /**
     * 设置resdAddrCoty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResdAddrCoty(String value) {
        this.resdAddrCoty = value;
    }

    /**
     * 获取resdAddrSubd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResdAddrSubd() {
        return resdAddrSubd;
    }

    /**
     * 设置resdAddrSubd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResdAddrSubd(String value) {
        this.resdAddrSubd = value;
    }

    /**
     * 获取resdAddrVil属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResdAddrVil() {
        return resdAddrVil;
    }

    /**
     * 设置resdAddrVil属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResdAddrVil(String value) {
        this.resdAddrVil = value;
    }

    /**
     * 获取resdAddrHousnum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResdAddrHousnum() {
        return resdAddrHousnum;
    }

    /**
     * 设置resdAddrHousnum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResdAddrHousnum(String value) {
        this.resdAddrHousnum = value;
    }

    /**
     * 获取resdAddrPoscode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResdAddrPoscode() {
        return resdAddrPoscode;
    }

    /**
     * 设置resdAddrPoscode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResdAddrPoscode(String value) {
        this.resdAddrPoscode = value;
    }

    /**
     * 获取resdAddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResdAddr() {
        return resdAddr;
    }

    /**
     * 设置resdAddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResdAddr(String value) {
        this.resdAddr = value;
    }

    /**
     * 获取emprTel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmprTel() {
        return emprTel;
    }

    /**
     * 设置emprTel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmprTel(String value) {
        this.emprTel = value;
    }

    /**
     * 获取emprPoscode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmprPoscode() {
        return emprPoscode;
    }

    /**
     * 设置emprPoscode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmprPoscode(String value) {
        this.emprPoscode = value;
    }

    /**
     * 获取emprAddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmprAddr() {
        return emprAddr;
    }

    /**
     * 设置emprAddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmprAddr(String value) {
        this.emprAddr = value;
    }

    /**
     * 获取conerTel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConerTel() {
        return conerTel;
    }

    /**
     * 设置conerTel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConerTel(String value) {
        this.conerTel = value;
    }

    /**
     * 获取conerName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConerName() {
        return conerName;
    }

    /**
     * 设置conerName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConerName(String value) {
        this.conerName = value;
    }

    /**
     * 获取conerAddr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConerAddr() {
        return conerAddr;
    }

    /**
     * 设置conerAddr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConerAddr(String value) {
        this.conerAddr = value;
    }

    /**
     * 获取conerRltsCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConerRltsCode() {
        return conerRltsCode;
    }

    /**
     * 设置conerRltsCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConerRltsCode(String value) {
        this.conerRltsCode = value;
    }

    /**
     * 获取admWayName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmWayName() {
        return admWayName;
    }

    /**
     * 设置admWayName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmWayName(String value) {
        this.admWayName = value;
    }

    /**
     * 获取admWayCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmWayCode() {
        return admWayCode;
    }

    /**
     * 设置admWayCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmWayCode(String value) {
        this.admWayCode = value;
    }

    /**
     * 获取trtTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrtTypeName() {
        return trtTypeName;
    }

    /**
     * 设置trtTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrtTypeName(String value) {
        this.trtTypeName = value;
    }

    /**
     * 获取trtType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrtType() {
        return trtType;
    }

    /**
     * 设置trtType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrtType(String value) {
        this.trtType = value;
    }

    /**
     * 获取admCaty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmCaty() {
        return admCaty;
    }

    /**
     * 设置admCaty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmCaty(String value) {
        this.admCaty = value;
    }

    /**
     * 获取admWard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmWard() {
        return admWard;
    }

    /**
     * 设置admWard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmWard(String value) {
        this.admWard = value;
    }

    /**
     * 获取admDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmDate() {
        return admDate;
    }

    /**
     * 设置admDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmDate(String value) {
        this.admDate = value;
    }

    /**
     * 获取dscgDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscgDate() {
        return dscgDate;
    }

    /**
     * 设置dscgDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscgDate(String value) {
        this.dscgDate = value;
    }

    /**
     * 获取dscgCaty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscgCaty() {
        return dscgCaty;
    }

    /**
     * 设置dscgCaty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscgCaty(String value) {
        this.dscgCaty = value;
    }

    /**
     * 获取refldeptcatyname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefldeptcatyname() {
        return refldeptcatyname;
    }

    /**
     * 设置refldeptcatyname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefldeptcatyname(String value) {
        this.refldeptcatyname = value;
    }

    /**
     * 获取dscgWard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscgWard() {
        return dscgWard;
    }

    /**
     * 设置dscgWard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscgWard(String value) {
        this.dscgWard = value;
    }

    /**
     * 获取iptDays属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIptDays() {
        return iptDays;
    }

    /**
     * 设置iptDays属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIptDays(String value) {
        this.iptDays = value;
    }

    /**
     * 获取drugDicmFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugDicmFlag() {
        return drugDicmFlag;
    }

    /**
     * 设置drugDicmFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugDicmFlag(String value) {
        this.drugDicmFlag = value;
    }

    /**
     * 获取dicmDrugName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDicmDrugName() {
        return dicmDrugName;
    }

    /**
     * 设置dicmDrugName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDicmDrugName(String value) {
        this.dicmDrugName = value;
    }

    /**
     * 获取dieAutpFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDieAutpFlag() {
        return dieAutpFlag;
    }

    /**
     * 设置dieAutpFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDieAutpFlag(String value) {
        this.dieAutpFlag = value;
    }

    /**
     * 获取aboCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAboCode() {
        return aboCode;
    }

    /**
     * 设置aboCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAboCode(String value) {
        this.aboCode = value;
    }

    /**
     * 获取aboName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAboName() {
        return aboName;
    }

    /**
     * 设置aboName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAboName(String value) {
        this.aboName = value;
    }

    /**
     * 获取rhCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRhCode() {
        return rhCode;
    }

    /**
     * 设置rhCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRhCode(String value) {
        this.rhCode = value;
    }

    /**
     * 获取rhName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRhName() {
        return rhName;
    }

    /**
     * 设置rhName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRhName(String value) {
        this.rhName = value;
    }

    /**
     * 获取dieFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDieFlag() {
        return dieFlag;
    }

    /**
     * 设置dieFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDieFlag(String value) {
        this.dieFlag = value;
    }

    /**
     * 获取deptdrtName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptdrtName() {
        return deptdrtName;
    }

    /**
     * 设置deptdrtName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptdrtName(String value) {
        this.deptdrtName = value;
    }

    /**
     * 获取chfdrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChfdrName() {
        return chfdrName;
    }

    /**
     * 设置chfdrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChfdrName(String value) {
        this.chfdrName = value;
    }

    /**
     * 获取atddrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtddrName() {
        return atddrName;
    }

    /**
     * 设置atddrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtddrName(String value) {
        this.atddrName = value;
    }

    /**
     * 获取chfpdrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChfpdrName() {
        return chfpdrName;
    }

    /**
     * 设置chfpdrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChfpdrName(String value) {
        this.chfpdrName = value;
    }

    /**
     * 获取iptDrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIptDrName() {
        return iptDrName;
    }

    /**
     * 设置iptDrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIptDrName(String value) {
        this.iptDrName = value;
    }

    /**
     * 获取respNursName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespNursName() {
        return respNursName;
    }

    /**
     * 设置respNursName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespNursName(String value) {
        this.respNursName = value;
    }

    /**
     * 获取trainDrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainDrName() {
        return trainDrName;
    }

    /**
     * 设置trainDrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainDrName(String value) {
        this.trainDrName = value;
    }

    /**
     * 获取intnDrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntnDrName() {
        return intnDrName;
    }

    /**
     * 设置intnDrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntnDrName(String value) {
        this.intnDrName = value;
    }

    /**
     * 获取codrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodrName() {
        return codrName;
    }

    /**
     * 设置codrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodrName(String value) {
        this.codrName = value;
    }

    /**
     * 获取qltctrlDrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQltctrlDrName() {
        return qltctrlDrName;
    }

    /**
     * 设置qltctrlDrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQltctrlDrName(String value) {
        this.qltctrlDrName = value;
    }

    /**
     * 获取qltctrlNursName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQltctrlNursName() {
        return qltctrlNursName;
    }

    /**
     * 设置qltctrlNursName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQltctrlNursName(String value) {
        this.qltctrlNursName = value;
    }

    /**
     * 获取medcasQltName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedcasQltName() {
        return medcasQltName;
    }

    /**
     * 设置medcasQltName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedcasQltName(String value) {
        this.medcasQltName = value;
    }

    /**
     * 获取medcasQltCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedcasQltCode() {
        return medcasQltCode;
    }

    /**
     * 设置medcasQltCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedcasQltCode(String value) {
        this.medcasQltCode = value;
    }

    /**
     * 获取qltctrlDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQltctrlDate() {
        return qltctrlDate;
    }

    /**
     * 设置qltctrlDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQltctrlDate(String value) {
        this.qltctrlDate = value;
    }

    /**
     * 获取dscgWayName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscgWayName() {
        return dscgWayName;
    }

    /**
     * 设置dscgWayName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscgWayName(String value) {
        this.dscgWayName = value;
    }

    /**
     * 获取dscgWay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscgWay() {
        return dscgWay;
    }

    /**
     * 设置dscgWay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscgWay(String value) {
        this.dscgWay = value;
    }

    /**
     * 获取acpMedinsCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcpMedinsCode() {
        return acpMedinsCode;
    }

    /**
     * 设置acpMedinsCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcpMedinsCode(String value) {
        this.acpMedinsCode = value;
    }

    /**
     * 获取acpMedinsName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcpMedinsName() {
        return acpMedinsName;
    }

    /**
     * 设置acpMedinsName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcpMedinsName(String value) {
        this.acpMedinsName = value;
    }

    /**
     * 获取dscg31DaysRinpFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscg31DaysRinpFlag() {
        return dscg31DaysRinpFlag;
    }

    /**
     * 设置dscg31DaysRinpFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscg31DaysRinpFlag(String value) {
        this.dscg31DaysRinpFlag = value;
    }

    /**
     * 获取dscg31DaysRinpPup属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscg31DaysRinpPup() {
        return dscg31DaysRinpPup;
    }

    /**
     * 设置dscg31DaysRinpPup属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscg31DaysRinpPup(String value) {
        this.dscg31DaysRinpPup = value;
    }

    /**
     * 获取damgIntxExtRea属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDamgIntxExtRea() {
        return damgIntxExtRea;
    }

    /**
     * 设置damgIntxExtRea属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDamgIntxExtRea(String value) {
        this.damgIntxExtRea = value;
    }

    /**
     * 获取damgIntxExtReaDisecode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDamgIntxExtReaDisecode() {
        return damgIntxExtReaDisecode;
    }

    /**
     * 设置damgIntxExtReaDisecode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDamgIntxExtReaDisecode(String value) {
        this.damgIntxExtReaDisecode = value;
    }

    /**
     * 获取brnDamgBfadmComaDura属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrnDamgBfadmComaDura() {
        return brnDamgBfadmComaDura;
    }

    /**
     * 设置brnDamgBfadmComaDura属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrnDamgBfadmComaDura(String value) {
        this.brnDamgBfadmComaDura = value;
    }

    /**
     * 获取brnDamgAfadmComaDura属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrnDamgAfadmComaDura() {
        return brnDamgAfadmComaDura;
    }

    /**
     * 设置brnDamgAfadmComaDura属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrnDamgAfadmComaDura(String value) {
        this.brnDamgAfadmComaDura = value;
    }

    /**
     * 获取ventUsedDura属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVentUsedDura() {
        return ventUsedDura;
    }

    /**
     * 设置ventUsedDura属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVentUsedDura(String value) {
        this.ventUsedDura = value;
    }

    /**
     * 获取cnfmDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCnfmDate() {
        return cnfmDate;
    }

    /**
     * 设置cnfmDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCnfmDate(String value) {
        this.cnfmDate = value;
    }

    /**
     * 获取patnDiseDiagCrsp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatnDiseDiagCrsp() {
        return patnDiseDiagCrsp;
    }

    /**
     * 设置patnDiseDiagCrsp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatnDiseDiagCrsp(String value) {
        this.patnDiseDiagCrsp = value;
    }

    /**
     * 获取patnDiseDiagCrspCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatnDiseDiagCrspCode() {
        return patnDiseDiagCrspCode;
    }

    /**
     * 设置patnDiseDiagCrspCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatnDiseDiagCrspCode(String value) {
        this.patnDiseDiagCrspCode = value;
    }

    /**
     * 获取iptPatnDiagInscp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIptPatnDiagInscp() {
        return iptPatnDiagInscp;
    }

    /**
     * 设置iptPatnDiagInscp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIptPatnDiagInscp(String value) {
        this.iptPatnDiagInscp = value;
    }

    /**
     * 获取iptPatnDiagInscpCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIptPatnDiagInscpCode() {
        return iptPatnDiagInscpCode;
    }

    /**
     * 设置iptPatnDiagInscpCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIptPatnDiagInscpCode(String value) {
        this.iptPatnDiagInscpCode = value;
    }

    /**
     * 获取dscgTrtRslt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscgTrtRslt() {
        return dscgTrtRslt;
    }

    /**
     * 设置dscgTrtRslt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscgTrtRslt(String value) {
        this.dscgTrtRslt = value;
    }

    /**
     * 获取dscgTrtRsltCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscgTrtRsltCode() {
        return dscgTrtRsltCode;
    }

    /**
     * 设置dscgTrtRsltCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscgTrtRsltCode(String value) {
        this.dscgTrtRsltCode = value;
    }

    /**
     * 获取medinsOrgcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedinsOrgcode() {
        return medinsOrgcode;
    }

    /**
     * 设置medinsOrgcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedinsOrgcode(String value) {
        this.medinsOrgcode = value;
    }

    /**
     * 获取age属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置age属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAge(String value) {
        this.age = value;
    }

    /**
     * 获取aise属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAise() {
        return aise;
    }

    /**
     * 设置aise属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAise(String value) {
        this.aise = value;
    }

    /**
     * 获取poteIntnDrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoteIntnDrName() {
        return poteIntnDrName;
    }

    /**
     * 设置poteIntnDrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoteIntnDrName(String value) {
        this.poteIntnDrName = value;
    }

    /**
     * 获取hbsag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHbsag() {
        return hbsag;
    }

    /**
     * 设置hbsag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHbsag(String value) {
        this.hbsag = value;
    }

    /**
     * 获取hcvab属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHcvab() {
        return hcvab;
    }

    /**
     * 设置hcvab属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHcvab(String value) {
        this.hcvab = value;
    }

    /**
     * 获取hivab属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHivab() {
        return hivab;
    }

    /**
     * 设置hivab属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHivab(String value) {
        this.hivab = value;
    }

    /**
     * 获取rescCnt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRescCnt() {
        return rescCnt;
    }

    /**
     * 设置rescCnt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRescCnt(String value) {
        this.rescCnt = value;
    }

    /**
     * 获取rescSuccCnt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRescSuccCnt() {
        return rescSuccCnt;
    }

    /**
     * 设置rescSuccCnt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRescSuccCnt(String value) {
        this.rescSuccCnt = value;
    }

    /**
     * 获取hospDiseFsttime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHospDiseFsttime() {
        return hospDiseFsttime;
    }

    /**
     * 设置hospDiseFsttime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHospDiseFsttime(String value) {
        this.hospDiseFsttime = value;
    }

    /**
     * 获取hifPayWayName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHifPayWayName() {
        return hifPayWayName;
    }

    /**
     * 设置hifPayWayName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHifPayWayName(String value) {
        this.hifPayWayName = value;
    }

    /**
     * 获取hifPayWayCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHifPayWayCode() {
        return hifPayWayCode;
    }

    /**
     * 设置hifPayWayCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHifPayWayCode(String value) {
        this.hifPayWayCode = value;
    }

    /**
     * 获取medFeePaymtdName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedFeePaymtdName() {
        return medFeePaymtdName;
    }

    /**
     * 设置medFeePaymtdName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedFeePaymtdName(String value) {
        this.medFeePaymtdName = value;
    }

    /**
     * 获取medfeePaymtdCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedfeePaymtdCode() {
        return medfeePaymtdCode;
    }

    /**
     * 设置medfeePaymtdCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedfeePaymtdCode(String value) {
        this.medfeePaymtdCode = value;
    }

    /**
     * 获取selfpayAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelfpayAmt() {
        return selfpayAmt;
    }

    /**
     * 设置selfpayAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelfpayAmt(String value) {
        this.selfpayAmt = value;
    }

    /**
     * 获取medfeeSumamt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedfeeSumamt() {
        return medfeeSumamt;
    }

    /**
     * 设置medfeeSumamt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedfeeSumamt(String value) {
        this.medfeeSumamt = value;
    }

    /**
     * 获取ordnMedServfee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdnMedServfee() {
        return ordnMedServfee;
    }

    /**
     * 设置ordnMedServfee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdnMedServfee(String value) {
        this.ordnMedServfee = value;
    }

    /**
     * 获取ordnTrtOprtFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdnTrtOprtFee() {
        return ordnTrtOprtFee;
    }

    /**
     * 设置ordnTrtOprtFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdnTrtOprtFee(String value) {
        this.ordnTrtOprtFee = value;
    }

    /**
     * 获取nursFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNursFee() {
        return nursFee;
    }

    /**
     * 设置nursFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNursFee(String value) {
        this.nursFee = value;
    }

    /**
     * 获取comMedServOthFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComMedServOthFee() {
        return comMedServOthFee;
    }

    /**
     * 设置comMedServOthFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComMedServOthFee(String value) {
        this.comMedServOthFee = value;
    }

    /**
     * 获取palgDiagFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPalgDiagFee() {
        return palgDiagFee;
    }

    /**
     * 设置palgDiagFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPalgDiagFee(String value) {
        this.palgDiagFee = value;
    }

    /**
     * 获取labDiagFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabDiagFee() {
        return labDiagFee;
    }

    /**
     * 设置labDiagFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabDiagFee(String value) {
        this.labDiagFee = value;
    }

    /**
     * 获取rdhyDiagFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRdhyDiagFee() {
        return rdhyDiagFee;
    }

    /**
     * 设置rdhyDiagFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRdhyDiagFee(String value) {
        this.rdhyDiagFee = value;
    }

    /**
     * 获取clncDiseFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClncDiseFee() {
        return clncDiseFee;
    }

    /**
     * 设置clncDiseFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClncDiseFee(String value) {
        this.clncDiseFee = value;
    }

    /**
     * 获取nsrgtrtItemFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNsrgtrtItemFee() {
        return nsrgtrtItemFee;
    }

    /**
     * 设置nsrgtrtItemFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNsrgtrtItemFee(String value) {
        this.nsrgtrtItemFee = value;
    }

    /**
     * 获取clncPhysTrtFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClncPhysTrtFee() {
        return clncPhysTrtFee;
    }

    /**
     * 设置clncPhysTrtFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClncPhysTrtFee(String value) {
        this.clncPhysTrtFee = value;
    }

    /**
     * 获取rgtrtTrtFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRgtrtTrtFee() {
        return rgtrtTrtFee;
    }

    /**
     * 设置rgtrtTrtFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRgtrtTrtFee(String value) {
        this.rgtrtTrtFee = value;
    }

    /**
     * 获取anstFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstFee() {
        return anstFee;
    }

    /**
     * 设置anstFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstFee(String value) {
        this.anstFee = value;
    }

    /**
     * 获取oprnFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnFee() {
        return oprnFee;
    }

    /**
     * 设置oprnFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnFee(String value) {
        this.oprnFee = value;
    }

    /**
     * 获取rhabFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRhabFee() {
        return rhabFee;
    }

    /**
     * 设置rhabFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRhabFee(String value) {
        this.rhabFee = value;
    }

    /**
     * 获取tcmTrtFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcmTrtFee() {
        return tcmTrtFee;
    }

    /**
     * 设置tcmTrtFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcmTrtFee(String value) {
        this.tcmTrtFee = value;
    }

    /**
     * 获取wmfee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWmfee() {
        return wmfee;
    }

    /**
     * 设置wmfee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWmfee(String value) {
        this.wmfee = value;
    }

    /**
     * 获取abtlMednFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbtlMednFee() {
        return abtlMednFee;
    }

    /**
     * 设置abtlMednFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbtlMednFee(String value) {
        this.abtlMednFee = value;
    }

    /**
     * 获取tcmpatFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcmpatFee() {
        return tcmpatFee;
    }

    /**
     * 设置tcmpatFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcmpatFee(String value) {
        this.tcmpatFee = value;
    }

    /**
     * 获取tcmherbFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcmherbFee() {
        return tcmherbFee;
    }

    /**
     * 设置tcmherbFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcmherbFee(String value) {
        this.tcmherbFee = value;
    }

    /**
     * 获取bloFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloFee() {
        return bloFee;
    }

    /**
     * 设置bloFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloFee(String value) {
        this.bloFee = value;
    }

    /**
     * 获取albuFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlbuFee() {
        return albuFee;
    }

    /**
     * 设置albuFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlbuFee(String value) {
        this.albuFee = value;
    }

    /**
     * 获取glonFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlonFee() {
        return glonFee;
    }

    /**
     * 设置glonFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlonFee(String value) {
        this.glonFee = value;
    }

    /**
     * 获取clotfacFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClotfacFee() {
        return clotfacFee;
    }

    /**
     * 设置clotfacFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClotfacFee(String value) {
        this.clotfacFee = value;
    }

    /**
     * 获取cykiFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCykiFee() {
        return cykiFee;
    }

    /**
     * 设置cykiFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCykiFee(String value) {
        this.cykiFee = value;
    }

    /**
     * 获取examDspoMatlFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamDspoMatlFee() {
        return examDspoMatlFee;
    }

    /**
     * 设置examDspoMatlFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamDspoMatlFee(String value) {
        this.examDspoMatlFee = value;
    }

    /**
     * 获取trtDspoMatlFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrtDspoMatlFee() {
        return trtDspoMatlFee;
    }

    /**
     * 设置trtDspoMatlFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrtDspoMatlFee(String value) {
        this.trtDspoMatlFee = value;
    }

    /**
     * 获取oprnDspoMatlFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnDspoMatlFee() {
        return oprnDspoMatlFee;
    }

    /**
     * 设置oprnDspoMatlFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnDspoMatlFee(String value) {
        this.oprnDspoMatlFee = value;
    }

    /**
     * 获取othFee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOthFee() {
        return othFee;
    }

    /**
     * 设置othFee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOthFee(String value) {
        this.othFee = value;
    }

    /**
     * 获取valiFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValiFlag() {
        return valiFlag;
    }

    /**
     * 设置valiFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValiFlag(String value) {
        this.valiFlag = value;
    }

    /**
     * 获取fixmedinsCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixmedinsCode() {
        return fixmedinsCode;
    }

    /**
     * 设置fixmedinsCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixmedinsCode(String value) {
        this.fixmedinsCode = value;
    }

    /**
     * 获取scsj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScsj() {
        return scsj;
    }

    /**
     * 设置scsj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScsj(String value) {
        this.scsj = value;
    }

    /**
     * 获取flag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置flag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * 获取czy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCzy() {
        return czy;
    }

    /**
     * 设置czy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCzy(String value) {
        this.czy = value;
    }

    /**
     * 获取brxh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrxh() {
        return brxh;
    }

    /**
     * 设置brxh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrxh(String value) {
        this.brxh = value;
    }

    /**
     * 获取chfdrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChfdrCode() {
        return chfdrCode;
    }

    /**
     * 设置chfdrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChfdrCode(String value) {
        this.chfdrCode = value;
    }

    /**
     * 获取atddrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAtddrCode() {
        return atddrCode;
    }

    /**
     * 设置atddrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAtddrCode(String value) {
        this.atddrCode = value;
    }

    /**
     * 获取iptDrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIptDrCode() {
        return iptDrCode;
    }

    /**
     * 设置iptDrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIptDrCode(String value) {
        this.iptDrCode = value;
    }

    /**
     * 获取respNursCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespNursCode() {
        return respNursCode;
    }

    /**
     * 设置respNursCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespNursCode(String value) {
        this.respNursCode = value;
    }

    /**
     * 获取trainDrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainDrCode() {
        return trainDrCode;
    }

    /**
     * 设置trainDrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainDrCode(String value) {
        this.trainDrCode = value;
    }

    /**
     * 获取intnDrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntnDrCode() {
        return intnDrCode;
    }

    /**
     * 设置intnDrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntnDrCode(String value) {
        this.intnDrCode = value;
    }

    /**
     * 获取codrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodrCode() {
        return codrCode;
    }

    /**
     * 设置codrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodrCode(String value) {
        this.codrCode = value;
    }

    /**
     * 获取qltctrlDrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQltctrlDrCode() {
        return qltctrlDrCode;
    }

    /**
     * 设置qltctrlDrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQltctrlDrCode(String value) {
        this.qltctrlDrCode = value;
    }

    /**
     * 获取qltctrlNursCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQltctrlNursCode() {
        return qltctrlNursCode;
    }

    /**
     * 设置qltctrlNursCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQltctrlNursCode(String value) {
        this.qltctrlNursCode = value;
    }

    /**
     * 获取deptdrtCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptdrtCode() {
        return deptdrtCode;
    }

    /**
     * 设置deptdrtCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptdrtCode(String value) {
        this.deptdrtCode = value;
    }

    /**
     * 获取otpWmDise属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtpWmDise() {
        return otpWmDise;
    }

    /**
     * 设置otpWmDise属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtpWmDise(String value) {
        this.otpWmDise = value;
    }

    /**
     * 获取wmDiseCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWmDiseCode() {
        return wmDiseCode;
    }

    /**
     * 设置wmDiseCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWmDiseCode(String value) {
        this.wmDiseCode = value;
    }

    /**
     * 获取otpcmdise属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtpcmdise() {
        return otpcmdise;
    }

    /**
     * 设置otpcmdise属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtpcmdise(String value) {
        this.otpcmdise = value;
    }

    /**
     * 获取tcmdisecode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcmdisecode() {
        return tcmdisecode;
    }

    /**
     * 设置tcmdisecode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcmdisecode(String value) {
        this.tcmdisecode = value;
    }

    /**
     * 获取refldeptDept属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefldeptDept() {
        return refldeptDept;
    }

    /**
     * 设置refldeptDept属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefldeptDept(String value) {
        this.refldeptDept = value;
    }

    /**
     * 获取jgdm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJgdm() {
        return jgdm;
    }

    /**
     * 设置jgdm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJgdm(String value) {
        this.jgdm = value;
    }

    /**
     * 获取ybzffs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYbzffs() {
        return ybzffs;
    }

    /**
     * 设置ybzffs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYbzffs(String value) {
        this.ybzffs = value;
    }

    /**
     * Gets the value of the additionalFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAdditionalFields() {
        if (additionalFields == null) {
            additionalFields = new ArrayList<String>();
        }
        return this.additionalFields;
    }

    /**
     * Gets the value of the nlsFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nlsFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNLSFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNLSFields() {
        if (nlsFields == null) {
            nlsFields = new ArrayList<String>();
        }
        return this.nlsFields;
    }

}

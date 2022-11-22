//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.04.26 时间 09:19:51 AM CST 
//


package com.haitaiinc.hisdb.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.haitaiinc.xml.jaxb.JAXBObject;


/**
 * <p>VInpatientinfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="VInpatientinfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ipid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdminissionNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionTimes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PatientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SexCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgeDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MarriageStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MarriageStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PatientClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionRegisterTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionWay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionPurpose" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionHospital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionDeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionWardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmissionWard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DischargeTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BedNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BedFeeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Room" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateOfIllness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DoctorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Doctor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MedicalFrpCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MedicalGrp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NursiongLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NurseID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nurse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NursingGrpCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NursiongGrp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MrStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZzDoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZzDoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZrDoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZrDoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InHopitalDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegisterDiagnosis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegisterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DqFyze" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DqYjjze" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="D4401" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "VInpatientinfo", propOrder = {
    "ipid",
    "pid",
    "adminissionNo",
    "admissionTimes",
    "patientName",
    "sexCode",
    "sex",
    "age",
    "ageDesc",
    "marriageStatusCode",
    "marriageStatus",
    "feeTypeCode",
    "feeTypeName",
    "patientClass",
    "admissionRegisterTime",
    "admissionWay",
    "admissionPurpose",
    "admissionTime",
    "admissionHospital",
    "admissionDeptCode",
    "admissionDept",
    "admissionWardCode",
    "admissionWard",
    "deptCode",
    "deptName",
    "wardCode",
    "wardName",
    "dischargeTime",
    "bedNo",
    "bedFeeType",
    "room",
    "stateOfIllness",
    "doctorID",
    "doctor",
    "medicalFrpCode",
    "medicalGrp",
    "nursiongLevel",
    "nurseID",
    "nurse",
    "nursingGrpCode",
    "nursiongGrp",
    "mrStatus",
    "zzDoctorCode",
    "zzDoctorName",
    "zrDoctorCode",
    "zrDoctorName",
    "inHopitalDay",
    "registerDiagnosis",
    "registerCode",
    "dqFyze",
    "dqYjjze",
    "d4401",
    "additionalFields",
    "nlsFields"
})
public class VInpatientinfo
    extends JAXBObject
{

    @XmlElement(name = "Ipid")
    protected String ipid;
    @XmlElement(name = "Pid")
    protected String pid;
    @XmlElement(name = "AdminissionNo")
    protected String adminissionNo;
    @XmlElement(name = "AdmissionTimes")
    protected String admissionTimes;
    @XmlElement(name = "PatientName")
    protected String patientName;
    @XmlElement(name = "SexCode")
    protected String sexCode;
    @XmlElement(name = "Sex")
    protected String sex;
    @XmlElement(name = "Age")
    protected String age;
    @XmlElement(name = "AgeDesc")
    protected String ageDesc;
    @XmlElement(name = "MarriageStatusCode")
    protected String marriageStatusCode;
    @XmlElement(name = "MarriageStatus")
    protected String marriageStatus;
    @XmlElement(name = "FeeTypeCode")
    protected String feeTypeCode;
    @XmlElement(name = "FeeTypeName")
    protected String feeTypeName;
    @XmlElement(name = "PatientClass")
    protected String patientClass;
    @XmlElement(name = "AdmissionRegisterTime")
    protected String admissionRegisterTime;
    @XmlElement(name = "AdmissionWay")
    protected String admissionWay;
    @XmlElement(name = "AdmissionPurpose")
    protected String admissionPurpose;
    @XmlElement(name = "AdmissionTime")
    protected String admissionTime;
    @XmlElement(name = "AdmissionHospital")
    protected String admissionHospital;
    @XmlElement(name = "AdmissionDeptCode")
    protected String admissionDeptCode;
    @XmlElement(name = "AdmissionDept")
    protected String admissionDept;
    @XmlElement(name = "AdmissionWardCode")
    protected String admissionWardCode;
    @XmlElement(name = "AdmissionWard")
    protected String admissionWard;
    @XmlElement(name = "DeptCode")
    protected String deptCode;
    @XmlElement(name = "DeptName")
    protected String deptName;
    @XmlElement(name = "WardCode")
    protected String wardCode;
    @XmlElement(name = "WardName")
    protected String wardName;
    @XmlElement(name = "DischargeTime")
    protected String dischargeTime;
    @XmlElement(name = "BedNo")
    protected String bedNo;
    @XmlElement(name = "BedFeeType")
    protected String bedFeeType;
    @XmlElement(name = "Room")
    protected String room;
    @XmlElement(name = "StateOfIllness")
    protected String stateOfIllness;
    @XmlElement(name = "DoctorID")
    protected String doctorID;
    @XmlElement(name = "Doctor")
    protected String doctor;
    @XmlElement(name = "MedicalFrpCode")
    protected String medicalFrpCode;
    @XmlElement(name = "MedicalGrp")
    protected String medicalGrp;
    @XmlElement(name = "NursiongLevel")
    protected String nursiongLevel;
    @XmlElement(name = "NurseID")
    protected String nurseID;
    @XmlElement(name = "Nurse")
    protected String nurse;
    @XmlElement(name = "NursingGrpCode")
    protected String nursingGrpCode;
    @XmlElement(name = "NursiongGrp")
    protected String nursiongGrp;
    @XmlElement(name = "MrStatus")
    protected String mrStatus;
    @XmlElement(name = "ZzDoctorCode")
    protected String zzDoctorCode;
    @XmlElement(name = "ZzDoctorName")
    protected String zzDoctorName;
    @XmlElement(name = "ZrDoctorCode")
    protected String zrDoctorCode;
    @XmlElement(name = "ZrDoctorName")
    protected String zrDoctorName;
    @XmlElement(name = "InHopitalDay")
    protected String inHopitalDay;
    @XmlElement(name = "RegisterDiagnosis")
    protected String registerDiagnosis;
    @XmlElement(name = "RegisterCode")
    protected String registerCode;
    @XmlElement(name = "DqFyze")
    protected String dqFyze;
    @XmlElement(name = "DqYjjze")
    protected String dqYjjze;
    @XmlElement(name = "D4401")
    protected String d4401;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取ipid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpid() {
        return ipid;
    }

    /**
     * 设置ipid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpid(String value) {
        this.ipid = value;
    }

    /**
     * 获取pid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置pid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPid(String value) {
        this.pid = value;
    }

    /**
     * 获取adminissionNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminissionNo() {
        return adminissionNo;
    }

    /**
     * 设置adminissionNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminissionNo(String value) {
        this.adminissionNo = value;
    }

    /**
     * 获取admissionTimes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionTimes() {
        return admissionTimes;
    }

    /**
     * 设置admissionTimes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionTimes(String value) {
        this.admissionTimes = value;
    }

    /**
     * 获取patientName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * 设置patientName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientName(String value) {
        this.patientName = value;
    }

    /**
     * 获取sexCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexCode() {
        return sexCode;
    }

    /**
     * 设置sexCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexCode(String value) {
        this.sexCode = value;
    }

    /**
     * 获取sex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置sex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
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
     * 获取ageDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgeDesc() {
        return ageDesc;
    }

    /**
     * 设置ageDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgeDesc(String value) {
        this.ageDesc = value;
    }

    /**
     * 获取marriageStatusCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarriageStatusCode() {
        return marriageStatusCode;
    }

    /**
     * 设置marriageStatusCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarriageStatusCode(String value) {
        this.marriageStatusCode = value;
    }

    /**
     * 获取marriageStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarriageStatus() {
        return marriageStatus;
    }

    /**
     * 设置marriageStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarriageStatus(String value) {
        this.marriageStatus = value;
    }

    /**
     * 获取feeTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeTypeCode() {
        return feeTypeCode;
    }

    /**
     * 设置feeTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeTypeCode(String value) {
        this.feeTypeCode = value;
    }

    /**
     * 获取feeTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeTypeName() {
        return feeTypeName;
    }

    /**
     * 设置feeTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeTypeName(String value) {
        this.feeTypeName = value;
    }

    /**
     * 获取patientClass属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientClass() {
        return patientClass;
    }

    /**
     * 设置patientClass属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientClass(String value) {
        this.patientClass = value;
    }

    /**
     * 获取admissionRegisterTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionRegisterTime() {
        return admissionRegisterTime;
    }

    /**
     * 设置admissionRegisterTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionRegisterTime(String value) {
        this.admissionRegisterTime = value;
    }

    /**
     * 获取admissionWay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionWay() {
        return admissionWay;
    }

    /**
     * 设置admissionWay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionWay(String value) {
        this.admissionWay = value;
    }

    /**
     * 获取admissionPurpose属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionPurpose() {
        return admissionPurpose;
    }

    /**
     * 设置admissionPurpose属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionPurpose(String value) {
        this.admissionPurpose = value;
    }

    /**
     * 获取admissionTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionTime() {
        return admissionTime;
    }

    /**
     * 设置admissionTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionTime(String value) {
        this.admissionTime = value;
    }

    /**
     * 获取admissionHospital属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionHospital() {
        return admissionHospital;
    }

    /**
     * 设置admissionHospital属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionHospital(String value) {
        this.admissionHospital = value;
    }

    /**
     * 获取admissionDeptCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionDeptCode() {
        return admissionDeptCode;
    }

    /**
     * 设置admissionDeptCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionDeptCode(String value) {
        this.admissionDeptCode = value;
    }

    /**
     * 获取admissionDept属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionDept() {
        return admissionDept;
    }

    /**
     * 设置admissionDept属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionDept(String value) {
        this.admissionDept = value;
    }

    /**
     * 获取admissionWardCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionWardCode() {
        return admissionWardCode;
    }

    /**
     * 设置admissionWardCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionWardCode(String value) {
        this.admissionWardCode = value;
    }

    /**
     * 获取admissionWard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionWard() {
        return admissionWard;
    }

    /**
     * 设置admissionWard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionWard(String value) {
        this.admissionWard = value;
    }

    /**
     * 获取deptCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置deptCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptCode(String value) {
        this.deptCode = value;
    }

    /**
     * 获取deptName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置deptName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptName(String value) {
        this.deptName = value;
    }

    /**
     * 获取wardCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWardCode() {
        return wardCode;
    }

    /**
     * 设置wardCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWardCode(String value) {
        this.wardCode = value;
    }

    /**
     * 获取wardName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWardName() {
        return wardName;
    }

    /**
     * 设置wardName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWardName(String value) {
        this.wardName = value;
    }

    /**
     * 获取dischargeTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDischargeTime() {
        return dischargeTime;
    }

    /**
     * 设置dischargeTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDischargeTime(String value) {
        this.dischargeTime = value;
    }

    /**
     * 获取bedNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedNo() {
        return bedNo;
    }

    /**
     * 设置bedNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedNo(String value) {
        this.bedNo = value;
    }

    /**
     * 获取bedFeeType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedFeeType() {
        return bedFeeType;
    }

    /**
     * 设置bedFeeType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedFeeType(String value) {
        this.bedFeeType = value;
    }

    /**
     * 获取room属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置room属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoom(String value) {
        this.room = value;
    }

    /**
     * 获取stateOfIllness属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOfIllness() {
        return stateOfIllness;
    }

    /**
     * 设置stateOfIllness属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOfIllness(String value) {
        this.stateOfIllness = value;
    }

    /**
     * 获取doctorID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctorID() {
        return doctorID;
    }

    /**
     * 设置doctorID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctorID(String value) {
        this.doctorID = value;
    }

    /**
     * 获取doctor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * 设置doctor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoctor(String value) {
        this.doctor = value;
    }

    /**
     * 获取medicalFrpCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalFrpCode() {
        return medicalFrpCode;
    }

    /**
     * 设置medicalFrpCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalFrpCode(String value) {
        this.medicalFrpCode = value;
    }

    /**
     * 获取medicalGrp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalGrp() {
        return medicalGrp;
    }

    /**
     * 设置medicalGrp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalGrp(String value) {
        this.medicalGrp = value;
    }

    /**
     * 获取nursiongLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNursiongLevel() {
        return nursiongLevel;
    }

    /**
     * 设置nursiongLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNursiongLevel(String value) {
        this.nursiongLevel = value;
    }

    /**
     * 获取nurseID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNurseID() {
        return nurseID;
    }

    /**
     * 设置nurseID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNurseID(String value) {
        this.nurseID = value;
    }

    /**
     * 获取nurse属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNurse() {
        return nurse;
    }

    /**
     * 设置nurse属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNurse(String value) {
        this.nurse = value;
    }

    /**
     * 获取nursingGrpCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNursingGrpCode() {
        return nursingGrpCode;
    }

    /**
     * 设置nursingGrpCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNursingGrpCode(String value) {
        this.nursingGrpCode = value;
    }

    /**
     * 获取nursiongGrp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNursiongGrp() {
        return nursiongGrp;
    }

    /**
     * 设置nursiongGrp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNursiongGrp(String value) {
        this.nursiongGrp = value;
    }

    /**
     * 获取mrStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMrStatus() {
        return mrStatus;
    }

    /**
     * 设置mrStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMrStatus(String value) {
        this.mrStatus = value;
    }

    /**
     * 获取zzDoctorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZzDoctorCode() {
        return zzDoctorCode;
    }

    /**
     * 设置zzDoctorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZzDoctorCode(String value) {
        this.zzDoctorCode = value;
    }

    /**
     * 获取zzDoctorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZzDoctorName() {
        return zzDoctorName;
    }

    /**
     * 设置zzDoctorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZzDoctorName(String value) {
        this.zzDoctorName = value;
    }

    /**
     * 获取zrDoctorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZrDoctorCode() {
        return zrDoctorCode;
    }

    /**
     * 设置zrDoctorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZrDoctorCode(String value) {
        this.zrDoctorCode = value;
    }

    /**
     * 获取zrDoctorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZrDoctorName() {
        return zrDoctorName;
    }

    /**
     * 设置zrDoctorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZrDoctorName(String value) {
        this.zrDoctorName = value;
    }

    /**
     * 获取inHopitalDay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInHopitalDay() {
        return inHopitalDay;
    }

    /**
     * 设置inHopitalDay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInHopitalDay(String value) {
        this.inHopitalDay = value;
    }

    /**
     * 获取registerDiagnosis属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterDiagnosis() {
        return registerDiagnosis;
    }

    /**
     * 设置registerDiagnosis属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterDiagnosis(String value) {
        this.registerDiagnosis = value;
    }

    /**
     * 获取registerCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterCode() {
        return registerCode;
    }

    /**
     * 设置registerCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterCode(String value) {
        this.registerCode = value;
    }

    /**
     * 获取dqFyze属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDqFyze() {
        return dqFyze;
    }

    /**
     * 设置dqFyze属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDqFyze(String value) {
        this.dqFyze = value;
    }

    /**
     * 获取dqYjjze属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDqYjjze() {
        return dqYjjze;
    }

    /**
     * 设置dqYjjze属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDqYjjze(String value) {
        this.dqYjjze = value;
    }

    /**
     * 获取d4401属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getD4401() {
        return d4401;
    }

    /**
     * 设置d4401属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setD4401(String value) {
        this.d4401 = value;
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

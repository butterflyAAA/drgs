//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.09.27 时间 05:04:12 PM CST 
//


package com.haitaiinc.db;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.haitaiinc.xml.jaxb.JAXBObject;


/**
 * <p>OperOrderConfig complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OperOrderConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ipid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ordinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsNew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperaSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HealGrade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HealGradeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CutGradeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CutGradeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperaComplicationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperaComplicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsOperAid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationStartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationEndTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationDoctor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationDoctorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssistantI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssistantICode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssistantIi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssistantIiCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationRoomCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AsaLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AsaLevelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Anesthesia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnesthesiaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnesthesiaDoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnesthesiaDoctor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RiskLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RiskLevelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsElective" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsMainOperation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationStartExactTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationEndExactTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IntraoperativeForeignBody" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsAntibacterial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AntimicrobialsDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnplannedSurgery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DaySurgery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationContinuedTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsMainDrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperResourcesOrdinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationCountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsOrderSave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DipOperaOrdinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DipOperaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsOverThreeHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "OperOrderConfig", propOrder = {
    "recSN",
    "ipid",
    "operationName",
    "operationCode",
    "operationLevel",
    "operationLevelCode",
    "ordinal",
    "isNew",
    "operaSN",
    "healGrade",
    "healGradeCode",
    "cutGradeName",
    "cutGradeCode",
    "operationTime",
    "operType",
    "operaComplicationCode",
    "operaComplicationName",
    "isOperAid",
    "operationStartTime",
    "operationEndTime",
    "operationDoctor",
    "operationDoctorID",
    "assistantI",
    "assistantICode",
    "assistantIi",
    "assistantIiCode",
    "operationRoom",
    "operationRoomCode",
    "asaLevelCode",
    "asaLevelName",
    "anesthesia",
    "anesthesiaCode",
    "anesthesiaDoctorCode",
    "anesthesiaDoctor",
    "riskLevelCode",
    "riskLevelName",
    "isElective",
    "isMainOperation",
    "operationStartExactTime",
    "operationEndExactTime",
    "intraoperativeForeignBody",
    "isAntibacterial",
    "antimicrobialsDay",
    "unplannedSurgery",
    "daySurgery",
    "operationContinuedTime",
    "isMainDrg",
    "operResourcesOrdinal",
    "operationCountryCode",
    "operationCountryName",
    "isOrderSave",
    "dipOperaOrdinal",
    "dipOperaName",
    "isOverThreeHours",
    "additionalFields",
    "nlsFields"
})
public class OperOrderConfig
    extends JAXBObject
{

    @XmlElement(name = "RecSN")
    protected String recSN;
    @XmlElement(name = "Ipid")
    protected String ipid;
    @XmlElement(name = "OperationName")
    protected String operationName;
    @XmlElement(name = "OperationCode")
    protected String operationCode;
    @XmlElement(name = "OperationLevel")
    protected String operationLevel;
    @XmlElement(name = "OperationLevelCode")
    protected String operationLevelCode;
    @XmlElement(name = "Ordinal")
    protected String ordinal;
    @XmlElement(name = "IsNew")
    protected String isNew;
    @XmlElement(name = "OperaSN")
    protected String operaSN;
    @XmlElement(name = "HealGrade")
    protected String healGrade;
    @XmlElement(name = "HealGradeCode")
    protected String healGradeCode;
    @XmlElement(name = "CutGradeName")
    protected String cutGradeName;
    @XmlElement(name = "CutGradeCode")
    protected String cutGradeCode;
    @XmlElement(name = "OperationTime")
    protected String operationTime;
    @XmlElement(name = "OperType")
    protected String operType;
    @XmlElement(name = "OperaComplicationCode")
    protected String operaComplicationCode;
    @XmlElement(name = "OperaComplicationName")
    protected String operaComplicationName;
    @XmlElement(name = "IsOperAid")
    protected String isOperAid;
    @XmlElement(name = "OperationStartTime")
    protected String operationStartTime;
    @XmlElement(name = "OperationEndTime")
    protected String operationEndTime;
    @XmlElement(name = "OperationDoctor")
    protected String operationDoctor;
    @XmlElement(name = "OperationDoctorID")
    protected String operationDoctorID;
    @XmlElement(name = "AssistantI")
    protected String assistantI;
    @XmlElement(name = "AssistantICode")
    protected String assistantICode;
    @XmlElement(name = "AssistantIi")
    protected String assistantIi;
    @XmlElement(name = "AssistantIiCode")
    protected String assistantIiCode;
    @XmlElement(name = "OperationRoom")
    protected String operationRoom;
    @XmlElement(name = "OperationRoomCode")
    protected String operationRoomCode;
    @XmlElement(name = "AsaLevelCode")
    protected String asaLevelCode;
    @XmlElement(name = "AsaLevelName")
    protected String asaLevelName;
    @XmlElement(name = "Anesthesia")
    protected String anesthesia;
    @XmlElement(name = "AnesthesiaCode")
    protected String anesthesiaCode;
    @XmlElement(name = "AnesthesiaDoctorCode")
    protected String anesthesiaDoctorCode;
    @XmlElement(name = "AnesthesiaDoctor")
    protected String anesthesiaDoctor;
    @XmlElement(name = "RiskLevelCode")
    protected String riskLevelCode;
    @XmlElement(name = "RiskLevelName")
    protected String riskLevelName;
    @XmlElement(name = "IsElective")
    protected String isElective;
    @XmlElement(name = "IsMainOperation")
    protected String isMainOperation;
    @XmlElement(name = "OperationStartExactTime")
    protected String operationStartExactTime;
    @XmlElement(name = "OperationEndExactTime")
    protected String operationEndExactTime;
    @XmlElement(name = "IntraoperativeForeignBody")
    protected String intraoperativeForeignBody;
    @XmlElement(name = "IsAntibacterial")
    protected String isAntibacterial;
    @XmlElement(name = "AntimicrobialsDay")
    protected String antimicrobialsDay;
    @XmlElement(name = "UnplannedSurgery")
    protected String unplannedSurgery;
    @XmlElement(name = "DaySurgery")
    protected String daySurgery;
    @XmlElement(name = "OperationContinuedTime")
    protected String operationContinuedTime;
    @XmlElement(name = "IsMainDrg")
    protected String isMainDrg;
    @XmlElement(name = "OperResourcesOrdinal")
    protected String operResourcesOrdinal;
    @XmlElement(name = "OperationCountryCode")
    protected String operationCountryCode;
    @XmlElement(name = "OperationCountryName")
    protected String operationCountryName;
    @XmlElement(name = "IsOrderSave")
    protected String isOrderSave;
    @XmlElement(name = "DipOperaOrdinal")
    protected String dipOperaOrdinal;
    @XmlElement(name = "DipOperaName")
    protected String dipOperaName;
    @XmlElement(name = "IsOverThreeHours")
    protected String isOverThreeHours;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取recSN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecSN() {
        return recSN;
    }

    /**
     * 设置recSN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecSN(String value) {
        this.recSN = value;
    }

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
     * 获取operationName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * 设置operationName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationName(String value) {
        this.operationName = value;
    }

    /**
     * 获取operationCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationCode() {
        return operationCode;
    }

    /**
     * 设置operationCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationCode(String value) {
        this.operationCode = value;
    }

    /**
     * 获取operationLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationLevel() {
        return operationLevel;
    }

    /**
     * 设置operationLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationLevel(String value) {
        this.operationLevel = value;
    }

    /**
     * 获取operationLevelCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationLevelCode() {
        return operationLevelCode;
    }

    /**
     * 设置operationLevelCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationLevelCode(String value) {
        this.operationLevelCode = value;
    }

    /**
     * 获取ordinal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdinal() {
        return ordinal;
    }

    /**
     * 设置ordinal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdinal(String value) {
        this.ordinal = value;
    }

    /**
     * 获取isNew属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsNew() {
        return isNew;
    }

    /**
     * 设置isNew属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsNew(String value) {
        this.isNew = value;
    }

    /**
     * 获取operaSN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperaSN() {
        return operaSN;
    }

    /**
     * 设置operaSN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperaSN(String value) {
        this.operaSN = value;
    }

    /**
     * 获取healGrade属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHealGrade() {
        return healGrade;
    }

    /**
     * 设置healGrade属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHealGrade(String value) {
        this.healGrade = value;
    }

    /**
     * 获取healGradeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHealGradeCode() {
        return healGradeCode;
    }

    /**
     * 设置healGradeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHealGradeCode(String value) {
        this.healGradeCode = value;
    }

    /**
     * 获取cutGradeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCutGradeName() {
        return cutGradeName;
    }

    /**
     * 设置cutGradeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCutGradeName(String value) {
        this.cutGradeName = value;
    }

    /**
     * 获取cutGradeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCutGradeCode() {
        return cutGradeCode;
    }

    /**
     * 设置cutGradeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCutGradeCode(String value) {
        this.cutGradeCode = value;
    }

    /**
     * 获取operationTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationTime() {
        return operationTime;
    }

    /**
     * 设置operationTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationTime(String value) {
        this.operationTime = value;
    }

    /**
     * 获取operType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperType() {
        return operType;
    }

    /**
     * 设置operType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperType(String value) {
        this.operType = value;
    }

    /**
     * 获取operaComplicationCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperaComplicationCode() {
        return operaComplicationCode;
    }

    /**
     * 设置operaComplicationCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperaComplicationCode(String value) {
        this.operaComplicationCode = value;
    }

    /**
     * 获取operaComplicationName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperaComplicationName() {
        return operaComplicationName;
    }

    /**
     * 设置operaComplicationName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperaComplicationName(String value) {
        this.operaComplicationName = value;
    }

    /**
     * 获取isOperAid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsOperAid() {
        return isOperAid;
    }

    /**
     * 设置isOperAid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsOperAid(String value) {
        this.isOperAid = value;
    }

    /**
     * 获取operationStartTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationStartTime() {
        return operationStartTime;
    }

    /**
     * 设置operationStartTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationStartTime(String value) {
        this.operationStartTime = value;
    }

    /**
     * 获取operationEndTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationEndTime() {
        return operationEndTime;
    }

    /**
     * 设置operationEndTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationEndTime(String value) {
        this.operationEndTime = value;
    }

    /**
     * 获取operationDoctor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationDoctor() {
        return operationDoctor;
    }

    /**
     * 设置operationDoctor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationDoctor(String value) {
        this.operationDoctor = value;
    }

    /**
     * 获取operationDoctorID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationDoctorID() {
        return operationDoctorID;
    }

    /**
     * 设置operationDoctorID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationDoctorID(String value) {
        this.operationDoctorID = value;
    }

    /**
     * 获取assistantI属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistantI() {
        return assistantI;
    }

    /**
     * 设置assistantI属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistantI(String value) {
        this.assistantI = value;
    }

    /**
     * 获取assistantICode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistantICode() {
        return assistantICode;
    }

    /**
     * 设置assistantICode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistantICode(String value) {
        this.assistantICode = value;
    }

    /**
     * 获取assistantIi属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistantIi() {
        return assistantIi;
    }

    /**
     * 设置assistantIi属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistantIi(String value) {
        this.assistantIi = value;
    }

    /**
     * 获取assistantIiCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistantIiCode() {
        return assistantIiCode;
    }

    /**
     * 设置assistantIiCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistantIiCode(String value) {
        this.assistantIiCode = value;
    }

    /**
     * 获取operationRoom属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationRoom() {
        return operationRoom;
    }

    /**
     * 设置operationRoom属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationRoom(String value) {
        this.operationRoom = value;
    }

    /**
     * 获取operationRoomCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationRoomCode() {
        return operationRoomCode;
    }

    /**
     * 设置operationRoomCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationRoomCode(String value) {
        this.operationRoomCode = value;
    }

    /**
     * 获取asaLevelCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsaLevelCode() {
        return asaLevelCode;
    }

    /**
     * 设置asaLevelCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsaLevelCode(String value) {
        this.asaLevelCode = value;
    }

    /**
     * 获取asaLevelName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsaLevelName() {
        return asaLevelName;
    }

    /**
     * 设置asaLevelName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsaLevelName(String value) {
        this.asaLevelName = value;
    }

    /**
     * 获取anesthesia属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnesthesia() {
        return anesthesia;
    }

    /**
     * 设置anesthesia属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnesthesia(String value) {
        this.anesthesia = value;
    }

    /**
     * 获取anesthesiaCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnesthesiaCode() {
        return anesthesiaCode;
    }

    /**
     * 设置anesthesiaCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnesthesiaCode(String value) {
        this.anesthesiaCode = value;
    }

    /**
     * 获取anesthesiaDoctorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnesthesiaDoctorCode() {
        return anesthesiaDoctorCode;
    }

    /**
     * 设置anesthesiaDoctorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnesthesiaDoctorCode(String value) {
        this.anesthesiaDoctorCode = value;
    }

    /**
     * 获取anesthesiaDoctor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnesthesiaDoctor() {
        return anesthesiaDoctor;
    }

    /**
     * 设置anesthesiaDoctor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnesthesiaDoctor(String value) {
        this.anesthesiaDoctor = value;
    }

    /**
     * 获取riskLevelCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRiskLevelCode() {
        return riskLevelCode;
    }

    /**
     * 设置riskLevelCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRiskLevelCode(String value) {
        this.riskLevelCode = value;
    }

    /**
     * 获取riskLevelName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRiskLevelName() {
        return riskLevelName;
    }

    /**
     * 设置riskLevelName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRiskLevelName(String value) {
        this.riskLevelName = value;
    }

    /**
     * 获取isElective属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsElective() {
        return isElective;
    }

    /**
     * 设置isElective属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsElective(String value) {
        this.isElective = value;
    }

    /**
     * 获取isMainOperation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsMainOperation() {
        return isMainOperation;
    }

    /**
     * 设置isMainOperation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsMainOperation(String value) {
        this.isMainOperation = value;
    }

    /**
     * 获取operationStartExactTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationStartExactTime() {
        return operationStartExactTime;
    }

    /**
     * 设置operationStartExactTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationStartExactTime(String value) {
        this.operationStartExactTime = value;
    }

    /**
     * 获取operationEndExactTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationEndExactTime() {
        return operationEndExactTime;
    }

    /**
     * 设置operationEndExactTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationEndExactTime(String value) {
        this.operationEndExactTime = value;
    }

    /**
     * 获取intraoperativeForeignBody属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntraoperativeForeignBody() {
        return intraoperativeForeignBody;
    }

    /**
     * 设置intraoperativeForeignBody属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntraoperativeForeignBody(String value) {
        this.intraoperativeForeignBody = value;
    }

    /**
     * 获取isAntibacterial属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAntibacterial() {
        return isAntibacterial;
    }

    /**
     * 设置isAntibacterial属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAntibacterial(String value) {
        this.isAntibacterial = value;
    }

    /**
     * 获取antimicrobialsDay属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntimicrobialsDay() {
        return antimicrobialsDay;
    }

    /**
     * 设置antimicrobialsDay属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntimicrobialsDay(String value) {
        this.antimicrobialsDay = value;
    }

    /**
     * 获取unplannedSurgery属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnplannedSurgery() {
        return unplannedSurgery;
    }

    /**
     * 设置unplannedSurgery属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnplannedSurgery(String value) {
        this.unplannedSurgery = value;
    }

    /**
     * 获取daySurgery属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDaySurgery() {
        return daySurgery;
    }

    /**
     * 设置daySurgery属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaySurgery(String value) {
        this.daySurgery = value;
    }

    /**
     * 获取operationContinuedTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationContinuedTime() {
        return operationContinuedTime;
    }

    /**
     * 设置operationContinuedTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationContinuedTime(String value) {
        this.operationContinuedTime = value;
    }

    /**
     * 获取isMainDrg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsMainDrg() {
        return isMainDrg;
    }

    /**
     * 设置isMainDrg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsMainDrg(String value) {
        this.isMainDrg = value;
    }

    /**
     * 获取operResourcesOrdinal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperResourcesOrdinal() {
        return operResourcesOrdinal;
    }

    /**
     * 设置operResourcesOrdinal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperResourcesOrdinal(String value) {
        this.operResourcesOrdinal = value;
    }

    /**
     * 获取operationCountryCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationCountryCode() {
        return operationCountryCode;
    }

    /**
     * 设置operationCountryCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationCountryCode(String value) {
        this.operationCountryCode = value;
    }

    /**
     * 获取operationCountryName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationCountryName() {
        return operationCountryName;
    }

    /**
     * 设置operationCountryName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationCountryName(String value) {
        this.operationCountryName = value;
    }

    /**
     * 获取isOrderSave属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsOrderSave() {
        return isOrderSave;
    }

    /**
     * 设置isOrderSave属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsOrderSave(String value) {
        this.isOrderSave = value;
    }

    /**
     * 获取dipOperaOrdinal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDipOperaOrdinal() {
        return dipOperaOrdinal;
    }

    /**
     * 设置dipOperaOrdinal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDipOperaOrdinal(String value) {
        this.dipOperaOrdinal = value;
    }

    /**
     * 获取dipOperaName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDipOperaName() {
        return dipOperaName;
    }

    /**
     * 设置dipOperaName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDipOperaName(String value) {
        this.dipOperaName = value;
    }

    /**
     * 获取isOverThreeHours属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsOverThreeHours() {
        return isOverThreeHours;
    }

    /**
     * 设置isOverThreeHours属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsOverThreeHours(String value) {
        this.isOverThreeHours = value;
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

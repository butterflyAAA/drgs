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
 * <p>BsOprninfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BsOprninfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OprnOprtDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnOprtName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnOprtCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnOprtSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnLvCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnLvName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Asit1Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Asit2Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SincHealLv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SincHealLvCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstMtdName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstMtdCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstDrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnOperPart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnOperPartCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnConTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstLvName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstLvCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnPatnType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnPatnTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MainOprnFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstAsaLvCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstAsaLvName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstMednCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstMednName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstMednDos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Unt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstBegntime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstEndtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstCopnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstCopnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstCopnDscr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PacuBegntime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PacuEndtime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CancOprnFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValiFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptMedcasHmpgSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MdtrtSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Brxh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sxh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnstDrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Asit2Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Asit1Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OprnOprtType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Jgdm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "BsOprninfo", propOrder = {
    "oprnOprtDate",
    "oprnOprtName",
    "oprnOprtCode",
    "oprnOprtSN",
    "oprnLvCode",
    "oprnLvName",
    "operName",
    "asit1Name",
    "asit2Name",
    "sincHealLv",
    "sincHealLvCode",
    "anstMtdName",
    "anstMtdCode",
    "anstDrName",
    "oprnOperPart",
    "oprnOperPartCode",
    "oprnConTime",
    "anstLvName",
    "anstLvCode",
    "oprnPatnType",
    "oprnPatnTypeCode",
    "mainOprnFlag",
    "anstAsaLvCode",
    "anstAsaLvName",
    "anstMednCode",
    "anstMednName",
    "anstMednDos",
    "unt",
    "anstBegntime",
    "anstEndtime",
    "anstCopnCode",
    "anstCopnName",
    "anstCopnDscr",
    "pacuBegntime",
    "pacuEndtime",
    "cancOprnFlag",
    "valiFlag",
    "iptMedcasHmpgSN",
    "mdtrtSN",
    "brxh",
    "sxh",
    "operCode",
    "anstDrCode",
    "asit2Code",
    "asit1Code",
    "oprnOprtType",
    "jgdm",
    "additionalFields",
    "nlsFields"
})
public class BsOprninfo
    extends JAXBObject
{

    @XmlElement(name = "OprnOprtDate")
    protected String oprnOprtDate;
    @XmlElement(name = "OprnOprtName")
    protected String oprnOprtName;
    @XmlElement(name = "OprnOprtCode")
    protected String oprnOprtCode;
    @XmlElement(name = "OprnOprtSN")
    protected String oprnOprtSN;
    @XmlElement(name = "OprnLvCode")
    protected String oprnLvCode;
    @XmlElement(name = "OprnLvName")
    protected String oprnLvName;
    @XmlElement(name = "OperName")
    protected String operName;
    @XmlElement(name = "Asit1Name")
    protected String asit1Name;
    @XmlElement(name = "Asit2Name")
    protected String asit2Name;
    @XmlElement(name = "SincHealLv")
    protected String sincHealLv;
    @XmlElement(name = "SincHealLvCode")
    protected String sincHealLvCode;
    @XmlElement(name = "AnstMtdName")
    protected String anstMtdName;
    @XmlElement(name = "AnstMtdCode")
    protected String anstMtdCode;
    @XmlElement(name = "AnstDrName")
    protected String anstDrName;
    @XmlElement(name = "OprnOperPart")
    protected String oprnOperPart;
    @XmlElement(name = "OprnOperPartCode")
    protected String oprnOperPartCode;
    @XmlElement(name = "OprnConTime")
    protected String oprnConTime;
    @XmlElement(name = "AnstLvName")
    protected String anstLvName;
    @XmlElement(name = "AnstLvCode")
    protected String anstLvCode;
    @XmlElement(name = "OprnPatnType")
    protected String oprnPatnType;
    @XmlElement(name = "OprnPatnTypeCode")
    protected String oprnPatnTypeCode;
    @XmlElement(name = "MainOprnFlag")
    protected String mainOprnFlag;
    @XmlElement(name = "AnstAsaLvCode")
    protected String anstAsaLvCode;
    @XmlElement(name = "AnstAsaLvName")
    protected String anstAsaLvName;
    @XmlElement(name = "AnstMednCode")
    protected String anstMednCode;
    @XmlElement(name = "AnstMednName")
    protected String anstMednName;
    @XmlElement(name = "AnstMednDos")
    protected String anstMednDos;
    @XmlElement(name = "Unt")
    protected String unt;
    @XmlElement(name = "AnstBegntime")
    protected String anstBegntime;
    @XmlElement(name = "AnstEndtime")
    protected String anstEndtime;
    @XmlElement(name = "AnstCopnCode")
    protected String anstCopnCode;
    @XmlElement(name = "AnstCopnName")
    protected String anstCopnName;
    @XmlElement(name = "AnstCopnDscr")
    protected String anstCopnDscr;
    @XmlElement(name = "PacuBegntime")
    protected String pacuBegntime;
    @XmlElement(name = "PacuEndtime")
    protected String pacuEndtime;
    @XmlElement(name = "CancOprnFlag")
    protected String cancOprnFlag;
    @XmlElement(name = "ValiFlag")
    protected String valiFlag;
    @XmlElement(name = "IptMedcasHmpgSN")
    protected String iptMedcasHmpgSN;
    @XmlElement(name = "MdtrtSN")
    protected String mdtrtSN;
    @XmlElement(name = "Brxh")
    protected String brxh;
    @XmlElement(name = "Sxh")
    protected String sxh;
    @XmlElement(name = "OperCode")
    protected String operCode;
    @XmlElement(name = "AnstDrCode")
    protected String anstDrCode;
    @XmlElement(name = "Asit2Code")
    protected String asit2Code;
    @XmlElement(name = "Asit1Code")
    protected String asit1Code;
    @XmlElement(name = "OprnOprtType")
    protected String oprnOprtType;
    @XmlElement(name = "Jgdm")
    protected String jgdm;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取oprnOprtDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnOprtDate() {
        return oprnOprtDate;
    }

    /**
     * 设置oprnOprtDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnOprtDate(String value) {
        this.oprnOprtDate = value;
    }

    /**
     * 获取oprnOprtName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnOprtName() {
        return oprnOprtName;
    }

    /**
     * 设置oprnOprtName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnOprtName(String value) {
        this.oprnOprtName = value;
    }

    /**
     * 获取oprnOprtCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnOprtCode() {
        return oprnOprtCode;
    }

    /**
     * 设置oprnOprtCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnOprtCode(String value) {
        this.oprnOprtCode = value;
    }

    /**
     * 获取oprnOprtSN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnOprtSN() {
        return oprnOprtSN;
    }

    /**
     * 设置oprnOprtSN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnOprtSN(String value) {
        this.oprnOprtSN = value;
    }

    /**
     * 获取oprnLvCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnLvCode() {
        return oprnLvCode;
    }

    /**
     * 设置oprnLvCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnLvCode(String value) {
        this.oprnLvCode = value;
    }

    /**
     * 获取oprnLvName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnLvName() {
        return oprnLvName;
    }

    /**
     * 设置oprnLvName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnLvName(String value) {
        this.oprnLvName = value;
    }

    /**
     * 获取operName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperName() {
        return operName;
    }

    /**
     * 设置operName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperName(String value) {
        this.operName = value;
    }

    /**
     * 获取asit1Name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsit1Name() {
        return asit1Name;
    }

    /**
     * 设置asit1Name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsit1Name(String value) {
        this.asit1Name = value;
    }

    /**
     * 获取asit2Name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsit2Name() {
        return asit2Name;
    }

    /**
     * 设置asit2Name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsit2Name(String value) {
        this.asit2Name = value;
    }

    /**
     * 获取sincHealLv属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSincHealLv() {
        return sincHealLv;
    }

    /**
     * 设置sincHealLv属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSincHealLv(String value) {
        this.sincHealLv = value;
    }

    /**
     * 获取sincHealLvCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSincHealLvCode() {
        return sincHealLvCode;
    }

    /**
     * 设置sincHealLvCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSincHealLvCode(String value) {
        this.sincHealLvCode = value;
    }

    /**
     * 获取anstMtdName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstMtdName() {
        return anstMtdName;
    }

    /**
     * 设置anstMtdName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstMtdName(String value) {
        this.anstMtdName = value;
    }

    /**
     * 获取anstMtdCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstMtdCode() {
        return anstMtdCode;
    }

    /**
     * 设置anstMtdCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstMtdCode(String value) {
        this.anstMtdCode = value;
    }

    /**
     * 获取anstDrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstDrName() {
        return anstDrName;
    }

    /**
     * 设置anstDrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstDrName(String value) {
        this.anstDrName = value;
    }

    /**
     * 获取oprnOperPart属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnOperPart() {
        return oprnOperPart;
    }

    /**
     * 设置oprnOperPart属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnOperPart(String value) {
        this.oprnOperPart = value;
    }

    /**
     * 获取oprnOperPartCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnOperPartCode() {
        return oprnOperPartCode;
    }

    /**
     * 设置oprnOperPartCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnOperPartCode(String value) {
        this.oprnOperPartCode = value;
    }

    /**
     * 获取oprnConTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnConTime() {
        return oprnConTime;
    }

    /**
     * 设置oprnConTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnConTime(String value) {
        this.oprnConTime = value;
    }

    /**
     * 获取anstLvName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstLvName() {
        return anstLvName;
    }

    /**
     * 设置anstLvName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstLvName(String value) {
        this.anstLvName = value;
    }

    /**
     * 获取anstLvCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstLvCode() {
        return anstLvCode;
    }

    /**
     * 设置anstLvCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstLvCode(String value) {
        this.anstLvCode = value;
    }

    /**
     * 获取oprnPatnType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnPatnType() {
        return oprnPatnType;
    }

    /**
     * 设置oprnPatnType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnPatnType(String value) {
        this.oprnPatnType = value;
    }

    /**
     * 获取oprnPatnTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnPatnTypeCode() {
        return oprnPatnTypeCode;
    }

    /**
     * 设置oprnPatnTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnPatnTypeCode(String value) {
        this.oprnPatnTypeCode = value;
    }

    /**
     * 获取mainOprnFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainOprnFlag() {
        return mainOprnFlag;
    }

    /**
     * 设置mainOprnFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainOprnFlag(String value) {
        this.mainOprnFlag = value;
    }

    /**
     * 获取anstAsaLvCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstAsaLvCode() {
        return anstAsaLvCode;
    }

    /**
     * 设置anstAsaLvCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstAsaLvCode(String value) {
        this.anstAsaLvCode = value;
    }

    /**
     * 获取anstAsaLvName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstAsaLvName() {
        return anstAsaLvName;
    }

    /**
     * 设置anstAsaLvName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstAsaLvName(String value) {
        this.anstAsaLvName = value;
    }

    /**
     * 获取anstMednCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstMednCode() {
        return anstMednCode;
    }

    /**
     * 设置anstMednCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstMednCode(String value) {
        this.anstMednCode = value;
    }

    /**
     * 获取anstMednName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstMednName() {
        return anstMednName;
    }

    /**
     * 设置anstMednName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstMednName(String value) {
        this.anstMednName = value;
    }

    /**
     * 获取anstMednDos属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstMednDos() {
        return anstMednDos;
    }

    /**
     * 设置anstMednDos属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstMednDos(String value) {
        this.anstMednDos = value;
    }

    /**
     * 获取unt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnt() {
        return unt;
    }

    /**
     * 设置unt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnt(String value) {
        this.unt = value;
    }

    /**
     * 获取anstBegntime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstBegntime() {
        return anstBegntime;
    }

    /**
     * 设置anstBegntime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstBegntime(String value) {
        this.anstBegntime = value;
    }

    /**
     * 获取anstEndtime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstEndtime() {
        return anstEndtime;
    }

    /**
     * 设置anstEndtime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstEndtime(String value) {
        this.anstEndtime = value;
    }

    /**
     * 获取anstCopnCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstCopnCode() {
        return anstCopnCode;
    }

    /**
     * 设置anstCopnCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstCopnCode(String value) {
        this.anstCopnCode = value;
    }

    /**
     * 获取anstCopnName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstCopnName() {
        return anstCopnName;
    }

    /**
     * 设置anstCopnName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstCopnName(String value) {
        this.anstCopnName = value;
    }

    /**
     * 获取anstCopnDscr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstCopnDscr() {
        return anstCopnDscr;
    }

    /**
     * 设置anstCopnDscr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstCopnDscr(String value) {
        this.anstCopnDscr = value;
    }

    /**
     * 获取pacuBegntime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPacuBegntime() {
        return pacuBegntime;
    }

    /**
     * 设置pacuBegntime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPacuBegntime(String value) {
        this.pacuBegntime = value;
    }

    /**
     * 获取pacuEndtime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPacuEndtime() {
        return pacuEndtime;
    }

    /**
     * 设置pacuEndtime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPacuEndtime(String value) {
        this.pacuEndtime = value;
    }

    /**
     * 获取cancOprnFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancOprnFlag() {
        return cancOprnFlag;
    }

    /**
     * 设置cancOprnFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancOprnFlag(String value) {
        this.cancOprnFlag = value;
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
     * 获取iptMedcasHmpgSN属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIptMedcasHmpgSN() {
        return iptMedcasHmpgSN;
    }

    /**
     * 设置iptMedcasHmpgSN属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIptMedcasHmpgSN(String value) {
        this.iptMedcasHmpgSN = value;
    }

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
     * 获取sxh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSxh() {
        return sxh;
    }

    /**
     * 设置sxh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSxh(String value) {
        this.sxh = value;
    }

    /**
     * 获取operCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperCode() {
        return operCode;
    }

    /**
     * 设置operCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperCode(String value) {
        this.operCode = value;
    }

    /**
     * 获取anstDrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnstDrCode() {
        return anstDrCode;
    }

    /**
     * 设置anstDrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnstDrCode(String value) {
        this.anstDrCode = value;
    }

    /**
     * 获取asit2Code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsit2Code() {
        return asit2Code;
    }

    /**
     * 设置asit2Code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsit2Code(String value) {
        this.asit2Code = value;
    }

    /**
     * 获取asit1Code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsit1Code() {
        return asit1Code;
    }

    /**
     * 设置asit1Code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsit1Code(String value) {
        this.asit1Code = value;
    }

    /**
     * 获取oprnOprtType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOprnOprtType() {
        return oprnOprtType;
    }

    /**
     * 设置oprnOprtType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOprnOprtType(String value) {
        this.oprnOprtType = value;
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

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
 * <p>BsDiseinfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BsDiseinfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PalgNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptPatnDisediagTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DisediagType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaindiagFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiagCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiagName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhospDiagCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhospDiagName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmDiseCondName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmDiseCondCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmCond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdmCondCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HighDiagEvid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BkupDeg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BkupDegCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValiFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IptMedcasHmpgSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MdtrtSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FixmedinsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Brxh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sxh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiagType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "BsDiseinfo", propOrder = {
    "palgNo",
    "iptPatnDisediagTypeCode",
    "disediagType",
    "maindiagFlag",
    "diagCode",
    "diagName",
    "inhospDiagCode",
    "inhospDiagName",
    "admDiseCondName",
    "admDiseCondCode",
    "admCond",
    "admCondCode",
    "highDiagEvid",
    "bkupDeg",
    "bkupDegCode",
    "valiFlag",
    "iptMedcasHmpgSN",
    "mdtrtSN",
    "fixmedinsCode",
    "brxh",
    "sxh",
    "diagType",
    "jgdm",
    "additionalFields",
    "nlsFields"
})
public class BsDiseinfo
    extends JAXBObject
{

    @XmlElement(name = "PalgNo")
    protected String palgNo;
    @XmlElement(name = "IptPatnDisediagTypeCode")
    protected String iptPatnDisediagTypeCode;
    @XmlElement(name = "DisediagType")
    protected String disediagType;
    @XmlElement(name = "MaindiagFlag")
    protected String maindiagFlag;
    @XmlElement(name = "DiagCode")
    protected String diagCode;
    @XmlElement(name = "DiagName")
    protected String diagName;
    @XmlElement(name = "InhospDiagCode")
    protected String inhospDiagCode;
    @XmlElement(name = "InhospDiagName")
    protected String inhospDiagName;
    @XmlElement(name = "AdmDiseCondName")
    protected String admDiseCondName;
    @XmlElement(name = "AdmDiseCondCode")
    protected String admDiseCondCode;
    @XmlElement(name = "AdmCond")
    protected String admCond;
    @XmlElement(name = "AdmCondCode")
    protected String admCondCode;
    @XmlElement(name = "HighDiagEvid")
    protected String highDiagEvid;
    @XmlElement(name = "BkupDeg")
    protected String bkupDeg;
    @XmlElement(name = "BkupDegCode")
    protected String bkupDegCode;
    @XmlElement(name = "ValiFlag")
    protected String valiFlag;
    @XmlElement(name = "IptMedcasHmpgSN")
    protected String iptMedcasHmpgSN;
    @XmlElement(name = "MdtrtSN")
    protected String mdtrtSN;
    @XmlElement(name = "FixmedinsCode")
    protected String fixmedinsCode;
    @XmlElement(name = "Brxh")
    protected String brxh;
    @XmlElement(name = "Sxh")
    protected String sxh;
    @XmlElement(name = "DiagType")
    protected String diagType;
    @XmlElement(name = "Jgdm")
    protected String jgdm;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取palgNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPalgNo() {
        return palgNo;
    }

    /**
     * 设置palgNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPalgNo(String value) {
        this.palgNo = value;
    }

    /**
     * 获取iptPatnDisediagTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIptPatnDisediagTypeCode() {
        return iptPatnDisediagTypeCode;
    }

    /**
     * 设置iptPatnDisediagTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIptPatnDisediagTypeCode(String value) {
        this.iptPatnDisediagTypeCode = value;
    }

    /**
     * 获取disediagType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisediagType() {
        return disediagType;
    }

    /**
     * 设置disediagType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisediagType(String value) {
        this.disediagType = value;
    }

    /**
     * 获取maindiagFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaindiagFlag() {
        return maindiagFlag;
    }

    /**
     * 设置maindiagFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaindiagFlag(String value) {
        this.maindiagFlag = value;
    }

    /**
     * 获取diagCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagCode() {
        return diagCode;
    }

    /**
     * 设置diagCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagCode(String value) {
        this.diagCode = value;
    }

    /**
     * 获取diagName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagName() {
        return diagName;
    }

    /**
     * 设置diagName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagName(String value) {
        this.diagName = value;
    }

    /**
     * 获取inhospDiagCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhospDiagCode() {
        return inhospDiagCode;
    }

    /**
     * 设置inhospDiagCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhospDiagCode(String value) {
        this.inhospDiagCode = value;
    }

    /**
     * 获取inhospDiagName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhospDiagName() {
        return inhospDiagName;
    }

    /**
     * 设置inhospDiagName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhospDiagName(String value) {
        this.inhospDiagName = value;
    }

    /**
     * 获取admDiseCondName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmDiseCondName() {
        return admDiseCondName;
    }

    /**
     * 设置admDiseCondName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmDiseCondName(String value) {
        this.admDiseCondName = value;
    }

    /**
     * 获取admDiseCondCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmDiseCondCode() {
        return admDiseCondCode;
    }

    /**
     * 设置admDiseCondCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmDiseCondCode(String value) {
        this.admDiseCondCode = value;
    }

    /**
     * 获取admCond属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmCond() {
        return admCond;
    }

    /**
     * 设置admCond属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmCond(String value) {
        this.admCond = value;
    }

    /**
     * 获取admCondCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmCondCode() {
        return admCondCode;
    }

    /**
     * 设置admCondCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmCondCode(String value) {
        this.admCondCode = value;
    }

    /**
     * 获取highDiagEvid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHighDiagEvid() {
        return highDiagEvid;
    }

    /**
     * 设置highDiagEvid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHighDiagEvid(String value) {
        this.highDiagEvid = value;
    }

    /**
     * 获取bkupDeg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBkupDeg() {
        return bkupDeg;
    }

    /**
     * 设置bkupDeg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBkupDeg(String value) {
        this.bkupDeg = value;
    }

    /**
     * 获取bkupDegCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBkupDegCode() {
        return bkupDegCode;
    }

    /**
     * 设置bkupDegCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBkupDegCode(String value) {
        this.bkupDegCode = value;
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
     * 获取diagType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiagType() {
        return diagType;
    }

    /**
     * 设置diagType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiagType(String value) {
        this.diagType = value;
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

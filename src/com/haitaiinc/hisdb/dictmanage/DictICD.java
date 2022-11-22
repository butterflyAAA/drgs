//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.04.25 时间 01:03:06 PM CST 
//


package com.haitaiinc.hisdb.dictmanage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.haitaiinc.xml.jaxb.JAXBObject;


/**
 * <p>DictICD complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DictICD">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ICDCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JbMc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZdflID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bbh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DelFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zdym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cjsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cjr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zhgxsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zhgxr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zfjb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JkzxBm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CrbFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ICDTnbFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AfpFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GlFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CsqxFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CrbFhtx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Lx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Jbdm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Jslxdm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DictICD", propOrder = {
    "icdCode",
    "jbMc",
    "zdflID",
    "bbh",
    "delFlag",
    "pym",
    "zdym",
    "cjsj",
    "cjr",
    "zhgxsj",
    "zhgxr",
    "code",
    "zfjb",
    "remark",
    "jkzxBm",
    "crbFlag",
    "icdTnbFlag",
    "afpFlag",
    "glFlag",
    "csqxFlag",
    "crbFhtx",
    "lx",
    "jbdm",
    "jslxdm",
    "additionalFields",
    "nlsFields"
})
public class DictICD
    extends JAXBObject
{

    @XmlElement(name = "ICDCode")
    protected String icdCode;
    @XmlElement(name = "JbMc")
    protected String jbMc;
    @XmlElement(name = "ZdflID")
    protected String zdflID;
    @XmlElement(name = "Bbh")
    protected String bbh;
    @XmlElement(name = "DelFlag")
    protected String delFlag;
    @XmlElement(name = "Pym")
    protected String pym;
    @XmlElement(name = "Zdym")
    protected String zdym;
    @XmlElement(name = "Cjsj")
    protected String cjsj;
    @XmlElement(name = "Cjr")
    protected String cjr;
    @XmlElement(name = "Zhgxsj")
    protected String zhgxsj;
    @XmlElement(name = "Zhgxr")
    protected String zhgxr;
    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Zfjb")
    protected String zfjb;
    @XmlElement(name = "Remark")
    protected String remark;
    @XmlElement(name = "JkzxBm")
    protected String jkzxBm;
    @XmlElement(name = "CrbFlag")
    protected String crbFlag;
    @XmlElement(name = "ICDTnbFlag")
    protected String icdTnbFlag;
    @XmlElement(name = "AfpFlag")
    protected String afpFlag;
    @XmlElement(name = "GlFlag")
    protected String glFlag;
    @XmlElement(name = "CsqxFlag")
    protected String csqxFlag;
    @XmlElement(name = "CrbFhtx")
    protected String crbFhtx;
    @XmlElement(name = "Lx")
    protected String lx;
    @XmlElement(name = "Jbdm")
    protected String jbdm;
    @XmlElement(name = "Jslxdm")
    protected String jslxdm;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取icdCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICDCode() {
        return icdCode;
    }

    /**
     * 设置icdCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICDCode(String value) {
        this.icdCode = value;
    }

    /**
     * 获取jbMc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJbMc() {
        return jbMc;
    }

    /**
     * 设置jbMc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJbMc(String value) {
        this.jbMc = value;
    }

    /**
     * 获取zdflID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdflID() {
        return zdflID;
    }

    /**
     * 设置zdflID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdflID(String value) {
        this.zdflID = value;
    }

    /**
     * 获取bbh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBbh() {
        return bbh;
    }

    /**
     * 设置bbh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBbh(String value) {
        this.bbh = value;
    }

    /**
     * 获取delFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置delFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelFlag(String value) {
        this.delFlag = value;
    }

    /**
     * 获取pym属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPym() {
        return pym;
    }

    /**
     * 设置pym属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPym(String value) {
        this.pym = value;
    }

    /**
     * 获取zdym属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdym() {
        return zdym;
    }

    /**
     * 设置zdym属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdym(String value) {
        this.zdym = value;
    }

    /**
     * 获取cjsj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCjsj() {
        return cjsj;
    }

    /**
     * 设置cjsj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCjsj(String value) {
        this.cjsj = value;
    }

    /**
     * 获取cjr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCjr() {
        return cjr;
    }

    /**
     * 设置cjr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCjr(String value) {
        this.cjr = value;
    }

    /**
     * 获取zhgxsj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZhgxsj() {
        return zhgxsj;
    }

    /**
     * 设置zhgxsj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZhgxsj(String value) {
        this.zhgxsj = value;
    }

    /**
     * 获取zhgxr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZhgxr() {
        return zhgxr;
    }

    /**
     * 设置zhgxr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZhgxr(String value) {
        this.zhgxr = value;
    }

    /**
     * 获取code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * 获取zfjb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZfjb() {
        return zfjb;
    }

    /**
     * 设置zfjb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZfjb(String value) {
        this.zfjb = value;
    }

    /**
     * 获取remark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置remark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * 获取jkzxBm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJkzxBm() {
        return jkzxBm;
    }

    /**
     * 设置jkzxBm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJkzxBm(String value) {
        this.jkzxBm = value;
    }

    /**
     * 获取crbFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrbFlag() {
        return crbFlag;
    }

    /**
     * 设置crbFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrbFlag(String value) {
        this.crbFlag = value;
    }

    /**
     * 获取icdTnbFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICDTnbFlag() {
        return icdTnbFlag;
    }

    /**
     * 设置icdTnbFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICDTnbFlag(String value) {
        this.icdTnbFlag = value;
    }

    /**
     * 获取afpFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfpFlag() {
        return afpFlag;
    }

    /**
     * 设置afpFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfpFlag(String value) {
        this.afpFlag = value;
    }

    /**
     * 获取glFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlFlag() {
        return glFlag;
    }

    /**
     * 设置glFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlFlag(String value) {
        this.glFlag = value;
    }

    /**
     * 获取csqxFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsqxFlag() {
        return csqxFlag;
    }

    /**
     * 设置csqxFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsqxFlag(String value) {
        this.csqxFlag = value;
    }

    /**
     * 获取crbFhtx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrbFhtx() {
        return crbFhtx;
    }

    /**
     * 设置crbFhtx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrbFhtx(String value) {
        this.crbFhtx = value;
    }

    /**
     * 获取lx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLx() {
        return lx;
    }

    /**
     * 设置lx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLx(String value) {
        this.lx = value;
    }

    /**
     * 获取jbdm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJbdm() {
        return jbdm;
    }

    /**
     * 设置jbdm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJbdm(String value) {
        this.jbdm = value;
    }

    /**
     * 获取jslxdm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJslxdm() {
        return jslxdm;
    }

    /**
     * 设置jslxdm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJslxdm(String value) {
        this.jslxdm = value;
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

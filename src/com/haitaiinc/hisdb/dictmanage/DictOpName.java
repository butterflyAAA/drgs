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
 * <p>DictOpName complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DictOpName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SsID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SsMc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SsdjID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zdym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DelFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cjsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cjr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zhgxsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zhgxr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Bacode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Optype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Opcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sfsy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DictOpName", propOrder = {
    "ssID",
    "ssMc",
    "ssdjID",
    "pym",
    "zdym",
    "delFlag",
    "cjsj",
    "cjr",
    "zhgxsj",
    "zhgxr",
    "bacode",
    "optype",
    "opcode",
    "sfsy",
    "additionalFields",
    "nlsFields"
})
public class DictOpName
    extends JAXBObject
{

    @XmlElement(name = "SsID")
    protected String ssID;
    @XmlElement(name = "SsMc")
    protected String ssMc;
    @XmlElement(name = "SsdjID")
    protected String ssdjID;
    @XmlElement(name = "Pym")
    protected String pym;
    @XmlElement(name = "Zdym")
    protected String zdym;
    @XmlElement(name = "DelFlag")
    protected String delFlag;
    @XmlElement(name = "Cjsj")
    protected String cjsj;
    @XmlElement(name = "Cjr")
    protected String cjr;
    @XmlElement(name = "Zhgxsj")
    protected String zhgxsj;
    @XmlElement(name = "Zhgxr")
    protected String zhgxr;
    @XmlElement(name = "Bacode")
    protected String bacode;
    @XmlElement(name = "Optype")
    protected String optype;
    @XmlElement(name = "Opcode")
    protected String opcode;
    @XmlElement(name = "Sfsy")
    protected String sfsy;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取ssID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsID() {
        return ssID;
    }

    /**
     * 设置ssID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsID(String value) {
        this.ssID = value;
    }

    /**
     * 获取ssMc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsMc() {
        return ssMc;
    }

    /**
     * 设置ssMc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsMc(String value) {
        this.ssMc = value;
    }

    /**
     * 获取ssdjID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsdjID() {
        return ssdjID;
    }

    /**
     * 设置ssdjID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsdjID(String value) {
        this.ssdjID = value;
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
     * 获取bacode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBacode() {
        return bacode;
    }

    /**
     * 设置bacode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBacode(String value) {
        this.bacode = value;
    }

    /**
     * 获取optype属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptype() {
        return optype;
    }

    /**
     * 设置optype属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptype(String value) {
        this.optype = value;
    }

    /**
     * 获取opcode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpcode() {
        return opcode;
    }

    /**
     * 设置opcode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpcode(String value) {
        this.opcode = value;
    }

    /**
     * 获取sfsy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSfsy() {
        return sfsy;
    }

    /**
     * 设置sfsy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSfsy(String value) {
        this.sfsy = value;
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

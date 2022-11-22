//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.04.25 时间 11:42:21 AM CST 
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
 * <p>PatInpatDiagnosis complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PatInpatDiagnosis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZyzdjlID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PatID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zylsh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="YsID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZdRq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZdICD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZdlxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrlxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TjmID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZljgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JbaFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RybqID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FbID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FyID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cjsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cjr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zhgxsj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zhgxr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BgkFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Drlx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DzblMc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DzblCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zdsh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sbbz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Zdnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "PatInpatDiagnosis", propOrder = {
    "zyzdjlID",
    "patID",
    "zylsh",
    "ysID",
    "zdRq",
    "zdICD",
    "zdlxID",
    "brlxID",
    "tjmID",
    "zljgID",
    "jbaFlag",
    "rybqID",
    "fbID",
    "fyID",
    "cjsj",
    "cjr",
    "zhgxsj",
    "zhgxr",
    "bgkFlag",
    "drlx",
    "dzblMc",
    "dzblCode",
    "zdsh",
    "sbbz",
    "zdnr",
    "additionalFields",
    "nlsFields"
})
public class PatInpatDiagnosis
    extends JAXBObject
{

    @XmlElement(name = "ZyzdjlID")
    protected String zyzdjlID;
    @XmlElement(name = "PatID")
    protected String patID;
    @XmlElement(name = "Zylsh")
    protected String zylsh;
    @XmlElement(name = "YsID")
    protected String ysID;
    @XmlElement(name = "ZdRq")
    protected String zdRq;
    @XmlElement(name = "ZdICD")
    protected String zdICD;
    @XmlElement(name = "ZdlxID")
    protected String zdlxID;
    @XmlElement(name = "BrlxID")
    protected String brlxID;
    @XmlElement(name = "TjmID")
    protected String tjmID;
    @XmlElement(name = "ZljgID")
    protected String zljgID;
    @XmlElement(name = "JbaFlag")
    protected String jbaFlag;
    @XmlElement(name = "RybqID")
    protected String rybqID;
    @XmlElement(name = "FbID")
    protected String fbID;
    @XmlElement(name = "FyID")
    protected String fyID;
    @XmlElement(name = "Cjsj")
    protected String cjsj;
    @XmlElement(name = "Cjr")
    protected String cjr;
    @XmlElement(name = "Zhgxsj")
    protected String zhgxsj;
    @XmlElement(name = "Zhgxr")
    protected String zhgxr;
    @XmlElement(name = "BgkFlag")
    protected String bgkFlag;
    @XmlElement(name = "Drlx")
    protected String drlx;
    @XmlElement(name = "DzblMc")
    protected String dzblMc;
    @XmlElement(name = "DzblCode")
    protected String dzblCode;
    @XmlElement(name = "Zdsh")
    protected String zdsh;
    @XmlElement(name = "Sbbz")
    protected String sbbz;
    @XmlElement(name = "Zdnr")
    protected String zdnr;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取zyzdjlID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZyzdjlID() {
        return zyzdjlID;
    }

    /**
     * 设置zyzdjlID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZyzdjlID(String value) {
        this.zyzdjlID = value;
    }

    /**
     * 获取patID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatID() {
        return patID;
    }

    /**
     * 设置patID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatID(String value) {
        this.patID = value;
    }

    /**
     * 获取zylsh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZylsh() {
        return zylsh;
    }

    /**
     * 设置zylsh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZylsh(String value) {
        this.zylsh = value;
    }

    /**
     * 获取ysID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYsID() {
        return ysID;
    }

    /**
     * 设置ysID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYsID(String value) {
        this.ysID = value;
    }

    /**
     * 获取zdRq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdRq() {
        return zdRq;
    }

    /**
     * 设置zdRq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdRq(String value) {
        this.zdRq = value;
    }

    /**
     * 获取zdICD属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdICD() {
        return zdICD;
    }

    /**
     * 设置zdICD属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdICD(String value) {
        this.zdICD = value;
    }

    /**
     * 获取zdlxID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdlxID() {
        return zdlxID;
    }

    /**
     * 设置zdlxID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdlxID(String value) {
        this.zdlxID = value;
    }

    /**
     * 获取brlxID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrlxID() {
        return brlxID;
    }

    /**
     * 设置brlxID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrlxID(String value) {
        this.brlxID = value;
    }

    /**
     * 获取tjmID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTjmID() {
        return tjmID;
    }

    /**
     * 设置tjmID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTjmID(String value) {
        this.tjmID = value;
    }

    /**
     * 获取zljgID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZljgID() {
        return zljgID;
    }

    /**
     * 设置zljgID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZljgID(String value) {
        this.zljgID = value;
    }

    /**
     * 获取jbaFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJbaFlag() {
        return jbaFlag;
    }

    /**
     * 设置jbaFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJbaFlag(String value) {
        this.jbaFlag = value;
    }

    /**
     * 获取rybqID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRybqID() {
        return rybqID;
    }

    /**
     * 设置rybqID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRybqID(String value) {
        this.rybqID = value;
    }

    /**
     * 获取fbID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFbID() {
        return fbID;
    }

    /**
     * 设置fbID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFbID(String value) {
        this.fbID = value;
    }

    /**
     * 获取fyID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFyID() {
        return fyID;
    }

    /**
     * 设置fyID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFyID(String value) {
        this.fyID = value;
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
     * 获取bgkFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBgkFlag() {
        return bgkFlag;
    }

    /**
     * 设置bgkFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBgkFlag(String value) {
        this.bgkFlag = value;
    }

    /**
     * 获取drlx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrlx() {
        return drlx;
    }

    /**
     * 设置drlx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrlx(String value) {
        this.drlx = value;
    }

    /**
     * 获取dzblMc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDzblMc() {
        return dzblMc;
    }

    /**
     * 设置dzblMc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDzblMc(String value) {
        this.dzblMc = value;
    }

    /**
     * 获取dzblCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDzblCode() {
        return dzblCode;
    }

    /**
     * 设置dzblCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDzblCode(String value) {
        this.dzblCode = value;
    }

    /**
     * 获取zdsh属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdsh() {
        return zdsh;
    }

    /**
     * 设置zdsh属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdsh(String value) {
        this.zdsh = value;
    }

    /**
     * 获取sbbz属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSbbz() {
        return sbbz;
    }

    /**
     * 设置sbbz属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSbbz(String value) {
        this.sbbz = value;
    }

    /**
     * 获取zdnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdnr() {
        return zdnr;
    }

    /**
     * 设置zdnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdnr(String value) {
        this.zdnr = value;
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

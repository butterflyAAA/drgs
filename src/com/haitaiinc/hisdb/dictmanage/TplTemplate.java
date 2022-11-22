//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.04.23 时间 09:00:49 AM CST 
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
 * <p>TplTemplate complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TplTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TplID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TplVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TplName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TplNamePy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TplDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TplData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TplStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TreeNode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NodeIndex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Creator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Modifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ModifyTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OwnerOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InoutFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TplType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TplUseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "TplTemplate", propOrder = {
    "tplID",
    "tplVersion",
    "tplName",
    "tplNamePy",
    "tplDesc",
    "tplData",
    "tplStatus",
    "treeNode",
    "nodeIndex",
    "creator",
    "createTime",
    "modifier",
    "modifyTime",
    "ownerOrg",
    "inoutFlag",
    "tplType",
    "tplUseType",
    "additionalFields",
    "nlsFields"
})
public class TplTemplate
    extends JAXBObject
{

    @XmlElement(name = "TplID")
    protected String tplID;
    @XmlElement(name = "TplVersion")
    protected String tplVersion;
    @XmlElement(name = "TplName")
    protected String tplName;
    @XmlElement(name = "TplNamePy")
    protected String tplNamePy;
    @XmlElement(name = "TplDesc")
    protected String tplDesc;
    @XmlElement(name = "TplData")
    protected String tplData;
    @XmlElement(name = "TplStatus")
    protected String tplStatus;
    @XmlElement(name = "TreeNode")
    protected String treeNode;
    @XmlElement(name = "NodeIndex")
    protected String nodeIndex;
    @XmlElement(name = "Creator")
    protected String creator;
    @XmlElement(name = "CreateTime")
    protected String createTime;
    @XmlElement(name = "Modifier")
    protected String modifier;
    @XmlElement(name = "ModifyTime")
    protected String modifyTime;
    @XmlElement(name = "OwnerOrg")
    protected String ownerOrg;
    @XmlElement(name = "InoutFlag")
    protected String inoutFlag;
    @XmlElement(name = "TplType")
    protected String tplType;
    @XmlElement(name = "TplUseType")
    protected String tplUseType;
    @XmlElement(name = "AdditionalFields")
    protected List<String> additionalFields;
    @XmlElement(name = "NLSFields")
    protected List<String> nlsFields;

    /**
     * 获取tplID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplID() {
        return tplID;
    }

    /**
     * 设置tplID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplID(String value) {
        this.tplID = value;
    }

    /**
     * 获取tplVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplVersion() {
        return tplVersion;
    }

    /**
     * 设置tplVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplVersion(String value) {
        this.tplVersion = value;
    }

    /**
     * 获取tplName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplName() {
        return tplName;
    }

    /**
     * 设置tplName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplName(String value) {
        this.tplName = value;
    }

    /**
     * 获取tplNamePy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplNamePy() {
        return tplNamePy;
    }

    /**
     * 设置tplNamePy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplNamePy(String value) {
        this.tplNamePy = value;
    }

    /**
     * 获取tplDesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplDesc() {
        return tplDesc;
    }

    /**
     * 设置tplDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplDesc(String value) {
        this.tplDesc = value;
    }

    /**
     * 获取tplData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplData() {
        return tplData;
    }

    /**
     * 设置tplData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplData(String value) {
        this.tplData = value;
    }

    /**
     * 获取tplStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplStatus() {
        return tplStatus;
    }

    /**
     * 设置tplStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplStatus(String value) {
        this.tplStatus = value;
    }

    /**
     * 获取treeNode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTreeNode() {
        return treeNode;
    }

    /**
     * 设置treeNode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTreeNode(String value) {
        this.treeNode = value;
    }

    /**
     * 获取nodeIndex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeIndex() {
        return nodeIndex;
    }

    /**
     * 设置nodeIndex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeIndex(String value) {
        this.nodeIndex = value;
    }

    /**
     * 获取creator属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置creator属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

    /**
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTime(String value) {
        this.createTime = value;
    }

    /**
     * 获取modifier属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置modifier属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifier(String value) {
        this.modifier = value;
    }

    /**
     * 获取modifyTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置modifyTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifyTime(String value) {
        this.modifyTime = value;
    }

    /**
     * 获取ownerOrg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerOrg() {
        return ownerOrg;
    }

    /**
     * 设置ownerOrg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerOrg(String value) {
        this.ownerOrg = value;
    }

    /**
     * 获取inoutFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInoutFlag() {
        return inoutFlag;
    }

    /**
     * 设置inoutFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInoutFlag(String value) {
        this.inoutFlag = value;
    }

    /**
     * 获取tplType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplType() {
        return tplType;
    }

    /**
     * 设置tplType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplType(String value) {
        this.tplType = value;
    }

    /**
     * 获取tplUseType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTplUseType() {
        return tplUseType;
    }

    /**
     * 设置tplUseType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTplUseType(String value) {
        this.tplUseType = value;
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

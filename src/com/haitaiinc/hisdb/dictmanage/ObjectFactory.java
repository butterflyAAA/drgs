//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.04.25 时间 01:03:06 PM CST 
//


package com.haitaiinc.hisdb.dictmanage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.haitaiinc.hisdb.dictmanage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DictICD_QNAME = new QName("", "DictICD");
    private final static QName _TplTemplate_QNAME = new QName("", "TplTemplate");
    private final static QName _DictOpName_QNAME = new QName("", "DictOpName");
    private final static QName _DictDepart_QNAME = new QName("", "DictDepart");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.haitaiinc.hisdb.dictmanage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DictICD }
     * 
     */
    public DictICD createDictICD() {
        return new DictICD();
    }

    /**
     * Create an instance of {@link TplTemplate }
     * 
     */
    public TplTemplate createTplTemplate() {
        return new TplTemplate();
    }

    /**
     * Create an instance of {@link DictOpName }
     * 
     */
    public DictOpName createDictOpName() {
        return new DictOpName();
    }

    /**
     * Create an instance of {@link DictDepart }
     * 
     */
    public DictDepart createDictDepart() {
        return new DictDepart();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictICD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DictICD")
    public JAXBElement<DictICD> createDictICD(DictICD value) {
        return new JAXBElement<DictICD>(_DictICD_QNAME, DictICD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TplTemplate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TplTemplate")
    public JAXBElement<TplTemplate> createTplTemplate(TplTemplate value) {
        return new JAXBElement<TplTemplate>(_TplTemplate_QNAME, TplTemplate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictOpName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DictOpName")
    public JAXBElement<DictOpName> createDictOpName(DictOpName value) {
        return new JAXBElement<DictOpName>(_DictOpName_QNAME, DictOpName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictDepart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DictDepart")
    public JAXBElement<DictDepart> createDictDepart(DictDepart value) {
        return new JAXBElement<DictDepart>(_DictDepart_QNAME, DictDepart.class, null, value);
    }

}

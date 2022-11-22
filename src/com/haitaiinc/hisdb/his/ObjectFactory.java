//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.04.25 时间 11:42:21 AM CST 
//


package com.haitaiinc.hisdb.his;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.haitaiinc.hisdb.his package. 
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

    private final static QName _PatInpatDiagnosis_QNAME = new QName("", "PatInpatDiagnosis");
    private final static QName _VPatientinfo_QNAME = new QName("", "VPatientinfo");
    private final static QName _VInpatientinfo_QNAME = new QName("", "VInpatientinfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.haitaiinc.hisdb.his
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PatInpatDiagnosis }
     * 
     */
    public PatInpatDiagnosis createPatInpatDiagnosis() {
        return new PatInpatDiagnosis();
    }

    /**
     * Create an instance of {@link VPatientinfo }
     * 
     */
    public VPatientinfo createVPatientinfo() {
        return new VPatientinfo();
    }

    /**
     * Create an instance of {@link VInpatientinfo }
     * 
     */
    public VInpatientinfo createVInpatientinfo() {
        return new VInpatientinfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatInpatDiagnosis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PatInpatDiagnosis")
    public JAXBElement<PatInpatDiagnosis> createPatInpatDiagnosis(PatInpatDiagnosis value) {
        return new JAXBElement<PatInpatDiagnosis>(_PatInpatDiagnosis_QNAME, PatInpatDiagnosis.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VPatientinfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VPatientinfo")
    public JAXBElement<VPatientinfo> createVPatientinfo(VPatientinfo value) {
        return new JAXBElement<VPatientinfo>(_VPatientinfo_QNAME, VPatientinfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VInpatientinfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VInpatientinfo")
    public JAXBElement<VInpatientinfo> createVInpatientinfo(VInpatientinfo value) {
        return new JAXBElement<VInpatientinfo>(_VInpatientinfo_QNAME, VInpatientinfo.class, null, value);
    }

}

//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.5-5 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.04.24 时间 02:54:53 PM CST 
//


package com.haitaiinc.hisdb.drgs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.haitaiinc.hisdb.drgs package. 
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

    private final static QName _FrontSheet_QNAME = new QName("", "FrontSheet");
    private final static QName _BsBaseinfo_QNAME = new QName("", "BsBaseinfo");
    private final static QName _BsOprninfo_QNAME = new QName("", "BsOprninfo");
    private final static QName _BsDiseinfo_QNAME = new QName("", "BsDiseinfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.haitaiinc.hisdb.drgs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FrontSheet }
     * 
     */
    public FrontSheet createFrontSheet() {
        return new FrontSheet();
    }

    /**
     * Create an instance of {@link BsBaseinfo }
     * 
     */
    public BsBaseinfo createBsBaseinfo() {
        return new BsBaseinfo();
    }

    /**
     * Create an instance of {@link BsOprninfo }
     * 
     */
    public BsOprninfo createBsOprninfo() {
        return new BsOprninfo();
    }

    /**
     * Create an instance of {@link BsDiseinfo }
     * 
     */
    public BsDiseinfo createBsDiseinfo() {
        return new BsDiseinfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FrontSheet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FrontSheet")
    public JAXBElement<FrontSheet> createFrontSheet(FrontSheet value) {
        return new JAXBElement<FrontSheet>(_FrontSheet_QNAME, FrontSheet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BsBaseinfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BsBaseinfo")
    public JAXBElement<BsBaseinfo> createBsBaseinfo(BsBaseinfo value) {
        return new JAXBElement<BsBaseinfo>(_BsBaseinfo_QNAME, BsBaseinfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BsOprninfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BsOprninfo")
    public JAXBElement<BsOprninfo> createBsOprninfo(BsOprninfo value) {
        return new JAXBElement<BsOprninfo>(_BsOprninfo_QNAME, BsOprninfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BsDiseinfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BsDiseinfo")
    public JAXBElement<BsDiseinfo> createBsDiseinfo(BsDiseinfo value) {
        return new JAXBElement<BsDiseinfo>(_BsDiseinfo_QNAME, BsDiseinfo.class, null, value);
    }

}

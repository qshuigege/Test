
package com.actionsoft.apps.fs_b2b.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.actionsoft.apps.fs_b2b.ws package. 
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

    private final static QName _GetB2BDataResponse_QNAME = new QName("http://ws.fs_b2b.apps.actionsoft.com/", "getB2bDataResponse");
    private final static QName _GetB2BData_QNAME = new QName("http://ws.fs_b2b.apps.actionsoft.com/", "getB2bData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.actionsoft.apps.fs_b2b.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetB2BDataResponse }
     * 
     */
    public GetB2BDataResponse createGetB2BDataResponse() {
        return new GetB2BDataResponse();
    }

    /**
     * Create an instance of {@link GetB2BData }
     * 
     */
    public GetB2BData createGetB2BData() {
        return new GetB2BData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetB2BDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fs_b2b.apps.actionsoft.com/", name = "getB2bDataResponse")
    public JAXBElement<GetB2BDataResponse> createGetB2BDataResponse(GetB2BDataResponse value) {
        return new JAXBElement<GetB2BDataResponse>(_GetB2BDataResponse_QNAME, GetB2BDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetB2BData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.fs_b2b.apps.actionsoft.com/", name = "getB2bData")
    public JAXBElement<GetB2BData> createGetB2BData(GetB2BData value) {
        return new JAXBElement<GetB2BData>(_GetB2BData_QNAME, GetB2BData.class, null, value);
    }

}

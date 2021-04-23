
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _GetImageDetails_QNAME = new QName("http://service/", "GetImageDetails");
    private final static QName _GetImageDetailsResponse_QNAME = new QName("http://service/", "GetImageDetailsResponse");
    private final static QName _Upload_QNAME = new QName("http://service/", "upload");
    private final static QName _UploadResponse_QNAME = new QName("http://service/", "uploadResponse");
    private final static QName _UploadArg1_QNAME = new QName("", "arg1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetImageDetails }
     * 
     */
    public GetImageDetails createGetImageDetails() {
        return new GetImageDetails();
    }

    /**
     * Create an instance of {@link GetImageDetailsResponse }
     * 
     */
    public GetImageDetailsResponse createGetImageDetailsResponse() {
        return new GetImageDetailsResponse();
    }

    /**
     * Create an instance of {@link Upload }
     * 
     */
    public Upload createUpload() {
        return new Upload();
    }

    /**
     * Create an instance of {@link UploadResponse }
     * 
     */
    public UploadResponse createUploadResponse() {
        return new UploadResponse();
    }

    /**
     * Create an instance of {@link Imaged }
     * 
     */
    public Imaged createImaged() {
        return new Imaged();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImageDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetImageDetails }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "GetImageDetails")
    public JAXBElement<GetImageDetails> createGetImageDetails(GetImageDetails value) {
        return new JAXBElement<GetImageDetails>(_GetImageDetails_QNAME, GetImageDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetImageDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetImageDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "GetImageDetailsResponse")
    public JAXBElement<GetImageDetailsResponse> createGetImageDetailsResponse(GetImageDetailsResponse value) {
        return new JAXBElement<GetImageDetailsResponse>(_GetImageDetailsResponse_QNAME, GetImageDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Upload }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "upload")
    public JAXBElement<Upload> createUpload(Upload value) {
        return new JAXBElement<Upload>(_Upload_QNAME, Upload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UploadResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service/", name = "uploadResponse")
    public JAXBElement<UploadResponse> createUploadResponse(UploadResponse value) {
        return new JAXBElement<UploadResponse>(_UploadResponse_QNAME, UploadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "", name = "arg1", scope = Upload.class)
    public JAXBElement<byte[]> createUploadArg1(byte[] value) {
        return new JAXBElement<byte[]>(_UploadArg1_QNAME, byte[].class, Upload.class, ((byte[]) value));
    }

}

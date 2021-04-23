
package service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ImageServiceService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:8080/FileUploadWebService/ImageServiceService?WSDL")
public class ImageServiceService
    extends Service
{

    private final static URL IMAGESERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException IMAGESERVICESERVICE_EXCEPTION;
    private final static QName IMAGESERVICESERVICE_QNAME = new QName("http://service/", "ImageServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/FileUploadWebService/ImageServiceService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IMAGESERVICESERVICE_WSDL_LOCATION = url;
        IMAGESERVICESERVICE_EXCEPTION = e;
    }

    public ImageServiceService() {
        super(__getWsdlLocation(), IMAGESERVICESERVICE_QNAME);
    }

    public ImageServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IMAGESERVICESERVICE_QNAME, features);
    }

    public ImageServiceService(URL wsdlLocation) {
        super(wsdlLocation, IMAGESERVICESERVICE_QNAME);
    }

    public ImageServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IMAGESERVICESERVICE_QNAME, features);
    }

    public ImageServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ImageServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ImageService
     */
    @WebEndpoint(name = "ImageServicePort")
    public ImageService getImageServicePort() {
        return super.getPort(new QName("http://service/", "ImageServicePort"), ImageService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ImageService
     */
    @WebEndpoint(name = "ImageServicePort")
    public ImageService getImageServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service/", "ImageServicePort"), ImageService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IMAGESERVICESERVICE_EXCEPTION!= null) {
            throw IMAGESERVICESERVICE_EXCEPTION;
        }
        return IMAGESERVICESERVICE_WSDL_LOCATION;
    }

}
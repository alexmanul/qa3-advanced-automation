import Utils.SOAPHelper;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

@Log4j
public class SOAPTest {
    final SOAPHelper soapHelper = new SOAPHelper();

    String urlSoap = "http://www.dneonline.com/calculator.asmx";

    @Test
    public void TEST_SOAP_01() {
        String soapMessage = soapHelper.createSoapMessage(165, 2);
        soapHelper.makeSoapRequest(soapMessage, urlSoap);
    }

}

/*
 * Created on 2004-11-29
 */
import java.io.IOException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Patryk Czarnik
 */
public class LiczbySAX {
  public static void main(String[] args) {
    if(args.length < 1) {
      System.out.println("Za malo parametrow");
      return;
    }

    try {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      factory.setValidating(true);
      SAXParser parser = factory.newSAXParser();
      
      LiczbyHandler handler = new LiczbyHandler();
      parser.parse(args[0], handler);

      System.out.println("Result: "+handler.getResult());
    } catch (FactoryConfigurationError e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SAXException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  private static class LiczbyHandler extends DefaultHandler {
	enum Stan {ZEWN, GRUPA, LICZBA};

    private int fWynik = 0;
    private Stan fStan = Stan.ZEWN;
    private StringBuffer fBuf;
    
    public int getResult() {
      return fWynik;
    }
   
    public void startElement(String uri, String localName, String qName,
        Attributes attributes) throws SAXException {
      if("grupa".equals(qName)) {
        String attrVal = attributes.getValue("wazne");
        if("tak".equals(attrVal))
          fStan = Stan.GRUPA;
      } else if("l".equals(qName)) {
        if(fStan == Stan.GRUPA) {
          fStan = Stan.LICZBA;
          fBuf = new StringBuffer();
        }
      }
    }

    public void endElement(String uri, String localName, String qName)
    throws SAXException {
      if("grupa".equals(qName)) {
        if(fStan == Stan.GRUPA) {
          fStan = Stan.ZEWN;
        }
      } else if("l".equals(qName)) {
        if(fStan == Stan.LICZBA) {
          fStan = Stan.GRUPA;
          try {
            fWynik += Integer.parseInt(fBuf.toString());
          } catch (NumberFormatException e) {
          }
        }
      }
    }
    public void characters(char[] ch, int start, int length)
        throws SAXException {
      if(fStan == Stan.LICZBA)
        fBuf.append(ch, start, length);
    }
  }
}

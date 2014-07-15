package atrujillomauro.samsung.comercialsuit;

import android.content.Context;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class UtilsCP {
    private static Document cpDocument;

    public static void loadDOM(Context context) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            cpDocument = builder.parse(context.getResources().openRawResource(R.raw.bbdd));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getCP(String calle, String municipio) {

        return calle;
    }

    public static Document getCpDocument() {
        return cpDocument;
    }
}

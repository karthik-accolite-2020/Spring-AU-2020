import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLParsing {
	public static void main(String[] args) {
		SAXParserFactory factory=SAXParserFactory.newInstance();
		try {
			SAXParser parser=factory.newSAXParser();
			HandleXMLData handler=new HandleXMLData();
			parser.parse(new File("books.xml"), handler);
			ArrayList<Book> data=handler.getList();
			data.forEach((b)->System.out.println(b.toString()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

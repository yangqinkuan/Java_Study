package xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseDemo01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//1、获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2从解析工厂里面拿到解析器
		SAXParser parse = factory.newSAXParser();
		//3、加载文档 Document 注册处理器
		//4、编写处理器
		PersonHandler handler = new PersonHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xml/person.xml"),handler);
		List<Person> persons = handler.getPersons();
		for(Person p:persons){
			System.out.println(p.getName()+"-------"+p.getAge());
		}
	}
}

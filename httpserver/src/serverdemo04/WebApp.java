package serverdemo04;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WebApp {
	private static ServletContext contxt;
	static{
		//��ȡ��������
				try {
					SAXParserFactory factory = SAXParserFactory.newInstance();
					//��ȡ������
					SAXParser sax = factory.newSAXParser();
					//ָ��XML+������
					WebHandler web = new WebHandler();
					sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("serverdemo04/web.xml"), web);
					//��Listת��Map
					
					
					
					contxt = new ServletContext();
					Map<String,String> servlet = contxt.getServlet();
					
					//servlet-name servlet-class
					for(Entity entity:web.getEntityList()){
						servlet.put(entity.getName(), entity.getClz());
					}
					//url-pattern servlet-name	
					
					

					Map<String,String> mapping = contxt.getMapping();
					for(Mapping map:web.getMappingList()){
						List<String> urls = map.getUrlPattern();
						for(String url:urls){
							mapping.put(url, map.getName());
						}
					}
					
				} catch (ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				}
		
		
		
		
		
		
		
		
		
				
		
	}
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if((null==url)||(url=url.trim()).equals("")){
			return null;
		}
		//�����ַ���(����·��)��������
	
		//return contxt.getServlet().get(contxt.getMapping().get(url));
		String name = contxt.getServlet().get(contxt.getMapping().get(url));
		return (Servlet)Class.forName(name).newInstance();
	}

	
	
}

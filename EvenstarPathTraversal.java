package kr.co.evenstar.cwe.cwe022;

import java.io.File;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
public class EvenstarPathTraversal extends HttpServlet{
 
	@RequestMapping(value = "evenstarPathTraversal.do", method = RequestMethod.GET)
	public String evenstarExample(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
//////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		//BAD
		String name = ((Properties) request).getProperty("filename");
		if( name != null )
		{
		   File file = new File("/usr/local/tmp/" + name);
		   file.delete();
		}

		
		
		//GOOD

		
		
//////////////////////////////////////////////////////////////////////////////////////////////////

		model.addAttribute("cweId", "cwe22" );
		model.addAttribute("cweDes", "EvenstarPathTraversal" );
		
		return "cwe100";
	}
}

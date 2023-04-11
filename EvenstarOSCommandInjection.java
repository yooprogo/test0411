package kr.co.evenstar.cwe.cwe078;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 
@Controller
public class EvenstarOSCommandInjection extends HttpServlet  {
 
	@RequestMapping(value = "evenstarOSCommandInjection.do", method = RequestMethod.GET)
	public String evenstarExample(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
		
//////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		//BAD
		String opt = request.getParameter("opt");
		
		String cmd = getServletContext().getRealPath("/") + "WEB-INF/dump.sh -opt=" + opt;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			if(process != null) {
				process.destroy();
			}
		}


		
		
		/*
		//GOOD

		*/
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////

		model.addAttribute("cweId", "cwe78" );
		model.addAttribute("cweDes", "EvenstarOSCommandInjection" );
		
		return "cwe100";
	}
}

package il.co.electriccollege.servlets.uploads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@MultipartConfig()
@WebServlet("/file-upload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		String testParam = request.getParameter("test");
		String username = request.getParameter("username");
		
		Part part = request.getPart("user_file");
		
		String filename = null;
		String pathPrefix = "/Users/yaakov/Development/teaching/uploads/";
		
		// get uploaded file name
		String dispositionHeader = part.getHeader("Content-Disposition");
		for(String s: dispositionHeader.split(";")) {
			if(s.contains("filename")) {
				filename = s.split("=")[1].trim().replace("\"", "");
				break;
			}
		}
//		String fileName = getSubmittedFileName(filePart); // available from tomcat 8 and up

		String uploadedFileLocation = pathPrefix + username + "_" + filename;
		
		// copy file to server's filesystem
		part.write(uploadedFileLocation);
//		InputStream inputStream = part.getInputStream(); // alternative to part.write()		
		
		String responseMessage = "file uploaded to %s";
		response.getWriter().append(String.format(responseMessage, uploadedFileLocation));
	}

}

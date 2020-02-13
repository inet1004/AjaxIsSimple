package com.yedam.lch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServletXML
 */
@WebServlet("/EmpServletXML")
public class EmpServletXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServletXML() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EmpDTO> list = new ArrayList<>();
		EmpService service = new EmpServiceImpl();
		list = service.selectEmpAll();
//		<employees>
//		  <employee>
//		    <firstName>John</firstName> 
//		    <lastName>Doe</lastName>
//		  </employee>
//		</employees>
		
		String emps = "<employees>";
		for (EmpDTO emp : list) {
			emps += "<employee>"
			+ "<empId>" + emp.getEmployeeId() + "</empId>"
			+ "<firstName>" + emp.getFirstName() + "</firstName>"
			+ "<lastName>" + emp.getLastName() + "</lastName>"
			+ "</employee>";
		}
		emps += "</employees>";
		response.getWriter().append(emps);
	}

}

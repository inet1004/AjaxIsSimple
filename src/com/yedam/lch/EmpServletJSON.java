package com.yedam.lch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/EmpServletJSON")
public class EmpServletJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpServletJSON() {
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
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<EmpDTO> list = new ArrayList<>();
		EmpService service = new EmpServiceImpl();
		list = service.selectEmpAll();

		JSONArray ary = new JSONArray();
		for (EmpDTO emp : list) {
			JSONObject obj = new JSONObject();
			obj.put("firstName", emp.getFirstName());
			obj.put("lastName", emp.getLastName());
			obj.put("salary", emp.getSalary());
			obj.put("email", emp.getEmail());
			obj.put("employeeId", emp.getEmployeeId());
			ary.add(obj);
		}
		out.print(ary.toString());

//		{"employees":[
//          { "firstName":"John", "lastName":"Doe" },
//          { "firstName":"Anna", "lastName":"Smith" },
//          { "firstName":"Peter", "lastName":"Jones" }
//      ]}

//		String emps = "{\"employees\":[";
//		int cnt = list.size();
//		int iCnt = 0;
//		for (EmpDTO emp : list) {
//			emps += "{\"empId\":\"" + emp.getEmployeeId() //
//					+ "\",\"firstName\":\"" + emp.getFirstName() //
//					+ "\",\"lastName\":\"" + emp.getLastName() //
//					+ "\",\"email\":\"" + emp.getEmail() //
//					+ "\",\"salary\":\"" + emp.getSalary() //
//					+ "\"}";
//			if (++iCnt != cnt) {
//				emps += ",";
//			}
//		}
//		emps += "]}";

//		PrintWriter out= response.getWriter();
//		out.print(JSONArray.fromObject(list.toString()));
	}
}

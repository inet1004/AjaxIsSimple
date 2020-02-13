package com.yedam.lch;

import java.util.List;

public class EmpApp {
	public static void main(String[] args) {
		EmpService service = new EmpServiceImpl();
		List<EmpDTO> list = service.selectEmpAll();
		for (EmpDTO emp : list) {
			System.out.println(emp);
		}
	}
}

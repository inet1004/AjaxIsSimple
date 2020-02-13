package com.yedam.lch;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl extends EmpService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<EmpDTO> selectEmpAll() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		try {
			String sql = "select * from employees order by 1";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setEmployeeId(rs.getInt("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoneNumber(rs.getString("phone_number"));
				dto.setHireDate(rs.getString("hire_date"));
				dto.setSalary(rs.getInt("salary"));
				dto.setJobId(rs.getString("job_id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}

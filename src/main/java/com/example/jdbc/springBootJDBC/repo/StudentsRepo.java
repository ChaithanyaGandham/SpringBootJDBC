package com.example.jdbc.springBootJDBC.repo;

import com.example.jdbc.springBootJDBC.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class StudentsRepo {

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Students s) {
		String sql = "insert into Students (id, name) values (?, ?)";
		int count = template.update(sql, s.getId(), s.getName());
		System.out.println(count + " row/s affected");
	}

	public List<Students> fetchStudents() {

		String sql = "select * from Students";
		RowMapper<Students> mapper = new RowMapper<Students>() {
			@Override
			public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
				Students s = new Students();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				return s;
			}
		};
		List<Students> studentsList = template.query(sql, mapper);
		return studentsList;
	}
}

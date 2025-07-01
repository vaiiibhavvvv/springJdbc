package com.example.springJdbc.repository;

import com.example.springJdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student) {
        System.out.println("added repo");
        String sql = "insert into student(rollno,name,marks) values(?,?,?)";
       int rows =  jdbc.update(sql, student.getRollNo(),student.getName(),student.getMarks());
        System.out.println(rows + "Added");
    }

    public List<Student> findAll() {
//        List<Student> students = new ArrayList<>();
//        return students;
        String sql = "select * from student";
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
               Student s = new Student();
               s.setMarks(rs.getInt("rollno"));
               s.setName(rs.getString("name"));
               s.setRollNo(rs.getInt("marks"));
                return s;
            }
        };
        List<Student> stu =  jdbc.query(sql,mapper);
        return stu;
    }
}

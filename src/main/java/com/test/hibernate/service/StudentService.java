package com.test.hibernate.service;

import com.test.hibernate.model.Student;
import java.util.List;

public interface StudentService {

  List<Student> getAll();
  Student getById(long id);
  long createStudent();
  long updateStudent(long id);
  long deleteStudentBuId();

}

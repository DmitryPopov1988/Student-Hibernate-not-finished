package rest.repository;

import rest.model.Student;
import java.util.List;

public interface StudentDao {

  List<Student> getAll();
  Student getById(long id);
  long createStudent(Student student);
  long updateStudent(Student student);
  long deleteStudentById(long id);

}

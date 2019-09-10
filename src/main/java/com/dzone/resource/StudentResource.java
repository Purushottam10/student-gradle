package com.dzone.resource;

import com.codahale.metrics.annotation.Timed;
import com.dzone.api.Student;
import com.dzone.service.StudentService;
import com.google.inject.Inject;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Timed
public class StudentResource {

   /* public StudentResource() {
    }*/
   //Student student;

   @Inject
    StudentService studentService;

  /*  @Inject
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }
*/
  /*  @Path("/getName")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getName(){
        return "Puru";
    }

    @Path("/getStudent")
    @GET
    public List<Student> getAllStudent(){
        Student student = new Student();
        student.setDob(121232313333L);
        student.setEmail("puuru@gmail.com");
        student.setFirstName("puru");
        student.setMarks("456");
        List<Student> list = new ArrayList<>();
        list.add(student);
        return list;
    }*/
    @Path("/save")
    @POST
    public Student save(Student student){

        return studentService.save(student);
    }

    @Path("/getAll")
    @GET
    public List<Student> getAll(){
        return studentService.getAllStudent();
    }

    @POST
    @Path("/updateStudent")
    public Student updateStudent(@QueryParam("id") String studentId, @Valid Student student){
        Student studentdb = studentService.getStudentById(studentId);
       return studentService.updateStudent(student);
    }

    @POST
    @Path("/delete")
    public Boolean delete(@QueryParam("id") String id){
      //  Student student = studentService.getStudentById(id);
        studentService.delete(id);
       return true;
        }
}
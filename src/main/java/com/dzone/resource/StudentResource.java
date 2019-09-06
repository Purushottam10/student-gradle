package com.dzone.resource;
import com.dzone.api.Student;
import com.codahale.metrics.annotation.Timed;
import com.dzone.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Timed
public class StudentResource {


    @Inject
    public StudentResource() {
    }

    @Inject
    StudentService studentService;

   /* @Inject
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }*/

    @Path("/getName")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getName(){
        return "Puru";
    }
   /* @Path("/getAll")
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
    }
*/
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

}
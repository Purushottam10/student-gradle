package resource;
import api.Student;
import com.codahale.metrics.annotation.Timed;
import service.StudentService;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Timed
public class StudentResource {
    @Inject
    StudentService studentService;

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    @Inject
    public StudentResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.studentService = studentService;
        this.counter = new AtomicLong();
    }
    @Path("/getName")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getName(){
        return "Puru";
    }
    @Path("/getAll")
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

    @Path("/save")
    @POST
    public Student save(Student student){
       return studentService.save(student);
    }
}
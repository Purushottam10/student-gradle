import org.glassfish.hk2.utilities.binding.AbstractBinder;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.annotation.PostConstruct;


public class ApplicationBinder extends AbstractBinder {
    @PostConstruct
    @Override
    protected void configure() {
        bind(StudentService.class).to(StudentServiceImpl.class);
        bind(StudentRepository.class).to(StudentRepositoryImpl.class);
    }
}

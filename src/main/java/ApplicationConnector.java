import com.google.inject.AbstractModule;

import com.dzone.repository.StudentRepository;
import com.dzone.repository.impl.StudentRepositoryImpl;
import com.dzone.service.StudentService;
import com.dzone.service.impl.StudentServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.annotation.PostConstruct;


public class ApplicationConnector extends /*AbstractModule*/ AbstractBinder {
    @PostConstruct
    @Override
    protected void configure() {
        bind(StudentService.class).to(StudentServiceImpl.class);
        bind(StudentRepository.class).to(StudentRepositoryImpl.class);
    }
}
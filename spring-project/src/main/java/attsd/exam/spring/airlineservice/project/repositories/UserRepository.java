package attsd.exam.spring.airlineservice.project.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import attsd.exam.spring.airlineservice.project.model.User;


public interface UserRepository extends MongoRepository<User, String> {
    
    User findByEmail(String email);
    
}
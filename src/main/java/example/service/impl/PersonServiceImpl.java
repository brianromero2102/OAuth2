package example.service.impl;

import example.model.dto.RequestUser;
import example.model.dto.ResponseUser;
import example.model.entity.api.User;
import example.model.entity.db.UserEntity;
import example.model.repository.UserRepository;
import example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.jar.JarException;

import static example.util.Utility.*;

@Service
public class PersonServiceImpl implements PersonService {

    public UserRepository userRepository;

    @Override
    public Mono<ResponseUser> flowAuthenticate(RequestUser requestUser) {
        return getUserByUsername(requestUser.getUsername())
                .map( user -> new ResponseUser());
    }

    private Mono<UserEntity> getUser(String username) {
        return Mono.fromFuture( CompletableFuture.supplyAsync(() -> {
            //return userRepository.getUserByUsername(personId);
            return new UserEntity();
        }));
    }

    private Mono<UserEntity> getUserByUsername(String username) {
        return Mono.fromFuture( CompletableFuture.supplyAsync(() -> {
                    //return userRepository.getUsersByUsername(username);
                    List<UserEntity> listUsers = new ArrayList<>();
                    listUsers.add(objUserEntity());
                    listUsers.add(objUserEntity());
                    listUsers.add(objUserEntity());
                    return listUsers;
                }))
                .handle( validateListUser( listUsers -> listUsers.size() > 1,
                                  listUsers -> new Exception(),
                                  UserEntity.class))
                .map( listUser -> listUser.get(0))
                .handle( validateStateUser ( user -> user.isFlagEnrollment() ,
                                   user -> new Exception(),
                                   UserEntity.class));
    }

    private UserEntity objUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setFlagEnrollment(true);
        userEntity.setPersonId("123123");
        userEntity.setUsername("brian01");
        return userEntity;
    }

    private ResponseUser builderResponseUser(UserEntity  userEntity) {
        ResponseUser responseUser = new ResponseUser();
        responseUser.setUsername(userEntity.getUsername());
        return responseUser;
    }

    private Mono<ResponseUser> flowWithCard(UserEntity userEntity) {
        return null;
    }

    private Mono<ResponseUser> flowWithoutCard(UserEntity userEntity) {
        return null;
    }
}


package example.util;

import example.model.entity.db.UserEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utility {

    public static
    <T,R>
    BiConsumer<? super T, SynchronousSink<R>>
    validateStateUser(Predicate<R> p, Function<R, Exception> f, Class<R> clazz) {
        return (obj, sync) -> {
            if(p.test((R) obj)) {
                sync.next((R) obj);
            } else {
                sync.error( f.apply((R) obj));
            }
        };
    }

    public static
    <T,R>
    BiConsumer<? super T, SynchronousSink<List<R>>>
    validateListUser(Predicate<List<R>> p, Function<R, Exception> f, Class<R> clazz) {
        return (obj, sync) -> {
            if(p.test((List<R>) obj)) {
                sync.error( f.apply((R) obj));
            } else {
                sync.next((List<R>) obj);
            }
        };
    }
}

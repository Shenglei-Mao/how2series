package io.github.robwin;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class Test {



    public static void main(String[] args) {
//        Flux.just("Hello", "World").subscribe(System.out::println);
////        Flux.range(1, 100).buffer(20).subscribe(System.out::println);
////
////        Flux.just("a", "b", "e")
////            .zipWith(Flux.just("c", "d", "f"))
////            .subscribe(System.out::println);
////
////
////        List<Integer> elements = new ArrayList<>();
////
////        Flux.just(1, 2, 3, 4)
////            .log()
////            .subscribe(new Subscriber<Integer>() {
////                @Override
////                public void onSubscribe(Subscription s) {
////                    s.request(Long.MAX_VALUE);
////                    System.out.println("On Subscription");
////                }
////
////                @Override
////                public void onNext(Integer integer) {
////                    elements.add(1);
////                }
////
////                @Override
////                public void onError(Throwable t) {}
////
////                @Override
////                public void onComplete() {
////                    System.out.println("Hello World");
////                }
////            });
////        System.out.println(elements);
////
////
////        Flux.just(1, 2, 3, 4)
////            .log()
////            .subscribe(elements::add);
////
////        System.out.println(elements);
////
////
////        List<String> values = new ArrayList<>();
////        Flux.just(1, 2, 3, 4)
////            .log()
////            .map(i -> i * 2)
////            .zipWith(Flux.range(0, Integer.MAX_VALUE),
////                (one, two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
////            .subscribe(values::add);
////        System.out.println(values);

        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while(true) {
                fluxSink.next(System.currentTimeMillis());
            }
        }).sample(ofSeconds(2)).publish();

        publish.subscribe(System.out::println);
//        publish.subscribe(System.out::println);

//        publish.connect();

        int[] a = new int[]{1, 2, 3};
        for (int k : a) {
            System.out.println(k);
        }

    }
}

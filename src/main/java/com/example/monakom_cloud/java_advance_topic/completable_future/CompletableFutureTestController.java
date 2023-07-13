package com.example.monakom_cloud.java_advance_topic.completable_future;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@RestController
@RequestMapping("cf")
public class CompletableFutureTestController {


    /**
     * We have created an instance of ExecutorService that we will use to submit a task that never ends - we call it testFeature01Support().
     * After that we want to print the value of the stringFuture variable on the console by invoking the get() method.
     * This method waits if necessary for the computation to complete, and then retrieves its result.

     * -> But because we are calling testFeature01Support()
     *      -> that never ends, the result will never be printed on the console,
     *      -> and we don’t have any way to complete it manually by passing a value.
     */
    @GetMapping("test1")
    public void testFeature01() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executorService.submit(this::neverEndingComputation);

        System.out.println("the result is : "+stringFuture.get());
    }


    /**
     * @throws InterruptedException
     * Now let’s see how to overcome this limitation by using the class CompletableFuture.
     * We will use the same scenario, but in this case, we will provide our value by using the method complete() of the CompletableFuture class.

     * -> if the neverEndingComputation() is taken to long time, the invoker have an ability to fork complete with some default value
     *
     * => To Summary this CompletableFuture will not block the main thread. 😽
     */

    @GetMapping("test2")
    public void testCompleteFuture() throws ExecutionException, InterruptedException {

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(this::neverEndingComputation);
        System.out.println("Is the stringCompletableFuture done ? " + stringCompletableFuture.isDone());

        // if the neverEndingComputation() is take to long so the invoker have a ability to fork complete with some default value
        if (stringCompletableFuture.isDone() == false) {

            stringCompletableFuture.complete("Pls Stop"); //=> this line will fork job to completed with the default 'Pls Stop'
            System.out.println("Am fork quit job here :(");
            System.out.println("the result is : "+stringCompletableFuture.get());
        }
    }
    private String neverEndingComputation() {

        if (1 == 1) {

            while (1==1) {
                System.out.println("am in here struck in loop");
            }
        }

        return "To test this fun will never completed ";
    }






    @GetMapping("test3")
    public Map<String,String> testCompleteFutureCombiningOperations() throws ExecutionException, InterruptedException {

        CompletableFuture<Map<String,String>> invokeApiWithHugData =
                CompletableFuture
                .supplyAsync(()->
                        this.apiGetOrderIDByTerminal("IFL")
                )
                .thenApply(
                        this::getOrderDetailById
                );

        System.out.println("Is the invokeApiWithHugData done ? " + invokeApiWithHugData.isDone());



//        /if (fetchTime > 700ms) -> break
//        if (invokeApiWithHugData.isDone() == false) {
//
//            invokeApiWithHugData.complete(Map.of("undefiled", "n/a"));
//            System.out.println("Am fork quit job here :(");
//            System.out.println("the result is : "+invokeApiWithHugData.get());
//        }

        return invokeApiWithHugData.get();
    }
    private String apiGetOrderIDByTerminal(String terminal) {
        for (int i = 0; i < 10000; i++) {
            System.out.print(MessageFormat.format("api 1 slow({0}), ", i));
        }
        log.info("terminal request is    : "+terminal);
        log.info("return order detail id : 001");
        return "001";
    }
    private Map<String, String> getOrderDetailById(String orderId) {
        Map<String,String> result = Map.of(
                "item", "coca",
                "qty", "5",
                "price","1$"
                );
        log.warn("request order ID : "+orderId);
        log.warn("request result   : "+result);


        return result;
    }




    @GetMapping("test4")
    public void testCombineTwoCompleteFuture() throws ExecutionException, InterruptedException {

        long start1 = System.currentTimeMillis();
        var style1 =
                completeFutureApiGetOrderIDByTerminal("IFL")// ->
                .thenApply(this::completeFutureApiGetOrderDetailById) //->
                .get()
                .get();

        long end1 = System.currentTimeMillis();
        System.out.printf("The operation took " + Math.min(start1,end1));



        long start2 = System.currentTimeMillis();
        var style2 =
                completeFutureApiGetOrderIDByTerminal("IFL")// ->
                        .thenCompose(this::completeFutureApiGetOrderDetailById) //->
                        .get();

        long end2 = System.currentTimeMillis();
        System.out.printf("The operation took " + Math.min(start2,end2));

    }
    private CompletableFuture<String> completeFutureApiGetOrderIDByTerminal(String terminal) {

        return CompletableFuture.supplyAsync(()-> {
            for (int i = 0; i < 10000; i++) {
                System.out.print(MessageFormat.format("api 1 slow({0}), ", i));
            }
            log.info("terminal request is    : "+terminal);
            log.info("return order detail id : 001");

            return "001";
        });


    }
    private CompletableFuture<Map<String,String>> completeFutureApiGetOrderDetailById(String orderId) {

        return CompletableFuture.supplyAsync(()-> {

            Map<String,String> result = Map.of(
                    "item", "coca",
                    "qty", "5",
                    "price","1$"
            );
            log.warn("request order ID : "+orderId);
            log.warn("request result   : "+result);

            return result;
        });


    }





    @GetMapping("test5")
    public void test4Test4 () {

        CompletableFuture
                .supplyAsync(() -> "hello completable future")
                .thenApply(String::toUpperCase);
    }

    @GetMapping("test6")
    public void test4TestAcceptAndRun () {

        //style1 -> thenAccept
        CompletableFuture
                .supplyAsync(() -> "hello completable future")
                .thenApply(String::toUpperCase)
                .thenApply(x-> x.replace(" ","_"))
                .thenAccept(x->System.out.println("ThenAccept is will not return anything"));


        //style1 -> thenRun
        CompletableFuture
                .supplyAsync(() -> "hello completable future")
                .thenApply(String::toUpperCase)
                .thenApply(x-> x.replace(" ","_"))
                .thenRun(()-> System.out.println("ThenAccept is will not return anything" + Thread.currentThread().getName()));

        System.out.println("Out block " + Thread.currentThread().getName());
    }

}
























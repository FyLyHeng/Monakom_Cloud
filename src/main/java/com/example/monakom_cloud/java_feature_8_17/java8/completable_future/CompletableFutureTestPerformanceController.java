package com.example.monakom_cloud.java_feature_8_17.java8.completable_future;

import com.example.monakom_cloud.java_feature_8_17.java8.completable_future.model.Category;
import com.example.monakom_cloud.java_feature_8_17.java8.completable_future.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("cf-pf")
public class CompletableFutureTestPerformanceController {

    private final Stream<Transaction> listTransaction = Stream.of(
        new Transaction("1", "description 1"),
        new Transaction("2", "description 2"),
        new Transaction("3", "description 3"),
        new Transaction("4", "description 4"),
        new Transaction("5", "description 5"),
        new Transaction("6", "description 6"),
        new Transaction("7", "description 7"),
        new Transaction("8", "description 8"),
        new Transaction("9", "description 9"),
        new Transaction("10", "description 10")
    );


    /**
     * The testPerformance will takes 10 seconds to complete because we are categorizing each transaction in sequence and the time needed to categorize one transaction is one second.
     * @return
     */
    @GetMapping("test01")
    public List<Category> testPerformance() {

        long start = System.currentTimeMillis();

        var categories = Stream.of(
                        new Transaction("1", "description 1"),
                        new Transaction("2", "description 2"),
                        new Transaction("3", "description 3"),
                        new Transaction("4", "description 4"),
                        new Transaction("5", "description 5"),
                        new Transaction("6", "description 6"),
                        new Transaction("7", "description 7"),
                        new Transaction("8", "description 8"),
                        new Transaction("9", "description 9"),
                        new Transaction("10", "description 10")
                )
                .map(CategorizationService::categorizeTransaction)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        long timeConsume = end - start;

        System.out.printf("The operation took " + timeConsume);
        //System.out.println("Categories are: " + categories);

        return categories;
    }





    /**
     * Using a parallel stream, our client application will look like this
     * The difference is huge! Now our application runs almost three times faster, but this is not the whole story.
     * It takes 2s to completed.

     * Can we do something to increase the performance of our application even more? YES!
     * @return
     */
    @GetMapping("test02")
    public List<Category> testPerformanceParallel() {

        long start = System.currentTimeMillis();

        var categories = Stream.of(
                        new Transaction("1", "description 1"),
                        new Transaction("2", "description 2"),
                        new Transaction("3", "description 3"),
                        new Transaction("4", "description 4"),
                        new Transaction("5", "description 5"),
                        new Transaction("6", "description 6"),
                        new Transaction("7", "description 7"),
                        new Transaction("8", "description 8"),
                        new Transaction("9", "description 9"),
                        new Transaction("10", "description 10")
                )
                .parallel()
                .map(CategorizationService::categorizeTransaction)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();

        System.out.printf("The operation took %s ms%n", end - start);
        //System.out.println("Categories are: " + categories);

        return categories;
    }


    @GetMapping("test03")
    public List<Category> testPerformanceParallelWithCompeteAbleFuture() {

        long start = System.currentTimeMillis();
        Executor executor = Executors.newFixedThreadPool(10);
        var futureCategories = Stream.of(
                        new Transaction("1", "description 1"),
                        new Transaction("2", "description 2"),
                        new Transaction("3", "description 3"),
                        new Transaction("4", "description 4"),
                        new Transaction("5", "description 5"),
                        new Transaction("6", "description 6"),
                        new Transaction("7", "description 7"),
                        new Transaction("8", "description 8"),
                        new Transaction("9", "description 9"),
                        new Transaction("10", "description 10")

                )
                .map(transaction-> CompletableFuture
                        .supplyAsync(()->
                                CategorizationService.categorizeTransaction(transaction)
                                , executor
                        )
                ).collect(Collectors.toList());

        var categories = futureCategories
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();

        System.out.printf("The operation took %s ms%n", end - start);
        //System.out.println("Categories are: " + categories);

        return categories;
    }




}
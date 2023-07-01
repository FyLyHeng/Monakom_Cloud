package com.example.monakom_cloud.core;

import com.example.monakom_cloud.core.exception.NotFoundExecution;
import com.example.monakom_cloud.core.repo.BaseRepository;
import com.example.monakom_cloud.core.response.JSONFormat;
import com.example.monakom_cloud.core.response.ResponseDTO;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.management.ConstructorParameters;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;


public abstract class GenericRestfulController<T> {

    public final JSONFormat jsonFormat;
    public final BaseRepository<T> repository;
    private final String resourceName;

    @ConstructorParameters({"JSONFormat","BaseRepository<T>"})
    public GenericRestfulController(JSONFormat jsonFormat, BaseRepository<T> baseRepository) {
        this.jsonFormat = jsonFormat;
        this.repository  = baseRepository;
        this.resourceName = this.getGenericTypeClass().getSimpleName();
    }

    @GetMapping("/all")
    public ResponseDTO all() {
        return jsonFormat.responseObj(repository.findAll());
    }


    @GetMapping("{id}")
    public ResponseDTO getById(@PathVariable Long id) throws Throwable {

        var data = repository.findById(id).orElseThrow(this::notFoundThrowable);
        return jsonFormat.responseObj(data);
    }


    /**
     *
     * @param customDto is the class type to transform Model Format to CustomDto
     * @param <R>
     * @return return ResponseDTO Format with Data_field is the list of R
     */
    @GetMapping("/list")
    public <R>ResponseDTO list(Class<R> customDto) {

        Specification<T> search = (root, query, criteriaBuilder) -> {
            ArrayList<Predicate> predicates = new ArrayList<>() {
                {
                    add(criteriaBuilder.like(criteriaBuilder.upper(root.get("posTerminalId")), "%${title.toString().uppercase(Locale.getDefault())}%"));
                    add(criteriaBuilder.like(criteriaBuilder.upper(root.get("posTerminalId")), "%${title.toString().uppercase(Locale.getDefault())}%"));
                }
            };

            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };

        Pageable paging = PageRequest.of(0, 5, Sort.by("price").descending());

        Page<R> data = repository.findAll(search,customDto ,paging);

        return jsonFormat.responseObj(data);
    }



    //===============================================

    private Throwable notFoundThrowable(){
        return new NotFoundExecution(resourceName +" Id Not Found!");
    }
    private void notFound(){
        throw new NotFoundExecution(resourceName +" Id Not Found!");
    }
    @SuppressWarnings("unchecked")
    private Class<T> getGenericTypeClass() {
        try {
            String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            Class<?> clazz = Class.forName(className);
            return (Class<T>) clazz;
        } catch (Exception e) {
            throw new IllegalStateException("Class is not parametrized with generic type!!! Please use extends <> ");
        }
    }



}

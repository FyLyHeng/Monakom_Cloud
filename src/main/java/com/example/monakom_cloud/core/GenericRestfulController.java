package com.example.monakom_cloud.core;

import com.example.monakom_cloud.core.exception.NotFoundException;
import com.example.monakom_cloud.core.repo.BaseRepository;
import com.example.monakom_cloud.core.response.JSONFormat;
import com.example.monakom_cloud.core.response.ResponseDTO;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public abstract class GenericRestfulController<T extends BaseEntity> {

    protected JSONFormat jsonFormat;
    protected BaseRepository<T> repository;
    protected String resourceName;

    public GenericRestfulController(JSONFormat jsonFormat, BaseRepository<T> targetRepo) {
        this.jsonFormat = jsonFormat;
        this.repository = targetRepo;
        this.resourceName = this.getGenericTypeClass().getSimpleName();
    }

    @PostMapping
    public ResponseDTO create(@RequestBody T entity) {
        var data = repository.save(entity);
        return jsonFormat.responseObj(data);
    }

    @GetMapping("/all")
    public ResponseDTO all() {
        return jsonFormat.responseObj(repository.findAll());
    }


    @GetMapping("{id}")
    public ResponseDTO getById(@PathVariable Long id) throws Throwable {

        T data = repository.findById(id).orElseThrow(() -> notFoundThrowable(id));
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
            List<Predicate> predicates = Arrays.asList(

                    criteriaBuilder.like(criteriaBuilder.upper(root.get("posTerminalId")), "%${title.toString().uppercase(Locale.getDefault())}%"),
                    criteriaBuilder.like(criteriaBuilder.upper(root.get("posTerminalId")), "%${title.toString().uppercase(Locale.getDefault())}%")
                );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Pageable paging = PageRequest.of(0, 5, Sort.by("price").descending());

        //Page<R> data = repository.findAll(search ,paging);
        //todo : add mapstruct for transform to DTO class

        return jsonFormat.responseObj(null);
    }



    //===============================================

    private Throwable notFoundThrowable(Long id) {
        //MessageFormat.format("{0} Id : {1} Not Found!", resourceName, id);
        return new NotFoundException(String.format("%s Id : %s Not Found!", resourceName, id));
    }
    private void notFound(){
        throw new NotFoundException(resourceName +" Id Not Found!");
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

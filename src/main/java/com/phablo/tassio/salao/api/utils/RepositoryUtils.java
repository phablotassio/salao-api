package com.phablo.tassio.salao.api.utils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;

public class RepositoryUtils {

    public static void addPagination(TypedQuery<? extends Serializable> query, Pageable pageable) {

        int actualPage = pageable.getPageNumber();
        int totalRegistersPerPage = pageable.getPageSize();
        int firstRegisterOfPage = actualPage * totalRegistersPerPage;

        query.setFirstResult(firstRegisterOfPage);
        query.setMaxResults(totalRegistersPerPage);

    }

    public static void addOrdination(Pageable pageable, CriteriaBuilder builder,
                                     CriteriaQuery<?> criteria, Root<?> root) {
        Sort sort = pageable.getSort();
        if (sort != null & sort.isSorted()) {
            Sort.Order order = sort.iterator().next();
            String field = order.getProperty();
            criteria.orderBy(order.isAscending() ? builder.asc(root.get(field)) : builder.desc(root.get(field)));
        }
    }


}

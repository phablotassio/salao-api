package com.phablo.tassio.salao.api.repository.Employee;

import com.phablo.tassio.salao.api.model.*;
import com.phablo.tassio.salao.api.model.Filter.EmployeeFilter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepositoryQuerry {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Employee> findAllWithFilter(EmployeeFilter employeeFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        Fetch<Employee, FisicPerson> fisicPersonFetch = root.fetch("fisicPerson", JoinType.LEFT);
        Join<Employee, FisicPerson> fisicPersonJoin = (Join<Employee, FisicPerson>) fisicPersonFetch;

        fisicPersonJoin.fetch("person",JoinType.LEFT);
        Fetch<Employee, Role> role = root.fetch("role", JoinType.LEFT);
        Fetch<Employee, JuridicalPerson> juridicalPersonFetch = root.fetch("juridicalPerson", JoinType.INNER);

        Join<Employee, FisicPerson> join = (Join<Employee, FisicPerson>) fisicPersonFetch;

        Predicate[] predicates = createPredicates(builder, employeeFilter, root, join);
        criteriaQuery.where(predicates);
        TypedQuery<Employee> query = manager.createQuery(criteriaQuery);
        addOrdenation(query, pageable);

        return new PageImpl<>(query.getResultList()).getContent();
    }

    private Predicate[] createPredicates(CriteriaBuilder builder, EmployeeFilter employeeFilter,
                                         Root<Employee> root, Join<Employee, FisicPerson> join) {

        List<Predicate> predicates = new ArrayList<>();

        if (employeeFilter.getAdmissionDate() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("admissionDate"),
                    employeeFilter.getAdmissionDate()));
        }

        if(!StringUtils.isEmpty(employeeFilter.getFullName())){
            predicates.add(builder.like(builder.lower(join.get("fullName")), "%" + employeeFilter.getFullName().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }

    private void addOrdenation(TypedQuery<Employee> query, Pageable pageable) {

        int paaginaAtual = pageable.getPageNumber();
        int totalRegistrosPogPagina = pageable.getPageSize();
        int primeiroRegistroPagina = paaginaAtual * totalRegistrosPogPagina;

        query.setFirstResult(primeiroRegistroPagina);
        query.setMaxResults(totalRegistrosPogPagina);

    }


}

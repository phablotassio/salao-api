package com.phablo.tassio.salao.api.repository.Employee;

import com.phablo.tassio.salao.api.model.*;
import com.phablo.tassio.salao.api.model.Filter.EmployeeFilter;
import com.phablo.tassio.salao.api.utils.RepositoryUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Employee> findAllWithFilter(EmployeeFilter employeeFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        Fetch<Employee, FisicPerson> fisicPersonFetch = root.fetch("fisicPerson", JoinType.LEFT);
        Fetch<Employee, GroupPerson> groupPersonFetch = root.fetch("groupPerson");
        Join<Employee, FisicPerson> fisicPersonJoin = (Join<Employee, FisicPerson>) fisicPersonFetch;

        fisicPersonJoin.fetch("person", JoinType.LEFT);
        Fetch<Employee, Role> role = root.fetch("role", JoinType.LEFT);
        Fetch<Employee, JuridicalPerson> juridicalPersonFetch = root.fetch("juridicalPerson", JoinType.INNER);


        Predicate[] predicates = createPredicates(builder, employeeFilter, root, fisicPersonJoin);
        criteriaQuery.where(predicates);
        RepositoryUtils.addOrdination(pageable, builder, criteriaQuery, root);
        TypedQuery<Employee> query = manager.createQuery(criteriaQuery);
        RepositoryUtils.addPagination(query, pageable);

        return new PageImpl<>(query.getResultList()).getContent();
    }

    private Predicate[] createPredicates(CriteriaBuilder builder, EmployeeFilter employeeFilter,
                                         Root<Employee> root, Join<Employee, FisicPerson> fisicPersonJoin) {

        List<Predicate> predicates = new ArrayList<>();

        if (employeeFilter.getAdmissionDate() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("admissionDate"),
                    employeeFilter.getAdmissionDate()));
        }

        if (!StringUtils.isEmpty(employeeFilter.getFullName())) {
            predicates.add(builder.like(builder.lower(fisicPersonJoin.get("fullName")), "%" + employeeFilter.getFullName().toLowerCase() + "%"));
        }

        if (employeeFilter.getIdGroupPerson() != null) {
            predicates.add(builder.equal(root.get("groupPerson"), employeeFilter.getIdGroupPerson()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}

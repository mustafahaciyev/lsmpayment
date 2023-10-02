package com.example.lmspayment.specification;

import com.example.lmspayment.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class PaymentSpecification {

    public static Specification<Student> hasPhoneNumber(String phoneNumber) {
        return (Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            Predicate predicate =  builder.equal(root.get("phoneNumber"), phoneNumber);
            return predicate;
        };
    }

}

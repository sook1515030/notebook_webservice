package com.example.notebookwebproject.Paging;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class NotebookSpecification {
    public static Specification<Notebook> searchBrand(final String brand){
     return new Specification<Notebook>() {
         @Override
         public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
             return criteriaBuilder.equal(root.get("brand"),brand);
         }
       };
    }
    public static Specification<Notebook> searchMemorySize(final int memorysize){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Object obj = root.get("memorysize");
                System.out.println(obj.getClass().getName() + " " +root.get("memorysize") + " parameter: " + memorysize + " result+ " + criteriaBuilder.equal(root.get("memorysize"),memorysize));
                return criteriaBuilder.equal(root.get("memorysize"),memorysize);
            }
        };
    }
    public static Specification<Notebook> searchCPU(final String cpukind){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search cpukind");
                return criteriaBuilder.equal(root.get("cpukind"),cpukind);
            }
        };
    }
    public static Specification<Notebook> searchPrice(final String pricerange){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search price");
                if (pricerange.equals("range1"))
                    return criteriaBuilder.lessThanOrEqualTo(root.get("price"), 500000);
                else if (pricerange.equals("range2"))
                    return criteriaBuilder.between(root.get("price"), 500000,1000000);
                else if (pricerange.equals("range3"))
                    return criteriaBuilder.between(root.get("price"),1000000,1500000);
                else if (pricerange.equals("range4"))
                    return criteriaBuilder.between(root.get("price"),1500000,2000000);
                else if (pricerange.equals("range5"))
                    return criteriaBuilder.greaterThan(root.get("price"),2000000);
                else
                    System.out.println("exception");
                    return criteriaBuilder.between(root.get("price"), 0, 5000000);
            }
        };
    }

    public static Specification<Notebook> searchSize(final float sizeint){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search size");
                return criteriaBuilder.equal(root.get("sizeint"),sizeint);
            }
        };
    }

    public static Specification<Notebook> searchWeight(final String weight){
        return new Specification<Notebook>() {
            @Override
            public Predicate toPredicate(Root<Notebook> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                System.out.println("search weight");
                if (weight.equals("range1"))
                    return criteriaBuilder.lessThanOrEqualTo(root.get("price"), 1000);
                else if (weight.equals("range2"))
                    return criteriaBuilder.between(root.get("price"), 1000,1500);
                else if (weight.equals("range3"))
                    return criteriaBuilder.between(root.get("price"),1500,2000);
                else if (weight.equals("range4"))
                    return criteriaBuilder.greaterThan(root.get("price"),2000);
                else
                    System.out.println("exception");
                return criteriaBuilder.between(root.get("price"), 0, 5000000);
            }
        };
    }

}
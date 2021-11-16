//package com.sges.service.impl;
//
//import com.sges.entity.Authority;
//import com.sges.generic.impl.GenericServiceImpl;
//import com.sges.repo.AuthorityRepo;
//import com.sges.service.AuthorityService;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthorityServiceImpl extends GenericServiceImpl<Authority, Integer> implements AuthorityService {
//
//    final AuthorityRepo authorityRepo;
//
//    public AuthorityServiceImpl(JpaRepository<Authority, Integer> jpaRepository, AuthorityRepo authorityRepo) {
//        super(jpaRepository);
//        this.authorityRepo = authorityRepo;
//    }
//
//    @Override
//    public void deleteAuthorityByUser_Id(Integer id) {
//        if (authorityRepo.existsAuthorityByUser_Id(id)) {
//            authorityRepo.deleteAuthorityByUser_Id(id);
//        }
//    }
//
//}

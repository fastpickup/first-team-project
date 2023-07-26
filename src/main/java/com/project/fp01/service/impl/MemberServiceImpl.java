package com.project.fp01.service.impl;

/*
 * Made By : Jo Sang Hee
 * When 2023-07-26
 * Time AM 10:40
 */

import com.project.fp01.dto.MemberDTO;
import com.project.fp01.mappers.MemberMapper;
import com.project.fp01.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  //의존성 주입
  private final MemberMapper memberMapper;
//  public MemberServiceImpl(MemberMapper memberMapper){
//    log.info("-----------------------------------------------------");
//    this.memberMapper = memberMapper;
//  }

  //join Member
  @Override
  public int joinMember(MemberDTO memberDTO) {
    log.info("join Service------------------------------------------------");

    return memberMapper.joinMember(memberDTO);
  }

  //read Member
  @Override
  public MemberDTO readMember(String eamil) {
    log.info("read Service------------------------------------------------");

    return memberMapper.readMember(eamil);
  }

  //delete Member
  @Override
  public int deleteMember(String email) {
    log.info("delete Service------------------------------------------------");

    return memberMapper.deleteMember(email);
  }

  //update Member
  @Override
  public int updateMember(MemberDTO memberDTO) {
    log.info("update Service------------------------------------------------");

    return memberMapper.updateMember(memberDTO);
  }

  //list Member
  @Override
  public List<MemberDTO> listMember() {
    log.info("list Service------------------------------------------------");

    return memberMapper.listMember();
  }

  //
}

package com.project.fp01.service;

/*
 * Made By : Jo Sang Hee
 * When 2023-07-26
 * Time AM 10:40
 */

import com.project.fp01.dto.MemberDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MemberService {
  // join Member
  int joinMember(MemberDTO memberDTO);

  // read Member
  MemberDTO readMember(String eamil);

  // delete Mmeber
  int deleteMember(String email);

  // update Member
  int updateMember(MemberDTO memberDTO);

  // list Member
  List<MemberDTO> listMember();
}

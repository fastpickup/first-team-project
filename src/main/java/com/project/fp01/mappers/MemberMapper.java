package com.project.fp01.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.fp01.dto.MemberDTO;

@Mapper
public interface MemberMapper {

    // join member
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

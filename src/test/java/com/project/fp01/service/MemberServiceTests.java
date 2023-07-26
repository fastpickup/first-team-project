package com.project.fp01.service;

/*
 * Made By : Jo Sang Hee
 * When 2023-07-26
 * Time AM 10:47
 */

import com.project.fp01.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class MemberServiceTests {
  
  //의존성 주입
  @Autowired
  private MemberService memberService;

  //테스트 값 생성
  private static final String TEST_EMAIL = "jo_sh_1028@naver.com";
  private static final String TEST_MEMBER_PASSWORD = "sdlkfjslkfj";
  private static final String TEST_MEMBER_NAME = "조상희";
  private static final String TEST_MEMBER_PHONE="010-4597-1589";

  //dto 생성
  private MemberDTO memberDTO;

  //BeforeEach로 생성
  @BeforeEach
  public void init(){
    memberDTO = MemberDTO.builder()
      .email(TEST_EMAIL)
      .memberPw(TEST_MEMBER_PASSWORD)
      .memberName(TEST_MEMBER_NAME)
      .memberPhone(TEST_MEMBER_PHONE)
      .build();
  }

  //join test
  @Test
  @Transactional
  @DisplayName("멤버 회원가입 테스트 서비스")
  public void testJoinMemberService(){
    log.info("=== Start Member Join Service Test ===");
    int joinMember = memberService.joinMember(memberDTO);
    MemberDTO dto = memberService.readMember(TEST_EMAIL);
    Assertions.assertNotNull(dto);
    Assertions.assertEquals(1, joinMember, "Member Join Fail");
    log.info("=== End Member Join Service Test ===");
  }

  //read test
  @Test
  @Transactional
  @DisplayName("멤버 조회 테스트 서비스")
  public void testReadMemberService(){
    log.info("=== Start Member Read Service Test ===");
    MemberDTO dto = memberService.readMember(TEST_EMAIL);
    Assertions.assertNotNull(dto);
    log.info("=== End Member Read Service Test ===");
  }

  //
}

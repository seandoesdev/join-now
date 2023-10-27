package com.exam.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("AcceptPrintDTO")
public class AcceptPrintDTO {
	UserInfoDTO applyUserInfoDTO; // 신청자
	UserInfoDTO acceptUserInfoDTO; // 작성자
	PostDTO postDTO; // 게시판 정보
	AcceptDTO acceptDTO; // 신청 정보
	
	public AcceptPrintDTO() {}

	public AcceptPrintDTO(UserInfoDTO applyUserInfoDTO, UserInfoDTO acceptUserInfoDTO, PostDTO postDTO,
			AcceptDTO acceptDTO) {
		this.applyUserInfoDTO = applyUserInfoDTO;
		this.acceptUserInfoDTO = acceptUserInfoDTO;
		this.postDTO = postDTO;
		this.acceptDTO = acceptDTO;
	}

	public UserInfoDTO getApplyUserInfoDTO() {
		return applyUserInfoDTO;
	}

	public void setApplyUserInfoDTO(UserInfoDTO applyUserInfoDTO) {
		this.applyUserInfoDTO = applyUserInfoDTO;
	}

	public UserInfoDTO getAcceptUserInfoDTO() {
		return acceptUserInfoDTO;
	}

	public void setAcceptUserInfoDTO(UserInfoDTO acceptUserInfoDTO) {
		this.acceptUserInfoDTO = acceptUserInfoDTO;
	}

	public PostDTO getPostDTO() {
		return postDTO;
	}

	public void setPostDTO(PostDTO postDTO) {
		this.postDTO = postDTO;
	}

	public AcceptDTO getAcceptDTO() {
		return acceptDTO;
	}

	public void setAcceptDTO(AcceptDTO acceptDTO) {
		this.acceptDTO = acceptDTO;
	}

	@Override
	public String toString() {
		return "AcceptPrintDTO [applyUserInfoDTO=" + applyUserInfoDTO + ", acceptUserInfoDTO=" + acceptUserInfoDTO
				+ ", postDTO=" + postDTO + ", acceptDTO=" + acceptDTO + "]";
	}

	

	
}

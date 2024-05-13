package com.trpg.trpg_back.global.comm.responseData;

public enum ResponseDataCode {

	SUCCESS(200), // 요청 성공 및 요청정보 반환.
	CREATED(201), // 응답에 대한 요청으로 새로운 리소스 생성.
	BAD(400), // 잘못된 요청
	UNAUTH(401), // 인증실패(인증정보 없음)
	FORBIDDEN(403), // 권한 없음
	NOT_FOUND(404), // 요청 리소스 찾지못함.
	SERVER_ERROR(500), // 서버 에러
	UNAVAILABLE(503), // 서버에서 응답준비가 안된 요청
	ERROR(999); // 기타 모든 에러

	private final int code;

	ResponseDataCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}

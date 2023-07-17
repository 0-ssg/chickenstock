package util;

import java.util.Date;

public class PdsUtil {

	public static String getNewFileName(String filename) {
		String newfilename = "";
		String fpost = ""; // .jpg, .txt. .*
		
		// .indexOf('.') << .에 대한 위치가 나옴
		if(filename.indexOf('.') > 0) {	// 확장자명이 있음
			fpost = filename.substring(filename.indexOf('.')); // .부터 문자 저장 ex) .txt
			newfilename = new Date().getTime() + fpost;		   // 2324324.txt
			
		}else {	// 확장자명이 없음				내 마음대로 확장자 붙이기
			newfilename = new Date().getTime() + ".back";
		}
		return newfilename;
	}
}

package validate;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import vo.TeacherVO;

// 유효성 체크 관련
public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	// 유효성 체크로직
	// 유효성 체크할 객체, 오류 발생시 오류 msg 등록할 Map객체
	@Override
	public void validate(Object target, Errors error) {
		// TODO Auto-generated method stub
		TeacherVO mem = (TeacherVO) target;
		// name이란 이름으로 두번쨰인자(properties 파일에 등록된 이름)프로퍼티 이름 집어넣기
		// 이렇게 하면 다국어 지원 가능
		// 직접 메세지를 넣고 싶다면 인자가 3개인 함수에서 3번째에 입력
		if (mem.getUsername().isEmpty())
			error.rejectValue("username", "required.empty.name");
		if (mem.getId().isEmpty())
			error.rejectValue("id", "required.empty.id");
		if (mem.getPassword().isEmpty())
			error.rejectValue("password", "required.empty.passwd");
		if (mem.getBirthday().isEmpty())
			error.rejectValue("birthday", "required.empty.birthday");
		if (mem.getEmail().isEmpty())
			error.rejectValue("email", "required.empty.email");
		else{
			if (!isEmailValidator(mem.getEmail()))
				error.rejectValue("email", "required.validate.email");
		}
		if (mem.getPhonenum().isEmpty())
			error.rejectValue("phonenum", "required.empty.phonenum");
		else{
			if (!isPhonenumValidator(mem.getPhonenum()))
				error.rejectValue("phonenum", "required.validate.phonenum");
		}

		// 생년월윌, 이메일, 폰넘버 필수
	}

	private boolean isEmailValidator(String email) {
		if (email == null)
			return false;
		boolean isMatch = Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", email.trim());
		return isMatch;
	}

	private boolean isPhonenumValidator(String phonenum) {
		if (phonenum == null)
			return false;
		boolean isMatch = Pattern.matches("010[1-9][0-9]{7}", phonenum.trim());
		return isMatch;
	}

}

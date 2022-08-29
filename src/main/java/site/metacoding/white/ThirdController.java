package site.metacoding.white;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.white.domain.Third;


// 고급 데이터 받기(json, x-www-form-뭐시기, text)


@RestController
public class ThirdController {
	
	@PostMapping("/third")
	public String postData(Third third) {
		return "id : "+third.getId()+", title : "+third.getTitle()
		+", content : "+third.getContent();
	}
	
	
	// UPDATE third SET title=?, content=? WHERE id=?
	// WHERE절에 걸리는 것은 http body로 받는거보다 주소로 받는다. (프로토콜)
	@PutMapping("/third/{id}")
	public String putData(@PathVariable Integer id, Third third) {
		return third.toString();
	}
	
	@PutMapping("/third/{id}/json")
	public String putJsonData(@PathVariable Integer id, @RequestBody Third third) {
		return third.toString();
	}
	
	
	
}

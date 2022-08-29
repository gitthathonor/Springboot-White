package site.metacoding.white;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// 데이터 받기
// GET -> http body가 없음 -> QueryString, PathVariable(pk)-> form(GET) -> 브라우저(주소뒤?붙이기)
// 쿼리 스트링으로 날리는 것들은 DB에 where절에 조건을 걸어라는 뜻
// POST,PUT -> Http body에 담아준다. -> form(POST) -> JS
// DELETE -> http body가 없음 -> QueryString, PathVariable(pk)

// primary key로 질의하는 것은 @PathVariable로 질의하고
// 그 이외의 것들은 쿼리스트링으로 하는 것이 트렌드

@RestController
public class SecondController {
	
	@GetMapping("/second/{id}") //pk가 1인것
	public String getData(@PathVariable Integer id)	{
		return "id : " + id;
	}
	
	
	// QueryString은 x-www-form-urlencoded 타입니다.
	@GetMapping("/second")
	public String getData2(String title, String content) {
		return "title : " + title + ", content : " + content;
	}
	
	
	// BR -> title=제목&content=내용, content-type -> 스프링이 parsing을 할 수 있게 해준다.
	@PostMapping("/second")
	public String postData(String title, String content) { // 스프링 parsing 기본 전략 : x-www-form-...
		return "title : " + title + ", content : " + content;
	}
	
	
	@PutMapping("/second")
	public String putData(String title, String content) { // 스프링 parsing 기본 전략 : x-www-form-...
		return "title : " + title + ", content : " + content;
	}
	
	@DeleteMapping("/second/{id}")
	public String putData(@PathVariable Integer id) { // 스프링 parsing 기본 전략 : x-www-form-...
		return id + "delete ok";
	}
	
	
	
	
}

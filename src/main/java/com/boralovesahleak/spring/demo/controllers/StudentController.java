package com.boralovesahleak.spring.demo.controllers;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boralovesahleak.spring.demo.model.Student;
import com.boralovesahleak.spring.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService; 
	// when create view name must end with [_view.jsp]
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String getAddStudent(Model model){
		Student ahleak = new Student();
		ahleak.setStuId(1);
		ahleak.setStuName("ស្រីលាក់");
		ahleak.setLvlYear("1");
		studentService.add(ahleak);
		return "student/list";
		
	}
	
	@RequestMapping(value="/liststudent", method = RequestMethod.GET)
//	@ResponseBody
	public ResponseEntity<Map<String, Object>> getAllStudent(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("allStudent", studentService.getAllStudent());
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}

// what the fuck? why? jap
// invalid location




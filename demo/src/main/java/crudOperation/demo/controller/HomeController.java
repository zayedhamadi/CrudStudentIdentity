package crudOperation.demo.controller;


import crudOperation.demo.entity.Student;
import crudOperation.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = ("/" ))
public class HomeController {
@Autowired
    private StudentRepository StudentRepository;


    @GetMapping
    public String index(){
        return "welcome to springboot";
    }

    @PostMapping("/StudentIdentity")
    public  Student StudentIdentity(@RequestBody Student student){
        this.StudentRepository.save(student);
        return student;
    }



    //handler for delete particular person

    @DeleteMapping("/DeleteStudent/{rollNumber}")
    public String DeleteStudent(@PathVariable int rollNumber){
        Optional<Student>OptionalStudent=this.StudentRepository.findById(rollNumber);
        if (OptionalStudent.isPresent()){
            Student s=OptionalStudent.get();
            this.StudentRepository.delete(s);
            return "delete Successfully";
        }else {
            return "there sa big problem here";
        }
        }
            //handler for update
        @PutMapping ("/UpdateStudent")
    public Student UpdateStudent(@RequestBody Student student){
        this.StudentRepository.save(student);
        return student;
        }


        //get a particular student data
        @GetMapping("/getStudentData/{rollNumber}")
    public  Student getStudentData(@PathVariable int rollNumber){
Optional <Student>optionallStudent =this.StudentRepository.findById(rollNumber);
            return optionallStudent.orElse(null);

        }

    //handler to get all student
    @GetMapping("/StudentList")
    public List<Student>StudentList (){
        return this.StudentRepository.findAll();
    }
}


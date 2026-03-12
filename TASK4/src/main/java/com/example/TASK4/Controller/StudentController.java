package com.example.TASK4.Controller;
//TASK-1 : Created student controller
import lombok.Setter;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TASK4.Model.Student;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private static List<Student> students=new ArrayList<>();
    static{
        students.add(new Student(1,"Hiranya",20));
        students.add(new Student(2,"Ashmitha",20));
        students.add(new Student(3,"Harati",20));
        students.add(new Student(4,"uma",21));
        students.add(new Student(5,"Divya",20));
        students.add(new Student(6,"Sravanti",19));
    }
    @GetMapping//TASK2:Implemented GET /api/students :JAVA list->JSON Array
    public List<Student> getAllStudents(){
        return students;
    }
    @GetMapping("/{id}")//TASK3: Implemented GET /api/students/1
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        for(Student student:students){
            if(student.getId()==id){
                return ResponseEntity.ok(student);
            }else{
                return ResponseEntity.notFound().build();
            }
        }
        return null;
    }
    @GetMapping("/search")//TASK4:Implemented Search ny name
    public ResponseEntity<List<Student>> searchStudents(@RequestParam String name){
        List<Student> result=students.stream()
                .filter(student->student.getName().equalsIgnoreCase(name))
                .toList();
        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping//TASK5:POST
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        students.add(student);
        return ResponseEntity.status(201).body(student);
    }
    @PutMapping("/{id}")//TASK6:PUT
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student updatedStudent){
        for(Student student:students){
            if(student.getId()==id){
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")//TASK7: deleted /api/students/{id}
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        for(Student student:students){
            if(student.getId()==id){
                students.remove(student);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
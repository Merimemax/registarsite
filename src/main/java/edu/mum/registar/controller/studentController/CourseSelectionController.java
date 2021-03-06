package edu.mum.registar.controller.studentController;

import edu.mum.registar.domain.*;
import edu.mum.registar.service.sectionService.SectionService;
import edu.mum.registar.service.semesterService.SemesterService;
import edu.mum.registar.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/student")
@Controller
public class CourseSelectionController {

    @Autowired
    SemesterService semesterService;

    @Autowired
    StudentService studentService;

    @Autowired
    SectionService sectionService;

    private static List<Semester> semesters() {
        List<Semester> semesterList = new ArrayList<>();
        List<Block> blockList = new ArrayList<>();
        List<Section> sectionList = new ArrayList<>();

        Course course = new Course();
        course.setId(1);
        course.setCourseCode("CS545");
        course.setCourseName("WAA");
        course.setCredit(4);

        Faculty faculty = new Faculty();
        faculty.setId(Long.valueOf(1));
        faculty.setFirstName("Tina");
        faculty.setLastName("Xing");

//    ==========================sections=====================================
        Section m114 = new Section();
        m114.setId(Long.valueOf(1));
        m114.setSectionNo("M115");
        m114.setCapacity(25);
        m114.setCourse(course);
        m114.setProffessor(faculty);


        Section M215 = new Section();
        M215.setId(Long.valueOf(1));
        M215.setSectionNo("M215");
        M215.setCapacity(25);
        M215.setCourse(course);
        M215.setProffessor(faculty);


        Section v47 = new Section();
        v47.setId(Long.valueOf(1));
        v47.setSectionNo("v47");
        v47.setCapacity(25);
        v47.setCourse(course);
        v47.setProffessor(faculty);


        sectionList.add(m114);
        sectionList.add(M215);
        sectionList.add(v47);

//    ==========================/sections=====================================
//    ==========================block=====================================
        Block feb = new Block();
        feb.setId(Long.valueOf(1));
        feb.setBlockName("Feb2019");
        feb.setSections(sectionList);


        Block march = new Block();
        march.setId(Long.valueOf(2));
        march.setBlockName("Feb2019");
        march.setSections(sectionList);


        blockList.add(feb);
        blockList.add(march);

//    ==========================/block=====================================
        Semester spring = new Semester();
        spring.setId(Long.valueOf(3));
        spring.setSemesterName("Fall2019");
        spring.setBlockList(blockList);

        Semester summer = new Semester();
        summer.setId(Long.valueOf(3));
        summer.setSemesterName("Fall2019");
        summer.setBlockList(blockList);

        Semester fall = new Semester();
        fall.setId(Long.valueOf(3));
        fall.setSemesterName("Fall2019");
        fall.setBlockList(blockList);

        semesterList.add(spring);
        semesterList.add(summer);
        semesterList.add(fall);

        return semesterList;
    }

    @GetMapping("/courses")
    public @ResponseBody
    List<Semester> getBlocks() {
        return semesterService.getSemesters();
    }

    @GetMapping("/selectCourse")
    public String selectCourse(Model model, HttpServletRequest request, @RequestParam("studid") long id) {
        List<Semester> semesterList = CourseSelectionController.semesters();

        Student student = (Student) request.getSession().getAttribute("student");


        model.addAttribute("semester", semesterService.getOne(id));
        return "student/courseOption";
    }

    @PostMapping(value = "/enroll")
   public @ResponseBody String  enrolledcourse(@RequestParam("id") String id) {

        String[] toBeEnroll = id.split("-");
        String stuId = toBeEnroll[0];
        String secId = toBeEnroll[1];

//        Section section = sectionService.getOne(Long.parseLong(secId));
//        Student student = studentService.findStudentById(Long.parseLong(secId));
//        section.addStudent(student);
//        student.enrolleCourse(section.getCourse());
//
//        sectionService.save(section);
//        studentService.save(student);

        System.out.println("enrolled " + stuId + " " + secId);

        return "Success";
    }

}

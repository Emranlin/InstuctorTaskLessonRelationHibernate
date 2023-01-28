package peaksoft;

import peaksoft.config.HibernateConnection;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.service.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SplittableRandom;

import static jakarta.persistence.ParameterMode.IN;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
      //  HibernateConnection.getEntityManager();
        CourseService courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        TaskService taskService = new TaskServiceImpl();


        int number = new Scanner(System.in).nextInt();
        switch (number) {
            case 1 -> {
                System.out.println("Enter course_name :");
                String courseName = new Scanner(System.in).nextLine();
                System.out.println("Enter duration :");
                int duration = new Scanner(System.in).nextInt();
                System.out.println("Enter Create At(yyyy-mm-dd) :");
                String createAt = new Scanner(System.in).next();
                String[] split = createAt.split("-");
                System.out.println("Enter the imageLink");
                String imageLink = new Scanner(System.in).next();
                System.out.println("Enter description :");
                String description = new Scanner(System.in).nextLine();
                Course course = new Course(courseName, duration,LocalDate.of(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2])), imageLink, description);
                courseService.saveCourse(course);}
            case 2->courseService.getCourseById(new Scanner(System.in).nextLong());
            case 3->courseService.getAllCourse();
            case 4->{
                System.out.println("Enter the name ");
                String name=new Scanner(System.in).nextLine();
                courseService.getByCourseName(name);}
            case 5->{
                System.out.println("Enter the id which you want change ");
                Long id=new Scanner(System.in).nextLong();
                System.out.println("Enter course_name :");
                String courseName = new Scanner(System.in).nextLine();
                System.out.println("Enter duration :");
                int duration = new Scanner(System.in).nextInt();
                System.out.println("Enter Create At(yyyy-mm-dd) :");
                String createAt = new Scanner(System.in).next();
                String[] split = createAt.split("-");
                System.out.println("Enter the imageLink");
                String imageLink = new Scanner(System.in).next();
                System.out.println("Enter description :");
                String description = new Scanner(System.in).nextLine();
                Course course = new Course(courseName, duration,LocalDate.of(Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]),Integer.parseInt(split[2])), imageLink, description);
                courseService.updateCourse(id,course);}
            case 6->courseService.deleteById(3L);
            case 7->instructorService.getInstructorById(1L);
            case 8-> System.out.println(instructorService.deleteInstructorById(3L));
            case 9->{
                System.out.println("Enter the firstNAme");
                String firstName=new Scanner(System.in).nextLine();
                System.out.println("Enter the lastNAme");
                String lastName=new Scanner(System.in).nextLine();
                System.out.println("Enter the email");
                String email=new Scanner(System.in).nextLine();
                System.out.println("Enter the phoneNumber");
                int phoneNumber=new Scanner(System.in).nextInt();
                Instructor instructor=new Instructor(firstName,lastName,email,phoneNumber);
                System.out.println(instructorService.saveInstructor(instructor));}
            case 10->instructorService.getInstructorById(3L);
            case 11-> System.out.println(instructorService.deleteInstructorById(1L));
            case 12->{
                System.out.println("Enter the id which id want you change");
                Long id=new Scanner(System.in).nextLong();
                System.out.println("Enter the firstNAme");
                String firstName=new Scanner(System.in).nextLine();
                System.out.println("Enter the lastNAme");
                String lastName=new Scanner(System.in).nextLine();
                System.out.println("Enter the email");
                String email=new Scanner(System.in).nextLine();
                System.out.println("Enter the phoneNumber");
                int phoneNumber=new Scanner(System.in).nextInt();
                Instructor instructor=new Instructor(firstName,lastName,email,phoneNumber);
                instructorService.updateInstructor(id,instructor);}
            case 13->lessonService.getLessonById(1L);
            case 14->lessonService.getLessonsByCourseId(3L);
            case 15->{
                System.out.println("Enter the name ");
                String name=new Scanner(System.in).nextLine();
                System.out.println("Enter the deadLine");
                int deadLine=new Scanner(System.in).nextInt();
                Task task=new Task(name,deadLine);
                System.out.println(lessonService.saveLesson(2L, task));
            }
            case 16->{
                System.out.println("Id which you want change");
                Long id=new Scanner(System.in).nextLong();
                System.out.println("Enter the name");
                String name=new Scanner(System.in).nextLine();
                System.out.println("Enter the videoLink");
                String videoLink=new Scanner(System.in).nextLine();
                Lesson lesson=new Lesson(name,videoLink);
                lessonService.updateLesson(id,lesson);}
            case 17->{System.out.println("Enter the name ");
                String name=new Scanner(System.in).nextLine();
                System.out.println("Enter the deadLine");
                int deadLine=new Scanner(System.in).nextInt();
                Task task=new Task(name,deadLine);
                System.out.println(taskService.saveTask(task));}
            case 18->taskService.deleteTaskById(1L);
            case 19->taskService.getAllTaskByLessonId(3L);
            case 20->{System.out.println("Enter the name ");
                String name=new Scanner(System.in).nextLine();
                System.out.println("Enter the deadLine");
                int deadLine=new Scanner(System.in).nextInt();
                Task task=new Task(name,deadLine);
                taskService.updateTask(3L,task);
            }






        }
    }
}

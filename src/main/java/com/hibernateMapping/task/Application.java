package com.hibernateMapping.task;


import com.hibernateMapping.task.models.Result;
import com.hibernateMapping.task.models.Sections;
import com.hibernateMapping.task.models.Students;
import com.hibernateMapping.task.models.Subjects;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Application {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        Result result = new Result();
        result.setResultStatus("pass");
        LOGGER.info("creating object {}",result);

        Sections sections = new Sections();
        sections.setSectionName("A1");
        LOGGER.info("creating object {}",sections);

        Subjects subject1 = new Subjects();
        subject1.setSubjectName("Science");
        LOGGER.info("creating object {}",subject1);

        Subjects subject2 = new Subjects();
        subject2.setSubjectName("Math");
        LOGGER.info("creating object {}",subject2);


        Students student1 = new Students();
        student1.setSections(sections);
        student1.setResult(result);
        student1.setValue(346);
        student1.setSubjects(subject1);
        LOGGER.info("creating object {}",student1);

        Students student2 = new Students();
        student2.setSections(sections);
        student2.setResult(result);
        student2.setValue(1000);
        student2.setSubjects(subject2);
        LOGGER.info("creating object {}",student2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(student1);
            LOGGER.info("save Student with studentID: {}",student1.getStudentID());
            session.save(student2);
            LOGGER.info("save Student with studentID: {}",student2.getStudentID());


            Query query = session.createQuery("from Students");
            List<Students> students = query.list();
            LOGGER.info("Getting {} students from database",students.size());
            for (Students student : students) {
                LOGGER.info("Student with StudentID {} detail: {}",student.getStudentID(),student);
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();

        }
    }
}

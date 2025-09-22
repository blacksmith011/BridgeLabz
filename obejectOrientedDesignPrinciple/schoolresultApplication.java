//Class Diagram
+-----------------+            +-----------------+
|     Student     |            |     Subject     |
+-----------------+            +-----------------+
| - name: String  |<>----------| - subjectName   |
| - rollNo: int   | 1..*       | - marks: int    |
+-----------------+            +-----------------+
| +getSubjects()  |            | +getMarks()     |
| +addSubject()   |            |                 |
+-----------------+            +-----------------+

              |
              | uses
              v
+-------------------------+
|    GradeCalculator      |
+-------------------------+
| +calculateGrade(Student)|
+-------------------------+
//Object Diagram

Student: John
+-----------------+
| name = "John"   |
| rollNo = 101    |
+-----------------+
| Subjects        |
+-----------------+

Subject1: Maths
+-----------------+
| subjectName="Maths" |
| marks = 90          |
+-----------------+

Subject2: Science
+-----------------+
| subjectName="Science" |
| marks = 85            |
+-----------------+
//Sequence Diagram
Student (John)        GradeCalculator
     |                       |
     |---- requestGrade() --->|
     |                       |
     |<--- calculateGrade()---|
     |                       |
     |------ showGrade ------>|
     |                       |

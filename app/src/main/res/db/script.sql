CREATE TABLE IF NOT EXSIST Teacher
(
  id INT NOT NULL,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXSIST Admin
(
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXSIST Class
(
  class_id INT NOT NULL,
  class_name VARCHAR(7) NOT NULL,
  teacher_id INT NOT NULL,
  PRIMARY KEY (class_id),
  FOREIGN KEY (teacher_id) REFERENCES Teacher(id)
);

CREATE TABLE IF NOT EXSIST Student
(
  regNo VARCHAR(13) NOT NULL,
  First_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  class_id INT NOT NULL,
  PRIMARY KEY (regNo),
  FOREIGN KEY (class_id) REFERENCES Class(class_id)
);

CREATE TABLE IF NOT EXSIST Subject
(
  subject_id INT NOT NULL,
  name VARCHAR(20) NOT NULL,
  teacher_id INT NOT NULL,
  PRIMARY KEY (subject_id),
  FOREIGN KEY (teacher_id) REFERENCES Teacher(id)
);

CREATE TABLE IF NOT EXSIST Results
(
  marks INT NOT NULL,
  comments VARCHAR(255) NOT NULL,
  result_id INT NOT NULL,
  regNo VARCHAR(13) NOT NULL,
  subject_id INT NOT NULL,
  PRIMARY KEY (result_id),
  FOREIGN KEY (regNo) REFERENCES Student(regNo),
  FOREIGN KEY (subject_id) REFERENCES Subject(subject_id)
);

CREATE TABLE IF NOT EXSIST Takes
(
  regNo VARCHAR(13) NOT NULL,
  subject_id INT NOT NULL,
  PRIMARY KEY (regNo, subject_id),
  FOREIGN KEY (regNo) REFERENCES Student(regNo),
  FOREIGN KEY (subject_id) REFERENCES Subject(subject_id)
);

CREATE TABLE IF NOT EXSIST taught_in
(
  class_id INT NOT NULL,
  subject_id INT NOT NULL,
  PRIMARY KEY (class_id, subject_id),
  FOREIGN KEY (class_id) REFERENCES Class(class_id),
  FOREIGN KEY (subject_id) REFERENCES Subject(subject_id)
);
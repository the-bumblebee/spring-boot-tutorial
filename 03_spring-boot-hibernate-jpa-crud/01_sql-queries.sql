SELECT * FROM student_tracker.student;

-- Set auto increment key from 3000
ALTER TABLE student_tracker.student AUTO_INCREMENT=3000;

-- Remove all data and reset AUTO_INCREMENT starting with 1
TRUNCATE student_tracker.student;
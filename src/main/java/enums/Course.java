package enums;

public enum Course {
        JAVA_QA_ENGINEER_PROFESSIONAL(
                "Java QA Engineer. Professional",
                "Курс по автоматизированному тестированию на Java: продвинутые инструменты, новые карьерные возможности",
                "4 месяца",
                "Онлайн");

        private final String courseName;
        private final String courseDescription;
        private final String trainingDuration;
        private final String trainingFormat;

        Course(String courseName, String courseDescription, String trainingDuration, String trainingFormat) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.trainingDuration = trainingDuration;
        this.trainingFormat = trainingFormat;
    }

        public String getCourseName() {
        return courseName;
    }

        public String getCourseDescription() {
        return courseDescription;
    }

        public String getTrainingDuration() {
        return trainingDuration;
    }

        public String getTrainingFormat() {
        return trainingFormat;
    }
}



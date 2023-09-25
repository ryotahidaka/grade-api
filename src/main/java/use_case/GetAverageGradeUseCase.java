package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team teami = gradeDB.getMyTeam();
        String[] teamy;
        teamy = teami.getMembers();
        int grade = 0;
        int counter = 0;
        for (String id : teamy) {
            Grade newgrade = gradeDB.getGrade(id, course);
            grade += newgrade.getGrade();
            counter++;
        }
        if (counter == 0) {
            return 0;
        }
        return grade / counter;
    }
}

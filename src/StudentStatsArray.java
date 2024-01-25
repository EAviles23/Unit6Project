import org.w3c.dom.ls.LSOutput;

public class StudentStatsArray {

    // Add private final variable to hold Students array
    private final Student[] students;

    public StudentStatsArray(Student[] students) {
        this.students = students;
    }

    // Returns the average gpa of the students
    public double averageGpa() {
        double sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getGpa();
        }
        return sum / students.length;
    }

    // Returns the gpa range of the students
    public double getGpaRange() {
        double max = students[0].getGpa();
        double min = students[0].getGpa();
        for (int i = 1; i < students.length; i++) {
            if (students[i].getGpa() > max) {
                max = students[i].getGpa();
            }
            if (students[i].getGpa() < min)
            {
                min = students[i].getGpa();
            }
        }
        return max - min;
    }

    // Returns the name of the student that has the longest length
    public String getLongestName() {
        String longest = students[0].getName();
        for (int i = 1; i < students.length; i++) {
            if (students[i].getName().length() > longest.length()) ;
            longest = students[i].getName();
        }
        return longest;
    }

    // Returns a count of the number freshman students
    public int getNumFreshman() {
        int fresh = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getYear() == 1) {
                fresh++;
            }
        }
        return fresh;
    }

    // Returns the index of the first student with a name equal to name.
    // Returns -1 if not found
    public int search(String name) {
        String nameInd;
        for (int i = 0; i < students.length; i++) {
            nameInd = students[i].getName();
            name = name.toLowerCase();
            if (name.equals(nameInd)) {
                name = students[i].getName();
                return students[i].getName().indexOf(name);
            }
        }
        return -1;
    }

    // Returns the index of the first student with a gpa greater than or equal to the gpa
    // Returns -1 if not found
    public double search(double gpa)
    {
        double gpaInd = 0;
        for(int i = 0; i < students.length; i++)
        {
            gpaInd= students[i].getGpa();
            if(students[i].getGpa() >= gpa)
            {
               gpaInd = students[i].getGpa();
            }
        }
        return gpaInd;
    }

    // Returns 1 if the students are sorted in ascending order by their gpa; -1 if they
    // are sorted in descending order; 0 otherwise.
    public int sortStatus() {
        if (isAscending()) {
            return 1;
        }
        if (isDescending()) {
            return -1;
        } else {
            return 0;
        }
    }
        private boolean isAscending()
        {
            double gpa1 = students[0].getGpa();
            for(int i = 1; i < students.length; i ++)
            {
                if(gpa1 > students[i].getGpa())
                {
                    return false;
                }
            }
            return true;
        }
        private boolean isDescending()
            {
                    double gpa2 = students[0].getGpa();
                    for(int i = 1; i < students.length; i ++)
                    {
                        if(gpa2 < students[i].getGpa())
                        {
                            return false;
                        }
                    }
                return true;
            }


    // Returns the array of students in JSON like format
    public String toString() {
        String result = "\n";
        for(int i = 0; i < students.length; i++)
        {
            result += students[i].toString() + "\n";
        }
        return result;
    }
}
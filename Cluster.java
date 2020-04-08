//the cluster to hold my varables so i cab test agaist my "test java class"//
public class Cluster {

    //mini system about student in a sch to get their sore/grades and income
    private int studentid;
    private int income;
    private int scoreid;
    private int clusterNumber;



    public Cluster(int clusterNumber, int scoreid, int income, int studentid) {
        super();
        this.clusterNumber = clusterNumber;
        this.scoreid = scoreid;
        this.income= income;
        this.studentid = studentid;
    }
//Get the value from "myTable" with the key
    /*...*/

    public int getStudentid() {
        return studentid;
    }
    public void setStudentid(int studentid) {
        this.studentid= studentid;
    }
    public int getIncome() {
        return income;
    }
    public void setIncome(int income) {
        this.income = income;
    }
    public int getScoreid() {
        return scoreid;
    }
    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }
    public int getClusterNumber() {
        return clusterNumber;
    }
    public void setClusterNumber(int clusterNumber) {
        this.clusterNumber = clusterNumber;
    }

    //Insert a value with a key in "myTable"
    /*...*/
    @Override
    public String toString() {
        return "studentid=" + studentid + ", income=" + income + ", scoreid="
                + scoreid+ ", clusterNumber=" + clusterNumber + "]";
    }

    // calculatioin of the income and score
    public double calculateDistance(Record record) {
        return Math.sqrt(Math.pow((getStudentid() - record.getId()), 2) + Math.pow((getIncome() - record.getIncome()),2) + Math.pow((getScoreid() - record.getScore()), 2));
    }

    // Binding the algorithm together to product an outcome
    public void updateRecord(Record record) {
        studentid((getStudentid()+record.getStudentid())/2);
        setIncome((getIncome()+record.getIncome())/2);
        setScoreid((getScoreid()+record.getScore())/2);
    }

}

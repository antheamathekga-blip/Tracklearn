public class Student {
  private String id;
  private String name;
  private int attendance;
  private double averageMark;
  private String riskStatus;
  public Student(String id, String name, int attendance, double averageMark){
   this.id = id;
   this.name = name;
   this.attendance = attendance;
   this.averageMark = averageMark;
   }
   public String getId(){
   return id;
   }
   public int getAttendance(){
   return attendance;
  }
  public double getAverageMark(){
  return averageMark;
  }
  public String getRiskStatus() {
  return riskStatus;
  }
  public void setRiskStatus(String riskStatus) {
 this.riskStatus = riskStatus;
}
}

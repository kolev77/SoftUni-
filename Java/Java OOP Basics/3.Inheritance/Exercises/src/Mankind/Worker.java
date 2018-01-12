package Mankind;

public class Worker extends Human {
    private Double weeklySalary;
    private Double workingHours;

    public Worker(String firstName, String lastName, Double weeklySalary, Double workingHours) {
        super(firstName, lastName);
        this.setWeeklySalary(weeklySalary);
        this.setWorkingHours(workingHours);
    }


    private void setWeeklySalary(Double weeklySalary) {
        if (weeklySalary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weeklySalary = weeklySalary;
    }

    private void setWorkingHours(Double workingHours) {
        if (workingHours < 1 || workingHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }

    private Double getWeeklySalary() {
        return weeklySalary;
    }

    private Double getWorkingHours() {
        return workingHours;
    }

    private Double getSalaryPerHour() {
        Double salaryPerDay = this.getWeeklySalary() / 7.0;
        Double salaryPerHour = salaryPerDay / this.getWorkingHours();
        return salaryPerHour;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f", this.getWeeklySalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.getWorkingHours()))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", this.getSalaryPerHour()));

        return sb.toString();
    }
}

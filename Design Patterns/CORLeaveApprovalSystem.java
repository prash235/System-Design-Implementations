// Request class
class LeaveRequest {
    private String employeeName;
    private int days;

    public LeaveRequest(String employeeName, int days) {
        this.employeeName = employeeName;
        this.days = days;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getDays() {
        return days;
    }
}

// Abstract Handler
abstract class LeaveHandler {
    protected LeaveHandler nextHandler;

    public void setNextHandler(LeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void processLeave(LeaveRequest request);
}

// Concrete Handlers
class TeamLead extends LeaveHandler {
    @Override
    public void processLeave(LeaveRequest request) {
        if (request.getDays() <= 5) {
            System.out.println("✅ TeamLead approved " + request.getDays() + " days for " + request.getEmployeeName());
        } else if (nextHandler != null) {
            nextHandler.processLeave(request);
        }
    }
}

class Manager extends LeaveHandler {
    @Override
    public void processLeave(LeaveRequest request) {
        if (request.getDays() <= 10) {
            System.out.println("✅ Manager approved " + request.getDays() + " days for " + request.getEmployeeName());
        } else if (nextHandler != null) {
            nextHandler.processLeave(request);
        }
    }
}

class Director extends LeaveHandler {
    @Override
    public void processLeave(LeaveRequest request) {
        if (request.getDays() <= 20) {
            System.out.println("✅ Director approved " + request.getDays() + " days for " + request.getEmployeeName());
        } else {
            System.out.println("❌ Leave request denied for " + request.getEmployeeName() + " (" + request.getDays() + " days)");
        }
    }
}

// Client
public class CORLeaveApprovalSystem {
    public static void main(String[] args) {
        // Build chain
        LeaveHandler teamLead = new TeamLead();
        LeaveHandler manager = new Manager();
        LeaveHandler director = new Director();

        teamLead.setNextHandler(manager);
        manager.setNextHandler(director);

        // Test cases
        LeaveRequest req1 = new LeaveRequest("Alice", 3);
        LeaveRequest req2 = new LeaveRequest("Bob", 7);
        LeaveRequest req3 = new LeaveRequest("Charlie", 15);
        LeaveRequest req4 = new LeaveRequest("David", 25);

        teamLead.processLeave(req1);
        teamLead.processLeave(req2);
        teamLead.processLeave(req3);
        teamLead.processLeave(req4);
    }
}

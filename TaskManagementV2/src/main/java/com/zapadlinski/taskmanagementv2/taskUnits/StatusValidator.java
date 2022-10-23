package com.zapadlinski.taskmanagementv2.taskUnits;

import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;
import com.zapadlinski.taskmanagementv2.user.Employee;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class StatusValidator {

    public boolean validateStatus(TaskUnit taskUnit, UnitStatus newStatus, Employee employee){
        UnitStatus oldStatus = taskUnit.getStatus();
        switch (oldStatus) {
            case NEW -> {
                return newStatus == UnitStatus.IN_PROGRESS
                        || newStatus == UnitStatus.HALTED
                        || newStatus == UnitStatus.CANCELLED;
            }
            case IN_PROGRESS -> {
                return newStatus == UnitStatus.FOR_TESTING
                        || newStatus == UnitStatus.HALTED
                        || newStatus == UnitStatus.CANCELLED;
            }
            case FOR_TESTING, REFACTORED -> {
                return newStatus == UnitStatus.TESTED
                        || newStatus == UnitStatus.HALTED
                        || newStatus == UnitStatus.CANCELLED;
            }
            case TESTED -> {
                return newStatus == UnitStatus.COMPLETED
                        || newStatus == UnitStatus.HALTED
                        || newStatus == UnitStatus.CANCELLED;
            }
            case COMPLETED, CANCELLED -> {
                return false;
            }
            case HALTED -> {
                if (newStatus != UnitStatus.HALTED
                && newStatus != UnitStatus.COMPLETED)
                    return true;
            }
            case FOR_REFACTORING -> {
                return newStatus == UnitStatus.REFACTORED
                        || newStatus == UnitStatus.HALTED
                        || newStatus == UnitStatus.CANCELLED;
            }
            default -> throw new IllegalStateException("Unexpected value: " + oldStatus);
        }
        return false;
    }
}

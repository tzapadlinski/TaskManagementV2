package com.zapadlinski.taskmanagementv2.taskUnits.wrappers;

import com.zapadlinski.taskmanagementv2.taskUnits.status.UnitStatus;

public record IdStatusWrapper(Long id, UnitStatus status) {
}

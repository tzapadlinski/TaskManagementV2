package com.zapadlinski.taskmanagementv2.taskUnits.wrappers;

import com.zapadlinski.taskmanagementv2.taskUnits.enumeration.UnitStatus;

public record IdStatusWrapper(Long id, UnitStatus status) {
}

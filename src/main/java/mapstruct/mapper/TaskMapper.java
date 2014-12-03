package mapstruct.mapper;

import mapstruct.dto.UITaskListDto;
import mapstruct.entity.Task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper
public interface TaskMapper {

    @Mappings({
      @Mapping(source = "id", target = "taskId"),
      @Mapping(source = "name", target = "taskName"),
      @Mapping(source = "status.id", target = "taskStatusId"),
      @Mapping(source = "status.name", target = "taskStatusName"),
    })
    UITaskListDto taskToUITaskListDto(Task task);

    @Mappings({
            @Mapping(source = "taskId", target = "id"),
            @Mapping(source = "taskName", target = "name"),
            //@Mapping(source = "taskStatusId", target = "status.id"), /* not work */
            //@Mapping(source = "taskStatusName", target = "status.name") /* not work */
    })
    void updateTaskFromUITaskListDto(UITaskListDto uiTaskListDto, @MappingTarget Task task);
}

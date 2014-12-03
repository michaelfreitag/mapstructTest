package mapstruct.mapper;

import mapstruct.dto.UITaskListDto;
import mapstruct.entity.Task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(uses=StatusRepository.class)
public interface TaskMapper {

    @Mappings({
      @Mapping(source = "id", target = "taskId"),
      @Mapping(source = "name", target = "taskName"),
      @Mapping(source = "status.id", target = "taskStatusId"),
      @Mapping(source = "status.name", target = "taskStatusName"),
    })
    UITaskListDto taskToUITaskListDto(Task task);

    @Mappings({
            @Mapping(target = "id", ignore=true),
            @Mapping(source = "taskName", target = "name"),
            @Mapping(source = "taskStatusId", target = "status")
    })
    void updateTaskFromUITaskListDto(UITaskListDto uiTaskListDto, @MappingTarget Task task);
}

package mapstruct.mapper;

import javax.annotation.Generated;
import mapstruct.dto.UITaskListDto;
import mapstruct.entity.Status;
import mapstruct.entity.Task;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2014-12-03T12:05:31+0100"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public UITaskListDto taskToUITaskListDto(Task task)  {
        if ( task == null ) {
            return null;
        }

        UITaskListDto uITaskListDto = new UITaskListDto();

        uITaskListDto.setTaskId( task.getId() );
        uITaskListDto.setTaskName( task.getName() );
        uITaskListDto.setTaskStatusId( taskStatusId( task ) );
        uITaskListDto.setTaskStatusName( taskStatusName( task ) );


        return uITaskListDto;
    }


    @Override
    public void updateTaskFromUITaskListDto(UITaskListDto carDto, Task task)  {
        if ( carDto == null ) {
            return;
        }



        task.setId( carDto.getTaskId() );
        task.setName( carDto.getTaskName() );

    }


    private Long taskStatusId(Task task) {

        Long long_ = null;
        if ( task != null ) {
            Status status = task.getStatus();
            if ( status != null ) {
                Long id = status.getId();
                if ( id != null ) {
                    long_ = id;
                }
            }
        }
        return long_;
    }


    private String taskStatusName(Task task) {

        String string = null;
        if ( task != null ) {
            Status status = task.getStatus();
            if ( status != null ) {
                String name = status.getName();
                if ( name != null ) {
                    string = name;
                }
            }
        }
        return string;
    }

}

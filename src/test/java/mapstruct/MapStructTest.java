package mapstruct;

import mapstruct.dto.UITaskListDto;
import mapstruct.entity.Status;
import mapstruct.entity.Task;
import mapstruct.mapper.TaskMapper;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class MapStructTest {

    private TaskMapper taskMapper;

    private Task persistedTask;

    @Before
    public void init() {
        taskMapper = Mappers.getMapper(TaskMapper.class);

        //set up test data
        persistedTask = new Task();
        persistedTask.setId(1L);
        persistedTask.setName("polish");

        Status status = new Status();
        status.setId(1L);
        status.setName("started");

        persistedTask.setStatus(status);


    }


    @Test
    public void testEntityToDto() {

        /*
            example: a rest endpoint provides a persistedTask
            the persistedTask entity should be transformed to a dto which is the contract between frontend and backend
         */

        //given
        //this.persistedTask


        //when
        UITaskListDto uiTaskListDto = taskMapper.taskToUITaskListDto(persistedTask);

        //then
        assertThat(uiTaskListDto.getTaskId(), is(1L));
        assertThat(uiTaskListDto.getTaskName(), is("polish"));
        assertThat(uiTaskListDto.getTaskStatusId(), is(1L));
        assertThat(uiTaskListDto.getTaskStatusName(), is("started"));
    }



    @Test
    public void testDtoToEntity() {

        /*
           example: a rest endpoint consumes a persistedTask
           it loads the persisted task and want to apply the changes from the dto
         */


        //given
        UITaskListDto uiTaskListDto = new UITaskListDto();
        uiTaskListDto.setTaskId(1L);
        uiTaskListDto.setTaskName("polish everything");
        uiTaskListDto.setTaskStatusId(2L);

        //when

        /* load from persitence */
        Task task = this.persistedTask;
        taskMapper.updateTaskFromUITaskListDto(uiTaskListDto, task);


        //then
        assertThat(task.getId(), is(1L));
        assertThat(task.getStatus(), is(not(persistedTask.getStatus()))); //should be a new instance, because the current instance is a attached entity
        assertThat(task.getStatus().getId(), is(2L));


    }

}

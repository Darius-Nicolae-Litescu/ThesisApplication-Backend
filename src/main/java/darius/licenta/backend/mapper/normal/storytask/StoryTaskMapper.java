package darius.licenta.backend.mapper.normal.storytask;

import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.dto.normal.storytask.*;
import darius.licenta.backend.dto.normal.storytask.fullinformation.FullInformationStoryTaskDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoryTaskMapper {
    @Mapping(source = "createdById", target = "createdBy.id")
    @Mapping(source = "createdByUsername", target = "createdBy.username")
    @Mapping(source = "createdByEmail", target = "createdBy.email")
    @Mapping(source = "assignedToId", target = "assignedTo.id")
    @Mapping(source = "assignedToUsername", target = "assignedTo.username")
    @Mapping(source = "assignedToEmail", target = "assignedTo.email")
    @Mapping(source = "storyId", target = "story.id")
    @Mapping(source = "storyDescription", target = "story.description")
    StoryTask fullInformationStoryTaskDtoToStoryTask(FullInformationStoryTaskDto fullInformationStoryTaskDto);

    @InheritInverseConfiguration(name = "fullInformationStoryTaskDtoToStoryTask")
    FullInformationStoryTaskDto storyTaskToFullInformationStoryTaskDto(StoryTask storyTask);

    @InheritConfiguration(name = "fullInformationStoryTaskDtoToStoryTask")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromFullInformationStoryTaskDto(FullInformationStoryTaskDto fullInformationStoryTaskDto, @MappingTarget StoryTask storyTask);

    @Mapping(source = "assignedToId", target = "assignedTo.id")
    @Mapping(source = "storyId", target = "story.id")
    StoryTask insertStoryTaskDtoToStoryTask(InsertStoryTaskDto insertStoryTaskDto);

    @InheritInverseConfiguration(name = "insertStoryTaskDtoToStoryTask")
    InsertStoryTaskDto storyTaskToInsertStoryTaskDto(StoryTask storyTask);

    @InheritConfiguration(name = "insertStoryTaskDtoToStoryTask")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromInsertStoryTaskDto(InsertStoryTaskDto insertStoryTaskDto, @MappingTarget StoryTask storyTask);

    StoryTask responseStoryTaskDtoToStoryTask(ResponseStoryTaskDto responseStoryTaskDto);

    ResponseStoryTaskDto storyTaskToResponseStoryTaskDto(StoryTask storyTask);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromResponseStoryTaskDto(ResponseStoryTaskDto responseStoryTaskDto, @MappingTarget StoryTask storyTask);

    @Mapping(source = "createdById", target = "createdBy.id")
    @Mapping(source = "createdByUsername", target = "createdBy.username")
    @Mapping(source = "assignedToId", target = "assignedTo.id")
    @Mapping(source = "assignedToUsername", target = "assignedTo.username")
    StoryTask updateStoryTaskDtoToStoryTask(UpdateStoryTaskDto updateStoryTaskDto);

    @InheritInverseConfiguration(name = "updateStoryTaskDtoToStoryTask")
    UpdateStoryTaskDto storyTaskToUpdateStoryTaskDto(StoryTask storyTask);

    @InheritConfiguration(name = "updateStoryTaskDtoToStoryTask")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromUpdateStoryTaskDto(UpdateStoryTaskDto updateStoryTaskDto, @MappingTarget StoryTask storyTask);

    @Mapping(source = "assignedToUsername", target = "assignedTo.username")
    StoryTask changeStoryTaskGeneralDetailsToStoryTask(ChangeStoryTaskGeneralDetails changeStoryTaskGeneralDetails);

    @Mapping(source = "assignedTo.username", target = "assignedToUsername")
    ChangeStoryTaskGeneralDetails storyTaskToChangeStoryTaskGeneralDetails(StoryTask storyTask);

    @Mapping(source = "assignedToUsername", target = "assignedTo.username")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromChangeStoryTaskGeneralDetails(ChangeStoryTaskGeneralDetails changeStoryTaskGeneralDetails, @MappingTarget StoryTask storyTask);

    StoryTask changeStoryTaskTitleAndDescriptionToStoryTask(ChangeStoryTaskTitleAndDescription changeStoryTaskTitleAndDescription);

    ChangeStoryTaskTitleAndDescription storyTaskToChangeStoryTaskTitleAndDescription(StoryTask storyTask);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoryTaskFromChangeStoryTaskTitleAndDescription(ChangeStoryTaskTitleAndDescription changeStoryTaskTitleAndDescription, @MappingTarget StoryTask storyTask);
}

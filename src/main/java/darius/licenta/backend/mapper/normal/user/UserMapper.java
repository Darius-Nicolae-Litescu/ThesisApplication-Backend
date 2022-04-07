package darius.licenta.backend.mapper.normal.user;

import darius.licenta.backend.domain.sql.Category;
import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.dto.normal.story.response.table.TableUserDto;
import darius.licenta.backend.dto.normal.user.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User responseUserDtoToUser(ResponseUserDto userDto);

    ResponseUserDto userToResponseUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDto(ResponseUserDto userDto, @MappingTarget User user);

    User createUserDtoToUser(CreateUserDto createUserDto);

    CreateUserDto userToCreateUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromCreateUserDto(CreateUserDto createUserDto, @MappingTarget User user);

    User updateUserPasswordDtoToUser(UpdateUserPasswordDto updateUserPasswordDto);

    UpdateUserPasswordDto userToUpdateUserPasswordDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUpdateUserPasswordDto(UpdateUserPasswordDto updateUserPasswordDto, @MappingTarget User user);

    User updateUserProfilePictureDtoToUser(UpdateUserProfilePictureDto updateUserProfilePictureDto);

    UpdateUserProfilePictureDto userToUpdateUserProfilePictureDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUpdateUserProfilePictureDto(UpdateUserProfilePictureDto updateUserProfilePictureDto, @MappingTarget User user);

    User updateUserEmailDtoToUser(UpdateUserEmailDto updateUserEmailDto);

    UpdateUserEmailDto userToUpdateUserEmailDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUpdateUserEmailDto(UpdateUserEmailDto updateUserEmailDto, @MappingTarget User user);

    User tableUserDtoToUser(TableUserDto tableUserDto);

    TableUserDto userToTableUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromTableUserDto(TableUserDto tableUserDto, @MappingTarget User user);

    default Set<Long> categoriesToCategoryIds2(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }

    default Set<Long> storySubtasksToStorySubtaskIds(Set<StoryTask> storySubtasks) {
        return storySubtasks.stream().map(StoryTask::getId).collect(Collectors.toSet());
    }
}

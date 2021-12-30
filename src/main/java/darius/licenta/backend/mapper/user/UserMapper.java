package darius.licenta.backend.mapper.user;

import darius.licenta.backend.domain.User;
import darius.licenta.backend.dto.user.*;
import org.mapstruct.*;

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
}

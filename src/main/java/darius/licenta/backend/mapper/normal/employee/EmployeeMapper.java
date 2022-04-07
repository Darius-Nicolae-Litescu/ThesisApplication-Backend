package darius.licenta.backend.mapper.normal.employee;

import darius.licenta.backend.domain.sql.Category;
import darius.licenta.backend.domain.sql.Employee;
import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.dto.normal.employee.insert.InsertEmployeeDto;
import darius.licenta.backend.dto.normal.employee.response.EmployeeDto;
import darius.licenta.backend.dto.normal.story.response.table.TableEmployeeDto;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmployeeMapper {
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    EmployeeDto employeeToEmployeeDto(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromEmployeeDto(EmployeeDto employeeDto, @MappingTarget Employee employee);

    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "positionId", target = "position.id")
    @Mapping(source = "userId", target = "user.id")
    Employee insertEmployeeDtoToEmployee(InsertEmployeeDto insertEmployeeDto);

    @InheritInverseConfiguration(name = "insertEmployeeDtoToEmployee")
    InsertEmployeeDto employeeToInsertEmployeeDto(Employee employee);

    @InheritConfiguration(name = "insertEmployeeDtoToEmployee")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromInsertEmployeeDto(InsertEmployeeDto insertEmployeeDto, @MappingTarget Employee employee);

    default Set<Long> categoriesToCategoryIds2(Set<Category> categories) {
        return categories.stream().map(Category::getId).collect(Collectors.toSet());
    }

    default Set<Long> storySubtasksToStorySubtaskIds(Set<StoryTask> storySubtasks) {
        return storySubtasks.stream().map(StoryTask::getId).collect(Collectors.toSet());
    }

    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "positionId", target = "position.id")
    @Mapping(source = "userId", target = "user.id")
    Employee tableEmployeeDtoToEmployee(TableEmployeeDto tableEmployeeDto);

    @InheritInverseConfiguration(name = "tableEmployeeDtoToEmployee")
    TableEmployeeDto employeeToTableEmployeeDto(Employee employee);

    @InheritConfiguration(name = "tableEmployeeDtoToEmployee")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromTableEmployeeDto(TableEmployeeDto tableEmployeeDto, @MappingTarget Employee employee);

}

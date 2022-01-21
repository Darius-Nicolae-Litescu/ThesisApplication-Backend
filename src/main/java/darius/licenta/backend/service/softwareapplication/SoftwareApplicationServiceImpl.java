package darius.licenta.backend.service.softwareapplication;

import darius.licenta.backend.domain.Priority;
import darius.licenta.backend.domain.SoftwareApplication;
import darius.licenta.backend.dto.priority.PriorityDto;
import darius.licenta.backend.dto.role.RoleDto;
import darius.licenta.backend.dto.softwareapplication.InsertSoftwareApplicationDto;
import darius.licenta.backend.dto.softwareapplication.SoftwareApplicationDto;
import darius.licenta.backend.mapper.softwareapplication.SoftwareApplicationMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.SoftwareApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SoftwareApplicationServiceImpl implements SoftwareApplicationService {

    private final SoftwareApplicationRepository softwareApplicationRepository;
    private final SoftwareApplicationMapper softwareApplicationMapper;

    @Autowired
    public SoftwareApplicationServiceImpl(SoftwareApplicationRepository softwareApplicationRepository, SoftwareApplicationMapper softwareApplicationMapper) {
        this.softwareApplicationRepository = softwareApplicationRepository;
        this.softwareApplicationMapper = softwareApplicationMapper;
    }


    @Override
    public ApiResponse<SoftwareApplicationDto> insert(InsertSoftwareApplicationDto insertSoftwareApplicationDto) {
        SoftwareApplication softwareApplication = softwareApplicationMapper.insertSoftwareApplicationDtoToSoftwareApplication(insertSoftwareApplicationDto);

        softwareApplicationRepository.save(softwareApplication);

        SoftwareApplicationDto softwareApplicationDto = softwareApplicationMapper.softwareApplicationToSoftwareApplicationDto(softwareApplication);
        return new ApiResponse<>(softwareApplicationDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<SoftwareApplicationDto> update(SoftwareApplicationDto softwareApplicationDto) {
        SoftwareApplication softwareApplication = softwareApplicationRepository.getById(softwareApplicationDto.getId());

        softwareApplication.setDescription(softwareApplicationDto.getDescription());
        softwareApplication.setName(softwareApplicationDto.getName());

        softwareApplicationRepository.save(softwareApplication);

        SoftwareApplicationDto softwareApplicationDtoResponse = softwareApplicationMapper.softwareApplicationToSoftwareApplicationDto(softwareApplication);

        return new ApiResponse<>(softwareApplicationDtoResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<SoftwareApplicationDto>> findByName(String name) {
        List<SoftwareApplication> softwareApplicationList = softwareApplicationRepository.findByNameIgnoreCase(name);
        if (CollectionUtils.isEmpty(softwareApplicationList)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<SoftwareApplicationDto> softwareApplicationDtoList = new ArrayList<>();

        softwareApplicationList.forEach(softwareApplication -> softwareApplicationDtoList.add(softwareApplicationMapper.softwareApplicationToSoftwareApplicationDto(softwareApplication)));
        return new ApiResponse<>(softwareApplicationDtoList, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<SoftwareApplicationDto>> findByDescription(String description) {
        List<SoftwareApplication> softwareApplicationList = softwareApplicationRepository.findByDescriptionIsLikeIgnoreCase(description);
        if (CollectionUtils.isEmpty(softwareApplicationList)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<SoftwareApplicationDto> softwareApplicationDtoList = new ArrayList<>();

        softwareApplicationList.forEach(softwareApplication -> softwareApplicationDtoList.add(softwareApplicationMapper.softwareApplicationToSoftwareApplicationDto(softwareApplication)));
        return new ApiResponse<>(softwareApplicationDtoList, HttpStatus.OK);
    }

    @Override
    public ApiResponse<SoftwareApplicationDto> findById(Long id) {
        Optional<SoftwareApplication> softwareApplication = softwareApplicationRepository.findById(id);
        if (softwareApplication.isPresent()) {
            SoftwareApplicationDto softwareApplicationDto = softwareApplicationMapper.softwareApplicationToSoftwareApplicationDto(softwareApplication.get());
            return new ApiResponse<>(softwareApplicationDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<List<SoftwareApplicationDto>> findAll() {
        List<SoftwareApplication> softwareApplicationList = softwareApplicationRepository.findAll();
        List<SoftwareApplicationDto> softwareApplicationDtoList = softwareApplicationList.stream()
                .map(softwareApplicationMapper::softwareApplicationToSoftwareApplicationDto)
                .collect(Collectors.toList());

        return new ApiResponse<>(softwareApplicationDtoList, HttpStatus.OK);
    }

    @Override
    public ApiResponse<SoftwareApplicationDto> deleteById(Long id) {
        Optional<SoftwareApplication> softwareApplication = softwareApplicationRepository.findById(id);
        if (softwareApplication.isPresent()) {
            softwareApplicationRepository.delete(softwareApplication.get());
            SoftwareApplicationDto softwareApplicationDto = softwareApplicationMapper.softwareApplicationToSoftwareApplicationDto(softwareApplication.get());
            return new ApiResponse<>(softwareApplicationDto, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Software application id not found ... ", null, HttpStatus.NOT_FOUND);
        }
    }
}

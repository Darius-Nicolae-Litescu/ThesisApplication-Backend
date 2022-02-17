package darius.licenta.backend.service.priority;

import darius.licenta.backend.domain.sql.Priority;
import darius.licenta.backend.dto.normal.priority.InsertPriorityDto;
import darius.licenta.backend.dto.normal.priority.PriorityDto;
import darius.licenta.backend.mapper.normal.priority.PriorityMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.jpa.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;
    private final PriorityMapper priorityMapper;

    @Autowired
    public PriorityServiceImpl(PriorityRepository priorityRepository, PriorityMapper priorityMapper) {
        this.priorityRepository = priorityRepository;
        this.priorityMapper = priorityMapper;
    }

    @Override
    public ApiResponse<PriorityDto> insert(InsertPriorityDto insertPriorityDto) {
        Priority priority = priorityMapper.insertPriorityDtoToPriority(insertPriorityDto);

        priorityRepository.save(priority);

        PriorityDto responsePriorityDto = priorityMapper.priorityToPriorityDto(priority);
        return new ApiResponse<>(responsePriorityDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PriorityDto> updateGeneralInformation(PriorityDto priorityDto) {
        Priority priority = priorityRepository.getById(priorityDto.getId());

        priority.setTitle(priorityDto.getTitle());
        priority.setLevel(priorityDto.getLevel());
        priority.setDescription(priorityDto.getDescription());

        priorityRepository.save(priority);

        PriorityDto priorityDtoResponse = priorityMapper.priorityToPriorityDto(priority);
        return new ApiResponse<>(priorityDtoResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PriorityDto> updatePicture(Long id, Blob pictureBlob) {
        Priority priority = priorityRepository.getById(id);

        priority.setPriorityIcon(pictureBlob);
        priorityRepository.save(priority);

        PriorityDto priorityDtoResponse = priorityMapper.priorityToPriorityDto(priority);
        return new ApiResponse<>(priorityDtoResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<PriorityDto>> findByDescription(String description) {
        List<Priority> priorities = priorityRepository.findByDescription(description);
        if (CollectionUtils.isEmpty(priorities)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<PriorityDto> priorityDtos = new ArrayList<>();

        priorities.forEach(priority -> priorityDtos.add(priorityMapper.priorityToPriorityDto(priority)));
        return new ApiResponse<>(priorityDtos, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<PriorityDto>> findByTitle(String title) {
        List<Priority> priorities = priorityRepository.findByTitle(title);
        if (CollectionUtils.isEmpty(priorities)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<PriorityDto> priorityDtos = new ArrayList<>();

        priorities.forEach(priority -> priorityDtos.add(priorityMapper.priorityToPriorityDto(priority)));
        return new ApiResponse<>(priorityDtos, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<PriorityDto>> findByLevel(int level) {
        List<Priority> priorities = priorityRepository.findByLevel(level);
        if (CollectionUtils.isEmpty(priorities)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<PriorityDto> priorityDtos = new ArrayList<>();

        priorities.forEach(priority -> priorityDtos.add(priorityMapper.priorityToPriorityDto(priority)));
        return new ApiResponse<>(priorityDtos, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PriorityDto> findById(Long id) {
        Optional<Priority> priority = priorityRepository.findById(id);
        if (priority.isPresent()) {
            PriorityDto priorityDto = priorityMapper.priorityToPriorityDto(priority.get());
            return new ApiResponse<>(priorityDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<List<PriorityDto>> getAllPriorities() {
        List<Priority> priorities = priorityRepository.findAll();
        if (CollectionUtils.isEmpty(priorities)) {
            return new ApiResponse<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        List<PriorityDto> priorityDtos = new ArrayList<>();

        priorities.forEach(priority -> priorityDtos.add(priorityMapper.priorityToPriorityDto(priority)));
        return new ApiResponse<>(priorityDtos, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<PriorityDto>> deleteByTitle(String title) {
        List<Priority> priorities = priorityRepository.findByTitle(title);
        if (!CollectionUtils.isEmpty(priorities)) {
            priorityRepository.deleteAllInBatch(priorities);
            List<PriorityDto> priorityDtos = new ArrayList<>();
            priorities.forEach(priority -> priorityDtos.add(priorityMapper.priorityToPriorityDto(priority)));
            return new ApiResponse<>(priorityDtos, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("No priorities with title found ... ", null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<PriorityDto> deleteById(Long id) {
        Optional<Priority> priority = priorityRepository.findById(id);
        if (priority.isPresent()) {
            priorityRepository.delete(priority.get());
            PriorityDto priorityDto = priorityMapper.priorityToPriorityDto(priority.get());
            return new ApiResponse<>(priorityDto, HttpStatus.ACCEPTED);
        } else {
            return new ApiResponse<>("Priority id not found ... ", null, HttpStatus.NOT_FOUND);
        }
    }
}

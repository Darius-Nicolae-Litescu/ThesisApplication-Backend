package darius.licenta.backend.service.softwareapplication;

import darius.licenta.backend.domain.SoftwareApplication;
import darius.licenta.backend.dto.softwareapplication.InsertSoftwareApplicationDto;
import darius.licenta.backend.dto.softwareapplication.SoftwareApplicationDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;
import java.util.Optional;

public interface SoftwareApplicationService {
    ApiResponse<SoftwareApplicationDto> insert(InsertSoftwareApplicationDto insertSoftwareApplicationDto);
    ApiResponse<SoftwareApplicationDto> update (SoftwareApplicationDto softwareApplicationDto);
    ApiResponse<SoftwareApplicationDto> findByName(String name);
    ApiResponse<SoftwareApplicationDto> findByDescription(String description);
    ApiResponse<SoftwareApplicationDto> findById(Long id);
    ApiResponse<List<SoftwareApplicationDto>> findAll();

}

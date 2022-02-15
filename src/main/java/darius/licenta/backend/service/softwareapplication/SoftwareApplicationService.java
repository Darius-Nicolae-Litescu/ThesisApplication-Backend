package darius.licenta.backend.service.softwareapplication;

import darius.licenta.backend.dto.normal.softwareapplication.InsertSoftwareApplicationDto;
import darius.licenta.backend.dto.normal.softwareapplication.SoftwareApplicationDto;
import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;

public interface SoftwareApplicationService {
    ApiResponse<SoftwareApplicationDto> insert(InsertSoftwareApplicationDto insertSoftwareApplicationDto);
    ApiResponse<SoftwareApplicationDto> update (SoftwareApplicationDto softwareApplicationDto);
    ApiResponse<List<SoftwareApplicationDto>> findByName(String name);
    ApiResponse<List<SoftwareApplicationDto>> findByDescription(String description);
    ApiResponse<SoftwareApplicationDto> findById(Long id);
    ApiResponse<List<SoftwareApplicationDto>> findAll();
    ApiResponse<SoftwareApplicationDto> deleteById(Long id);
}

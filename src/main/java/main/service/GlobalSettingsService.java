package main.service;

import main.DTO.GlobalSettingsDto;
import main.api.response.SettingsResponse;
import main.model.GlobalSettingsEntity;
import main.repository.GlobalSettingsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GlobalSettingsService {

    @Autowired
    private GlobalSettingsRepository settingsRepository;
    @Autowired
    private ModelMapper mapper;

    public SettingsResponse getSettings() {
        SettingsResponse settingsResponse = new SettingsResponse();
        List<GlobalSettingsDto> dto = getDTO();
        settingsResponse.setMULTIUSER_MODE(getValue("MULTIUSER_MODE", dto));
        settingsResponse.setPOST_PREMODERATION(getValue("POST_PREMODERATION", dto));
        settingsResponse.setSTATISTICS_IS_PUBLIC(getValue("STATISTICS_IS_PUBLIC", dto));
        return settingsResponse;
    }

    private boolean getValue(String code, List<GlobalSettingsDto> dto) {
        return dto.stream()
                .filter(setting -> setting.getCode().equals(code))
                .findFirst()
                .get()
                .getValue()
                .equals("YES");
    }

    private List<GlobalSettingsDto> getDTO() {
        Iterable<GlobalSettingsEntity> all = settingsRepository.findAll();
        List<GlobalSettingsDto> allList = new ArrayList<>();
        all.forEach(globalSettingsEntity -> allList.add(mapper.map(globalSettingsEntity, GlobalSettingsDto.class)));
        return allList;
    }
}

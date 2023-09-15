package nl.novi.TechItEasy.services;

import nl.novi.TechItEasy.dto.InputDtoToTelevision;
import nl.novi.TechItEasy.dto.TelevisionDto;
import nl.novi.TechItEasy.models.Television;
import nl.novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {


    private final TelevisionRepository repos;


    public TelevisionService(TelevisionRepository repos) {

        this.repos = repos;
    }

    public TelevisionDto televisionToDto(Television t) {


        TelevisionDto televisionDto = new TelevisionDto();
        televisionDto.setType(t.getType());
        televisionDto.setBrand(t.getBrand());
        televisionDto.setName(t.getName());
        televisionDto.setPrice(t.getPrice());
        televisionDto.setAvailableSize(t.getAvailableSize());
        televisionDto.setRefreshRate(t.getRefreshRate());
        televisionDto.setScreenType(t.getScreenType());
        televisionDto.setScreenQuality(t.getScreenQuality());
        televisionDto.setSmartTv(t.getSmartTv());
        televisionDto.setWifi(t.getWifi());
        televisionDto.setVoiceControl(t.getVoiceControl());
        televisionDto.setHdr(t.getHdr());
        televisionDto.setBluetooth(t.getBluetooth());
        televisionDto.setAmbiLight(t.getAmbiLight());
        televisionDto.setOriginalStock(t.getOriginalStock());
        televisionDto.setSold(t.getSold());

        return televisionDto;
    }


    public Television dtoToTelevision(InputDtoToTelevision tDto) {

        Television television = new Television();

        television.setType(tDto.getType());
        television.setBrand(tDto.getBrand());
        television.setName(tDto.getName());
        television.setPrice(tDto.getPrice());
        television.setAvailableSize(tDto.getAvailableSize());
        television.setRefreshRate(tDto.getRefreshRate());
        television.setScreenType(tDto.getScreenType());
        television.setScreenQuality(tDto.getScreenQuality());
        television.setSmartTv(tDto.getSmartTv());
        television.setWifi(tDto.getWifi());
        television.setVoiceControl(tDto.getVoiceControl());
        television.setHdr(tDto.getHdr());
        television.setBluetooth(tDto.getBluetooth());
        television.setAmbiLight(tDto.getAmbiLight());
        television.setOriginalStock(tDto.getOriginalStock());
        television.setSold(tDto.getSold());

        return television;


    }

    public List<TelevisionDto> getTelevisions() {
        List<Television> televisions = repos.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        for (Television t : televisions) {
            //televisionToDto(t);
            televisionDtos.add(televisionToDto(t));
        }

        return televisionDtos;

    }

    public TelevisionDto getTelevision(Long id) {
        Optional<Television> television = repos.findById(id);
        return televisionToDto(television.get());
    }


    public Television addTelevision(InputDtoToTelevision tDto) {

        Television t = dtoToTelevision(tDto);
        repos.save(t);

        return (t);


    }

}





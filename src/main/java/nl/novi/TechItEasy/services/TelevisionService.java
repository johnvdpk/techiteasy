package nl.novi.TechItEasy.services;

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

    public TelevisionDto televisionToDto (Television t) {



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



    public void inputDtoToTelevision() {}

    public List<TelevisionDto> getTelevisions() {
        List<Television> televisions = repos.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        for (Television t  : televisions) {
          //televisionToDto(t);
          televisionDtos.add(televisionToDto(t));
        }

        return televisionDtos;

    }

    public TelevisionDto getTelevision(Long id) {
        Optional<Television> television = repos.findById(id);
            return televisionToDto(television.get());
        }



    // public int addTelevision() {
   //     return televisionDtos;

   // }

}





package uz.ucell.topupservice.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.ucell.topupservice.dto.TopupRequest;
import uz.ucell.topupservice.service.Impl.TopupServiceImpl;


@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopupService implements TopupServiceImpl {

    public void topup(TopupRequest topupRequest) {
        log.info("Topup request: " + topupRequest);
    }


}

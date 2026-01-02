package uz.ucell.topupservice.exception;

import lombok.extern.slf4j.Slf4j;
import uz.ucell.topupservice.dto.TopupRequest;

@Slf4j
public class TopupHandleException extends RuntimeException {
    public TopupHandleException(TopupRequest request, String message) {
        super(message);
        log.error("Caught exception handling topup request: {}, error: {}",request,message);

    }
}

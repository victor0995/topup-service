package uz.ucell.topupservice.service;

import uz.ucell.topupservice.dto.TopupRequest;
import uz.ucell.topupservice.model.MessageResponse;

public interface TopupService {

    void topup(TopupRequest topupRequest);
    void updateTopup(MessageResponse message);
}

package uz.ucell.topupservice.model;


import java.util.UUID;

public record ProlongationRequest(String msisdn, String serviceId, UUID id, Long amount) {

}

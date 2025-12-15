package uz.ucell.topupservice.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneId;
@Service
public class QuietTimeService {

    private static final ZoneId ZONE = ZoneId.of("Asia/Tashkent");

    public boolean isQuietTime() {
        LocalTime time = LocalTime.now(ZONE);
        return !time.isBefore(LocalTime.of(23, 0)) && time.isBefore(LocalTime.of(4, 0));
    }

}
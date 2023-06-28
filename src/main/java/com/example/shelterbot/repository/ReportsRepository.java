package com.example.shelterbot.repository;

import com.example.shelterbot.model.Report;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReportsRepository extends JpaRepository<Report, Long> {

    @Transactional
    Report getByUserOwnerId(Long userOwner_id);

    @Transactional
    List<Report> getAllByUserOwnerId(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Report r set r.petPhoto = :pathToPhoto where r.id = :id")
    void updatePhoto(String pathToPhoto, long id);

    @Transactional
    @Modifying
    @Query("UPDATE Report r set r.text = :text where r.id = :reportID")
    void updateText(String text, Long reportID);

    @Transactional
    @Query("SELECT r FROM Report r JOIN User u ON cast(r.userOwner as biginteger) = u.id WHERE u.chatId = :chatID AND r.createdTime = CURRENT_DATE")
    Report getToDayReportByUserOwnerId(Long chatID);
//    @Transactional
//    @Query("SELECT Report FROM Report r WHERE r.userOwner = (select User from User u where u.chatId = :chatID) AND r.createdTime = CURRENT_DATE")
//    Report getToDayReportByUserOwnerId(Long chatID);
}

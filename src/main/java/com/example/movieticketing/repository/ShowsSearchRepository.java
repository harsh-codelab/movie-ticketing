package com.example.movieticketing.repository;

import com.example.movieticketing.dto.ShowRequest;
import com.example.movieticketing.entity.Shows;
import com.example.movieticketing.service.UtilityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@Log4j2
public class ShowsSearchRepository {

    @Autowired
    EntityManager entityManager;

    public List<Shows> getAllShowsBasedOnRequest(ShowRequest request){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shows> criteriaQuery = criteriaBuilder.createQuery(Shows.class);
        Root<Shows> showsRoot = criteriaQuery.from(Shows.class);
        List<Predicate> predicates = new ArrayList<>();

        if(UtilityService.notNullOrEmpty(request.getCinemaName())){
            log.info("Check added for {}",request.getCinemaName());
            predicates.add(criteriaBuilder.equal(showsRoot.get("cinemaName"),request.getCinemaName()));
        }
        if(UtilityService.notNullOrEmpty(request.getShowId())){
            log.info("Check added for {}",request.getShowId());
            predicates.add(criteriaBuilder.equal(showsRoot.get("id"),request.getShowId()));
        }
        if(UtilityService.notNullOrEmpty(request.getCityName())){
            log.info("Check added for {}",request.getCityName());
            predicates.add(criteriaBuilder.equal(showsRoot.get("cityName"),request.getCityName()));
        }
        if(request.getShowAvailableFrom()!=null){
            log.info("Check added for {}",request.getShowAvailableFrom());
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(showsRoot.get("availableFrom").as(LocalDateTime.class),request.getShowAvailableFrom()));
        }
        if(request.getShowAvailableTill()!=null){
            log.info("Check added for {}",request.getShowAvailableTill());
            predicates.add(criteriaBuilder.lessThanOrEqualTo(showsRoot.get("availableTill").as(LocalDateTime.class),request.getShowAvailableTill()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        List<Shows> shows = entityManager.createQuery(criteriaQuery).getResultList();
        return shows;
    }

}
